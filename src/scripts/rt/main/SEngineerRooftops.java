package scripts.rt.main;

import java.awt.Color;
import java.awt.Graphics;

import org.tribot.api.General;
import org.tribot.api2007.Login;
import org.tribot.api2007.Skills;
import org.tribot.api2007.Skills.SKILLS;
import org.tribot.script.Script;
import org.tribot.script.ScriptManifest;
import org.tribot.script.interfaces.Painting;

import scripts.rt.courses.AlKharidCourse;
import scripts.rt.courses.ArdougneCourse;
import scripts.rt.courses.CanifisCourse;
import scripts.rt.courses.Course;
import scripts.rt.courses.DraynorCourse;
import scripts.rt.courses.FaladorCourse;
import scripts.rt.courses.GnomeCourse;
import scripts.rt.courses.PollniveachCourse;
import scripts.rt.courses.RelekkaCourse;
import scripts.rt.courses.SeersCourse;
import scripts.rt.courses.VarrockCourse;
import scripts.rt.paint.FluffeesPaint;
import scripts.rt.paint.PaintInfo;
import scripts.rt.support.QuestSupport;
import scripts.rt.utils.Utils;

@ScriptManifest(authors = {
		"SEngineer" }, category = "Agility", name = "SEngineer's Rooftops", version = 3.00, description = "Rooftop Agility", gameMode = 1)

/**
 *
 * Rooftop Agility Script
 *
 * This script will train agility on rooftops
 *
 * @author SEngineer
 *
 */
public class SEngineerRooftops extends Script implements PaintInfo, Painting {

	private final Double scriptVersion = 3.00;

	private final FluffeesPaint display = new FluffeesPaint(
			this, FluffeesPaint.PaintLocations.TOP_RIGHT_CHATBOX,
			new Color[] { new Color(255, 251, 255) }, "Trebuchet MS", new Color[] { new Color(93, 156, 236, 127) },
			new Color[] { new Color(39, 95, 175) }, 1, false, 5, 3, 0);

	private Course course = new DraynorCourse();
	public static int xp = Skills.getXP(SKILLS.AGILITY);
	public static int level = Skills.getActualLevel(SKILLS.AGILITY);
	public static int courseStartLevel = level;
	public static int marks = 0;

	@Override
	public void run() {
		General.println("[Rooftops] Starting SEngineer's Rooftops");
		Utils.configureDaxWalker();
		General.useAntiBanCompliance(true);
		Login.login();

		while (true) {
			course = getCourse();
			course.doCourse();
		}
	}

	@Override
	public String[] getPaintInfo() {
        return new String[] {
        		"SEngineer's Rooftops v" + String.format("%.2f", scriptVersion),
        		"Course: " + course.getName(),
        		"XP Gained: " + (Skills.getXP(SKILLS.AGILITY) - xp),
        		"Levels Gained: " + (Skills.getActualLevel(SKILLS.AGILITY) - level),
        		"Marks Collected: " + marks,
        		"Script Runtime: " + display.getRuntimeString(),
        };
	}

	@Override
	public void onPaint(final Graphics gfx) {
		display.paint(gfx);
	}

	/**
	 * Returns the best possible course that can be completed
	 * @return Course
	 */
	public Course getCourse() {
		if (Skills.getActualLevel(SKILLS.AGILITY) >= 90) {
			return new ArdougneCourse();
		} else if (Skills.getActualLevel(SKILLS.AGILITY) >= 80) {
			return new RelekkaCourse();
		} else if (Skills.getActualLevel(SKILLS.AGILITY) >= 70) {
			return new PollniveachCourse();
		} else if (Skills.getActualLevel(SKILLS.AGILITY) >= 60) {
			return new SeersCourse();
		} else if (Skills.getActualLevel(SKILLS.AGILITY) >= 50) {
			return new FaladorCourse();
		} else if (Skills.getActualLevel(SKILLS.AGILITY) >= 40 && QuestSupport.Quest.PRIEST_IN_PERIL.isComplete()) {
			return new CanifisCourse();
		} else if (Skills.getActualLevel(SKILLS.AGILITY) >= 30) {
			return new VarrockCourse();
		} else if (Skills.getActualLevel(SKILLS.AGILITY) >= 20) {
			return new AlKharidCourse();
		} else if (Skills.getActualLevel(SKILLS.AGILITY) >= 10) {
			return new DraynorCourse();
		} else {
			return new GnomeCourse();
		}
	}
}
