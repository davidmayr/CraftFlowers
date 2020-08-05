package cm.ptks.craftflowers.util;

import cm.ptks.craftflowers.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FlowersManage {
   File f;
   FileConfiguration fc;

   public FlowersManage() {
      this.f = new File(Main.plugin.getDataFolder(), "flowers.yml");
      this.fc = YamlConfiguration.loadConfiguration(this.f);
   }

   public void saveFlower(Player p, String name, String id) {
      String pn = p.getName();
      if (this.fc.get("players." + pn) != null) {
         if (this.fc.get("players." + pn + "." + name) == null) {
            this.fc.set("players." + pn + "." + name, id);

            try {
               this.fc.save(this.f);
               p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GREEN + "Flower " + ChatColor.GOLD + name + ChatColor.GREEN + " saved!");
            } catch (IOException var7) {
               var7.printStackTrace();
            }
         } else {
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Flower " + ChatColor.GOLD + name + ChatColor.RED + " already exists!");
         }
      } else {
         this.fc.set("players." + pn + "." + name, id);

         try {
            this.fc.save(this.f);
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GREEN + "Flower " + ChatColor.GOLD + name + ChatColor.GREEN + " saved!");
         } catch (IOException var6) {
            var6.printStackTrace();
         }
      }

   }

   public void loadFlower(Player p, String name) {
      String pn = p.getName();
      if (this.fc.get("players." + pn + "." + name) != null) {
         if (p.getInventory().firstEmpty() == -1) {
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Inventory is full!");
         } else {
            String ids = this.fc.get("players." + pn + "." + name).toString().replace("[", "§7").replace(", ", ", §7").replace("]", "").replace("[", "");
            List<String> lore = new ArrayList(Arrays.asList(ids.split(", ")));
            ItemStack pot = new ItemStack(Material.FLOWER_POT_ITEM, 1);
            ItemMeta im = pot.getItemMeta();
            im.setDisplayName("§2craftFlowers");
            im.setLore(lore);
            pot.setItemMeta(im);
            p.getInventory().addItem(new ItemStack[]{pot});
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GREEN + "Flower " + ChatColor.GOLD + name + ChatColor.GREEN + " has been loaded.");
         }
      } else {
         p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Flower " + ChatColor.GOLD + name + ChatColor.RED + " does not exists!");
      }

   }

   public void deleteFlower(Player p, String name) {
      String pn = p.getName();
      if (this.fc.get("players." + pn + "." + name) != null) {
         this.fc.set("players." + pn + "." + name, (Object)null);

         try {
            this.fc.save(this.f);
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GREEN + "Flower " + ChatColor.GOLD + name + ChatColor.GREEN + " deleted!");
         } catch (IOException var5) {
            var5.printStackTrace();
         }
      } else {
         p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Flower " + ChatColor.GOLD + name + ChatColor.RED + " does not exists!");
      }

   }
}
