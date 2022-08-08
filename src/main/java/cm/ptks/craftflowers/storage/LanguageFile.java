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
		COMMAND_NO_PERMISSION_LOAD = language.getString("commands.no_permission_load");
		COMMAND_FLOWER_NOT_FOUND = language.getString("commands.flower_not_found");
		COMMAND_SUCCESS_LOAD = language.getString("commands.success_load");
		COMMAND_COMMAND_LOAD_TIP = language.getString("commands.command_load_tip");

		// /craftflowers delete
		COMMAND_NO_PERMISSION_DELETE = language.getString("commands.no_permission_delete");
		COMMAND_CANT_DELETE = language.getString("commands.cant_delete");
		COMMAND_SUCCESS_DELETE = language.getString("commands.success_delete");
		COMMAND_COMMAND_DELETE_TIP = language.getString("commands.command_delete_tip");

		// /craftflowers list
		COMMAND_NO_PERMISSION_LIST = language.getString("commands.no_permission_list");
		COMMAND_NO_SAVED_FLOWERS = language.getString("commands.no_saved_flowers");

		// flower_info
		FLOWER_INFO_AGE = language.getString("flower_info.age");
		FLOWER_INFO_CANT_SERIALIZE_FLOWERGROUP = language.getString("flower_info.cant_serialize_flowergroup");
		FLOWER_INFO_CANT_ADD_MORE_THAN_9_FLOWERS = language.getString("flower_info.cant_add_more_than_9_flowers");

		// flower
		FLOWER_SUNFLOWER = language.getString("flower.SUNFLOWER");
		FLOWER_SUGAR_CANE = language.getString("flower.SUGAR_CANE");
		FLOWER_LILAC = language.getString("flower.LILAC");
		FLOWER_ROSE_BUSH = language.getString("flower.ROSE_BUSH");
		FLOWER_PEONY = language.getString("flower.PEONY");
		FLOWER_TALL_GRASS = language.getString("flower.TALL_GRASS");
		FLOWER_LARGE_FERN = language.getString("flower.LARGE_FERN");
		FLOWER_OAK_SAPLING = language.getString("flower.OAK_SAPLING");
		FLOWER_SPRUCE_SAPLING = language.getString("flower.SPRUCE_SAPLING");
		FLOWER_BIRCH_SAPLING = language.getString("flower.BIRCH_SAPLING");
		FLOWER_JUNGLE_SAPLING = language.getString("flower.JUNGLE_SAPLING");
		FLOWER_ACACIA_SAPLING = language.getString("flower.ACACIA_SAPLING");
		FLOWER_DARK_OAK_SAPLING = language.getString("flower.DARK_OAK_SAPLING");
		FLOWER_DEAD_BUSH = language.getString("flower.DEAD_BUSH");
		FLOWER_GRASS = language.getString("flower.GRASS");
		FLOWER_FERN = language.getString("flower.FERN");
		FLOWER_NETHER_BRICK_FENCE = language.getString("flower.NETHER_BRICK_FENCE");

		FLOWER_DARK_OAK_FENCE = language.getString("flower.DARK_OAK_FENCE");
		FLOWER_SPRUCE_FENCE = language.getString("flower.SPRUCE_FENCE");
		FLOWER_OAK_FENCE = language.getString("flower.OAK_FENCE");
		FLOWER_BIRCH_FENCE = language.getString("flower.BIRCH_FENCE");
		FLOWER_JUNGLE_FENCE = language.getString("flower.JUNGLE_FENCE");
		FLOWER_ACACIA_FENCE = language.getString("flower.ACACIA_FENCE");
		FLOWER_CRIMSON_FENCE = language.getString("flower.CRIMSON_FENCE");
		FLOWER_WARPED_FENCE = language.getString("flower.WARPED_FENCE");
		FLOWER_MANGROVE_FENCE = language.getString("flower.MANGROVE_FENCE");
		FLOWER_DANDELION = language.getString("flower.DANDELION");
		FLOWER_POPPY = language.getString("flower.POPPY");
		FLOWER_BLUE_ORCHID = language.getString("flower.BLUE_ORCHID");
		FLOWER_ALLIUM = language.getString("flower.ALLIUM");
		FLOWER_AZURE_BLUET = language.getString("flower.AZURE_BLUET");
		FLOWER_RED_TULIP = language.getString("flower.RED_TULIP");
		FLOWER_ORANGE_TULIP = language.getString("flower.ORANGE_TULIP");
		FLOWER_WHITE_TULIP = language.getString("flower.WHITE_TULIP");
		FLOWER_PINK_TULIP = language.getString("flower.PINK_TULIP");
		FLOWER_OXEYE_DAISY = language.getString("flower.OXEYE_DAISY");
		FLOWER_CORNFLOWER = language.getString("flower.CORNFLOWER");
		FLOWER_LILY_OF_THE_VALLEY = language.getString("flower.LILY_OF_THE_VALLEY");
		FLOWER_WITHER_ROSE = language.getString("flower.WITHER_ROSE");
		FLOWER_BROWN_MUSHROOM = language.getString("flower.BROWN_MUSHROOM");
		FLOWER_RED_MUSHROOM = language.getString("flower.RED_MUSHROOM");
		FLOWER_CRIMSON_FUNGUS = language.getString("flower.CRIMSON_FUNGUS");
		FLOWER_WARPED_FUNGUS = language.getString("flower.WARPED_FUNGUS");
		FLOWER_FLOWER_POT = language.getString("flower.FLOWER_POT");

		// 1.17+
		FLOWER_MOSS_BLOCK = language.getString("flower.MOSS_BLOCK");
		FLOWER_AZALEA = language.getString("flower.AZALEA");
		FLOWER_FLOWERING_AZALEA = language.getString("flower.FLOWERING_AZALEA");
		FLOWER_AZALEA_LEAVES = language.getString("flower.AZALEA_LEAVES");
		FLOWER_FLOWERING_AZALEA_LEAVES = language.getString("flower.FLOWERING_AZALEA_LEAVES");
		FLOWER_GLOW_BERRIES = language.getString("flower.GLOW_BERRIES");
		FLOWER_BIG_DRIPLEAF = language.getString("flower.BIG_DRIPLEAF");
		FLOWER_BIG_DRIPLEAF_STEM = language.getString("flower.BIG_DRIPLEAF_STEM");
		FLOWER_SMALL_DRIPLEAF = language.getString("flower.SMALL_DRIPLEAF");
		FLOWER_SPORE_BLOSSOM = language.getString("flower.SPORE_BLOSSOM");

		// 1.19+
		FLOWER_MANGROVE_ROOTS = language.getString("flower.MANGROVE_ROOTS");
		FLOWER_MANGROVE_LEAVES = language.getString("flower.MANGROVE_LEAVES");
		FLOWER_MANGROVE_PROPAGULE = language.getString("flower.MANGROVE_PROPAGULE");


		FLOWER_OAK_LEAVES = language.getString("flower.OAK_LEAVES");
		FLOWER_SPRUCE_LEAVES = language.getString("flower.SPRUCE_LEAVES");
		FLOWER_BIRCH_LEAVES = language.getString("flower.BIRCH_LEAVES");
		FLOWER_JUNGLE_LEAVES = language.getString("flower.JUNGLE_LEAVES");
		FLOWER_ACACIA_LEAVES = language.getString("flower.ACACIA_LEAVES");
		FLOWER_DARK_OAK_LEAVES = language.getString("flower.DARK_OAK_LEAVES");
		FLOWER_LILY_PAD = language.getString("flower.LILY_PAD");
		FLOWER_VINE = language.getString("flower.VINE");
		FLOWER_CACTUS = language.getString("flower.CACTUS");
		FLOWER_MELON = language.getString("flower.MELON");
		FLOWER_PUMPKIN = language.getString("flower.PUMPKIN");
		FLOWER_SEAGRASS = language.getString("flower.SEAGRASS");
		FLOWER_SEA_PICKLE = language.getString("flower.SEA_PICKLE");
		FLOWER_KELP = language.getString("flower.KELP");
		FLOWER_BAMBOO = language.getString("flower.BAMBOO");
		FLOWER_END_ROD = language.getString("flower.END_ROD");
		FLOWER_SOUL_LANTERN = language.getString("flower.SOUL_LANTERN");
		FLOWER_LANTERN = language.getString("flower.LANTERN");
		FLOWER_COCOA_BEANS = language.getString("flower.COCOA_BEANS");
		FLOWER_CRIMSON_ROOTS = language.getString("flower.CRIMSON_ROOTS");
		FLOWER_WEEPING_VINES = language.getString("flower.WEEPING_VINES");
		FLOWER_WARPED_ROOTS = language.getString("flower.WARPED_ROOTS");
		FLOWER_NETHER_SPROUTS = language.getString("flower.NETHER_SPROUTS");
		FLOWER_TWISTING_VINES = language.getString("flower.TWISTING_VINES");
		FLOWER_BRAIN_CORAL = language.getString("flower.BRAIN_CORAL");
		FLOWER_BUBBLE_CORAL = language.getString("flower.BUBBLE_CORAL");
		FLOWER_FIRE_CORAL = language.getString("flower.FIRE_CORAL");
		FLOWER_HORN_CORAL = language.getString("flower.HORN_CORAL");
		FLOWER_TUBE_CORAL = language.getString("flower.TUBE_CORAL");
		FLOWER_BRAIN_CORAL_FAN = language.getString("flower.BRAIN_CORAL_FAN");
		FLOWER_BUBBLE_CORAL_FAN = language.getString("flower.BUBBLE_CORAL_FAN");
		FLOWER_FIRE_CORAL_FAN = language.getString("flower.FIRE_CORAL_FAN");
		FLOWER_HORN_CORAL_FAN = language.getString("flower.HORN_CORAL_FAN");
		FLOWER_TUBE_CORAL_FAN = language.getString("flower.TUBE_CORAL_FAN");

		FLOWER_WHEAT = language.getString("flower.WHEAT");
		FLOWER_WHEAT_AGE_0 = language.getString("flower.WHEAT_AGE.WHEAT_0");
		FLOWER_WHEAT_AGE_1 = language.getString("flower.WHEAT_AGE.WHEAT_1");
		FLOWER_WHEAT_AGE_2 = language.getString("flower.WHEAT_AGE.WHEAT_2");
		FLOWER_WHEAT_AGE_3 = language.getString("flower.WHEAT_AGE.WHEAT_3");
		FLOWER_WHEAT_AGE_4 = language.getString("flower.WHEAT_AGE.WHEAT_4");
		FLOWER_WHEAT_AGE_5 = language.getString("flower.WHEAT_AGE.WHEAT_5");
		FLOWER_WHEAT_AGE_6 = language.getString("flower.WHEAT_AGE.WHEAT_6");
		FLOWER_WHEAT_AGE_7 = language.getString("flower.WHEAT_AGE.WHEAT_7");

		FLOWER_POTATO = language.getString("flower.POTATO");
		FLOWER_POTATO_AGE_0 = language.getString("flower.POTATO_AGE.POTATO_0");
		FLOWER_POTATO_AGE_1 = language.getString("flower.POTATO_AGE.POTATO_1");
		FLOWER_POTATO_AGE_2 = language.getString("flower.POTATO_AGE.POTATO_2");
		FLOWER_POTATO_AGE_3 = language.getString("flower.POTATO_AGE.POTATO_3");
		FLOWER_POTATO_AGE_4 = language.getString("flower.POTATO_AGE.POTATO_4");
		FLOWER_POTATO_AGE_5 = language.getString("flower.POTATO_AGE.POTATO_5");
		FLOWER_POTATO_AGE_6 = language.getString("flower.POTATO_AGE.POTATO_6");
		FLOWER_POTATO_AGE_7 = language.getString("flower.POTATO_AGE.POTATO_7");

		FLOWER_CARROT = language.getString("flower.CARROT");
		FLOWER_CARROT_AGE_0 = language.getString("flower.CARROT_AGE.CARROT_0");
		FLOWER_CARROT_AGE_1 = language.getString("flower.CARROT_AGE.CARROT_1");
		FLOWER_CARROT_AGE_2 = language.getString("flower.CARROT_AGE.CARROT_2");
		FLOWER_CARROT_AGE_3 = language.getString("flower.CARROT_AGE.CARROT_3");
		FLOWER_CARROT_AGE_4 = language.getString("flower.CARROT_AGE.CARROT_4");
		FLOWER_CARROT_AGE_5 = language.getString("flower.CARROT_AGE.CARROT_5");
		FLOWER_CARROT_AGE_6 = language.getString("flower.CARROT_AGE.CARROT_6");
		FLOWER_CARROT_AGE_7 = language.getString("flower.CARROT_AGE.CARROT_7");

		FLOWER_BARRIER = language.getString("flower.BARRIER");

		// item
		ITEM_SECOND_PREFIX = language.getString("item.second_prefix");

		// gui
		GUI_TITLE = language.getString("gui.title");
		GUI_CREATE_FLOWER = language.getString("gui.create_flower");
		GUI_CANT_CREATE_EMPTY_FLOWER = language.getString("gui.cant_create_empty_flower");
		GUI_REMOVE_FROM_TOP = language.getString("gui.remove_from_top");
		GUI_CLEAR_ALL = language.getString("gui.clear_all");
		GUI_FLOWER_GROUP_TITLE_COLOR = language.getString("gui.flower_group_title_color");
		GUI_GLASS_NAME_COLOR = language.getString("gui.glass_name_color");
		GUI_PREVIOUS = language.getString("gui.previous");
		GUI_NEXT = language.getString("gui.next");
		GUI_SAVED_FLOWERPOTS = language.getString("gui.saved_flowerpots");
		GUI_SAVED_FLOWERPOTS_NAME_COLOR = language.getString("gui.saved_flowerpots_name_color");

		// action
		ACTION_NO_PERMISSION_PLACE = language.getString("action.no_permission_place");
		ACTION_MISSING_FOLLOWING_ITEMS = language.getString("action.missing_following_items");
		ACTION_MISSING_FOLLOWING_ITEMS_LIST = language.getString("action.missing_following_items_list");
		ACTION_NO_PERMISSION_EDIT = language.getString("action.no_permission_edit");
		ACTION_OUTDATE_VERSION = language.getString("action.outdate_version");
		ACTION_CURRENT_VERSION = language.getString("action.current_version");
		ACTION_NEWEST_VERSION = language.getString("action.newest_version");
		ACTION_DOWNLOAD_NEW_VERSION = language.getString("action.download_new_version");
		ACTION_FAILED_CHECK_VERSION = language.getString("action.failed_check_version");


	}

}


