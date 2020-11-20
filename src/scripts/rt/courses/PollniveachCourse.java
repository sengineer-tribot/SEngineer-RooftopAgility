package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.rt.utils.Utils;

/**
 * 
 * Pollniveach Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class PollniveachCourse extends Course {

	public PollniveachCourse() {

		name = "Pollniveach Rooftop";
		marks = true;
		courseStart = new RSTile(3352, 2963, 0);
		maxTimeout = 10000;

		roofUp = new Obstacle("Basket", courseStart, new RSArea(new RSTile(3351, 2964, 1), new RSTile(3351, 2964, 1)));
		
		course = Utils.add(course, 
				new Obstacle("Market stall", null, new RSArea(new RSTile(3352, 2973, 1), new RSTile(3352, 2973, 1))));
		course = Utils.add(course, 
				new Obstacle("Banner", null, new RSArea(new RSTile(3360, 2977, 1), new RSTile(3360, 2977, 1))));
		course = Utils.add(course, 
				new Obstacle("Gap", null, new RSArea(new RSTile(3366, 2976, 1), new RSTile(3366, 2976, 1))));
		course = Utils.add(course, 
				new Obstacle("Tree", null, new RSArea(new RSTile(3368, 2982, 1), new RSTile(3368, 2982, 1))));
		course = Utils.add(course, 
				new Obstacle("Rough wall", null, new RSArea(new RSTile(3365, 2983, 2), new RSTile(3365, 2983, 2))));
		course = Utils.add(course, 
				new Obstacle("Monkeybars", null, new RSArea(new RSTile(3358, 2991, 2), new RSTile(3358, 2991, 2))));
		course = Utils.add(course, 
				new Obstacle("Tree", null, new RSArea(new RSTile(3359, 3000, 2), new RSTile(3359, 3000, 2))));

		roofDown = new Obstacle("Drying line", null, new RSArea(new RSTile(3363, 2998, 0), new RSTile(3363, 2998, 0)));

	}
}
