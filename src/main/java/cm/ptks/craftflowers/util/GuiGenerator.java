package cm.ptks.craftflowers.util;

import cm.ptks.craftflowers.CraftFlowers;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.HashMap;

public class GuiGenerator {
    private HashMap<Integer, ItemStack> items = new HashMap();


    ItemStack glass_white;

    private CraftFlowers flowers;

    public GuiGenerator(CraftFlowers flowers) {
        this.flowers = flowers;
        this.glass_white = new ItemStack(Material.BLACK_STAINED_GLASS, 1, (short) 0);
        ItemMeta itemMeta = this.glass_white.getItemMeta();
        itemMeta.setDisplayName(" ");
        this.glass_white.setItemMeta(itemMeta);


        init();
    }

    public HashMap<Integer, ItemStack> getItems() {
        return items;
    }

    private void init() {
        putItem(0, Material.SUNFLOWER, "§2Sunflower");
        putItem(1, Material.LILAC, "§2Lilac");
        putItem(2, Material.TALL_GRASS, "§2Double Tallgrass");
        putItem(3, Material.LARGE_FERN, "§2Large Fern");
        putItem(4, Material.ROSE_BUSH, "§2Rose Bush");
        putItem(5, Material.PEONY, "§2Peony");
        putItem(6, Material.OAK_SAPLING, "§2Oak Sapling");
        putItem(7, Material.SPRUCE_SAPLING, "§2Spruce Sapling");
        putItem(8, Material.BIRCH_SAPLING, "§2Birch Sapling");
        putItem(9, Material.JUNGLE_SAPLING, "§2Jungle Sapling");
        putItem(10, Material.ACACIA_SAPLING, "§2Acacia Sapling");
        putItem(11, Material.DARK_OAK_SAPLING, "§2Dark Oak Sapling");
        putItem(12, Material.DEAD_BUSH, "§2Dead Bush");
        putItem(13, Material.GRASS, "§2Grass");
        putItem(14, Material.FERN, "§2Fern");
        putItem(15, Material.LILY_OF_THE_VALLEY, "§2Lily of the Valley");
        putItem(16, Material.DANDELION, "§2Dandelion");
        putItem(17, Material.POPPY, "§2Poppy");
        putItem(18, Material.BLUE_ORCHID, "§2Blue Orchid");
        putItem(19, Material.ALLIUM, "§2Allium");
        putItem(20, Material.AZURE_BLUET, "§2Azure Bluet");
        putItem(21, Material.RED_TULIP, "§2Red Tulip");
        putItem(22, Material.ORANGE_TULIP, "§2Orange Tulip");
        putItem(23, Material.WHITE_TULIP, "§2White Tulip");
        putItem(24, Material.PINK_TULIP, "§2Pink Tulip");
        putItem(25, Material.OXEYE_DAISY, "§2Oxeye Daisy");
        putItem(26, Material.BROWN_MUSHROOM, "§2Mushroom");
        putItem(27, Material.RED_MUSHROOM, "§2Mushroom");
        putItem(28, Material.OAK_LEAVES, "§2Oak Leaves");
        putItem(29, Material.SPRUCE_LEAVES, "§2Spruce Leaves");
        putItem(30, Material.BIRCH_LEAVES, "§2Birch Leaves");
        putItem(31, Material.JUNGLE_LEAVES, "§2Jungle Leaves");
        putItem(32, Material.ACACIA_LEAVES, "§2Acacia Leaves");
        putItem(33, Material.DARK_OAK_LEAVES, "§2Dark Oak Leaves");
        putItem(34, Material.LILY_PAD, "§2Lily Pad");
        putItem(35, Material.VINE, "§2Vines");
        putItem(36, Material.CACTUS, "§2Cactus");
        putItem(37, Material.MELON, "§2Melon");
        putItem(38, Material.PUMPKIN, "§2Pumpkin");
        putItem(39, Material.SUGAR_CANE, "§2Sugar Canes");
        putItem(40, Material.WITHER_ROSE, "§2Wither Rose");
        putItem(41, Material.SEAGRASS, "§2Seagrass");
        putItem(42, Material.SEA_PICKLE, "§2Sea Pickle");
        putItem(43, Material.CRIMSON_FUNGUS, "§2Crimson Fungus");
        putItem(44, Material.CRIMSON_ROOTS, "§2Crimson Roots");
        putItem(45, Material.WEEPING_VINES, "§2Weeping Vines");
        putItem(46, Material.WARPED_FUNGUS, "§2Warped Fungus");
        putItem(47, Material.WARPED_ROOTS, "§2Warped Roots");
        putItem(48, Material.NETHER_SPROUTS, "§2Nether Sprouts");
        putItem(49, Material.TWISTING_VINES, "§2Twisting Vines");
        putItem(50, Material.KELP, "§2Kelp");
        putItem(51, Material.BAMBOO, "§2Bamboo");
        putItem(52, Material.END_ROD, "§2End Rod");
        putItem(53, Material.CHORUS_PLANT, "§2Chorus Plant");
        putItem(54, Material.CHORUS_FLOWER, "§2Chorus Flower");
        putItem(55, Material.CHAIN, "§2Chain");
        putItem(56, Material.FLOWER_POT, "§2Flower Pot");
        putItem(57, Material.SOUL_LANTERN, "§2Soul Lantern");
        putItem(58, Material.LANTERN, "§2Lantern");


        putItem(Material.BRAIN_CORAL, "§2Brain Coral");
        putItem(Material.BUBBLE_CORAL, "§2Bubble Coral");
        putItem(Material.FIRE_CORAL, "§2Fire Coral");
        putItem(Material.HORN_CORAL, "§2Horn Coral");
        putItem(Material.TUBE_CORAL, "§2Tube Coral");
        putItem(Material.BRAIN_CORAL_FAN, "§2Brain Coral fan");
        putItem(Material.BUBBLE_CORAL_FAN, "§2Bubble Coral fan");
        putItem(Material.FIRE_CORAL_FAN, "§2Fire Coral fan");
        putItem(Material.HORN_CORAL_FAN, "§2Horn Coral fan");
        putItem(Material.TUBE_CORAL_FAN, "§2Tube Coral fan");

        putItem(Material.COCOA_BEANS, Material.COCOA, "§2Cocoa");
        putItem(Material.CORNFLOWER,"§2Cornflower");

        putItem(Material.WHEAT, Material.WHEAT, "§2Wheat Seed Age 0", 0);
        putItem(Material.WHEAT, Material.WHEAT, "§2Wheat Seed Age 1", 1);
        putItem(Material.WHEAT, Material.WHEAT, "§2Wheat Seed Age 2", 2);
        putItem(Material.WHEAT, Material.WHEAT,"§2Wheat Seed Age 3", 3);
        putItem(Material.WHEAT, Material.WHEAT,"§2Wheat Seed Age 4", 4);
        putItem(Material.WHEAT, Material.WHEAT,"§2Wheat Seed Age 5", 5);
        putItem(Material.WHEAT, Material.WHEAT,"§2Wheat Seed Age 6", 6);
        putItem(Material.WHEAT, Material.WHEAT,"§2Wheat Seed Age 7", 7);
        putItem(Material.POTATO, Material.POTATOES, "§2Potato Age 0", 0);
        putItem(Material.POTATO, Material.POTATOES, "§2Potato Age 1", 1);
        putItem(Material.POTATO, Material.POTATOES, "§2Potato Age 2", 2);
        putItem(Material.POTATO, Material.POTATOES, "§2Potato Age 3", 3);
        putItem(Material.POTATO, Material.POTATOES, "§2Potato Age 4", 4);
        putItem(Material.POTATO, Material.POTATOES, "§2Potato Age 5", 5);
        putItem(Material.POTATO, Material.POTATOES, "§2Potato Age 6", 6);
        putItem(Material.POTATO, Material.POTATOES, "§2Potato Age 7", 7);
        putItem(Material.CARROT, Material.CARROTS, "§2Carrot Age 0", 0);
        putItem(Material.CARROT, Material.CARROTS, "§2Carrot Age 1", 1);
        putItem(Material.CARROT, Material.CARROTS, "§2Carrot Age 2", 2);
        putItem(Material.CARROT, Material.CARROTS, "§2Carrot Age 3", 3);
        putItem(Material.CARROT, Material.CARROTS, "§2Carrot Age 4", 4);
        putItem(Material.CARROT, Material.CARROTS, "§2Carrot Age 5", 5);
        putItem(Material.CARROT, Material.CARROTS, "§2Carrot Age 6", 6);
        putItem(Material.CARROT, Material.CARROTS, "§2Carrot Age 7", 7);
    }


