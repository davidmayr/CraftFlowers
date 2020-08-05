package cm.ptks.craftflowers.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

public class GuiGenerator {
    static HashMap<Integer, ItemStack> items = new HashMap();

    static {
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
        putItem(12, Material.DEAD_BUSH, "§2Shrub");
        putItem(13, Material.GRASS, "§2Grass");
        putItem(14, Material.FERN, "§2Fern");
        putItem(15, Material.DEAD_BUSH, "§2Dead Bush");
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
    }

    ItemStack glass_create = craftGlassButton("§8Click to create a flower.");
    ItemStack glass_remove = craftGlassButton("§8Click to remove flower from top.");
    ItemStack glass_clear = craftGlassButton("§8Click to clear all.");
    ItemStack glass_white;

    public GuiGenerator() {
        this.glass_white = new ItemStack(Material.BLACK_STAINED_GLASS, 1, (short) 0);
        ItemMeta itemMeta = this.glass_white.getItemMeta();
        itemMeta.setDisplayName(" ");
        this.glass_white.setItemMeta(itemMeta);
    }

    static ItemStack craftGlassButton(String description) {
        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(" ");
        ArrayList<String> lore = new ArrayList();
        lore.add(" ");
        lore.add(description);
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        return item;
    }

    static void putItem(int mapIndex, Material material, String name) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);
        item.setItemMeta(im);
        items.put(mapIndex, item);
    }

    public void mainGUI(CommandSender commandSender) {
        final Inventory inv = Bukkit.getServer().createInventory(null, 54, "§2craftFlowers");
        final Player p = (Player) commandSender;

        inv.setItem(31, (ItemStack) HeadsList.heads.get("head_remove"));
        inv.setItem(32, (ItemStack) HeadsList.heads.get("head_clear"));
        inv.setItem(28, this.glass_white);
        inv.setItem(29, this.glass_white);
        inv.setItem(33, this.glass_white);
        inv.setItem(34, this.glass_white);
        inv.setItem(27, (ItemStack) HeadsList.heads.get("head_left"));
        inv.setItem(35, (ItemStack) HeadsList.heads.get("head_right"));

        int headNumber;
        for (headNumber = 0; headNumber < 27; ++headNumber) {
            inv.setItem(headNumber, items.get(headNumber));
        }

        for (headNumber = 1; headNumber < 10; ++headNumber) {
            inv.setItem(headNumber + 44, HeadsList.heads.get("h" + headNumber));
        }

        final InventoryView inventoryView = p.openInventory(inv);
        if (inventoryView.getItem(36) == null || inventoryView.getItem(36).getType().equals(Material.AIR)) {
            inv.setItem(30, (ItemStack) HeadsList.heads.get("head_create"));
        } else {
            inv.setItem(30, (ItemStack) HeadsList.heads.get("head_edit"));
        }

    }
}
