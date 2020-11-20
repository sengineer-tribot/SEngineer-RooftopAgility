package scripts.rt.courses;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.types.RSTile;

import scripts.rt.main.AK47Rooftops;
import scripts.rt.support.ABC2Support;
import scripts.rt.utils.Utils;

/**
 * 
 * Abstract class to represent an agility Course
 * 
 * @author SEngineer
 * 
 */
public abstract class Course {
	
	// ~~~~~~~~

	private ABC2Support abc2Support = ABC2Support.getInstance();

	// ~~~~~~~~

	protected String name;
	protected boolean marks;
	protected RSTile courseStart;
	protected int maxTimeout;
	
	protected Obstacle roofUp;
	protected Obstacle[] course = {};
	protected Obstacle roofDown;
	

	// ~~~~~~~~
	
	private boolean hasFallen;
	
	// ~~~~~~~~

	public void doCourse() {
		General.println("[Rooftops] DaxWalking to " + name + " course start");
		Utils.daxWalkTo(courseStart);

		while (true) {

			hasFallen = false;
			handleObstacleNoFail(roofUp);

			for (final Obstacle obstacle : course) {
				if (!handleObstacleWithFail(obstacle)) {
					break;
				}
				General.sleep(500, 900);
			}

			if (!hasFallen) {
				handleObstacleNoFail(roofDown);
			}

			if (hasUnlockedNewCourse()) {
				return;
			}

			General.sleep(100, 200);
		}
	}

	/**
	 * 
	 * Loots marks of graceful from the ground
	 * 
	 * @return true/false
	 * 
	 */
	public boolean lootMarks() {
		int marks = Utils.getInventoryItemCount("Mark of grace");

		if (this.marks && GroundItems.findNearest("Mark of grace").length > 0) {
			General.println("[Rooftops] Mark of grace located");
			if (Utils.takeNearbyStackable("Mark of grace", 25)) {
				Timing.waitCondition(() -> Utils.getInventoryItemCount("Mark of grace") > marks, 10000);
			}
		}

		return Utils.getInventoryItemCount("Mark of grace") > marks;
	}

	/**
	 * 
	 * Completes an obstacle on an obstacle course which can be failed
	 * 
	 * @param obstacle - obstacle to complete
	 * 
	 * @return true/false
	 * 
	 */
	public boolean handleObstacleWithFail(final Obstacle obstacle) {

		if (obstacle.getStartTile() != null) {
			General.println("[Rooftops] Walking to obstacle start tile");
			WebWalking.walkTo(obstacle.getStartTile());
			Timing.waitCondition(() -> !Player.isMoving(), 2000);
		}

		while (!obstacle.hasLanded()) {			
			if (Utils.interactWithObject(obstacle.getObstacle(), 1)) {
				General.println("[Rooftops] Attempting to handle obstacle " + obstacle.getObstacle());
				abc2Support.runAntiBan();
				Timing.waitCondition(() -> (obstacle.hasLanded() || obstacle.hasFallen()), maxTimeout);
			}

			if (obstacle.hasFallen()) {
				General.println("[Rooftops] Oops.. we've fallen");
				hasFallen = true;
				return false;
			}
		}
		
		General.sleep(200, 300);
		General.println("[Rooftops] Successfully handled obstacle");
		
		if (lootMarks()) {
			AK47Rooftops.marks += 1;
		}

		return true;
	}
	
	/**
	 * 
	 * Completes an obstacle on an obstacle course which cannot be failed
	 * 
	 * @param obstacle - obstacle to complete
	 * 
	 * @return true/false
	 * 
	 */
	public boolean handleObstacleNoFail(final Obstacle obstacle) {
		if (obstacle.getStartTile() != null) {
			General.println("[Rooftops] Walking to obstacle start tile");
			WebWalking.walkTo(obstacle.getStartTile());
			Timing.waitCondition(() -> !Player.isMoving(), 3000);
		}

		while (!obstacle.hasLanded()) {
			if (Utils.interactWithObject(obstacle.getObstacle(), 1)) {
				General.println("[Rooftops] Attempting to handle obstacle " + obstacle.getObstacle());
				Timing.waitCondition(() -> obstacle.hasLanded(), 3000);
			}
		}

		General.sleep(200, 300);
		General.println("[Rooftops] Successfully handled obstacle");
		
		if (lootMarks()) {
			AK47Rooftops.marks += 1;
		}

		return true;
	}
	
	/**
	 * Checks if the players current agility level is a multiple of 10 and not the same as the starting level
	 * @return true/false
	 */
	public boolean hasUnlockedNewCourse() {
		if(Skills.getActualLevel(SKILLS.AGILITY) % 10 == 0 && Skills.getActualLevel(SKILLS.AGILITY) > AK47Rooftops.courseStartLevel) {
			AK47Rooftops.courseStartLevel = Skills.getActualLevel(SKILLS.AGILITY);
			return true;
		}
		return false;
	}

	/**
	 * Gets the name of the course
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

}
