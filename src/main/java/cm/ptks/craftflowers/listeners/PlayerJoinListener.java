package cm.ptks.craftflowers.listeners;

import cm.ptks.craftflowers.Main;
import cm.ptks.craftflowers.util.CheckVersion;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
   @EventHandler
   public void joinPlayer(PlayerJoinEvent e) {
      Player p = e.getPlayer();
      CheckVersion cv = new CheckVersion();
      if (cv.isOutdated() && p.hasPermission("craftflowers.admin")) {
         p.sendMessage(ChatColor.DARK_RED + "------------------[craftFlowers]------------------");
         p.sendMessage(ChatColor.RED + "    Plugin is outdated!");
         p.sendMessage(ChatColor.DARK_RED + "    Current version: " + ChatColor.RED + Main.plugin.getDescription().getVersion() + ChatColor.DARK_GREEN + " The newest version: " + ChatColor.GREEN + cv.getNewestVersion());
         p.sendMessage(ChatColor.GOLD + "Download new version: " + ChatColor.YELLOW + "https://www.spigotmc.org/resources/craftflowers.49451/");
         p.sendMessage(ChatColor.DARK_RED + "--------------------------------------------------");
      }

   }
}
