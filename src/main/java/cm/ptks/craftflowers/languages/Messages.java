package cm.ptks.craftflowers.languages;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public final class Messages {

    public final static class COMMANDS {

        public static final String NO_PERMISSION_USE = "COMMANDS.NO_PERMISSION_USE";

        // /craftflowers info
        public static final String VERSION = "COMMANDS.VERSION";
        public static final String AUTHOR = "COMMANDS.AUTHOR";
        public static final String WEBSITE = "COMMANDS.WEBSITE";

        // /craftflowers save
        public static final String NO_PERMISSION_SAVE = "COMMANDS.NO_PERMISSION_SAVE";
        public static final String SUCCESS_SAVE = "COMMANDS.SUCCESS_SAVE";
        public static final String NEED_HOLD_CF_FLOWERPOT = "COMMANDS.NEED_HOLD_CF_FLOWERPOT";
        public static final String SAVE_SYNTAX = "COMMANDS.SAVE_SYNTAX";

        // /craftflowers load
        public static final String NO_PERMISSION_LOAD = "COMMANDS.NO_PERMISSION_LOAD";
        public static final String LOAD_NOT_FOUND = "COMMANDS.LOAD_NOT_FOUND";
        public static final String SUCCESS_LOAD = "COMMANDS.SUCCESS_LOAD";
        public static final String LOAD_SYNTAX = "COMMANDS.LOAD_SYNTAX";

        // /craftflowers delete
        public static final String NO_PERMISSION_DELETE = "COMMANDS.NO_PERMISSION_DELETE";
        public static final String CANT_DELETE = "COMMANDS.CANT_DELETE";
        public static final String SUCCESS_DELETE = "COMMANDS.SUCCESS_DELETE";
        public static final String DELETE_SYNTAX = "COMMANDS.DELETE_SYNTAX";

        // /craftflowers list
        public static final String NO_PERMISSION_LIST = "COMMANDS.NO_PERMISSION_LIST";
        public static final String NO_SAVED_FLOWERS = "COMMANDS.NO_SAVED_FLOWERS";

        // /craftflowers help
        public final static class HELP_MESSAGES {
            public static final String SYNTAX = "COMMANDS.HELP_MESSAGES.SYNTAX";
            public static final String OPEN_GUI = "COMMANDS.HELP_MESSAGES.OPEN_GUI";
            public static final String SAVE = "COMMANDS.HELP_MESSAGES.SAVE";
            public static final String LOAD = "COMMANDS.HELP_MESSAGES.LOAD";
            public static final String DELETE = "COMMANDS.HELP_MESSAGES.DELETE";
            public static final String INFO = "COMMANDS.HELP_MESSAGES.INFO";
            public static final String LIST = "COMMANDS.HELP_MESSAGES.LIST";
            public static final String HELP = "COMMANDS.HELP_MESSAGES.HELP";
        }
    }

    public final static class FLOWER_INFO {

        public static final String AGE = "FLOWER_INFO.AGE";
        public static final String LIMIT_REACHED = "FLOWER_INFO.LIMIT_REACHED";

    }

    public final static class FLOWER {
        public static final String SUNFLOWER = "FLOWER.SUNFLOWER";
        public static final String SUGAR_CANE = "FLOWER.SUGAR_CANE";
        public static final String LILAC = "FLOWER.LILAC";
        public static final String ROSE_BUSH = "FLOWER.ROSE_BUSH";
        public static final String PEONY = "FLOWER.PEONY";
        public static final String TALL_GRASS = "FLOWER.TALL_GRASS";
        public static final String LARGE_FERN = "FLOWER.LARGE_FERN";

        public static final String OAK_SAPLING = "FLOWER.OAK_SAPLING";
        public static final String SPRUCE_SAPLING = "FLOWER.SPRUCE_SAPLING";
        public static final String BIRCH_SAPLING = "FLOWER.BIRCH_SAPLING";
        public static final String JUNGLE_SAPLING = "FLOWER.JUNGLE_SAPLING";
        public static final String ACACIA_SAPLING = "FLOWER.ACACIA_SAPLING";
        public static final String DARK_OAK_SAPLING = "FLOWER.DARK_OAK_SAPLING";

        public static final String DEAD_BUSH = "FLOWER.DEAD_BUSH";
        public static final String GRASS = "FLOWER.GRASS";
        public static final String FERN = "FLOWER.FERN";
        
        public static final String NETHER_BRICK_FENCE;
        public static final String DARK_OAK_FENCE;
        public static final String SPRUCE_FENCE;
        public static final String OAK_FENCE;
        public static final String BIRCH_FENCE;
        public static final String JUNGLE_FENCE;
        public static final String ACACIA_FENCE;
        public static final String CRIMSON_FENCE;
        public static final String WARPED_FENCE;
        public static final String MANGROVE_FENCE;

        public static final String DANDELION;
        public static final String POPPY;
        public static final String BLUE_ORCHID;
        public static final String ALLIUM;
        public static final String AZURE_BLUET;
        public static final String RED_TULIP;
        public static final String ORANGE_TULIP;
        public static final String WHITE_TULIP;
        public static final String PINK_TULIP;
        public static final String OXEYE_DAISY;
        public static final String CORNFLOWER;
        public static final String LILY_OF_THE_VALLEY;
        public static final String WITHER_ROSE;
        public static final String BROWN_MUSHROOM;
        public static final String RED_MUSHROOM;
        public static final String CRIMSON_FUNGUS;
        public static final String WARPED_FUNGUS;
        public static final String FLOWER_POT;

        public static final String MOSS_BLOCK = "FLOWER.MOSS_BLOCK";
        public static final String AZALEA = "FLOWER.AZALEA";
        public static final String FLOWERING_AZALEA = "FLOWER.FLOWERING_AZALEA";
        public static final String AZALEA_LEAVES = "FLOWER.AZALEA_LEAVES";
        public static final String FLOWERING_AZALEA_LEAVES = "FLOWER.FLOWERING_AZALEA_LEAVES";
        public static final String GLOW_BERRIES = "FLOWER.GLOW_BERRIES";
        public static final String BIG_DRIPLEAF = "FLOWER.BIG_DRIPLEAF";
        public static final String BIG_DRIPLEAF_STEM = "FLOWER.BIG_DRIPLEAF_STEM";
        public static final String SMALL_DRIPLEAF = "FLOWER.SMALL_DRIPLEAF";
        public static final String SPORE_BLOSSOM = "FLOWER.SPORE_BLOSSOM";

        public static final String MANGROVE_ROOTS = "FLOWER.MANGROVE_ROOTS";
        public static final String MANGROVE_LEAVES = "FLOWER.MANGROVE_LEAVES";
        public static final String MANGROVE_PROPAGULE = "FLOWER.MANGROVE_PROPAGULE";

        public static final String OAK_LEAVES;
        public static final String SPRUCE_LEAVES;
        public static final String BIRCH_LEAVES;
        public static final String JUNGLE_LEAVES;
        public static final String ACACIA_LEAVES;
        public static final String DARK_OAK_LEAVES;

        public static final String LILY_PAD;
        public static final String VINE;
        public static final String CACTUS;
        public static final String MELON;
        public static final String PUMPKIN;
        public static final String SEAGRASS;
        public static final String SEA_PICKLE;
        public static final String KELP;
        public static final String BAMBOO;
        public static final String END_ROD;
        public static final String SOUL_LANTERN;
        public static final String LANTERN;
        public static final String COCOA_BEANS;
        public static final String CRIMSON_ROOTS;
        public static final String WEEPING_VINES;
        public static final String WARPED_ROOTS;
        public static final String NETHER_SPROUTS;
        public static final String TWISTING_VINES;
        
        public static final String BRAIN_CORAL;
        public static final String BUBBLE_CORAL;
        public static final String FIRE_CORAL;
        public static final String HORN_CORAL;
        public static final String TUBE_CORAL;
        public static final String BRAIN_CORAL_FAN;
        public static final String BUBBLE_CORAL_FAN;
        public static final String FIRE_CORAL_FAN;
        public static final String HORN_CORAL_FAN;
        public static final String TUBE_CORAL_FAN;

        public static final String WHEAT = "FLOWER.WHEAT";
        public static final String POTATO = "FLOWER.POTATO";
        public static final String CARROT = "FLOWER.CARROT";

        public static final String AIR = "FLOWER.AIR";
    }

    public final static class ITEM {
        public static final String FLOWER_POT = "ITEM.FLOWER_POT";
    }

    public final static class GUI {

        public static final String TITLE = "GUI.TITLE";
        public static final String CREATE_FLOWER = "GUI.CREATE_FLOWER";
        public static final String CANT_CREATE_EMPTY_FLOWER = "GUI.CANT_CREATE_EMPTY_FLOWER";
        public static final String REMOVE_FROM_TOP = "GUI.REMOVE_FROM_TOP";
        public static final String CLEAR_ALL = "GUI.CLEAR_ALL";
        public static final String FLOWER_GROUP_TITLE_COLOR = "GUI.FLOWER_GROUP_TITLE_COLOR";
        public static final String PREVIOUS = "GUI.PREVIOUS";
        public static final String NEXT = "GUI.NEXT";
        public static final String SAVED_FLOWERPOTS = "GUI.SAVED_FLOWERPOTS";
        public static final String SAVED_FLOWERPOTS_NAME_COLOR = "GUI.SAVED_FLOWERPOTS_NAME_COLOR";

    }

    public final static class ACTION {
        public static final String NO_PERMISSION_PLACE = "ACTION.NO_PERMISSION_PLACE";
        public static final String MISSING_FOLLOWING_ITEMS = "ACTION.MISSING_FOLLOWING_ITEMS";
        public static final String MISSING_FOLLOWING_ITEMS_LIST = "ACTION.MISSING_FOLLOWING_ITEMS_LIST";
        public static final String NO_PERMISSION_EDIT = "ACTION.NO_PERMISSION_EDIT";
        public static final String OUTDATED_VERSION = "ACTION.OUTDATED_VERSION";
        public static final String CURRENT_VERSION = "ACTION.CURRENT_VERSION";
        public static final String NEWEST_VERSION = "ACTION.NEWEST_VERSION";
        public static final String DOWNLOAD_NEW_VERSION = "ACTION.DOWNLOAD_NEW_VERSION";
        public static final String FAILED_CHECK_VERSION = "ACTION.FAILED_CHECK_VERSION";
    }

    public static void LoadLanguageFile() {
        YamlConfiguration language = null;

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
    }

    public static final String getCommandVersion(Player player, String version, ChatColor color) {
        return I18n.translate(player, COMMANDS.VERSION).replaceAll("<version>", color + version);
    }

    public static final String getCommandAuthor(Player player, String authors) {
        return I18n.translate(player, COMMANDS.AUTHOR).replaceAll("<author>", authors);
    }

    public static final String getCommandWebsite(Player player, String website) {
        return I18n.translate(player, COMMANDS.WEBSITE).replaceAll("<website>", website);
    }

    public static final String getCommandSuccessLoad(Player player, String args) {
        return I18n.translate(player, COMMANDS.SUCCESS_LOAD).replaceAll("<flower_pot_name>", args);
    }

    public static final String getCommandCantDelete(Player player, String args) {
        return I18n.translate(player, COMMANDS.CANT_DELETE).replaceAll("<flower_pot_name>", args);
    }

    public static final String getCommandSuccessDelete(Player player, String args) {
        return I18n.translate(player, COMMANDS.SUCCESS_DELETE).replaceAll("<flower_pot_name>", args);
    }

    public static final String getFlowerInfoAge(Player player, int age) {
        return I18n.translate(player, FLOWER_INFO.AGE).replaceAll("<age>", String.valueOf(age));
    }

    public static final String getActionMissingFollowingItemsList(Player player, String arrow, String flower, Integer integer) {
        return I18n.translate(player, ACTION.MISSING_FOLLOWING_ITEMS_LIST)
                .replaceAll("%1", arrow)
                .replaceAll("%2", flower)
                .replaceAll("%3", String.valueOf(integer));
    }

    public static final String getActionCurrentVersion(Player player, String version) {
        return I18n.translate(player, ACTION.CURRENT_VERSION).replaceAll("<version>", version);
    }

    public static final String getActionNewestVersion(Player player, String newVersion) {
        return I18n.translate(player, ACTION.NEWEST_VERSION).replaceAll("<version>", newVersion);
    }

    public static final String getActionDownloadNewVersion(Player player, String downloadLink) {
        return I18n.translate(player, ACTION.DOWNLOAD_NEW_VERSION).replaceAll("<link>", downloadLink);
    }
}
