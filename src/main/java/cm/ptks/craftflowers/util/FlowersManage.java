package cm.ptks.craftflowers.util;

import cm.ptks.craftflowers.CraftFlowers;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowersManage {
    File file;
    FileConfiguration fileConfiguration;

    public FlowersManage() {
        this.file = new File(CraftFlowers.plugin.getDataFolder(), "flowers.yml");

        this.fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
    }

    public void saveFlower(Player p, String name, JsonArray array) {
        String pn = p.getName();
        if (this.fileConfiguration.get("players." + pn) != null) {
            if (this.fileConfiguration.get("players." + pn + "." + name) != null) {
                p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Flower " + ChatColor.GOLD + name + ChatColor.RED + " already exists!");
                return;
            }
        }
        this.fileConfiguration.set("players." + pn + "." + name, array.toString());

        try {
            this.fileConfiguration.save(this.file);
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GREEN + "Flower " + ChatColor.GOLD + name + ChatColor.GREEN + " saved!");
        } catch (IOException var6) {
            var6.printStackTrace();
        }
    }

    public void loadFlower(Player player, String name) {
        String playerName = player.getName();
        if (this.fileConfiguration.get("players." + playerName + "." + name) != null) {
            if (player.getInventory().firstEmpty() == -1) {
                player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Inventory is full!");
            } else {

                String ids = this.fileConfiguration.getString("players." + playerName + "." + name);
                JsonArray array = new JsonParser().parse(ids).getAsJsonArray();


                ItemStack pot = new ItemStack(Material.FLOWER_POT, 1);
                ItemMeta im = pot.getItemMeta();
                im.setDisplayName("§2craftFlowers");
                ArrayList<String> lore = new ArrayList<>();

                for (JsonElement jsonElement : array) {
                    lore.add("§7" + jsonElement.getAsJsonObject().get("material"));
                }

                im.setLore(lore);
                im.getPersistentDataContainer().set(new NamespacedKey(CraftFlowers.plugin, "craftFlowersMeta"), PersistentDataType.STRING, array.toString());
                pot.setItemMeta(im);

                player.getInventory().addItem(pot);
                player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GREEN + "Flower " + ChatColor.GOLD + name + ChatColor.GREEN + " has been loaded.");
            }
        } else {
            player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Flower " + ChatColor.GOLD + name + ChatColor.RED + " does not exists!");
        }

    }

    public void deleteFlower(Player p, String name) {
        String pn = p.getName();
        if (this.fileConfiguration.get("players." + pn + "." + name) != null) {
            this.fileConfiguration.set("players." + pn + "." + name, null);

            try {
                this.fileConfiguration.save(this.file);
                p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GREEN + "Flower " + ChatColor.GOLD + name + ChatColor.GREEN + " deleted!");
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        } else {
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Flower " + ChatColor.GOLD + name + ChatColor.RED + " does not exists!");
        }

    }
}
