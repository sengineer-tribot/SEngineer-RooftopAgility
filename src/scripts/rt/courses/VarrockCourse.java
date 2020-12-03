package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

/**
 * 
 * Varrock Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class VarrockCourse extends Course {

	public VarrockCourse() {

		name = "Varrock Rooftop";
		marks = true;
		courseStart = new RSTile(3222, 3415, 0);
		maxTimeout = 12000;

		course = new Obstacle[] {
				new Obstacle("Rough wall", courseStart, new RSArea(new RSTile(3219, 3414, 3), new RSTile(3219, 3414, 3)), false),
				new Obstacle("Clothes line", null, new RSArea(new RSTile(3208, 3414, 3), new RSTile(3208, 3414, 3)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3197, 3416, 1), new RSTile(3197, 3416, 1)), true),
				new Obstacle("Wall", null, new RSArea(new RSTile(3192, 3406, 3), new RSTile(3192, 3406, 3)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3201, 3398, 3), new RSTile(3191, 3398, 3)), true),
				new Obstacle("Gap", new RSTile(3208, 3401, 3), new RSArea(new RSTile(3218, 3402, 3), new RSTile(3218, 3395, 3)), true),
				new Obstacle("Gap", new RSTile(3232, 3401, 3), new RSArea(new RSTile(3236, 3403, 3), new RSTile(3236, 3403, 3)), true),
				new Obstacle("Ledge", null, new RSArea(new RSTile(3236, 3410, 3), new RSTile(3240, 3410, 3)), true),
				new Obstacle("Edge", null, new RSArea(new RSTile(3240, 3417, 0), new RSTile(3236, 3417, 0)), false)		
		};

		finishToStartPath = new RSTile[] {
			    new RSTile(3227, 3416, 0),
			    courseStart
		};
	}
}
