package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.rt.utils.Utils;

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
		courseStart = new RSTile(3221, 3414, 0);
		maxTimeout = 12000;

		roofUp = new Obstacle("Rough wall", courseStart, new RSArea(new RSTile(3219, 3414, 3), new RSTile(3219, 3414, 3)));
		
		course = Utils.add(course, 
				new Obstacle("Clothes line", null, new RSArea(new RSTile(3208, 3414, 3), new RSTile(3208, 3414, 3))));
		course = Utils.add(course, 
				new Obstacle("Gap", null, new RSArea(new RSTile(3197, 3416, 1), new RSTile(3197, 3416, 1))));
		course = Utils.add(course, 
				new Obstacle("Wall", null, new RSArea(new RSTile(3192, 3406, 3), new RSTile(3192, 3406, 3))));
		course = Utils.add(course, 
				new Obstacle("Gap", null, new RSArea(new RSTile(3201, 3398, 3), new RSTile(3191, 3398, 3))));
		course = Utils.add(course, 
				new Obstacle("Gap", new RSTile(3208, 3401, 3), new RSArea(new RSTile(3218, 3402, 3), new RSTile(3218, 3395, 3))));
		course = Utils.add(course, 
				new Obstacle("Gap", new RSTile(3232, 3401, 3), new RSArea(new RSTile(3236, 3403, 3), new RSTile(3236, 3403, 3))));
		course = Utils.add(course, 
				new Obstacle("Ledge", null, new RSArea(new RSTile(3236, 3410, 3), new RSTile(3240, 3410, 3))));

		roofDown = new Obstacle("Edge", null, new RSArea(new RSTile(3240, 3417, 0), new RSTile(3236, 3417, 0)));

	}
}
