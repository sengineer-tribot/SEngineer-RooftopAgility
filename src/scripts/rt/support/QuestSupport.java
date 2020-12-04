package scripts.rt.support;
import org.tribot.api2007.Game;

/**
 * @author Encoded
 */
public class QuestSupport {

    public enum Quest {

        PRIEST_IN_PERIL(302, 61);

		private int setting;
		private int complete;

		Quest(int setting, int complete) {
			this.setting = setting;
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
