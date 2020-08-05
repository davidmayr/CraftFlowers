package cm.ptks.craftflowers;

import cm.ptks.craftflowers.Commands.Cmd;
import cm.ptks.craftflowers.Listeners.BlockPlace;
import cm.ptks.craftflowers.Listeners.InventoryClick;
import cm.ptks.craftflowers.Listeners.LeftClick;
import cm.ptks.craftflowers.Listeners.PlayerJoin;
import cm.ptks.craftflowers.Listeners.SwapHand;
import cm.ptks.craftflowers.Util.CheckVersion;
import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
   public static Main plugin;

   public void onEnable() {
      plugin = this;
      if (this.isFAWE()) {
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "------------------[craftFlowers]------------------");
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    FastAsyncWorldEdit was found");
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "    craftFlowers v" + this.getDescription().getVersion() + " has been enabled.");
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "--------------------------------------------------");
         new MetricsLite(this);
         this.regListeners();
         this.regCommands();
         this.checkYmls();
         CheckVersion cv = new CheckVersion();
         if (cv.isOutdated()) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "------------------[craftFlowers]------------------");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "    Plugin is outdated!");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "    Current version: " + ChatColor.RED + this.getDescription().getVersion() + ChatColor.DARK_GREEN + " The newest version: " + ChatColor.GREEN + cv.getNewestVersion());
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Download new version: " + ChatColor.YELLOW + "https://www.spigotmc.org/resources/craftflowers.49451/");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "--------------------------------------------------");
         }
      } else {
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "------------------[craftFlowers]------------------");
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "    FastAsyncWorldEdit not found");
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "    craftFlowers has been disabled.");
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Download FAWE: " + ChatColor.YELLOW + "https://goo.gl/sVxZrg");
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "--------------------------------------------------");
         Bukkit.getServer().getPluginManager().disablePlugin(this);
      }

   }

   private void regListeners() {
      Bukkit.getServer().getPluginManager().registerEvents(new BlockPlace(), this);
      Bukkit.getServer().getPluginManager().registerEvents(new LeftClick(), this);
      Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
      Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
      Bukkit.getServer().getPluginManager().registerEvents(new SwapHand(), this);
   }

   private void regCommands() {
      this.getCommand("craftflowers").setExecutor(new Cmd());
   }

   public void checkYmls() {
      if (!this.getDataFolder().exists()) {
         this.getDataFolder().mkdir();
      }

      if (!(new File(this.getDataFolder(), "flowers.yml")).exists()) {
         try {
            (new File(this.getDataFolder(), "flowers.yml")).createNewFile();
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "------------------[craftFlowers]------------------");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "    flowers.yml not found");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    File has been created");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "--------------------------------------------------");
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   public boolean isFAWE() {
      return Bukkit.getServer().getPluginManager().getPlugin("FastAsyncWorldEdit") != null;
   }
}
