package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

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
		isRooftop = true;
		courseStart = new RSTile(3352, 2963, 0);
		maxTimeout = 10000;
		
		course = new Obstacle[] {
				new Obstacle("Basket", null, new RSArea(new RSTile(3351, 2964, 1), new RSTile(3351, 2964, 1)), false),
				new Obstacle("Market stall", null, new RSArea(new RSTile(3352, 2973, 1), new RSTile(3352, 2973, 1)), true),
				new Obstacle("Banner", null, new RSArea(new RSTile(3360, 2977, 1), new RSTile(3360, 2977, 1)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3366, 2976, 1), new RSTile(3366, 2976, 1)), true),
				new Obstacle("Tree", null, new RSArea(new RSTile(3368, 2982, 1), new RSTile(3368, 2982, 1)), true),
				new Obstacle("Rough wall", null, new RSArea(new RSTile(3365, 2983, 2), new RSTile(3365, 2983, 2)), true),
				new Obstacle("Monkeybars", null, new RSArea(new RSTile(3358, 2991, 2), new RSTile(3358, 2991, 2)), true),
				new Obstacle("Tree", null, new RSArea(new RSTile(3359, 3000, 2), new RSTile(3359, 3000, 2)), true),
				new Obstacle("Drying line", null, new RSArea(new RSTile(3363, 2998, 0), new RSTile(3363, 2998, 0)), false)
		};

	}
}
