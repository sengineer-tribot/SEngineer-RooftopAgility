package scripts.rt.courses;

import java.util.Arrays;

import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

/**
 * 
 * Class to represent an Obstacle
 * 
 * @author SEngineer
 * 
 */
public class Obstacle {

	private final String obstacle;
	private final RSTile startTile;
	private final RSArea landArea;
	private final boolean canFail;

	/**
	 * 
	 * @param obstacle - the name of the obstacle we are interacting with
	 * @param startTile - can be null - the tile to walk to before attempting to click the obstacle
	 * @param landArea - the area we land on once we complete an obstacle
	 */
	public Obstacle(final String obstacle, final RSTile startTile, final RSArea landArea, final boolean canFail) {
		this.obstacle = obstacle;
		this.startTile = startTile;
		this.landArea = landArea;
		this.canFail = canFail;
	}

	public String getObstacle() {
		return this.obstacle;
	}

	public RSTile getStartTile() {
		return this.startTile;
	}

	public RSArea getLandingArea() {
		return this.landArea;
	}
	
	public boolean canFail() {
		return this.canFail;
	}
	
	public boolean hasLanded() {
		return getLandingArea().contains(Player.getPosition());
	}

	public boolean hasFallen() {
		return Player.getPosition().getPlane() == 0;
	}
	
	@Override
	public String toString() {
		return "Obstacle: " + obstacle + " || Start Tile: " + getStartTile().toString() + " || Landing Area: "
				+ Arrays.toString(getLandingArea().getAllTiles());
	}

}