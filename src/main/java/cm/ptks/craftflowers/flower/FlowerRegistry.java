package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.storage.LanguageFile;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerRegistry {

    private static final List<Flower> flowers = new ArrayList<>();

    static {
        registerFlower(new Flower(Material.SUNFLOWER, LanguageFile.FLOWER_SUNFLOWER));
        registerFlower(new Flower(Material.SUGAR_CANE, LanguageFile.FLOWER_SUGAR_CANE));
        registerFlower(new Flower(Material.LILAC, LanguageFile.FLOWER_LILAC));
        registerFlower(new Flower(Material.ROSE_BUSH, LanguageFile.FLOWER_ROSE_BUSH));
        registerFlower(new Flower(Material.PEONY, LanguageFile.FLOWER_PEONY));
        registerFlower(new Flower(Material.TALL_GRASS, LanguageFile.FLOWER_TALL_GRASS));
        registerFlower(new Flower(Material.LARGE_FERN, LanguageFile.FLOWER_LARGE_FERN));
        registerFlower(new Flower(Material.OAK_SAPLING, LanguageFile.FLOWER_OAK_SAPLING));
        registerFlower(new Flower(Material.SPRUCE_SAPLING, LanguageFile.FLOWER_SPRUCE_SAPLING));
        registerFlower(new Flower(Material.BIRCH_SAPLING, LanguageFile.FLOWER_BIRCH_SAPLING));
        registerFlower(new Flower(Material.JUNGLE_SAPLING, LanguageFile.FLOWER_JUNGLE_SAPLING));
        registerFlower(new Flower(Material.ACACIA_SAPLING, LanguageFile.FLOWER_ACACIA_SAPLING));
        registerFlower(new Flower(Material.DARK_OAK_SAPLING, LanguageFile.FLOWER_DARK_OAK_SAPLING));
        registerFlower(new Flower(Material.DEAD_BUSH, LanguageFile.FLOWER_DEAD_BUSH));
        registerFlower(new Flower(Material.GRASS, LanguageFile.FLOWER_GRASS));
        registerFlower(new Flower(Material.FERN, LanguageFile.FLOWER_FERN));
        registerFlower(new Flower(Material.NETHER_BRICK_FENCE, LanguageFile.FLOWER_NETHER_BRICK_FENCE));

        registerFlower(new Flower(Material.DARK_OAK_FENCE, LanguageFile.FLOWER_DARK_OAK_FENCE));
        registerFlower(new Flower(Material.SPRUCE_FENCE, LanguageFile.FLOWER_SPRUCE_FENCE));
        registerFlower(new Flower(Material.OAK_FENCE, LanguageFile.FLOWER_OAK_FENCE));
        registerFlower(new Flower(Material.BIRCH_FENCE, LanguageFile.FLOWER_BIRCH_FENCE));
        registerFlower(new Flower(Material.JUNGLE_FENCE, LanguageFile.FLOWER_JUNGLE_FENCE));
        registerFlower(new Flower(Material.ACACIA_FENCE, LanguageFile.FLOWER_ACACIA_FENCE));
        registerFlower(new Flower(Material.CRIMSON_FENCE, LanguageFile.FLOWER_CRIMSON_FENCE));
        registerFlower(new Flower(Material.WARPED_FENCE, LanguageFile.FLOWER_WARPED_FENCE));

        if (isValidMaterial("MANGROVE_FENCE") /* 1.19+ */) {
            registerFlower(new Flower(Material.MANGROVE_FENCE, LanguageFile.FLOWER_MANGROVE_FENCE));
        }

        registerFlower(new Flower(Material.DANDELION, LanguageFile.FLOWER_DANDELION));
        registerFlower(new Flower(Material.POPPY, LanguageFile.FLOWER_POPPY));
        registerFlower(new Flower(Material.BLUE_ORCHID, LanguageFile.FLOWER_BLUE_ORCHID));
        registerFlower(new Flower(Material.ALLIUM, LanguageFile.FLOWER_ALLIUM));
        registerFlower(new Flower(Material.AZURE_BLUET, LanguageFile.FLOWER_AZURE_BLUET));
        registerFlower(new Flower(Material.RED_TULIP, LanguageFile.FLOWER_RED_TULIP));
        registerFlower(new Flower(Material.ORANGE_TULIP, LanguageFile.FLOWER_ORANGE_TULIP));
        registerFlower(new Flower(Material.WHITE_TULIP, LanguageFile.FLOWER_WHITE_TULIP));
        registerFlower(new Flower(Material.PINK_TULIP, LanguageFile.FLOWER_PINK_TULIP));
        registerFlower(new Flower(Material.OXEYE_DAISY, LanguageFile.FLOWER_OXEYE_DAISY));
        registerFlower(new Flower(Material.CORNFLOWER, LanguageFile.FLOWER_CORNFLOWER));
        registerFlower(new Flower(Material.LILY_OF_THE_VALLEY, LanguageFile.FLOWER_LILY_OF_THE_VALLEY));
        registerFlower(new Flower(Material.WITHER_ROSE, LanguageFile.FLOWER_WITHER_ROSE));
        registerFlower(new Flower(Material.BROWN_MUSHROOM, LanguageFile.FLOWER_BROWN_MUSHROOM));
        registerFlower(new Flower(Material.RED_MUSHROOM, LanguageFile.FLOWER_RED_MUSHROOM));
        registerFlower(new Flower(Material.CRIMSON_FUNGUS, LanguageFile.FLOWER_CRIMSON_FUNGUS));
        registerFlower(new Flower(Material.WARPED_FUNGUS, LanguageFile.FLOWER_WARPED_FUNGUS));
        registerFlower(new Flower(Material.FLOWER_POT, LanguageFile.FLOWER_FLOWER_POT));

        if (isValidMaterial("AZALEA") /* 1.17 or newer*/) {
            registerFlower(new Flower(Material.MOSS_BLOCK, LanguageFile.FLOWER_MOSS_BLOCK));
            registerFlower(new Flower(Material.AZALEA, LanguageFile.FLOWER_AZALEA));
            registerFlower(new Flower(Material.FLOWERING_AZALEA, LanguageFile.FLOWER_FLOWERING_AZALEA));
            registerFlower(new Flower(Material.AZALEA_LEAVES, LanguageFile.FLOWER_AZALEA_LEAVES));
            registerFlower(new Flower(Material.FLOWERING_AZALEA_LEAVES, LanguageFile.FLOWER_FLOWERING_AZALEA_LEAVES));
            registerFlower(new Flower(Material.GLOW_BERRIES, LanguageFile.FLOWER_GLOW_BERRIES, Material.CAVE_VINES));
            registerFlower(new Flower(Material.BIG_DRIPLEAF, LanguageFile.FLOWER_BIG_DRIPLEAF));
            registerFlower(new Flower(Material.BIG_DRIPLEAF, LanguageFile.FLOWER_BIG_DRIPLEAF_STEM, Material.BIG_DRIPLEAF_STEM));
            registerFlower(new Flower(Material.SMALL_DRIPLEAF, LanguageFile.FLOWER_SMALL_DRIPLEAF));
            registerFlower(new Flower(Material.SPORE_BLOSSOM, LanguageFile.FLOWER_SPORE_BLOSSOM));
        }

        if (isValidMaterial("MANGROVE_LEAVES" /* 1.19*/)) {
            registerFlower(new Flower(Material.MANGROVE_ROOTS, LanguageFile.FLOWER_MANGROVE_ROOTS));
            registerFlower(new Flower(Material.MANGROVE_LEAVES, LanguageFile.FLOWER_MANGROVE_LEAVES));
            registerFlower(new Flower(Material.MANGROVE_PROPAGULE, LanguageFile.FLOWER_MANGROVE_PROPAGULE));
        }

        registerFlower(new Flower(Material.OAK_LEAVES, LanguageFile.FLOWER_OAK_LEAVES));
        registerFlower(new Flower(Material.SPRUCE_LEAVES, LanguageFile.FLOWER_SPRUCE_LEAVES));
        registerFlower(new Flower(Material.BIRCH_LEAVES, LanguageFile.FLOWER_BIRCH_LEAVES));
        registerFlower(new Flower(Material.JUNGLE_LEAVES, LanguageFile.FLOWER_JUNGLE_LEAVES));
        registerFlower(new Flower(Material.ACACIA_LEAVES, LanguageFile.FLOWER_ACACIA_LEAVES));
        registerFlower(new Flower(Material.DARK_OAK_LEAVES, LanguageFile.FLOWER_DARK_OAK_LEAVES));
        registerFlower(new Flower(Material.LILY_PAD, LanguageFile.FLOWER_LILY_PAD));
        registerFlower(new Flower(Material.VINE, LanguageFile.FLOWER_VINE));
        registerFlower(new Flower(Material.CACTUS, LanguageFile.FLOWER_CACTUS));
        registerFlower(new Flower(Material.MELON, LanguageFile.FLOWER_MELON));
        registerFlower(new Flower(Material.PUMPKIN, LanguageFile.FLOWER_PUMPKIN));
        registerFlower(new Flower(Material.SEAGRASS, LanguageFile.FLOWER_SEAGRASS));
        registerFlower(new Flower(Material.SEA_PICKLE, LanguageFile.FLOWER_SEA_PICKLE));
        registerFlower(new Flower(Material.KELP, LanguageFile.FLOWER_KELP));
        registerFlower(new Flower(Material.BAMBOO, LanguageFile.FLOWER_BAMBOO));
        registerFlower(new Flower(Material.END_ROD, LanguageFile.FLOWER_END_ROD));
        registerFlower(new Flower(Material.SOUL_LANTERN, LanguageFile.FLOWER_SOUL_LANTERN));
        registerFlower(new Flower(Material.LANTERN, LanguageFile.FLOWER_LANTERN));
        registerFlower(new Flower(Material.COCOA_BEANS, LanguageFile.FLOWER_COCOA_BEANS, Material.COCOA));
        registerFlower(new Flower(Material.CRIMSON_ROOTS, LanguageFile.FLOWER_CRIMSON_ROOTS));
        registerFlower(new Flower(Material.WEEPING_VINES, LanguageFile.FLOWER_WEEPING_VINES));
        registerFlower(new Flower(Material.WARPED_ROOTS, LanguageFile.FLOWER_WARPED_ROOTS));
        registerFlower(new Flower(Material.NETHER_SPROUTS, LanguageFile.FLOWER_NETHER_SPROUTS));
        registerFlower(new Flower(Material.TWISTING_VINES, LanguageFile.FLOWER_TWISTING_VINES));
        registerFlower(new Flower(Material.BRAIN_CORAL, LanguageFile.FLOWER_BRAIN_CORAL));
        registerFlower(new Flower(Material.BUBBLE_CORAL, LanguageFile.FLOWER_BUBBLE_CORAL));
        registerFlower(new Flower(Material.FIRE_CORAL, LanguageFile.FLOWER_FIRE_CORAL));
        registerFlower(new Flower(Material.HORN_CORAL, LanguageFile.FLOWER_HORN_CORAL));
        registerFlower(new Flower(Material.TUBE_CORAL, LanguageFile.FLOWER_TUBE_CORAL));
        registerFlower(new Flower(Material.BRAIN_CORAL_FAN, LanguageFile.FLOWER_BRAIN_CORAL_FAN));
        registerFlower(new Flower(Material.BUBBLE_CORAL_FAN, LanguageFile.FLOWER_BUBBLE_CORAL_FAN));
        registerFlower(new Flower(Material.FIRE_CORAL_FAN, LanguageFile.FLOWER_FIRE_CORAL_FAN));
        registerFlower(new Flower(Material.HORN_CORAL_FAN, LanguageFile.FLOWER_HORN_CORAL_FAN));
        registerFlower(new Flower(Material.TUBE_CORAL_FAN, LanguageFile.FLOWER_TUBE_CORAL_FAN));

        registerFlower(new FlowerGroup(Material.WHEAT, LanguageFile.FLOWER_WHEAT, Arrays.asList(
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER_WHEAT_AGE_0, 0),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER_WHEAT_AGE_1, 1),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER_WHEAT_AGE_2, 2),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER_WHEAT_AGE_3, 3),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER_WHEAT_AGE_4, 4),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER_WHEAT_AGE_5, 5),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER_WHEAT_AGE_6, 6),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER_WHEAT_AGE_7, 7)
        )));

        registerFlower(new FlowerGroup(Material.POTATO, LanguageFile.FLOWER_POTATO, Arrays.asList(
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER_POTATO_AGE_0, Material.POTATOES, 0),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER_POTATO_AGE_1, Material.POTATOES, 1),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER_POTATO_AGE_2, Material.POTATOES, 2),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER_POTATO_AGE_3, Material.POTATOES, 3),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER_POTATO_AGE_4, Material.POTATOES, 4),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER_POTATO_AGE_5, Material.POTATOES, 5),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER_POTATO_AGE_6, Material.POTATOES, 6),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER_POTATO_AGE_7, Material.POTATOES, 7)
        )));

        registerFlower(new FlowerGroup(Material.CARROT, LanguageFile.FLOWER_CARROT, Arrays.asList(
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER_CARROT_AGE_0, Material.CARROTS, 0),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER_CARROT_AGE_1, Material.CARROTS, 1),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER_CARROT_AGE_2, Material.CARROTS, 2),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER_CARROT_AGE_3, Material.CARROTS, 3),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER_CARROT_AGE_4, Material.CARROTS, 4),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER_CARROT_AGE_5, Material.CARROTS, 5),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER_CARROT_AGE_6, Material.CARROTS, 6),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER_CARROT_AGE_7, Material.CARROTS, 7)
        )));
        registerFlower(new Flower(Material.BARRIER, LanguageFile.FLOWER_AIR, Material.AIR));
    }

    private static <E extends Enum<E>> boolean isValidMaterial(String enumName) {
        if (enumName == null) {
            return false;
        } else {
            try {
                Material.valueOf(enumName);
                return true;
            } catch (IllegalArgumentException var3) {
                return false;
            }
        }
    }

    private static void registerFlower(Flower flower) {
        flowers.add(flower);
    }

    public static List<Flower> getFlowers() {
        return flowers;
    }
}
