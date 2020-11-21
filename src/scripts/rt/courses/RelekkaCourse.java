package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.rt.utils.Utils;

/**
 * 
 * Relekka Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class RelekkaCourse extends Course {

	public RelekkaCourse() {

		name = "Relekka Rooftop";
		marks = true;
		courseStart = new RSTile(2625, 3678, 0);
		maxTimeout = 10000;

		course = Utils.add(course,
				new Obstacle("Rough wall", courseStart, new RSArea(new RSTile(2625, 3676, 3), new RSTile(2625, 3676, 3)), false));
		
		course = Utils.add(course, 
				new Obstacle("Gap", null, new RSArea(new RSTile(2622, 3668, 3), new RSTile(2622, 3668, 3)), true));
		course = Utils.add(course, 
				new Obstacle("Tightrope", null, new RSArea(new RSTile(2627, 3654, 3), new RSTile(2627, 3654, 3)), true));
		course = Utils.add(course, 
				new Obstacle("Gap", null, new RSArea(new RSTile(2639, 3653, 3), new RSTile(2639, 3653, 3)), true));
		course = Utils.add(course, 
				new Obstacle("Gap", null, new RSArea(new RSTile(2643, 3657, 3), new RSTile(2643, 3657, 3)), true));
		course = Utils.add(course, 
				new Obstacle("Tightrope", null, new RSArea(new RSTile(2655, 3670, 3), new RSTile(2655, 3670, 3)), true));
		
		course = Utils.add(course, 
				new Obstacle("Pile of fish", null, new RSArea(new RSTile(2652, 3676, 0), new RSTile(2652, 3676, 0)), false));

	}
}
