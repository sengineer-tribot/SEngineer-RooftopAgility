package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

/**
 * 
 * Falador Rooftop Agility Course
 * 
 * @author SEngineer
 *
 */
public class FaladorCourse extends Course {

	public FaladorCourse() {

		name = "Falador Rooftop";
		isRooftop = true;
		courseStart = new RSTile(3035, 3340, 0);
		maxTimeout = 10000;
		
		course = new Obstacle[] {
				new Obstacle("Rough wall", null, new RSArea(new RSTile(3036, 3342, 3), new RSTile(3036, 3342, 3)), false),
				new Obstacle("Tightrope", null, new RSArea(new RSTile(3047, 3344, 3), new RSTile(3047, 3344, 3)), true),
				new Obstacle("Hand holds", null, new RSArea(new RSTile(3050, 3357, 3), new RSTile(3050, 3357, 3)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3048, 3361, 3), new RSTile(3048, 3361, 3)), true),
				new Obstacle("Gap", new RSTile(3045, 3362, 3), new RSArea(new RSTile(3041, 3361, 3), new RSTile(3041, 3364, 3)), true),
				new Obstacle("Tightrope", null, new RSArea(new RSTile(3028, 3354, 3), new RSTile(3028, 3354, 3)), true),
				new Obstacle("Tightrope", null, new RSArea(new RSTile(3020, 3353, 3), new RSTile(3020, 3353, 3)), true),
				new Obstacle("Gap", null, new RSArea(new RSTile(3018, 3349, 3), new RSTile(3018, 3349, 3)), true),
				new Obstacle("Ledge", null, new RSArea(new RSTile(3014, 3346, 3), new RSTile(3014, 3346, 3)), true),
				new Obstacle("Ledge", new RSTile(3011, 3344, 3), new RSArea(new RSTile(3011, 3342, 3), new RSTile(3013, 3342, 3)), true),
				new Obstacle("Ledge", new RSTile(3012, 3336, 3), new RSArea(new RSTile(3012, 3333, 3), new RSTile(3012, 3333, 3)), true),
				new Obstacle("Ledge", new RSTile(3017, 3334, 3), new RSArea(new RSTile(3019, 3332, 3), new RSTile(3019, 3335, 3)), true),
				new Obstacle("Edge", null, new RSArea(new RSTile(3029, 3332, 0), new RSTile(3029, 3335, 0)), false)
		};

	}
}
