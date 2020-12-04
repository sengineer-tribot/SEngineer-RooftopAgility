package scripts.rt.support;
import org.tribot.api2007.Game;

/**
 * @author Encoded
 */
public class QuestSupport {

    /**
     * Gets the player's quest points.
     *
     * @return amount of quest points
     */
    public static int getQuestPoints() {
        return Game.getSetting(101);
    }

    public enum Quest {

        PRIEST_IN_PERIL(302, 0, 61);

		private int setting;
		private int notStarted;
		private int complete;

		Quest(int setting, int notStarted, int complete) {
			this.setting = setting;
			this.notStarted = notStarted;
			this.complete = complete;
		}

		/**
		 * Checks if the quest is completed. (Green)
		 *
		 * @return true if completed, false otherwise
		 */
		public boolean isComplete() {
			return Game.getSetting(setting) >= complete;
		}

    }

}
