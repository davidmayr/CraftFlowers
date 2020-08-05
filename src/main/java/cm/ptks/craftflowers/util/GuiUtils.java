package cm.ptks.craftflowers.util;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiUtils {
   public void add(Inventory inv, ItemStack i, Player p) {
      for(int slot = 36; slot < 45; ++slot) {
         if (inv.getContents()[slot] == null) {
            inv.setItem(slot, i);
            return;
         }
      }

      p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Height 9 is maximum height of the flower.");
   }

   public void create(Inventory inv, Player p) {
      ItemStack pot = new ItemStack(Material.FLOWER_POT_ITEM, 1);
      ItemMeta im = pot.getItemMeta();
      im.setDisplayName("§2craftFlowers");
      ArrayList<String> lore = new ArrayList();

      for(int slot = 36; slot < 45; ++slot) {
         if (inv.getContents()[slot] != null) {
            ItemStack i = inv.getContents()[slot];
            if (i.getType().equals(Material.VINE)) {
               lore.add("§7" + i.getTypeId() + ":15");
            } else if (i.getType().equals(Material.SUGAR_CANE)) {
               lore.add("§783:0");
            } else {
               lore.add("§7" + i.getTypeId() + ":" + i.getData().getData());
            }
         }
      }

      im.setLore(lore);
      pot.setItemMeta(im);
      if (inv.getContents()[36] != null) {
         p.getInventory().addItem(new ItemStack[]{pot});
      }

   }

   public void update(Inventory inv, Player p) {
      ItemStack pot = new ItemStack(Material.FLOWER_POT_ITEM, 1);
      ItemMeta im = pot.getItemMeta();
      im.setDisplayName("§2craftFlowers");
      ArrayList<String> lore = new ArrayList();

      for(int slot = 36; slot < 45; ++slot) {
         if (inv.getContents()[slot] != null) {
            ItemStack i = inv.getContents()[slot];
            if (i.getType().equals(Material.VINE)) {
               lore.add("§7" + i.getTypeId() + ":15");
            }

            if (i.getType().equals(Material.SUGAR_CANE)) {
               lore.add("§783:0");
            } else {
               lore.add("§7" + i.getTypeId() + ":" + i.getData().getData());
            }
         }
      }

      im.setLore(lore);
      pot.setItemMeta(im);
      if (inv.getContents()[36] != null) {
         p.getInventory().setItemInHand(pot);
      }

   }

   public void remove(Inventory inv, Player p) {
      ItemStack air = new ItemStack(Material.AIR, 1);

      for(int slot = 44; slot > 35; --slot) {
         if (inv.getContents()[slot] != null) {
            inv.setItem(slot, air);
            return;
         }
      }

   }

   public void clear(Inventory i) {
      ItemStack air = new ItemStack(Material.AIR, 1);

      for(int slot = 36; slot < 45; ++slot) {
         i.setItem(slot, air);
      }

   }

   public void previous(Inventory i) {
      for(int slot = 0; slot < 27; ++slot) {
         i.setItem(slot, (ItemStack)GuiGenerator.items.get(slot));
      }

   }

   public void next(Inventory i) {
      ItemStack air = new ItemStack(Material.AIR, 1);
      i.setItem(0, (ItemStack)GuiGenerator.items.get(27));

      int slot;
      for(slot = 1; slot < 13; ++slot) {
         i.setItem(slot, (ItemStack)GuiGenerator.items.get(slot + 27));
      }

      for(slot = 13; slot < 27; ++slot) {
         i.setItem(slot, air);
      }

   }

   public void edit(InventoryView iV, ItemStack pot) {
      List<String> lore = pot.getItemMeta().getLore();
      if (pot.getItemMeta().hasLore() && lore.get(0) != null) {
         for(int i = 0; i < lore.size(); ++i) {
            String[] id = ((String)lore.get(i)).replace("§7", "").split(":");
            int _id = Integer.parseInt(id[0]);
            int _data = Integer.parseInt(id[1]);
            ItemStack item;
            int slot;
            if (_id == 83) {
               item = new ItemStack(Material.getMaterial(338), 1, (short)0);
               slot = i + 36;
               iV.setItem(slot, item);
            } else {
               item = new ItemStack(Material.getMaterial(_id), 1, (short)_data);
               slot = i + 36;
               iV.setItem(slot, item);
            }
         }
      }

   }
}
