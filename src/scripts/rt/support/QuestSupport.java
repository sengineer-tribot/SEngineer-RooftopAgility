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

        PRIEST_IN_PERIL(0, 0 , 0);

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
			if (this == SHIELD_OF_ARRAV) {
				return isShieldOfArravComplete();
			}

			return Game.getSetting(setting) >= complete;
		}

		/**
		 * Checks if the quest is started, but not complete. (Yellow)
		 *
		 * @return true if started, false otherwise
		 */
		public boolean isStarted() {
			if (this == SHIELD_OF_ARRAV) {
				return isShieldOfArravStarted();
			}

			return Game.getSetting(setting) != notStarted && !isComplete();
		}

		/**
		 * Checks if the quest is not started. (Red)
		 *
		 * @return true if not started, false otherwise
		 */
		public boolean isNotStarted() {
			if (this == SHIELD_OF_ARRAV) {
				return isShieldOfArravNotStarted();
			}

			return Game.getSetting(setting) == notStarted;
		}

		private boolean isShieldOfArravComplete() {
			int black = Game.getSetting(146);
			int phoenix = Game.getSetting(145);

			return black == 4 || phoenix == 7;
		}

		private boolean isShieldOfArravStarted() {
			int black = Game.getSetting(146);
			int phoenix = Game.getSetting(145);

			return black != 0 && phoenix != 0 && !isShieldOfArravComplete();
		}

		private boolean isShieldOfArravNotStarted() {
			int black = Game.getSetting(146);
			int phoenix = Game.getSetting(145);

			return black == 0 && phoenix == 0;
		}
    }

}
