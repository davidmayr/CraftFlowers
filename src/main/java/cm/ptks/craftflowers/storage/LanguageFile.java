package cm.ptks.craftflowers.storage;

import cm.ptks.craftflowers.CraftFlowers;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStreamReader;

public class LanguageFile {

	public static String COMMAND_NO_PERMISSION_USE;
	public static String COMMAND_VERSION;
	public static String COMMAND_AUTHOR;
	public static String COMMAND_WEBSITE;
	public static String COMMAND_NO_PERMISSION_SAVE;
	public static String COMMAND_SUCCESS_SAVE;
	public static String COMMAND_NEED_HOLD_CF_FLOWERPOT;
	public static String COMMAND_COMMAND_SAVE_TIP;
	public static String COMMAND_NO_PERMISSION_LOAD;
	public static String COMMAND_FLOWER_NOT_FOUND;
	public static String COMMAND_SUCCESS_LOAD;
	public static String COMMAND_COMMAND_LOAD_TIP;
	public static String COMMAND_NO_PERMISSION_DELETE;
	public static String COMMAND_CANT_DELETE;
	public static String COMMAND_SUCCESS_DELETE;
	public static String COMMAND_COMMAND_DELETE_TIP;
	public static String COMMAND_NO_PERMISSION_LIST;
	public static String COMMAND_NO_SAVED_FLOWERS;

	public static String FLOWER_INFO_AGE;
	public static String FLOWER_INFO_CANT_SERIALIZE_FLOWERGROUP;
	public static String FLOWER_INFO_CANT_ADD_MORE_THAN_9_FLOWERS;

	public static String FLOWER_SUNFLOWER;
	public static String FLOWER_SUGAR_CANE;
	public static String FLOWER_LILAC;
	public static String FLOWER_ROSE_BUSH;
	public static String FLOWER_PEONY;
	public static String FLOWER_TALL_GRASS;
	public static String FLOWER_LARGE_FERN;
	public static String FLOWER_OAK_SAPLING;
	public static String FLOWER_SPRUCE_SAPLING;
	public static String FLOWER_BIRCH_SAPLING;
	public static String FLOWER_JUNGLE_SAPLING;
	public static String FLOWER_ACACIA_SAPLING;
	public static String FLOWER_DARK_OAK_SAPLING;
	public static String FLOWER_DEAD_BUSH;
	public static String FLOWER_GRASS;
	public static String FLOWER_FERN;
	public static String FLOWER_NETHER_BRICK_FENCE;

	public static String FLOWER_DARK_OAK_FENCE;
	public static String FLOWER_SPRUCE_FENCE;
	public static String FLOWER_OAK_FENCE;
	public static String FLOWER_BIRCH_FENCE;
	public static String FLOWER_JUNGLE_FENCE;
	public static String FLOWER_ACACIA_FENCE;
	public static String FLOWER_CRIMSON_FENCE;
	public static String FLOWER_WARPED_FENCE;
	public static String FLOWER_MANGROVE_FENCE;
	public static String FLOWER_DANDELION;
	public static String FLOWER_POPPY;
	public static String FLOWER_BLUE_ORCHID;
	public static String FLOWER_ALLIUM;
	public static String FLOWER_AZURE_BLUET;
	public static String FLOWER_RED_TULIP;
	public static String FLOWER_ORANGE_TULIP;
	public static String FLOWER_WHITE_TULIP;
	public static String FLOWER_PINK_TULIP;
	public static String FLOWER_OXEYE_DAISY;
	public static String FLOWER_CORNFLOWER;
	public static String FLOWER_LILY_OF_THE_VALLEY;
	public static String FLOWER_WITHER_ROSE;
	public static String FLOWER_BROWN_MUSHROOM;
	public static String FLOWER_RED_MUSHROOM;
	public static String FLOWER_CRIMSON_FUNGUS;
	public static String FLOWER_WARPED_FUNGUS;
	public static String FLOWER_FLOWER_POT;

	public static String FLOWER_MOSS_BLOCK;
	public static String FLOWER_AZALEA;
	public static String FLOWER_FLOWERING_AZALEA;
	public static String FLOWER_AZALEA_LEAVES;
	public static String FLOWER_FLOWERING_AZALEA_LEAVES;
	public static String FLOWER_GLOW_BERRIES;
	public static String FLOWER_BIG_DRIPLEAF;
	public static String FLOWER_BIG_DRIPLEAF_STEM;
	public static String FLOWER_SMALL_DRIPLEAF;
	public static String FLOWER_SPORE_BLOSSOM;

	public static String FLOWER_MANGROVE_ROOTS;
	public static String FLOWER_MANGROVE_LEAVES;
	public static String FLOWER_MANGROVE_PROPAGULE;

	public static String FLOWER_OAK_LEAVES;
	public static String FLOWER_SPRUCE_LEAVES;
	public static String FLOWER_BIRCH_LEAVES;
	public static String FLOWER_JUNGLE_LEAVES;
	public static String FLOWER_ACACIA_LEAVES;
	public static String FLOWER_DARK_OAK_LEAVES;
	public static String FLOWER_LILY_PAD;
	public static String FLOWER_VINE;
	public static String FLOWER_CACTUS;
	public static String FLOWER_MELON;
	public static String FLOWER_PUMPKIN;
	public static String FLOWER_SEAGRASS;
	public static String FLOWER_SEA_PICKLE;
	public static String FLOWER_KELP;
	public static String FLOWER_BAMBOO;
	public static String FLOWER_END_ROD;
	public static String FLOWER_SOUL_LANTERN;
	public static String FLOWER_LANTERN;
	public static String FLOWER_COCOA_BEANS;
	public static String FLOWER_CRIMSON_ROOTS;
	public static String FLOWER_WEEPING_VINES;
	public static String FLOWER_WARPED_ROOTS;
	public static String FLOWER_NETHER_SPROUTS;
	public static String FLOWER_TWISTING_VINES;
	public static String FLOWER_BRAIN_CORAL;
	public static String FLOWER_BUBBLE_CORAL;
	public static String FLOWER_FIRE_CORAL;
	public static String FLOWER_HORN_CORAL;
	public static String FLOWER_TUBE_CORAL;
	public static String FLOWER_BRAIN_CORAL_FAN;
	public static String FLOWER_BUBBLE_CORAL_FAN;
	public static String FLOWER_FIRE_CORAL_FAN;
	public static String FLOWER_HORN_CORAL_FAN;
	public static String FLOWER_TUBE_CORAL_FAN;

