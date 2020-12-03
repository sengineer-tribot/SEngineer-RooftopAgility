package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

/**
 * 
 * Draynor Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class DraynorCourse extends Course {

	public DraynorCourse() {

		name = "Draynor Rooftop";
		marks = true;
		courseStart = new RSTile(310, 3279, 0);
		maxTimeout = 10000;
		
		course = new Obstacle[] {
				new Obstacle("Rough wall", courseStart, new RSArea(new RSTile(3102, 3279, 3), new RSTile(3102, 3279, 3)), false),
				new Obstacle("Tightrope", null, new RSArea(new RSTile(3090, 3276, 3), new RSTile(3090, 3276, 3)), true),
				new Obstacle("Tightrope", null, new RSArea(new RSTile(3094, 3267, 3), new RSTile(3092, 3266, 3)), true),
				new Obstacle("Narrow wall", null, new RSArea(new RSTile(3088, 3261, 3), new RSTile(3088, 3261, 3)), true),
				new Obstacle("Wall", null, new RSArea(new RSTile(3088, 3255, 3), new RSTile(3088, 3255, 3)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3096, 3256, 3), new RSTile(3096, 3256, 3)), true),
				new Obstacle("Crate", null, new RSArea(new RSTile(3103, 3261, 0), new RSTile(3103, 3261, 0)), false)
		};

	}
}
