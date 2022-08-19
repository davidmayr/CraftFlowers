package cm.ptks.craftflowers.languages;

import cm.ptks.craftflowers.CraftFlowers;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class LanguageFile {

    public final static class COMMANDS {
        public static String NO_PERMISSION_USE;
        public static String VERSION;
        public static String AUTHOR;
        public static String WEBSITE;
        public static String NO_PERMISSION_SAVE;
        public static String SUCCESS_SAVE;
        public static String NEED_HOLD_CF_FLOWERPOT;
        public static String SAVE_SYNTAX;
        public static String NO_PERMISSION_LOAD;
        public static String LOAD_NOT_FOUND;
        public static String SUCCESS_LOAD;
        public static String LOAD_SYNTAX;
        public static String NO_PERMISSION_DELETE;
        public static String CANT_DELETE;
        public static String SUCCESS_DELETE;
        public static String DELETE_SYNTAX;
        public static String NO_PERMISSION_LIST;
        public static String NO_SAVED_FLOWERS;

        public final static class HELP_MESSAGES {
            public static String SYNTAX;
            public static String OPEN_GUI;
            public static String SAVE;
            public static String LOAD;
            public static String DELETE;
            public static String INFO;
            public static String LIST;
            public static String HELP;
        }
    }

    public final static class FLOWER_INFO {

        public static String AGE;
        public static String LIMIT_REACHED;

    }

    public final static class FLOWER {
        public static String SUNFLOWER;
        public static String SUGAR_CANE;
        public static String LILAC;
        public static String ROSE_BUSH;
        public static String PEONY;
        public static String TALL_GRASS;
        public static String LARGE_FERN;
        public static String OAK_SAPLING;
        public static String SPRUCE_SAPLING;
        public static String BIRCH_SAPLING;
        public static String JUNGLE_SAPLING;
        public static String ACACIA_SAPLING;
        public static String DARK_OAK_SAPLING;
        public static String DEAD_BUSH;
        public static String GRASS;
        public static String FERN;
        public static String NETHER_BRICK_FENCE;

        public static String DARK_OAK_FENCE;
        public static String SPRUCE_FENCE;
        public static String OAK_FENCE;
        public static String BIRCH_FENCE;
        public static String JUNGLE_FENCE;
        public static String ACACIA_FENCE;
        public static String CRIMSON_FENCE;
        public static String WARPED_FENCE;
        public static String MANGROVE_FENCE;
        public static String DANDELION;
        public static String POPPY;
        public static String BLUE_ORCHID;
        public static String ALLIUM;
        public static String AZURE_BLUET;
        public static String RED_TULIP;
        public static String ORANGE_TULIP;
        public static String WHITE_TULIP;
        public static String PINK_TULIP;
        public static String OXEYE_DAISY;
        public static String CORNFLOWER;
        public static String LILY_OF_THE_VALLEY;
        public static String WITHER_ROSE;
        public static String BROWN_MUSHROOM;
        public static String RED_MUSHROOM;
        public static String CRIMSON_FUNGUS;
        public static String WARPED_FUNGUS;
        public static String FLOWER_POT;

        public static String MOSS_BLOCK;
        public static String AZALEA;
        public static String FLOWERING_AZALEA;
        public static String AZALEA_LEAVES;
        public static String FLOWERING_AZALEA_LEAVES;
        public static String GLOW_BERRIES;
        public static String BIG_DRIPLEAF;
        public static String BIG_DRIPLEAF_STEM;
        public static String SMALL_DRIPLEAF;
        public static String SPORE_BLOSSOM;

        public static String MANGROVE_ROOTS;
        public static String MANGROVE_LEAVES;
        public static String MANGROVE_PROPAGULE;

        public static String OAK_LEAVES;
        public static String SPRUCE_LEAVES;
        public static String BIRCH_LEAVES;
        public static String JUNGLE_LEAVES;
        public static String ACACIA_LEAVES;
        public static String DARK_OAK_LEAVES;
        public static String LILY_PAD;
        public static String VINE;
        public static String CACTUS;
        public static String MELON;
        public static String PUMPKIN;
        public static String SEAGRASS;
        public static String SEA_PICKLE;
        public static String KELP;
        public static String BAMBOO;
        public static String END_ROD;
        public static String SOUL_LANTERN;
        public static String LANTERN;
        public static String COCOA_BEANS;
        public static String CRIMSON_ROOTS;
        public static String WEEPING_VINES;
        public static String WARPED_ROOTS;
        public static String NETHER_SPROUTS;
        public static String TWISTING_VINES;
        public static String BRAIN_CORAL;
        public static String BUBBLE_CORAL;
        public static String FIRE_CORAL;
        public static String HORN_CORAL;
        public static String TUBE_CORAL;
        public static String BRAIN_CORAL_FAN;
        public static String BUBBLE_CORAL_FAN;
        public static String FIRE_CORAL_FAN;
        public static String HORN_CORAL_FAN;
        public static String TUBE_CORAL_FAN;

        public static String WHEAT;
        public static String WHEAT_AGE_0;
        public static String WHEAT_AGE_1;
        public static String WHEAT_AGE_2;
        public static String WHEAT_AGE_3;
        public static String WHEAT_AGE_4;
        public static String WHEAT_AGE_5;
        public static String WHEAT_AGE_6;
        public static String WHEAT_AGE_7;

        public static String POTATO;
        public static String POTATO_AGE_0;
        public static String POTATO_AGE_1;
        public static String POTATO_AGE_2;
        public static String POTATO_AGE_3;
        public static String POTATO_AGE_4;
        public static String POTATO_AGE_5;
        public static String POTATO_AGE_6;
        public static String POTATO_AGE_7;

        public static String CARROT;
        public static String CARROT_AGE_0;
        public static String CARROT_AGE_1;
        public static String CARROT_AGE_2;
        public static String CARROT_AGE_3;
        public static String CARROT_AGE_4;
        public static String CARROT_AGE_5;
        public static String CARROT_AGE_6;
        public static String CARROT_AGE_7;

        public static String AIR;
    }

    public final static class ITEM {
        public static String FLOWER_POT;
    }

    public final static class GUI {

        public static String TITLE;
        public static String CREATE_FLOWER;
        public static String CANT_CREATE_EMPTY_FLOWER;
        public static String REMOVE_FROM_TOP;
        public static String CLEAR_ALL;
        public static String FLOWER_GROUP_TITLE_COLOR;
        public static String GLASS_NAME_COLOR;
        public static String PREVIOUS;
        public static String NEXT;
        public static String SAVED_FLOWERPOTS;
        public static String SAVED_FLOWERPOTS_NAME_COLOR;

    }

    public final static class ACTION {
        public static String NO_PERMISSION_PLACE;
        public static String MISSING_FOLLOWING_ITEMS;
        public static String MISSING_FOLLOWING_ITEMS_LIST;
        public static String NO_PERMISSION_EDIT;
        public static String OUTDATE_VERSION;
        public static String CURRENT_VERSION;
        public static String NEWEST_VERSION;
        public static String DOWNLOAD_NEW_VERSION;
        public static String FAILED_CHECK_VERSION;
    }

    public static void LoadLanguageFile() {
        CraftFlowers instance = CraftFlowers.getInstance();

        String path = "language.yml";

        File languageFile = new File(instance.getDataFolder(), path);

        if (!languageFile.exists()) {
            instance.saveResource(path, false);
        }

        YamlConfiguration defaultLanguage =
                YamlConfiguration.loadConfiguration(new InputStreamReader(instance.getResource(path), StandardCharsets.UTF_8));

        YamlConfiguration language = YamlConfiguration.loadConfiguration(languageFile);

        language.addDefaults(defaultLanguage);

        // /craftflowers
        COMMANDS.NO_PERMISSION_USE = language.getString("COMMANDS.NO_PERMISSION_USE");

        // /craftflowers info
        COMMANDS.VERSION = language.getString("COMMANDS.VERSION");
        COMMANDS.AUTHOR = language.getString("COMMANDS.AUTHOR");
        COMMANDS.WEBSITE = language.getString("COMMANDS.WEBSITE");

        // /craftflowers save
        COMMANDS.NO_PERMISSION_SAVE = language.getString("COMMANDS.NO_PERMISSION_SAVE");
        COMMANDS.SUCCESS_SAVE = language.getString("COMMANDS.SUCCESS_SAVE");
        COMMANDS.NEED_HOLD_CF_FLOWERPOT = language.getString("COMMANDS.NEED_HOLD_CF_FLOWERPOT");
        COMMANDS.SAVE_SYNTAX = language.getString("COMMANDS.SAVE_SYNTAX");

        // /craftflowers load
        COMMANDS.NO_PERMISSION_LOAD = language.getString("COMMANDS.NO_PERMISSION_LOAD");
        COMMANDS.LOAD_NOT_FOUND = language.getString("COMMANDS.LOAD_NOT_FOUND");
        COMMANDS.SUCCESS_LOAD = language.getString("COMMANDS.SUCCESS_LOAD");
        COMMANDS.LOAD_SYNTAX = language.getString("COMMANDS.LOAD_SYNTAX");

        // /craftflowers delete
        COMMANDS.NO_PERMISSION_DELETE = language.getString("COMMANDS.NO_PERMISSION_DELETE");
        COMMANDS.CANT_DELETE = language.getString("COMMANDS.CANT_DELETE");
        COMMANDS.SUCCESS_DELETE = language.getString("COMMANDS.SUCCESS_DELETE");
        COMMANDS.DELETE_SYNTAX = language.getString("COMMANDS.DELETE_SYNTAX");

        // /craftflowers list
        COMMANDS.NO_PERMISSION_LIST = language.getString("COMMANDS.NO_PERMISSION_LIST");
        COMMANDS.NO_SAVED_FLOWERS = language.getString("COMMANDS.NO_SAVED_FLOWERS");

        // /craftflowers help
        COMMANDS.HELP_MESSAGES.SYNTAX = language.getString("COMMANDS.HELP_MESSAGES.SYNTAX");
        COMMANDS.HELP_MESSAGES.OPEN_GUI = language.getString("COMMANDS.HELP_MESSAGES.OPEN_GUI");
        COMMANDS.HELP_MESSAGES.SAVE = language.getString("COMMANDS.HELP_MESSAGES.SAVE");
        COMMANDS.HELP_MESSAGES.LOAD = language.getString("COMMANDS.HELP_MESSAGES.LOAD");
        COMMANDS.HELP_MESSAGES.DELETE = language.getString("COMMANDS.HELP_MESSAGES.DELETE");
        COMMANDS.HELP_MESSAGES.INFO = language.getString("COMMANDS.HELP_MESSAGES.INFO");
        COMMANDS.HELP_MESSAGES.LIST = language.getString("COMMANDS.HELP_MESSAGES.LIST");
        COMMANDS.HELP_MESSAGES.HELP = language.getString("COMMANDS.HELP_MESSAGES.HELP");

        // flower_info
        FLOWER_INFO.AGE = language.getString("FLOWER_INFO.AGE");
        FLOWER_INFO.LIMIT_REACHED = language.getString("FLOWER_INFO.LIMIT_REACHED");

        // flower
        FLOWER.SUNFLOWER = language.getString("FLOWER.SUNFLOWER");
        FLOWER.SUGAR_CANE = language.getString("FLOWER.SUGAR_CANE");
        FLOWER.LILAC = language.getString("FLOWER.LILAC");
        FLOWER.ROSE_BUSH = language.getString("FLOWER.ROSE_BUSH");
        FLOWER.PEONY = language.getString("FLOWER.PEONY");
        FLOWER.TALL_GRASS = language.getString("FLOWER.TALL_GRASS");
        FLOWER.LARGE_FERN = language.getString("FLOWER.LARGE_FERN");
        FLOWER.OAK_SAPLING = language.getString("FLOWER.OAK_SAPLING");
        FLOWER.SPRUCE_SAPLING = language.getString("FLOWER.SPRUCE_SAPLING");
        FLOWER.BIRCH_SAPLING = language.getString("FLOWER.BIRCH_SAPLING");
        FLOWER.JUNGLE_SAPLING = language.getString("FLOWER.JUNGLE_SAPLING");
        FLOWER.ACACIA_SAPLING = language.getString("FLOWER.ACACIA_SAPLING");
        FLOWER.DARK_OAK_SAPLING = language.getString("FLOWER.DARK_OAK_SAPLING");
        FLOWER.DEAD_BUSH = language.getString("FLOWER.DEAD_BUSH");
        FLOWER.GRASS = language.getString("FLOWER.GRASS");
        FLOWER.FERN = language.getString("FLOWER.FERN");
        FLOWER.NETHER_BRICK_FENCE = language.getString("FLOWER.NETHER_BRICK_FENCE");

        FLOWER.DARK_OAK_FENCE = language.getString("FLOWER.DARK_OAK_FENCE");
        FLOWER.SPRUCE_FENCE = language.getString("FLOWER.SPRUCE_FENCE");
        FLOWER.OAK_FENCE = language.getString("FLOWER.OAK_FENCE");
        FLOWER.BIRCH_FENCE = language.getString("FLOWER.BIRCH_FENCE");
        FLOWER.JUNGLE_FENCE = language.getString("FLOWER.JUNGLE_FENCE");
        FLOWER.ACACIA_FENCE = language.getString("FLOWER.ACACIA_FENCE");
        FLOWER.CRIMSON_FENCE = language.getString("FLOWER.CRIMSON_FENCE");
        FLOWER.WARPED_FENCE = language.getString("FLOWER.WARPED_FENCE");
        FLOWER.MANGROVE_FENCE = language.getString("FLOWER.MANGROVE_FENCE");
        FLOWER.DANDELION = language.getString("FLOWER.DANDELION");
        FLOWER.POPPY = language.getString("FLOWER.POPPY");
        FLOWER.BLUE_ORCHID = language.getString("FLOWER.BLUE_ORCHID");
        FLOWER.ALLIUM = language.getString("FLOWER.ALLIUM");
        FLOWER.AZURE_BLUET = language.getString("FLOWER.AZURE_BLUET");
        FLOWER.RED_TULIP = language.getString("FLOWER.RED_TULIP");
        FLOWER.ORANGE_TULIP = language.getString("FLOWER.ORANGE_TULIP");
        FLOWER.WHITE_TULIP = language.getString("FLOWER.WHITE_TULIP");
        FLOWER.PINK_TULIP = language.getString("FLOWER.PINK_TULIP");
        FLOWER.OXEYE_DAISY = language.getString("FLOWER.OXEYE_DAISY");
        FLOWER.CORNFLOWER = language.getString("FLOWER.CORNFLOWER");
        FLOWER.LILY_OF_THE_VALLEY = language.getString("FLOWER.LILY_OF_THE_VALLEY");
        FLOWER.WITHER_ROSE = language.getString("FLOWER.WITHER_ROSE");
        FLOWER.BROWN_MUSHROOM = language.getString("FLOWER.BROWN_MUSHROOM");
        FLOWER.RED_MUSHROOM = language.getString("FLOWER.RED_MUSHROOM");
        FLOWER.CRIMSON_FUNGUS = language.getString("FLOWER.CRIMSON_FUNGUS");
        FLOWER.WARPED_FUNGUS = language.getString("FLOWER.WARPED_FUNGUS");
        FLOWER.FLOWER_POT = language.getString("FLOWER.FLOWER_POT");

        // 1.17+
        FLOWER.MOSS_BLOCK = language.getString("FLOWER.MOSS_BLOCK");
        FLOWER.AZALEA = language.getString("FLOWER.AZALEA");
        FLOWER.FLOWERING_AZALEA = language.getString("FLOWER.FLOWERING_AZALEA");
        FLOWER.AZALEA_LEAVES = language.getString("FLOWER.AZALEA_LEAVES");
        FLOWER.FLOWERING_AZALEA_LEAVES = language.getString("FLOWER.FLOWERING_AZALEA_LEAVES");
        FLOWER.GLOW_BERRIES = language.getString("FLOWER.GLOW_BERRIES");
        FLOWER.BIG_DRIPLEAF = language.getString("FLOWER.BIG_DRIPLEAF");
        FLOWER.BIG_DRIPLEAF_STEM = language.getString("FLOWER.BIG_DRIPLEAF_STEM");
        FLOWER.SMALL_DRIPLEAF = language.getString("FLOWER.SMALL_DRIPLEAF");
        FLOWER.SPORE_BLOSSOM = language.getString("FLOWER.SPORE_BLOSSOM");

        // 1.19+
        FLOWER.MANGROVE_ROOTS = language.getString("FLOWER.MANGROVE_ROOTS");
        FLOWER.MANGROVE_LEAVES = language.getString("FLOWER.MANGROVE_LEAVES");
        FLOWER.MANGROVE_PROPAGULE = language.getString("FLOWER.MANGROVE_PROPAGULE");

        FLOWER.OAK_LEAVES = language.getString("FLOWER.OAK_LEAVES");
        FLOWER.SPRUCE_LEAVES = language.getString("FLOWER.SPRUCE_LEAVES");
        FLOWER.BIRCH_LEAVES = language.getString("FLOWER.BIRCH_LEAVES");
        FLOWER.JUNGLE_LEAVES = language.getString("FLOWER.JUNGLE_LEAVES");
        FLOWER.ACACIA_LEAVES = language.getString("FLOWER.ACACIA_LEAVES");
        FLOWER.DARK_OAK_LEAVES = language.getString("FLOWER.DARK_OAK_LEAVES");
        FLOWER.LILY_PAD = language.getString("FLOWER.LILY_PAD");
        FLOWER.VINE = language.getString("FLOWER.VINE");
        FLOWER.CACTUS = language.getString("FLOWER.CACTUS");
        FLOWER.MELON = language.getString("FLOWER.MELON");
        FLOWER.PUMPKIN = language.getString("FLOWER.PUMPKIN");
        FLOWER.SEAGRASS = language.getString("FLOWER.SEAGRASS");
        FLOWER.SEA_PICKLE = language.getString("FLOWER.SEA_PICKLE");
        FLOWER.KELP = language.getString("FLOWER.KELP");
        FLOWER.BAMBOO = language.getString("FLOWER.BAMBOO");
        FLOWER.END_ROD = language.getString("FLOWER.END_ROD");
        FLOWER.SOUL_LANTERN = language.getString("FLOWER.SOUL_LANTERN");
        FLOWER.LANTERN = language.getString("FLOWER.LANTERN");
        FLOWER.COCOA_BEANS = language.getString("FLOWER.COCOA_BEANS");
        FLOWER.CRIMSON_ROOTS = language.getString("FLOWER.CRIMSON_ROOTS");
        FLOWER.WEEPING_VINES = language.getString("FLOWER.WEEPING_VINES");
        FLOWER.WARPED_ROOTS = language.getString("FLOWER.WARPED_ROOTS");
        FLOWER.NETHER_SPROUTS = language.getString("FLOWER.NETHER_SPROUTS");
        FLOWER.TWISTING_VINES = language.getString("FLOWER.TWISTING_VINES");
        FLOWER.BRAIN_CORAL = language.getString("FLOWER.BRAIN_CORAL");
        FLOWER.BUBBLE_CORAL = language.getString("FLOWER.BUBBLE_CORAL");
        FLOWER.FIRE_CORAL = language.getString("FLOWER.FIRE_CORAL");
        FLOWER.HORN_CORAL = language.getString("FLOWER.HORN_CORAL");
        FLOWER.TUBE_CORAL = language.getString("FLOWER.TUBE_CORAL");
        FLOWER.BRAIN_CORAL_FAN = language.getString("FLOWER.BRAIN_CORAL_FAN");
        FLOWER.BUBBLE_CORAL_FAN = language.getString("FLOWER.BUBBLE_CORAL_FAN");
        FLOWER.FIRE_CORAL_FAN = language.getString("FLOWER.FIRE_CORAL_FAN");
        FLOWER.HORN_CORAL_FAN = language.getString("FLOWER.HORN_CORAL_FAN");
        FLOWER.TUBE_CORAL_FAN = language.getString("FLOWER.TUBE_CORAL_FAN");

        FLOWER.WHEAT = language.getString("FLOWER.WHEAT");
        FLOWER.WHEAT_AGE_0 = language.getString("FLOWER.WHEAT_AGE.WHEAT_0");
        FLOWER.WHEAT_AGE_1 = language.getString("FLOWER.WHEAT_AGE.WHEAT_1");
        FLOWER.WHEAT_AGE_2 = language.getString("FLOWER.WHEAT_AGE.WHEAT_2");
        FLOWER.WHEAT_AGE_3 = language.getString("FLOWER.WHEAT_AGE.WHEAT_3");
        FLOWER.WHEAT_AGE_4 = language.getString("FLOWER.WHEAT_AGE.WHEAT_4");
        FLOWER.WHEAT_AGE_5 = language.getString("FLOWER.WHEAT_AGE.WHEAT_5");
        FLOWER.WHEAT_AGE_6 = language.getString("FLOWER.WHEAT_AGE.WHEAT_6");
        FLOWER.WHEAT_AGE_7 = language.getString("FLOWER.WHEAT_AGE.WHEAT_7");

        FLOWER.POTATO = language.getString("FLOWER.POTATO");
        FLOWER.POTATO_AGE_0 = language.getString("FLOWER.POTATO_AGE.POTATO_0");
        FLOWER.POTATO_AGE_1 = language.getString("FLOWER.POTATO_AGE.POTATO_1");
        FLOWER.POTATO_AGE_2 = language.getString("FLOWER.POTATO_AGE.POTATO_2");
        FLOWER.POTATO_AGE_3 = language.getString("FLOWER.POTATO_AGE.POTATO_3");
        FLOWER.POTATO_AGE_4 = language.getString("FLOWER.POTATO_AGE.POTATO_4");
        FLOWER.POTATO_AGE_5 = language.getString("FLOWER.POTATO_AGE.POTATO_5");
        FLOWER.POTATO_AGE_6 = language.getString("FLOWER.POTATO_AGE.POTATO_6");
        FLOWER.POTATO_AGE_7 = language.getString("FLOWER.POTATO_AGE.POTATO_7");

        FLOWER.CARROT = language.getString("FLOWER.CARROT");
        FLOWER.CARROT_AGE_0 = language.getString("FLOWER.CARROT_AGE.CARROT_0");
        FLOWER.CARROT_AGE_1 = language.getString("FLOWER.CARROT_AGE.CARROT_1");
        FLOWER.CARROT_AGE_2 = language.getString("FLOWER.CARROT_AGE.CARROT_2");
        FLOWER.CARROT_AGE_3 = language.getString("FLOWER.CARROT_AGE.CARROT_3");
        FLOWER.CARROT_AGE_4 = language.getString("FLOWER.CARROT_AGE.CARROT_4");
        FLOWER.CARROT_AGE_5 = language.getString("FLOWER.CARROT_AGE.CARROT_5");
        FLOWER.CARROT_AGE_6 = language.getString("FLOWER.CARROT_AGE.CARROT_6");
        FLOWER.CARROT_AGE_7 = language.getString("FLOWER.CARROT_AGE.CARROT_7");

        FLOWER.AIR = language.getString("FLOWER.AIR");

        // item
        ITEM.FLOWER_POT = language.getString("ITEM.FLOWER_POT");

        // gui
        GUI.TITLE = language.getString("GUI.TITLE");
        GUI.CREATE_FLOWER = language.getString("GUI.CREATE_FLOWER");
        GUI.CANT_CREATE_EMPTY_FLOWER = language.getString("GUI.CANT_CREATE_EMPTY_FLOWER");
        GUI.REMOVE_FROM_TOP = language.getString("GUI.REMOVE_FROM_TOP");
        GUI.CLEAR_ALL = language.getString("GUI.CLEAR_ALL");
        GUI.FLOWER_GROUP_TITLE_COLOR = language.getString("GUI.FLOWER_GROUP_TITLE_COLOR");
        GUI.GLASS_NAME_COLOR = language.getString("GUI.GLASS_NAME_COLOR");
        GUI.PREVIOUS = language.getString("GUI.PREVIOUS");
        GUI.NEXT = language.getString("GUI.NEXT");
        GUI.SAVED_FLOWERPOTS = language.getString("GUI.SAVED_FLOWERPOTS");
        GUI.SAVED_FLOWERPOTS_NAME_COLOR = language.getString("GUI.SAVED_FLOWERPOTS_NAME_COLOR");

        // action
        ACTION.NO_PERMISSION_PLACE = language.getString("ACTION.NO_PERMISSION_PLACE");
        ACTION.MISSING_FOLLOWING_ITEMS = language.getString("ACTION.MISSING_FOLLOWING_ITEMS");
        ACTION.MISSING_FOLLOWING_ITEMS_LIST = language.getString("ACTION.MISSING_FOLLOWING_ITEMS_LIST");
        ACTION.NO_PERMISSION_EDIT = language.getString("ACTION.NO_PERMISSION_EDIT");
        ACTION.OUTDATE_VERSION = language.getString("ACTION.OUTDATE_VERSION");
        ACTION.CURRENT_VERSION = language.getString("ACTION.CURRENT_VERSION");
        ACTION.NEWEST_VERSION = language.getString("ACTION.NEWEST_VERSION");
        ACTION.DOWNLOAD_NEW_VERSION = language.getString("ACTION.DOWNLOAD_NEW_VERSION");
        ACTION.FAILED_CHECK_VERSION = language.getString("ACTION.FAILED_CHECK_VERSION");
    }

    public static String getCommandVersion(String version, String color) {
        return COMMANDS.VERSION.replaceAll("<version>", color + version);
    }

    public static String getCommandAuthor(String authors) {
        return COMMANDS.AUTHOR.replaceAll("<author>", authors);
    }

    public static String getCommandWebsite(String website) {
        return COMMANDS.WEBSITE.replaceAll("<website>", website);
    }

    public static String getCommandSuccessLoad(String args) {
        return COMMANDS.SUCCESS_LOAD.replaceAll("<flower_pot_name>", args);
    }

    public static String getCommandCantDelete(String args) {
        return COMMANDS.CANT_DELETE.replaceAll("<flower_pot_name>", args);
    }

    public static String getCommandSuccessDelete(String args) {
        return COMMANDS.SUCCESS_DELETE.replaceAll("<flower_pot_name>", args);
    }

    public static String getFlowerInfoAge(int age) {
        return FLOWER_INFO.AGE.replaceAll("<age>", String.valueOf(age));
    }

    public static String getActionMissingFollowingItemsList(
            String arrow, String flower, Integer integer) {
        return ACTION.MISSING_FOLLOWING_ITEMS_LIST
                .replaceAll("%1", arrow)
                .replaceAll("%2", flower)
                .replaceAll("%3", String.valueOf(integer));
    }

    public static String getActionCurrentVersion(String version) {
        return ACTION.CURRENT_VERSION.replaceAll("<version>", version);
    }

    public static String getActionNewestVersion(String new_version) {
        return ACTION.NEWEST_VERSION.replaceAll("<version>", new_version);
    }

    public static String getActionDownloadNewVersion(String download_link) {
        return ACTION.DOWNLOAD_NEW_VERSION.replaceAll("<link>", download_link);
    }
}
