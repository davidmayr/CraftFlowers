package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.storage.LanguageFile;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerRegistry {

    private static final List<Flower> flowers = new ArrayList<>();

    static {
        registerFlower(new Flower(Material.SUNFLOWER, LanguageFile.FLOWER.SUNFLOWER));
        registerFlower(new Flower(Material.SUGAR_CANE, LanguageFile.FLOWER.SUGAR_CANE));
        registerFlower(new Flower(Material.LILAC, LanguageFile.FLOWER.LILAC));
        registerFlower(new Flower(Material.ROSE_BUSH, LanguageFile.FLOWER.ROSE_BUSH));
        registerFlower(new Flower(Material.PEONY, LanguageFile.FLOWER.PEONY));
        registerFlower(new Flower(Material.TALL_GRASS, LanguageFile.FLOWER.TALL_GRASS));
        registerFlower(new Flower(Material.LARGE_FERN, LanguageFile.FLOWER.LARGE_FERN));
        registerFlower(new Flower(Material.OAK_SAPLING, LanguageFile.FLOWER.OAK_SAPLING));
        registerFlower(new Flower(Material.SPRUCE_SAPLING, LanguageFile.FLOWER.SPRUCE_SAPLING));
        registerFlower(new Flower(Material.BIRCH_SAPLING, LanguageFile.FLOWER.BIRCH_SAPLING));
        registerFlower(new Flower(Material.JUNGLE_SAPLING, LanguageFile.FLOWER.JUNGLE_SAPLING));
        registerFlower(new Flower(Material.ACACIA_SAPLING, LanguageFile.FLOWER.ACACIA_SAPLING));
        registerFlower(new Flower(Material.DARK_OAK_SAPLING, LanguageFile.FLOWER.DARK_OAK_SAPLING));
        registerFlower(new Flower(Material.DEAD_BUSH, LanguageFile.FLOWER.DEAD_BUSH));
        registerFlower(new Flower(Material.GRASS, LanguageFile.FLOWER.GRASS));
        registerFlower(new Flower(Material.FERN, LanguageFile.FLOWER.FERN));
        registerFlower(new Flower(Material.NETHER_BRICK_FENCE, LanguageFile.FLOWER.NETHER_BRICK_FENCE));

        registerFlower(new Flower(Material.DARK_OAK_FENCE, LanguageFile.FLOWER.DARK_OAK_FENCE));
        registerFlower(new Flower(Material.SPRUCE_FENCE, LanguageFile.FLOWER.SPRUCE_FENCE));
        registerFlower(new Flower(Material.OAK_FENCE, LanguageFile.FLOWER.OAK_FENCE));
        registerFlower(new Flower(Material.BIRCH_FENCE, LanguageFile.FLOWER.BIRCH_FENCE));
        registerFlower(new Flower(Material.JUNGLE_FENCE, LanguageFile.FLOWER.JUNGLE_FENCE));
        registerFlower(new Flower(Material.ACACIA_FENCE, LanguageFile.FLOWER.ACACIA_FENCE));
        registerFlower(new Flower(Material.CRIMSON_FENCE, LanguageFile.FLOWER.CRIMSON_FENCE));
        registerFlower(new Flower(Material.WARPED_FENCE, LanguageFile.FLOWER.WARPED_FENCE));

        if (isValidMaterial("MANGROVE_FENCE") /* 1.19+ */) {
            registerFlower(new Flower(Material.MANGROVE_FENCE, LanguageFile.FLOWER.MANGROVE_FENCE));
        }

        registerFlower(new Flower(Material.DANDELION, LanguageFile.FLOWER.DANDELION));
        registerFlower(new Flower(Material.POPPY, LanguageFile.FLOWER.POPPY));
        registerFlower(new Flower(Material.BLUE_ORCHID, LanguageFile.FLOWER.BLUE_ORCHID));
        registerFlower(new Flower(Material.ALLIUM, LanguageFile.FLOWER.ALLIUM));
        registerFlower(new Flower(Material.AZURE_BLUET, LanguageFile.FLOWER.AZURE_BLUET));
        registerFlower(new Flower(Material.RED_TULIP, LanguageFile.FLOWER.RED_TULIP));
        registerFlower(new Flower(Material.ORANGE_TULIP, LanguageFile.FLOWER.ORANGE_TULIP));
        registerFlower(new Flower(Material.WHITE_TULIP, LanguageFile.FLOWER.WHITE_TULIP));
        registerFlower(new Flower(Material.PINK_TULIP, LanguageFile.FLOWER.PINK_TULIP));
        registerFlower(new Flower(Material.OXEYE_DAISY, LanguageFile.FLOWER.OXEYE_DAISY));
        registerFlower(new Flower(Material.CORNFLOWER, LanguageFile.FLOWER.CORNFLOWER));
        registerFlower(new Flower(Material.LILY_OF_THE_VALLEY, LanguageFile.FLOWER.LILY_OF_THE_VALLEY));
        registerFlower(new Flower(Material.WITHER_ROSE, LanguageFile.FLOWER.WITHER_ROSE));
        registerFlower(new Flower(Material.BROWN_MUSHROOM, LanguageFile.FLOWER.BROWN_MUSHROOM));
        registerFlower(new Flower(Material.RED_MUSHROOM, LanguageFile.FLOWER.RED_MUSHROOM));
        registerFlower(new Flower(Material.CRIMSON_FUNGUS, LanguageFile.FLOWER.CRIMSON_FUNGUS));
        registerFlower(new Flower(Material.WARPED_FUNGUS, LanguageFile.FLOWER.WARPED_FUNGUS));
        registerFlower(new Flower(Material.FLOWER_POT, LanguageFile.FLOWER.FLOWER_POT));

        if (isValidMaterial("AZALEA") /* 1.17 or newer*/) {
            registerFlower(new Flower(Material.MOSS_BLOCK, LanguageFile.FLOWER.MOSS_BLOCK));
            registerFlower(new Flower(Material.AZALEA, LanguageFile.FLOWER.AZALEA));
            registerFlower(new Flower(Material.FLOWERING_AZALEA, LanguageFile.FLOWER.FLOWERING_AZALEA));
            registerFlower(new Flower(Material.AZALEA_LEAVES, LanguageFile.FLOWER.AZALEA_LEAVES));
            registerFlower(new Flower(Material.FLOWERING_AZALEA_LEAVES, LanguageFile.FLOWER.FLOWERING_AZALEA_LEAVES));
            registerFlower(new Flower(Material.GLOW_BERRIES, LanguageFile.FLOWER.GLOW_BERRIES, Material.CAVE_VINES));
            registerFlower(new Flower(Material.BIG_DRIPLEAF, LanguageFile.FLOWER.BIG_DRIPLEAF));
            registerFlower(new Flower(Material.BIG_DRIPLEAF, LanguageFile.FLOWER.BIG_DRIPLEAF_STEM, Material.BIG_DRIPLEAF_STEM));
            registerFlower(new Flower(Material.SMALL_DRIPLEAF, LanguageFile.FLOWER.SMALL_DRIPLEAF));
            registerFlower(new Flower(Material.SPORE_BLOSSOM, LanguageFile.FLOWER.SPORE_BLOSSOM));
        }

        if (isValidMaterial("MANGROVE_LEAVES" /* 1.19*/)) {
            registerFlower(new Flower(Material.MANGROVE_ROOTS, LanguageFile.FLOWER.MANGROVE_ROOTS));
            registerFlower(new Flower(Material.MANGROVE_LEAVES, LanguageFile.FLOWER.MANGROVE_LEAVES));
            registerFlower(new Flower(Material.MANGROVE_PROPAGULE, LanguageFile.FLOWER.MANGROVE_PROPAGULE));
        }

        registerFlower(new Flower(Material.OAK_LEAVES, LanguageFile.FLOWER.OAK_LEAVES));
        registerFlower(new Flower(Material.SPRUCE_LEAVES, LanguageFile.FLOWER.SPRUCE_LEAVES));
        registerFlower(new Flower(Material.BIRCH_LEAVES, LanguageFile.FLOWER.BIRCH_LEAVES));
        registerFlower(new Flower(Material.JUNGLE_LEAVES, LanguageFile.FLOWER.JUNGLE_LEAVES));
        registerFlower(new Flower(Material.ACACIA_LEAVES, LanguageFile.FLOWER.ACACIA_LEAVES));
        registerFlower(new Flower(Material.DARK_OAK_LEAVES, LanguageFile.FLOWER.DARK_OAK_LEAVES));
        registerFlower(new Flower(Material.LILY_PAD, LanguageFile.FLOWER.LILY_PAD));
        registerFlower(new Flower(Material.VINE, LanguageFile.FLOWER.VINE));
        registerFlower(new Flower(Material.CACTUS, LanguageFile.FLOWER.CACTUS));
        registerFlower(new Flower(Material.MELON, LanguageFile.FLOWER.MELON));
        registerFlower(new Flower(Material.PUMPKIN, LanguageFile.FLOWER.PUMPKIN));
        registerFlower(new Flower(Material.SEAGRASS, LanguageFile.FLOWER.SEAGRASS));
        registerFlower(new Flower(Material.SEA_PICKLE, LanguageFile.FLOWER.SEA_PICKLE));
        registerFlower(new Flower(Material.KELP, LanguageFile.FLOWER.KELP));
        registerFlower(new Flower(Material.BAMBOO, LanguageFile.FLOWER.BAMBOO));
        registerFlower(new Flower(Material.END_ROD, LanguageFile.FLOWER.END_ROD));
        registerFlower(new Flower(Material.SOUL_LANTERN, LanguageFile.FLOWER.SOUL_LANTERN));
        registerFlower(new Flower(Material.LANTERN, LanguageFile.FLOWER.LANTERN));
        registerFlower(new Flower(Material.COCOA_BEANS, LanguageFile.FLOWER.COCOA_BEANS, Material.COCOA));
        registerFlower(new Flower(Material.CRIMSON_ROOTS, LanguageFile.FLOWER.CRIMSON_ROOTS));
        registerFlower(new Flower(Material.WEEPING_VINES, LanguageFile.FLOWER.WEEPING_VINES));
        registerFlower(new Flower(Material.WARPED_ROOTS, LanguageFile.FLOWER.WARPED_ROOTS));
        registerFlower(new Flower(Material.NETHER_SPROUTS, LanguageFile.FLOWER.NETHER_SPROUTS));
        registerFlower(new Flower(Material.TWISTING_VINES, LanguageFile.FLOWER.TWISTING_VINES));
        registerFlower(new Flower(Material.BRAIN_CORAL, LanguageFile.FLOWER.BRAIN_CORAL));
        registerFlower(new Flower(Material.BUBBLE_CORAL, LanguageFile.FLOWER.BUBBLE_CORAL));
        registerFlower(new Flower(Material.FIRE_CORAL, LanguageFile.FLOWER.FIRE_CORAL));
        registerFlower(new Flower(Material.HORN_CORAL, LanguageFile.FLOWER.HORN_CORAL));
        registerFlower(new Flower(Material.TUBE_CORAL, LanguageFile.FLOWER.TUBE_CORAL));
        registerFlower(new Flower(Material.BRAIN_CORAL_FAN, LanguageFile.FLOWER.BRAIN_CORAL_FAN));
        registerFlower(new Flower(Material.BUBBLE_CORAL_FAN, LanguageFile.FLOWER.BUBBLE_CORAL_FAN));
        registerFlower(new Flower(Material.FIRE_CORAL_FAN, LanguageFile.FLOWER.FIRE_CORAL_FAN));
        registerFlower(new Flower(Material.HORN_CORAL_FAN, LanguageFile.FLOWER.HORN_CORAL_FAN));
        registerFlower(new Flower(Material.TUBE_CORAL_FAN, LanguageFile.FLOWER.TUBE_CORAL_FAN));

        registerFlower(new FlowerGroup(Material.WHEAT, LanguageFile.FLOWER.WHEAT, Arrays.asList(
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER.WHEAT_AGE_0, 0),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER.WHEAT_AGE_1, 1),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER.WHEAT_AGE_2, 2),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER.WHEAT_AGE_3, 3),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER.WHEAT_AGE_4, 4),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER.WHEAT_AGE_5, 5),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER.WHEAT_AGE_6, 6),
                new AgingFlower(Material.WHEAT, LanguageFile.FLOWER.WHEAT_AGE_7, 7)
        )));

        registerFlower(new FlowerGroup(Material.POTATO, LanguageFile.FLOWER.POTATO, Arrays.asList(
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER.POTATO_AGE_0, Material.POTATOES, 0),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER.POTATO_AGE_1, Material.POTATOES, 1),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER.POTATO_AGE_2, Material.POTATOES, 2),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER.POTATO_AGE_3, Material.POTATOES, 3),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER.POTATO_AGE_4, Material.POTATOES, 4),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER.POTATO_AGE_5, Material.POTATOES, 5),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER.POTATO_AGE_6, Material.POTATOES, 6),
                new AgingFlower(Material.POTATO, LanguageFile.FLOWER.POTATO_AGE_7, Material.POTATOES, 7)
        )));

        registerFlower(new FlowerGroup(Material.CARROT, LanguageFile.FLOWER.CARROT, Arrays.asList(
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER.CARROT_AGE_0, Material.CARROTS, 0),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER.CARROT_AGE_1, Material.CARROTS, 1),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER.CARROT_AGE_2, Material.CARROTS, 2),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER.CARROT_AGE_3, Material.CARROTS, 3),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER.CARROT_AGE_4, Material.CARROTS, 4),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER.CARROT_AGE_5, Material.CARROTS, 5),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER.CARROT_AGE_6, Material.CARROTS, 6),
                new AgingFlower(Material.CARROT, LanguageFile.FLOWER.CARROT_AGE_7, Material.CARROTS, 7)
        )));
        registerFlower(new Flower(Material.BARRIER, LanguageFile.FLOWER.AIR, Material.AIR));
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
