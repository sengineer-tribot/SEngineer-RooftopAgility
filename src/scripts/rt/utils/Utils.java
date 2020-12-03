package scripts.rt.utils;

import org.tribot.api.DynamicClicking;
import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.interfaces.Positionable;
import org.tribot.api2007.Camera;
import org.tribot.api2007.GroundItems;
import org.tribot.api2007.Inventory;
import org.tribot.api2007.Objects;
import org.tribot.api2007.PathFinding;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSGroundItem;
import org.tribot.api2007.types.RSObject;

import scripts.dax_api.api_lib.DaxWalker;
import scripts.dax_api.api_lib.models.DaxCredentials;
import scripts.dax_api.api_lib.models.DaxCredentialsProvider;

/**
 *
 * Utility Functions
 *
 * @author SEngineer
 *
 */
public class Utils {

	/**
	 *
	 * Configures the DaxWalker
	 *
	 */
	public static void configureDaxWalker() {
		DaxWalker.setCredentials(new DaxCredentialsProvider() {
			@Override
			public DaxCredentials getDaxCredentials() {
				return new DaxCredentials("sub_DPjXXzL5DeSiPf", "PUBLIC-KEY");
			}
		});
	}

	/**
	 * Dax Walks to a location if the Player is not already there
	 *
	 * @param destination - place to walk to
	 */
	public static void daxWalkTo(final Positionable destination) {
		while (!isDistanceFrom(destination, 5)) {
			General.println("[Rooftops] DaxWalking to " + destination.toString());
			DaxWalker.walkTo(destination);
			Timing.waitCondition(() -> !Player.isMoving(), 5000);
		}
	}
	
	/**
	 * Web Walks to a location if the Player is not already there
	 *
	 * @param destination - place to walk to
	 */
	public static void webWalkTo(final Positionable destination) {
		while (!isDistanceFrom(destination, 1)) {
			General.println("[Rooftops] WebWalking to " + destination.toString());
			WebWalking.walkTo(destination);
			Timing.waitCondition(() -> !Player.isMoving(), 5000);
		}
	}

	/**
	 * Checks if the player is standing on a specific tile
	 *
	 * @param destination - the location of the tile to check against
	 * @return true/false
	 */
	public static boolean isDistanceFrom(final Positionable destination, final int distance) {
		boolean isNear = false;

		if (Player.getPosition().getPlane() == destination.getPosition().getPlane()) {
			isNear = Player.getPosition().distanceTo(destination) <= distance;
		}

		return isNear;
	}

	/**
	 * Counts the number of items in an inventory
	 *
	 * @param item - name of the item to search for
	 * @return true/false
	 */
	public static int getInventoryItemCount(final String item) {
		return inventoryContains(item) ? Inventory.getCount(item) : 0;
	}

	/**
	 * Checks if the inventory contains a specific item
	 *
	 * @param item - name of the item to search for
	 * @return true/false
	 */
	public static boolean inventoryContains(final String item) {
		return Inventory.find(item).length > 0;
	}

	/**
	 * Checks if an interactive object is close to the player
	 *
	 * @param object - id of the interactive object to check for
	 * @return - true/false
	 */
	public static boolean isObjectClose(final RSObject object) {
		return isDistanceFrom(object.getPosition(), 25);
	}

	/**
	 * Interacts with an object using a specified button
	 *
	 * @param object - object to interact with
	 * @param button - button to click with
	 * @return true/false
	 */
	public static boolean interactWithObject(final String object, final int button) {
		final RSObject[] objects = Objects.findNearest(25, object);

		if (objects.length == 0 || !isObjectClose(objects[0])) {
			return false;
		}

		if (!objects[0].isClickable()) {
			General.println("[Rooftops] Turning camera to face: " + object);
			Camera.turnToTile(objects[0].getPosition());
			General.sleep(100, 200);
			return false;
		}

		General.println("[Rooftops] Attempting to interact with " + object);
		final boolean isInteracted = DynamicClicking.clickRSObject(objects[0], button);
		General.println("[Rooftops] Interacted with " + object + ": " + isInteracted);

		General.sleep(Numbers.TWO_TICKS, Numbers.THREE_TICKS);

		return isInteracted;
	}

	/**
	 * Checks if an item is close to the player
	 *
	 * @param item - item to check for
	 * @return true/false
	 */
	public static boolean isItemClose(final RSGroundItem item) {
		return Player.getPosition().distanceTo(item.getPosition()) < 25
				&& PathFinding.canReach(item.getPosition(), false);
	}

	/**
	 * Pick up a stackable item off the ground
	 *
	 * @param id       - item name to pickup
	 * @param distance - distance to search
	 */
	public static boolean takeNearbyStackable(final String name, final int distance) {
		if (Inventory.isFull() && !inventoryContains(name)) {
			return false;
		}

		final RSGroundItem[] items = GroundItems.findNearest(name);

		if (items.length == 0 || !isItemClose(items[0])) {
			return false;
		}

		if (!items[0].isClickable()) {
			General.println("[Rooftops] Turning camera to face: " + name);
			Camera.turnToTile(items[0].getPosition());
			General.sleep(100, 200);
			return false;
		}

		final int count = getInventoryItemCount(name);

		General.println("[Rooftops] Attempting to take nearby " + name);
		if (items[0].click("Take")) {
			Timing.waitCondition(() -> getInventoryItemCount(name) > count, Numbers.FIVE_SECONDS);
		}

		return getInventoryItemCount(name) > count;
	}
	
	/**
	 * Checks if an amount of time has elapsed
	 * 
	 * @param startTime    - the start time
	 * @param timeToElapse - the amount of time to elapse
	 * @return true/false
	 */
	public static boolean isTimeElapsed(final long startTime, final long time) {
		return (System.currentTimeMillis() - startTime) > time;
	}

}
