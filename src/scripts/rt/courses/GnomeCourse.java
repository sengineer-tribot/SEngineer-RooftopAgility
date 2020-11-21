package scripts.rt.courses;

import org.tribot.api2007.types.RSArea;
import org.tribot.api2007.types.RSTile;

import scripts.rt.utils.Utils;

/**
 * 
 * Gnome Agility Course
 * 
 * @author SEngineer
 *
 */
public class GnomeCourse extends Course {

	public GnomeCourse() {

		name = "Gnome Agility";
		marks = false;
		courseStart = new RSTile(2473, 3438, 0);
		maxTimeout = 6000;

		course = Utils.add(course, 
				new Obstacle("Log balance", courseStart, new RSArea(new RSTile(2474, 3429, 0), new RSTile(2474, 3429, 0)), false));

		course = Utils.add(course, 
				new Obstacle("Obstacle net", null, new RSArea(new RSTile(2471, 3423, 1), new RSTile(2476, 3424, 1)), false));
		course = Utils.add(course, 
				new Obstacle("Tree branch", null, new RSArea(new RSTile(2473, 3420, 2), new RSTile(2473, 3420, 2)), false));
		course = Utils.add(course, 
				new Obstacle("Balancing rope", null, new RSArea(new RSTile(2483, 3420, 2), new RSTile(2483, 3420, 2)), false));
		course = Utils.add(course, 
				new Obstacle("Tree branch", null, new RSArea(new RSTile(2487, 3420, 0), new RSTile(2487, 3420, 0)), false));
		course = Utils.add(course, 
				new Obstacle("Obstacle net", null, new RSArea(new RSTile(2483, 3427, 0), new RSTile(2488, 3428, 0)), false));

		course = Utils.add(course, 
				new Obstacle("Obstacle pipe", null, new RSArea(new RSTile(2484, 3437, 0), new RSTile(2487, 3437, 0)), false));

	}
}
