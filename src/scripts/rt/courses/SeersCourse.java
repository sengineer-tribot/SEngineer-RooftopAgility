package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

/**
 * 
 * Seers Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class SeersCourse extends Course {

	public SeersCourse() {

		name = "Seers Rooftop";
		isRooftop = true;
		courseStart = new RSTile(2729, 3487, 0);
		maxTimeout = 10000;
		
		course = new Obstacle[] {
				new Obstacle("Wall", null, new RSArea(new RSTile(2729, 3491, 3), new RSTile(2729, 3491, 3)), false),
				new Obstacle("Gap", null, new RSArea(new RSTile(2713, 3493, 2), new RSTile(2713, 3494, 2)), true),
				new Obstacle("Tightrope", null, new RSArea(new RSTile(2710, 3480, 2), new RSTile(2710, 3480, 2)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(2708, 3472, 3), new RSTile(2714, 3472, 3)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(2696, 3468, 2), new RSTile(2705, 3465, 2)), true),
				new Obstacle("Edge", null, new RSArea(new RSTile(2704, 3464, 0), new RSTile(2704, 3464, 0)), false)
		};
		
		finishToStartPath = new RSTile[] {
			    new RSTile(2705, 3462, 0),
			    new RSTile(2719, 3462, 0),
			    new RSTile(2721, 3468, 0),
			    new RSTile(2725, 3475, 0),
			    new RSTile(2727, 3481, 0),
			    courseStart
		};

	}
}
