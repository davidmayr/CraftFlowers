package cm.ptks.craftflowers.languages;

import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Bamboo;
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

        public static final String FLOWER_AMOUNT = "FLOWER_INFO.FLOWER_AMOUNT";

        public static final String BISECTED_UPPER = "FLOWER_INFO.BISECTED_UPPER";

        public static final String BISECTED_LOWER = "FLOWER_INFO.BISECTED_LOWER";

        public static final String BAMBOO_LEAVES = "FLOWER_INFO.BAMBOO_LEAVES";
        public static final String LIMIT_REACHED = "FLOWER_INFO.LIMIT_REACHED";

        public static final String FLOWER_LIST = "FLOWER_INFO.FLOWER_LIST";
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

        public static final String CHERRY_SAPLING = "FLOWER.CHERRY_SAPLING";

        public static final String DEAD_BUSH = "FLOWER.DEAD_BUSH";
        public static final String GRASS = "FLOWER.GRASS";
        public static final String FERN = "FLOWER.FERN";
        
        public static final String NETHER_BRICK_FENCE = "FLOWER.NETHER_BRICK_FENCE";
        public static final String DARK_OAK_FENCE = "FLOWER.DARK_OAK_FENCE";
        public static final String SPRUCE_FENCE = "FLOWER.SPRUCE_FENCE";
        public static final String OAK_FENCE = "FLOWER.OAK_FENCE";
        public static final String BIRCH_FENCE = "FLOWER.BIRCH_FENCE";
        public static final String JUNGLE_FENCE = "FLOWER.JUNGLE_FENCE";
        public static final String ACACIA_FENCE = "FLOWER.ACACIA_FENCE";
        public static final String CRIMSON_FENCE = "FLOWER.CRIMSON_FENCE";
        public static final String WARPED_FENCE = "FLOWER.WARPED_FENCE";
        public static final String MANGROVE_FENCE = "FLOWER.MANGROVE_FENCE";
        public static final String CHERRY_FENCE = "FLOWER.CHERRY_FENCE";
        public static final String BAMBOO_FENCE = "FLOWER.BAMBOO_FENCE";

        public static final String DANDELION = "FLOWER.DANDELION";
        public static final String POPPY = "FLOWER.POPPY";
        public static final String BLUE_ORCHID = "FLOWER.BLUE_ORCHID";
        public static final String ALLIUM = "FLOWER.ALLIUM";
        public static final String AZURE_BLUET = "FLOWER.AZURE_BLUET";
        public static final String RED_TULIP = "FLOWER.RED_TULIP";
        public static final String ORANGE_TULIP = "FLOWER.ORANGE_TULIP";
        public static final String WHITE_TULIP = "FLOWER.WHITE_TULIP";
        public static final String PINK_TULIP = "FLOWER.PINK_TULIP";
        public static final String OXEYE_DAISY = "FLOWER.OXEYE_DAISY";
        public static final String CORNFLOWER = "FLOWER.CORNFLOWER";
        public static final String LILY_OF_THE_VALLEY = "FLOWER.LILY_OF_THE_VALLEY";
        public static final String WITHER_ROSE = "FLOWER.WITHER_ROSE";
        public static final String BROWN_MUSHROOM = "FLOWER.BROWN_MUSHROOM";
        public static final String RED_MUSHROOM = "FLOWER.RED_MUSHROOM";
        public static final String CRIMSON_FUNGUS = "FLOWER.CRIMSON_FUNGUS";
        public static final String WARPED_FUNGUS = "FLOWER.WARPED_FUNGUS";

        public static final String TORCHFLOWER = "FLOWER.TORCHFLOWER";

        public static final String TORCHFLOWER_SEEDS = "FLOWER.TORCHFLOWER_SEEDS";

        public static final String PITCHER_POD = "FLOWER.PITCHER_POD";
        public static final String PITCHER_PLANT = "FLOWER.PITCHER_PLANT";
        public static final String PINK_PETALS = "FLOWER.PINK_PETALS";

        public static final String FLOWER_POT = "FLOWER.FLOWER_POT";

        public static final String MOSS_BLOCK = "FLOWER.MOSS_BLOCK";
        public static final String AZALEA = "FLOWER.AZALEA";
        public static final String FLOWERING_AZALEA = "FLOWER.FLOWERING_AZALEA";
        public static final String AZALEA_LEAVES = "FLOWER.AZALEA_LEAVES";
        public static final String CHERRY_LEAVES = "FLOWER.CHERRY_LEAVES";
        public static final String FLOWERING_AZALEA_LEAVES = "FLOWER.FLOWERING_AZALEA_LEAVES";
        public static final String GLOW_BERRIES = "FLOWER.GLOW_BERRIES";
        public static final String BIG_DRIPLEAF = "FLOWER.BIG_DRIPLEAF";
        public static final String BIG_DRIPLEAF_STEM = "FLOWER.BIG_DRIPLEAF_STEM";
        public static final String SMALL_DRIPLEAF = "FLOWER.SMALL_DRIPLEAF";
        public static final String SPORE_BLOSSOM = "FLOWER.SPORE_BLOSSOM";

        public static final String MANGROVE_ROOTS = "FLOWER.MANGROVE_ROOTS";
        public static final String MANGROVE_LEAVES = "FLOWER.MANGROVE_LEAVES";
        public static final String MANGROVE_PROPAGULE = "FLOWER.MANGROVE_PROPAGULE";

        public static final String OAK_LEAVES = "FLOWER.OAK_LEAVES";
        public static final String SPRUCE_LEAVES = "FLOWER.SPRUCE_LEAVES";
        public static final String BIRCH_LEAVES = "FLOWER.BIRCH_LEAVES";
        public static final String JUNGLE_LEAVES = "FLOWER.JUNGLE_LEAVES";
        public static final String ACACIA_LEAVES = "FLOWER.ACACIA_LEAVES";
        public static final String DARK_OAK_LEAVES = "FLOWER.DARK_OAK_LEAVES";
        public static final String LILY_PAD = "FLOWER.LILY_PAD";
        public static final String VINE = "FLOWER.VINE";
        public static final String CACTUS = "FLOWER.CACTUS";
        public static final String MELON = "FLOWER.MELON";
        public static final String PUMPKIN = "FLOWER.PUMPKIN";
        public static final String SEAGRASS = "FLOWER.SEAGRASS";
        public static final String SEA_PICKLE = "FLOWER.SEA_PICKLE";
        public static final String KELP = "FLOWER.KELP";
        public static final String BAMBOO = "FLOWER.BAMBOO";
        public static final String END_ROD = "FLOWER.END_ROD";
        public static final String SOUL_LANTERN = "FLOWER.SOUL_LANTERN";
        public static final String LANTERN = "FLOWER.LANTERN";
        public static final String COCOA_BEANS = "FLOWER.COCOA_BEANS";
        public static final String CRIMSON_ROOTS = "FLOWER.CRIMSON_ROOTS";
        public static final String WEEPING_VINES = "FLOWER.WEEPING_VINES";
        public static final String WARPED_ROOTS = "FLOWER.WARPED_ROOTS";
        public static final String NETHER_SPROUTS = "FLOWER.NETHER_SPROUTS";
        public static final String TWISTING_VINES = "FLOWER.TWISTING_VINES";
        public static final String BRAIN_CORAL = "FLOWER.BRAIN_CORAL";
        public static final String BUBBLE_CORAL = "FLOWER.BUBBLE_CORAL";
        public static final String FIRE_CORAL = "FLOWER.FIRE_CORAL";
        public static final String HORN_CORAL = "FLOWER.HORN_CORAL";
        public static final String TUBE_CORAL = "FLOWER.TUBE_CORAL";
        public static final String BRAIN_CORAL_FAN = "FLOWER.BRAIN_CORAL_FAN";
        public static final String BUBBLE_CORAL_FAN = "FLOWER.BUBBLE_CORAL_FAN";
        public static final String FIRE_CORAL_FAN = "FLOWER.FIRE_CORAL_FAN";
        public static final String HORN_CORAL_FAN = "FLOWER.HORN_CORAL_FAN";
        public static final String TUBE_CORAL_FAN = "FLOWER.TUBE_CORAL_FAN";

        public static final String WHEAT = "FLOWER.WHEAT";
        public static final String POTATO = "FLOWER.POTATO";
        public static final String CARROT = "FLOWER.CARROT";

        public static final String SWEET_BERRY_BUSH = "FLOWER.SWEET_BERRY_BUSH";

        public static final String AIR = "FLOWER.AIR";
        
        public static final String LIT_CANDLE = "FLOWER.CANDLE_GROUP_LIT";
        public static final String CANDLE = "FLOWER.CANDLE_GROUP";

        public static final String AMETHYST = "FLOWER.AMETHYST";
        public static final String AMETHYST_SMALL_BUD = "FLOWER.AMETHYST_SMALL_BUD";
        public static final String AMETHYST_MEDIUM_BUD = "FLOWER.AMETHYST_MEDIUM_BUD";
        public static final String AMETHYST_LARGE_BUD = "FLOWER.AMETHYST_LARGE_BUD";
        public static final String AMETHYST_CLUSTER = "FLOWER.AMETHYST_CLUSTER";

        public static final String CANDLE_LIT_INDICATOR = "FLOWER.CANDLE.LIT";

        public static final String CANDLE_CANDLE = "FLOWER.CANDLE.CANDLE";
        public static final String CANDLE_WHITE_CANDLE = "FLOWER.CANDLE.WHITE_CANDLE";
        public static final String CANDLE_ORANGE_CANDLE = "FLOWER.CANDLE.ORANGE_CANDLE";
        public static final String CANDLE_MAGENTA_CANDLE = "FLOWER.CANDLE.MAGENTA_CANDLE";
        public static final String CANDLE_LIGHT_BLUE_CANDLE = "FLOWER.CANDLE.LIGHT_BLUE_CANDLE";
        public static final String CANDLE_YELLOW_CANDLE = "FLOWER.CANDLE.YELLOW_CANDLE";
        public static final String CANDLE_LIME_CANDLE = "FLOWER.CANDLE.LIME_CANDLE";
        public static final String CANDLE_PINK_CANDLE = "FLOWER.CANDLE.PINK_CANDLE";
        public static final String CANDLE_GRAY_CANDLE = "FLOWER.CANDLE.GRAY_CANDLE";
        public static final String CANDLE_LIGHT_GRAY_CANDLE = "FLOWER.CANDLE.LIGHT_GRAY_CANDLE";
        public static final String CANDLE_CYAN_CANDLE = "FLOWER.CANDLE.CYAN_CANDLE";
        public static final String CANDLE_PURPLE_CANDLE = "FLOWER.CANDLE.PURPLE_CANDLE";
        public static final String CANDLE_BLUE_CANDLE = "FLOWER.CANDLE.BLUE_CANDLE";
        public static final String CANDLE_BROWN_CANDLE = "FLOWER.CANDLE.BROWN_CANDLE";
        public static final String CANDLE_GREEN_CANDLE = "FLOWER.CANDLE.GREEN_CANDLE";
        public static final String CANDLE_RED_CANDLE = "FLOWER.CANDLE.RED_CANDLE";
        public static final String CANDLE_BLACK_CANDLE = "FLOWER.CANDLE.BLACK_CANDLE";

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

    public static String getCommandVersion(Player player, String version, ChatColor color) {
        return I18n.translate(player, COMMANDS.VERSION).replaceAll("<version>", color + version);
    }

    public static String getCommandAuthor(Player player, String authors) {
        return I18n.translate(player, COMMANDS.AUTHOR).replaceAll("<author>", authors);
    }

    public static String getCommandWebsite(Player player, String website) {
        return I18n.translate(player, COMMANDS.WEBSITE).replaceAll("<website>", website);
    }

    public static String getCommandSuccessLoad(Player player, String args) {
        return I18n.translate(player, COMMANDS.SUCCESS_LOAD).replaceAll("<flower_pot_name>", args);
    }

    public static String getCommandCantDelete(Player player, String args) {
        return I18n.translate(player, COMMANDS.CANT_DELETE).replaceAll("<flower_pot_name>", args);
    }

    public static String getCommandSuccessDelete(Player player, String args) {
        return I18n.translate(player, COMMANDS.SUCCESS_DELETE).replaceAll("<flower_pot_name>", args);
    }

    public static String getFlowerInfoAge(Player player, int age) {
        return I18n.translate(player, FLOWER_INFO.AGE).replaceAll("<age>", String.valueOf(age));
    }

    public static String getFlowerInfoFlowerAmount(Player player, int age) {
        return I18n.translate(player, FLOWER_INFO.FLOWER_AMOUNT).replaceAll("<amount>", String.valueOf(age));
    }

    public static String getFlowerInfoBisected(Player player, Bisected.Half half) {
        if (half == Bisected.Half.TOP) {
            return I18n.translate(player, FLOWER_INFO.BISECTED_UPPER);
        } else {
            return I18n.translate(player, FLOWER_INFO.BISECTED_LOWER);
        }
    }

    public static String getFlowerInfoBambooLeaves(Player player, Bamboo.Leaves leaves) {
        return I18n.translate(player, FLOWER_INFO.BAMBOO_LEAVES).replaceAll("<leaves>", String.valueOf(leaves.name()));
    }


    public static String getActionMissingFollowingItemsList(Player player, String arrow, String flower, Integer integer) {
        return I18n.translate(player, ACTION.MISSING_FOLLOWING_ITEMS_LIST)
                .replaceAll("%1", arrow)
                .replaceAll("%2", flower)
                .replaceAll("%3", String.valueOf(integer));
    }

    public static String getActionCurrentVersion(Player player, String version) {
        return I18n.translate(player, ACTION.CURRENT_VERSION).replaceAll("<version>", version);
    }

    public static String getActionNewestVersion(Player player, String newVersion) {
        return I18n.translate(player, ACTION.NEWEST_VERSION).replaceAll("<version>", newVersion);
    }

    public static String getActionDownloadNewVersion(Player player, String downloadLink) {
        return I18n.translate(player, ACTION.DOWNLOAD_NEW_VERSION).replaceAll("<link>", downloadLink);
    }
}
