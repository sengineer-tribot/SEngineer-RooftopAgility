package scripts.rt.courses;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Player;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.Walking;
import org.tribot.api2007.types.RSTile;

import scripts.rt.main.SEngineerRooftops;
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
	protected RSTile[] path;

	protected Obstacle[] course = {};

	// ~~~~~~~~

	public void doCourse() {
		General.println("[Rooftops] DaxWalking to " + name + " course start");
		Utils.daxWalkTo(courseStart);

		while (true) {
			for (final Obstacle obstacle : course) {
				if (!handleObstacle(obstacle)) {
					break;
				}
				General.sleep(500, 900);
			}

			if (hasUnlockedNewCourse()) {
				return;
			}
			
			if(path != null) {
				General.println("[Rooftops] Walking path to course start");
				Walking.walkPath(path);
				Timing.waitCondition(() -> Utils.isDistanceFrom(path[path.length - 1], 0) && !Player.isMoving(), 3000);
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
	public boolean handleObstacle(final Obstacle obstacle) {

		if (obstacle.getStartTile() != null) {
			General.println("[Rooftops] Walking to obstacle start tile");
			Utils.webWalkTo(obstacle.getStartTile());
			Timing.waitCondition(() -> Utils.isDistanceFrom(obstacle.getStartTile(), 0) && !Player.isMoving(), 3000);
		}

		while (!obstacle.hasLanded()) {
			if (Utils.interactWithObject(obstacle.getObstacle(), 1)) {
				General.println("[Rooftops] Attempting to handle obstacle " + obstacle.getObstacle());
				abc2Support.runAntiBan();

				if (obstacle.canFail()) {
					Timing.waitCondition(() -> (obstacle.hasLanded() || obstacle.hasFallen()), maxTimeout);
				} else {
					Timing.waitCondition(() -> obstacle.hasLanded(), maxTimeout);
				}
			}

			if (obstacle.canFail()) {
				if (obstacle.hasFallen()) {
					General.println("[Rooftops] Oops.. we've fallen");
					return false;
				}
			}
		}

		General.sleep(200, 300);
		General.println("[Rooftops] Successfully handled obstacle");

		if (lootMarks()) {
			SEngineerRooftops.marks += 1;
		}

		return true;
	}

	/**
	 * Checks if the players current agility level is a multiple of 10 and not the
	 * same as the starting level
	 * 
	 * @return true/false
	 */
	public boolean hasUnlockedNewCourse() {
		if (Skills.getActualLevel(SKILLS.AGILITY) % 10 == 0
				&& Skills.getActualLevel(SKILLS.AGILITY) > SEngineerRooftops.courseStartLevel) {
			SEngineerRooftops.courseStartLevel = Skills.getActualLevel(SKILLS.AGILITY);
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