	public static String FLOWER_WHEAT;
	public static String FLOWER_WHEAT_AGE_0;
	public static String FLOWER_WHEAT_AGE_1;
	public static String FLOWER_WHEAT_AGE_2;
	public static String FLOWER_WHEAT_AGE_3;
	public static String FLOWER_WHEAT_AGE_4;
	public static String FLOWER_WHEAT_AGE_5;
	public static String FLOWER_WHEAT_AGE_6;
	public static String FLOWER_WHEAT_AGE_7;

	public static String FLOWER_POTATO;
	public static String FLOWER_POTATO_AGE_0;
	public static String FLOWER_POTATO_AGE_1;
	public static String FLOWER_POTATO_AGE_2;
	public static String FLOWER_POTATO_AGE_3;
	public static String FLOWER_POTATO_AGE_4;
	public static String FLOWER_POTATO_AGE_5;
	public static String FLOWER_POTATO_AGE_6;
	public static String FLOWER_POTATO_AGE_7;

	public static String FLOWER_CARROT;
	public static String FLOWER_CARROT_AGE_0;
	public static String FLOWER_CARROT_AGE_1;
	public static String FLOWER_CARROT_AGE_2;
	public static String FLOWER_CARROT_AGE_3;
	public static String FLOWER_CARROT_AGE_4;
	public static String FLOWER_CARROT_AGE_5;
	public static String FLOWER_CARROT_AGE_6;
	public static String FLOWER_CARROT_AGE_7;

	public static String FLOWER_BARRIER;

	public static String ITEM_SECOND_PREFIX;

	public static String GUI_TITLE;
	public static String GUI_CREATE_FLOWER;
	public static String GUI_CANT_CREATE_EMPTY_FLOWER;
	public static String GUI_REMOVE_FROM_TOP;
	public static String GUI_CLEAR_ALL;
	public static String GUI_FLOWER_GROUP_TITLE_COLOR;
	public static String GUI_GLASS_NAME_COLOR;
	public static String GUI_PREVIOUS;
	public static String GUI_NEXT;
	public static String GUI_SAVED_FLOWERPOTS;
	public static String GUI_SAVED_FLOWERPOTS_NAME_COLOR;


	public static String ACTION_NO_PERMISSION_PLACE;
	public static String ACTION_MISSING_FOLLOWING_ITEMS;
	public static String ACTION_MISSING_FOLLOWING_ITEMS_LIST;
	public static String ACTION_NO_PERMISSION_EDIT;
	public static String ACTION_OUTDATE_VERSION;
	public static String ACTION_CURRENT_VERSION;
	public static String ACTION_NEWEST_VERSION;
	public static String ACTION_DOWNLOAD_NEW_VERSION;
	public static String ACTION_FAILED_CHECK_VERSION;

	public static void LoadLanguageFile() {
		CraftFlowers instance = CraftFlowers.getInstance();

		String path = "language.yml";

		File languageFile = new File(instance.getDataFolder(), path);

		if (!languageFile.exists()) {
			instance.saveResource(path, false);
		}

		YamlConfiguration defaultLanguage = YamlConfiguration.loadConfiguration(new InputStreamReader(instance.getResource(path)));

		YamlConfiguration language = YamlConfiguration.loadConfiguration(languageFile);

		language.addDefaults(defaultLanguage);

		// /craftflowers
		COMMAND_NO_PERMISSION_USE = language.getString("commands.no_permission_use");

		// /craftflowers info
		COMMAND_VERSION = language.getString("commands.version");
		COMMAND_AUTHOR = language.getString("commands.author");
		COMMAND_WEBSITE = language.getString("commands.website");

		// /craftflowers save
		COMMAND_NO_PERMISSION_SAVE = language.getString("commands.no_permission_save");
		COMMAND_SUCCESS_SAVE = language.getString("commands.success_save");
		COMMAND_NEED_HOLD_CF_FLOWERPOT = language.getString("commands.need_hold_cf_flowerpot");
		COMMAND_COMMAND_SAVE_TIP = language.getString("commands.command_save_tip");

		// /craftflowers load
		COMMAND_NO_PERMISSION_LOAD = language.getString("commands.author");
		COMMAND_FLOWER_NOT_FOUND = language.getString("commands.author");
		COMMAND_SUCCESS_LOAD = language.getString("commands.author");
		COMMAND_COMMAND_LOAD_TIP = language.getString("commands.author");

		// /craftflowers delete
		COMMAND_NO_PERMISSION_DELETE = language.getString("commands.author");
		COMMAND_AUTHOR = language.getString("commands.author");
		COMMAND_AUTHOR = language.getString("commands.author");
		COMMAND_AUTHOR = language.getString("commands.author");

		COMMAND_AUTHOR = language.getString("commands.author");
		COMMAND_AUTHOR = language.getString("commands.author");


	}
}
