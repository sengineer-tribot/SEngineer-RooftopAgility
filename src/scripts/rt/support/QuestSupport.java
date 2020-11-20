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
        // Free
        BLACK_KNIGHTS_FORTRESS(130, 0 , 4),
        COOKS_ASSISTANT(29, 0, 2),
        DEMON_SLAYER(222, 0 , 22220899),
        DORICS_QUEST(31, 0, 100),
        DRAGON_SLAYER(176, 0 , 10), // 177?
        ERNEST_THE_CHICKEN(32, 0 , 3),
        GOBLIN_DIPLOMACY(62, 0 , 6),
        IMP_CATCHER(160, 0, 2),
        THE_KNIGHTS_SWORD(122, 0 , 7),
        PIRATES_TREASURE(71, 0, 4),
        PRINCE_ALI_RESCUE(273, 0 , 110),
        THE_RESTLESS_GHOST(107, 0 , 5),
        ROMEO_AND_JULIET(144, 0 , 100),
        RUNE_MYSTERIES(63, 0, 6),
        SHEEP_SHEARER(179, 0, 21),
        SHIELD_OF_ARRAV(146, 0 , 4), // Black Arm Gang Settings, Phoenix Gang = 145, 0, 7
        VAMPIRE_SLAYER(178, 0 , 3),
        WITCHS_POTION(67, 0, 3),
        // Member
        ANIMAL_MAGNETISM(0, 0 , 0),
        ANOTHER_SLICE_OF_HAM(0, 0 , 0),
        BETWEEN_A_ROCK(0, 0 , 0),
        BIG_CHOMPY_BIRD_HUNTING(0, 0 , 0),
        BIOHAZARD(0, 0 , 0),
        CABIN_FEVER(0, 0 , 0),
        CLOCK_TOWER(0, 0 , 0),
        COLD_WAR(0, 0 , 0),
        CONTACT(0, 0 , 0),
        CREATURE_OF_FENKENSTRAIN(0, 0 , 0),
        DARKNESS_OF_HALLOWVALE(0, 0 , 0),
        DEATH_PLATEAU(314, 0 , 80),
        DEATH_TO_THE_DORGESHUUN(0, 0 , 0),
        DESERT_TREASURE(0, 0 , 0),
        DEVIOUS_MINDS(0, 0 , 0),
        THE_DIG_SITE(0, 0 , 0),
        DREAM_MENTOR(0, 0 , 0),
        DRUIDIC_RITUAL(80, 0 , 4),
        DWARF_CANNON(0, 0 , 0),
        EADGARS_RUSE(0, 0 , 0),
        EAGLES_PEAK(0, 0 , 0),
        ELEMENTAL_WORKSHOP_I(0, 0 , 0),
        ELEMENTAL_WORKSHOP_II(0, 0 , 0),
        ENAKHRAS_LAMENT(0, 0 , 0),
        ENLIGHTENED_JOURNEY(0, 0 , 0),
        THE_EYES_OF_GLOUPHRIE(0, 0 , 0),
        FAIRYTALE_I_GROWING_PAINTS(671, 0 , 0),
        FAIRYTALE_II_CURE_A_QUEEN(0, 0 , 0),
        FAMILY_CREST(0, 0 , 0),
        THE_FEUD(0, 0 , 0),
        FIGHT_AREA(17, 0 , 15),
        FISHING_CONTEST(0, 0 , 0),
        FORGETTABLE_TALE(0, 0 , 0),
        THE_FREMENNIK_ISLES(0, 0 , 0),
        THE_FREMENNIK_TRIALS(347, 0 , 0),
        GARDEN_OF_TRANQUILITY(0, 0 , 0),
        GERTRUDES_CAT(180, 0 , 6),
        GHOSTS_AHOY(0, 0 , 0),
        THE_GIANT_DWARF(0, 0 , 0),
        THE_GOLEM(0, 0 , 0),
        THE_GRAND_TREE(150, 0 , 160),
        THE_GREAT_BRAIN_ROBBERY(0, 0 , 0),
        GRIM_TALES(0, 0 , 0),
        THE_HAND_IN_THE_SAND(0, 0 , 0),
        HAUNTED_MINE(0, 0 , 0),
        HAZEEL_CULT(0, 0 , 0),
        HEROES_QUEST(0, 0 , 0),
        HOLY_GRAIL(0, 0 , 0),
        HORROR_FROM_THE_DEEP(0, 0 , 0),
        ICTHLARINS_LITTLE_HELPER(0, 0 , 0),
        IN_AID_OF_THE_MYREQUE(705, 0 , 0),
        IN_SEARCH_OF_THE_MYREQUE(387, 0 , 110),
        JUNGLE_POTION(175, 0 , 7),
        KINGS_RANSOM(0, 0 , 0),
        LEGENDS_QUEST(0, 0 , 0),
        LOST_CITY(0, 0 , 0),
        THE_LOST_TRIBE(0, 0 , 0),
        LUNAR_DIPLOMACY(0, 0 , 0),
        MAKING_HISTORY(0, 0 , 0),
        MERLINS_CRYSTAL(0, 0 , 0),
        MONKS_FRIEND(30, 0 , 80),
        MONKEY_MADNESS_I(0, 0 , 0),
        MONKEY_MADNESS_II(0, 0 , 0),
        MOUNTAIN_DAUGHTER(0, 0 , 0),
        MOURNINGS_END_PART_I(0, 0 , 0),
        MOURNINGS_END_PART_II(0, 0 , 0),
        MURDER_MYSTERY(0, 0 , 0),
        MY_ARMS_BIG_ADVENTURE(0, 0 , 0),
        NATURE_SPIRIT(307, 0 , 110),
        OBSERVATORY_QUEST(0, 0 , 0),
        OLAFS_QUEST(0, 0 , 0),
        ONE_SMALL_FAVOUR(416, 0 , 280),
        PLAGUE_CITY(0, 0 , 0),
        PRIEST_IN_PERIL(0, 0 , 0),
        RAG_AND_BONE_MAN(0, 0 , 0),
        RATCATCHERS(0, 0 , 0),
        RECIPE_FOR_DISASTER(0, 0 , 0),
        RECRUITMENT_DRIVE(0, 0, 0),
        REGICIDE(0, 0, 0),
        ROVING_ELVES(0, 0, 0),
        ROYAL_TROUBLE(0, 0, 0),
        RUM_DEAL(0, 0, 0),
        SCORPION_CATCHER(0, 0, 0),
        SEA_SLUG(0, 0, 0),
        SHADES_OF_MORTTON(0, 0, 0),
        SHADOW_OF_THE_STORM(0, 0, 0),
        SHEEP_HERDER(0, 0, 0),
        SHILO_VILLAGE(116, 0, 15),
        THE_SLUG_MENACE(0, 0, 0),
        A_SOULS_BANE(0, 0, 0),
        SPIRITS_OF_THE_ELID(0, 0, 0),
        SWAN_SONG(723, 0, 1071511752),
        TAI_BWO_WANNAI_TRIO(0, 0, 0),
        A_TAIL_OF_TWO_CATS(0, 0, 0),
        TEARS_OF_GUTHIX(0, 0, 0),
        TEMPLE_OF_IKOV(0, 0, 0),
        THRONE_OF_MISCELLANIA(0, 0, 0),
        THE_TOURIST_TRAP(0, 0, 0),
        TOWER_OF_LIFE(0, 0, 0),
        TREE_GNOME_VILLAGE(111, 0, 9),
        TRIBAL_TOTEM(0, 0, 0),
        TROLL_ROMANCE(0, 0, 0),
        TROLL_STRONGHOLD(0, 0, 0),
        UNDERGROUND_PASS(0, 0, 0),
        WANTED(0, 0, 0),
        WATCHTOWER(0, 0, 0),
        WATERFALL_QUEST(65, 0, 10),
        WHAT_LIES_BELOW(0, 0, 0),
        WITCHES_HOUSE(226, 0, 7),
        ZORGE_FLESH_EATERS(0, 0, 0);

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