package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

/**
 * 
 * Canifis Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class CanifisCourse extends Course {

	public CanifisCourse() {

		name = "Canifis Rooftop";
		isRooftop = true;
		courseStart = new RSTile(3507, 3487, 0);
		maxTimeout = 10000;
		
		course = new Obstacle[] {
				new Obstacle("Tall tree", null, new RSArea(new RSTile(3505, 3489, 2), new RSTile(3507, 3495, 2)), false),
				new Obstacle("Gap", new RSTile(3507, 3495, 2), new RSArea(new RSTile(3502, 3504, 2), new RSTile(3502, 3504, 2)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3492, 3504, 2), new RSTile(3492, 3504, 2)), true),
				new Obstacle("Gap", new RSTile(3487, 3500, 2), new RSArea(new RSTile(3479, 3499, 3), new RSTile(3479, 3499, 3)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3478, 3486, 2), new RSTile(3478, 3486, 2)), true),
				new Obstacle("Pole-vault", null, new RSArea(new RSTile(3491, 3477, 3), new RSTile(3486, 3471, 3)), true),
				new Obstacle("Gap", new RSTile(3502, 3476, 3), new RSArea(new RSTile(3510, 3476, 2), new RSTile(3510, 3476, 2)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3510, 3485, 0), new RSTile(3510, 3485, 0)), false)
		};

	}
}