    private void putItem(int mapIndex, Material material, Material blockMaterial, String name, Integer age) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);

        if(blockMaterial != null) {
            im.getPersistentDataContainer().set(new NamespacedKey(this.flowers, "customBlock"), PersistentDataType.STRING, blockMaterial.name());
        }
        if(age != null) {
            im.getPersistentDataContainer().set(new NamespacedKey(this.flowers, "customAge"), PersistentDataType.INTEGER, age);
        }

        item.setItemMeta(im);
        items.put(mapIndex, item);
    }

    private void putItem(int mapIndex, Material material, Material blockMaterial, String name) {
        putItem(mapIndex, material, blockMaterial, name, null);
    }

    private void putItem(int mapIndex, Material material, String name) {
        putItem(mapIndex, material, null, name, null);
    }

    private void putItem(Material material, Material blockMaterial, String name, Integer age) {
        int lastIndex = 0;
        for (Integer integer : this.items.keySet()) {
            if(integer > lastIndex)
                lastIndex = integer;
        }
        putItem(lastIndex + 1, material, blockMaterial, name, age);
    }

    private void putItem(Material material, Material blockMaterial, String name) {
        putItem(material, blockMaterial, name, null);
    }

    private void putItem(Material material, String name) {
        putItem(material, null, name, null);
    }


    public void mainGUI(CommandSender commandSender) {
        final Inventory inv = Bukkit.getServer().createInventory(null, 54, "§2craftFlowers");
        final Player player = (Player) commandSender;

        inv.setItem(31, HeadsList.heads.get("head_remove"));
        inv.setItem(32, HeadsList.heads.get("head_clear"));
        inv.setItem(28, this.glass_white);
        inv.setItem(29, this.glass_white);
        inv.setItem(33, this.glass_white);
        inv.setItem(34, this.glass_white);
        inv.setItem(27, HeadsList.heads.get("head_left"));
        inv.setItem(35, HeadsList.heads.get("head_right"));

        int headNumber;
        for (headNumber = 0; headNumber < 27; ++headNumber) {
            inv.setItem(headNumber, items.get(headNumber));
        }

        for (headNumber = 1; headNumber < 10; ++headNumber) {
            inv.setItem(headNumber + 44, HeadsList.heads.get("h" + headNumber));
        }

        final InventoryView inventoryView = player.openInventory(inv);
        if (inventoryView.getItem(36) == null || inventoryView.getItem(36).getType().equals(Material.AIR)) {
            inv.setItem(30, (ItemStack) HeadsList.heads.get("head_create"));
        } else {
            inv.setItem(30, (ItemStack) HeadsList.heads.get("head_edit"));
        }

    }
}
