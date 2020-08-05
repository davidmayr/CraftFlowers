package cm.ptks.craftflowers.listeners;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.util.CheckVersion;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void joinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("craftflowers.admin")) {
            CheckVersion cv = new CheckVersion();
            if (!cv.isOutdated())
                return;
            player.sendMessage(ChatColor.DARK_RED + "------------------[craftFlowers]------------------");
            player.sendMessage(ChatColor.RED + "    Plugin is outdated!");
            player.sendMessage(ChatColor.DARK_RED + "    Current version: " + ChatColor.RED + CraftFlowers.plugin.getDescription().getVersion() + ChatColor.DARK_GREEN + " The newest version: " + ChatColor.GREEN + cv.getNewestVersion());
            player.sendMessage(ChatColor.GOLD + "Download new version: " + ChatColor.YELLOW + "https://www.spigotmc.org/resources/craftflowers.49451/");
            player.sendMessage(ChatColor.DARK_RED + "--------------------------------------------------");
        }

    }
}
