package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.rt.utils.Utils;

/**
 * 
 * Ardougne Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class ArdougneCourse extends Course {

	public ArdougneCourse() {

		name = "Ardougne Rooftop";
		marks = true;
		courseStart = new RSTile(2673, 3297, 0);
		maxTimeout = 10000;

		roofUp = new Obstacle("Wooden Beams", courseStart, new RSArea(new RSTile(2671, 3299, 3), new RSTile(2671, 3299, 3)));

		course = Utils.add(course, 
				new Obstacle("Gap", new RSTile(2671, 3309, 3), new RSArea(new RSTile(2665, 3318, 3), new RSTile(2665, 3318, 3))));
		course = Utils.add(course, 
				new Obstacle("Plank", null, new RSArea(new RSTile(2657, 3318, 3), new RSTile(2657, 3318, 3))));
		course = Utils.add(course, 
				new Obstacle("Gap", null, new RSArea(new RSTile(2653, 3314, 3), new RSTile(2653, 3314, 3))));
		course = Utils.add(course, 
				new Obstacle("Gap", new RSTile(2653, 3310, 3), new RSArea(new RSTile(2651, 3309, 3), new RSTile(2651, 3309, 3))));
		course = Utils.add(course, 
				new Obstacle("Steep roof", null, new RSArea(new RSTile(2656, 3297, 3), new RSTile(2656, 3297, 3))));
		
		roofDown = new Obstacle("Gap", null, new RSArea(new RSTile(2668, 3297, 0), new RSTile(2668, 3297, 0)));

	}
}
