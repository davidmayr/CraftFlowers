package cm.ptks.craftflowers.listeners;

import cm.ptks.craftflowers.CraftFlowers;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayerJoinListener implements Listener {

    private final CraftFlowers flowers;
    private final ExecutorService updateService = Executors.newSingleThreadExecutor();

    public PlayerJoinListener(CraftFlowers flowers) {
        this.flowers = flowers;
    }

    @EventHandler
    public void joinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("craftflowers.admin"))
            return;

        updateService.submit(() -> {
            if (!flowers.getVersionChecker().isOutdated())
                return;
            player.sendMessage(ChatColor.DARK_RED + "------------------[craftFlowers]------------------");
            player.sendMessage(ChatColor.RED + "    Plugin is outdated!");
            player.sendMessage(ChatColor.DARK_RED + "    Current version: " + ChatColor.RED + CraftFlowers.plugin.getDescription().getVersion() + ChatColor.DARK_GREEN + " The newest version: " + ChatColor.GREEN + flowers.getVersionChecker().getNewestVersion());
            player.sendMessage(ChatColor.GOLD + "Download new version: " + ChatColor.YELLOW + "https://www.spigotmc.org/resources/craftflowers-1-16-port-allowed-by-main-developer.82407/");
            player.sendMessage(ChatColor.DARK_RED + "--------------------------------------------------");
        });
    }
}
