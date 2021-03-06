package scripts.rt.courses;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Camera;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Player;
import org.tribot.api2007.Players;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.api2007.Walking;
import org.tribot.api2007.WorldHopper;
import org.tribot.api2007.types.RSTile;

import scripts.rt.main.SEngineerRooftops;
import scripts.rt.support.ABC2Support;
import scripts.rt.utils.Constants;
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
	protected boolean isRooftop;
	protected RSTile courseStart;
	protected int maxTimeout;
	protected Obstacle[] course;
	protected RSTile[] finishToStartPath;

	// ~~~~~~~~

	private boolean hasFallen;

	// ~~~~~~~~

	public void doCourse() {
		General.println("[Rooftops] DaxWalking to " + name + " course start");
		Utils.daxWalkTo(courseStart);

		while (true) {
			hasFallen = false;

			for (final Obstacle obstacle : course) {
				if (!handleObstacle(obstacle)) {
					hasFallen = true;
					break;
				}
				General.sleep(500, 900);
			}

			if (hasUnlockedNewCourse()) {
				return;
			}

			if (SEngineerRooftops.shouldHop) {
				General.println("[Rooftops] Hopping world as player detected");
				if(WorldHopper.changeWorld(WorldHopper.getRandomWorld(true))) {
					SEngineerRooftops.lastHop = System.currentTimeMillis();
					SEngineerRooftops.shouldHop = false;
				}
			}

			if (finishToStartPath != null && !hasFallen) {
				General.println("[Rooftops] Walking path to course start");
				Walking.walkPath(finishToStartPath);
				Timing.waitCondition(() -> Utils.isDistanceFrom(finishToStartPath[finishToStartPath.length - 1], 0)
						&& !Player.isMoving(), 10000);
			}
			
			if(hasFallen) {
				General.println("[Rooftops] DaxWalking to " + name + " course start");
				Utils.daxWalkTo(courseStart);
			}
			
			Camera.setCameraAngle(General.random(70, 100));

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
		int marks = Inventory.getCount("Mark of grace");

		if (this.isRooftop && GroundItems.findNearest("Mark of grace").length > 0) {
			General.println("[Rooftops] Mark of grace located");
			if (Utils.takeNearbyStackable("Mark of grace", 25)) {
				Timing.waitCondition(() -> Inventory.getCount("Mark of grace") > marks, 10000);
			}
		}

		return Inventory.getCount("Mark of grace") > marks;
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
			Timing.waitCondition(() -> Utils.isDistanceFrom(obstacle.getStartTile(), 0) && !Player.isMoving(), 4000);
		}

		while (!obstacle.hasLanded()) {
			if (Utils.interactWithObject(obstacle.getName(), 1)) {
				General.println("[Rooftops] Attempting to handle obstacle " + obstacle.getName());
				abc2Support.runAntiBan();

				if (obstacle.canFail()) {
					if (Players.getAll().length > 0
							&& Utils.isTimeElapsed(SEngineerRooftops.lastHop, Constants.Numbers.FIFTEEN_MINUTES)) {
						General.println("[Rooftops] Player detected! -- Hopping when we finish the lap.");
						SEngineerRooftops.shouldHop = true;
					}
					Timing.waitCondition(() -> (obstacle.hasLanded() || obstacle.hasFallen()), maxTimeout);
				} else {
					Timing.waitCondition(() -> obstacle.hasLanded(), maxTimeout);
				}
			}

			if (obstacle.canFail() && obstacle.hasFallen()) {
				General.println("[Rooftops] Oops.. we've fallen");
				General.sleep(500, 700); // Wait for fall animation to finish
				return false;
			}
			
			General.sleep(100, 200);
		}

		General.sleep(200, 300); // Slight buffer before moving obstacles
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
