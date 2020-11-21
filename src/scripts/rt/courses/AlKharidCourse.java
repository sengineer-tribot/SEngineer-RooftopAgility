package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.rt.utils.Utils;

/**
 * 
 * Al Kharid Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class AlKharidCourse extends Course {

	public AlKharidCourse() {

		name = "Al Kharid Rooftop";
		marks = true;
		courseStart = new RSTile(3275, 3197, 0);
		maxTimeout = 10000;

		course = Utils.add(course, 
				new Obstacle("Rough wall", courseStart, new RSArea(new RSTile(3273, 3192, 3), new RSTile(3273, 3192, 3)), false));

		course = Utils.add(course, 
				new Obstacle("Tightrope", null, new RSArea(new RSTile(3272, 3172, 3), new RSTile(3272, 3172, 3)), true));
		course = Utils.add(course, 
				new Obstacle("Cable", null, new RSArea(new RSTile(3284, 3166, 3), new RSTile(3284, 3166, 3)), true));
		course = Utils.add(course, 
				new Obstacle("Zip line", new RSTile(3300, 3163, 3), new RSArea(new RSTile(3315, 3163, 1), new RSTile(3315, 3163, 1)), true));
		course = Utils.add(course, 
				new Obstacle("Tropical tree", null, new RSArea(new RSTile(3317, 3174, 2), new RSTile(3317, 3174, 2)), true));
		course = Utils.add(course, 
				new Obstacle("Roof top beams", null, new RSArea(new RSTile(3316, 3180, 3), new RSTile(3316, 3180, 3)), true));
		course = Utils.add(course, 
				new Obstacle("Tightrope", null, new RSArea(new RSTile(3302, 3187, 3), new RSTile(3305, 3189, 3)), true));

		course = Utils.add(course,
				new Obstacle("Gap", null, new RSArea(new RSTile(3299, 3194, 0), new RSTile(3299, 3194, 0)), false));

	}
}
