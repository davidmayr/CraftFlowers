package cm.ptks.craftflowers.util;

import cm.ptks.craftflowers.Main;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiGenerator {
   ItemStack glass_create = craftGlassButton((short)5, "§8Click to create a flower.");
   ItemStack glass_remove = craftGlassButton((short)1, "§8Click to remove flower from top.");
   ItemStack glass_clear = craftGlassButton((short)14, "§8Click to clear all.");
   ItemStack glass_white;
   static HashMap<Integer, ItemStack> items = new HashMap();

   static {
      putItem(0, Material.DOUBLE_PLANT, (short)0, "§2Sunflower");
      putItem(1, Material.DOUBLE_PLANT, (short)1, "§2Lilac");
      putItem(2, Material.DOUBLE_PLANT, (short)2, "§2Double Tallgrass");
      putItem(3, Material.DOUBLE_PLANT, (short)3, "§2Large Fern");
      putItem(4, Material.DOUBLE_PLANT, (short)4, "§2Rose Bush");
      putItem(5, Material.DOUBLE_PLANT, (short)5, "§2Peony");
      putItem(6, Material.SAPLING, (short)0, "§2Oak Sapling");
      putItem(7, Material.SAPLING, (short)1, "§2Spruce Sapling");
      putItem(8, Material.SAPLING, (short)2, "§2Birch Sapling");
      putItem(9, Material.SAPLING, (short)3, "§2Jungle Sapling");
      putItem(10, Material.SAPLING, (short)4, "§2Acacia Sapling");
      putItem(11, Material.SAPLING, (short)5, "§2Dark Oak Sapling");
      putItem(12, Material.LONG_GRASS, (short)0, "§2Shrub");
      putItem(13, Material.LONG_GRASS, (short)1, "§2Grass");
      putItem(14, Material.LONG_GRASS, (short)2, "§2Fern");
      putItem(15, Material.DEAD_BUSH, (short)0, "§2Dead Bush");
      putItem(16, Material.YELLOW_FLOWER, (short)0, "§2Dandelion");
      putItem(17, Material.RED_ROSE, (short)0, "§2Poppy");
      putItem(18, Material.RED_ROSE, (short)1, "§2Blue Orchid");
      putItem(19, Material.RED_ROSE, (short)2, "§2Allium");
      putItem(20, Material.RED_ROSE, (short)3, "§2Azure Bluet");
      putItem(21, Material.RED_ROSE, (short)4, "§2Red Tulip");
      putItem(22, Material.RED_ROSE, (short)5, "§2Orange Tulip");
      putItem(23, Material.RED_ROSE, (short)6, "§2White Tulip");
      putItem(24, Material.RED_ROSE, (short)7, "§2Pink Tulip");
      putItem(25, Material.RED_ROSE, (short)8, "§2Oxeye Daisy");
      putItem(26, Material.BROWN_MUSHROOM, (short)0, "§2Mushroom");
      putItem(27, Material.RED_MUSHROOM, (short)0, "§2Mushroom");
      putItem(28, Material.LEAVES, (short)0, "§2Oak Leaves");
      putItem(29, Material.LEAVES, (short)1, "§2Spruce Leaves");
      putItem(30, Material.LEAVES, (short)2, "§2Birch Leaves");
      putItem(31, Material.LEAVES, (short)3, "§2Jungle Leaves");
      putItem(32, Material.LEAVES_2, (short)0, "§2Acacia Leaves");
      putItem(33, Material.LEAVES_2, (short)1, "§2Dark Oak Leaves");
      putItem(34, Material.WATER_LILY, (short)0, "§2Lily Pad");
      putItem(35, Material.VINE, (short)15, "§2Vines");
      putItem(36, Material.CACTUS, (short)0, "§2Cactus");
      putItem(37, Material.MELON_BLOCK, (short)0, "§2Melon");
      putItem(38, Material.PUMPKIN, (short)0, "§2Pumpkin");
      putItem(39, Material.SUGAR_CANE, (short)0, "§2Sugar Canes");
   }

   public GuiGenerator() {
      this.glass_white = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
      ItemMeta im = this.glass_white.getItemMeta();
      im.setDisplayName(" ");
      this.glass_white.setItemMeta(im);
   }

   static ItemStack craftGlassButton(short durability, String description) {
      ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, durability);
      ItemMeta im = item.getItemMeta();
      im.setDisplayName(" ");
      ArrayList<String> lore = new ArrayList();
      lore.add(" ");
      lore.add(description);
      im.setLore(lore);
      item.setItemMeta(im);
      return item;
   }

   static void putItem(int mapIndex, Material material, short durability, String name) {
      ItemStack item = new ItemStack(material, 1, durability);
      ItemMeta im = item.getItemMeta();
      im.setDisplayName(name);
      item.setItemMeta(im);
      items.put(mapIndex, item);
   }

   public void mainGUI(CommandSender cs) {
      final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)null, 54, "§2craftFlowers");
      final Player p = (Player)cs;
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
         public void run() {
            if (p.getOpenInventory().getItem(36).getType().equals(Material.AIR)) {
               inv.setItem(30, (ItemStack)HeadsList.heads.get("head_create"));
            } else {
               inv.setItem(30, (ItemStack)HeadsList.heads.get("head_edit"));
            }

         }
      }, 1L);
      inv.setItem(31, (ItemStack)HeadsList.heads.get("head_remove"));
      inv.setItem(32, (ItemStack)HeadsList.heads.get("head_clear"));
      inv.setItem(28, this.glass_white);
      inv.setItem(29, this.glass_white);
      inv.setItem(33, this.glass_white);
      inv.setItem(34, this.glass_white);
      inv.setItem(27, (ItemStack)HeadsList.heads.get("head_left"));
      inv.setItem(35, (ItemStack)HeadsList.heads.get("head_right"));

      int headNumber;
      for(headNumber = 0; headNumber < 27; ++headNumber) {
         inv.setItem(headNumber, (ItemStack)items.get(headNumber));
      }

      for(headNumber = 1; headNumber < 10; ++headNumber) {
         inv.setItem(headNumber + 44, (ItemStack)HeadsList.heads.get("h" + headNumber));
      }

      ((HumanEntity)cs).openInventory(inv);
   }
}
