package cm.ptks.craftflowers.listeners;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.languages.Messages;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final CraftFlowers plugin;

    private static final String DOWNLOAD_LINK = "https://www.spigotmc.org/resources/82407";

    public PlayerJoinListener(CraftFlowers flowers) {
        this.plugin = flowers;
    }

    @EventHandler
    public void joinPlayer(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("craftflowers.admin"))
            return;

        if (!plugin.getVersionChecker().isOutdated())
            return;
        player.sendMessage("§a");
        player.sendMessage(CraftFlowers.prefix + Messages.ACTION.OUTDATE_VERSION);
        player.sendMessage(CraftFlowers.prefix + Messages.getActionCurrentVersion(plugin.getDescription().getVersion()));
        player.sendMessage(CraftFlowers.prefix + Messages.getActionNewestVersion(String.valueOf(plugin.getVersionChecker().getNewestVersion())));
        player.sendMessage(CraftFlowers.prefix + Messages.getActionDownloadNewVersion(DOWNLOAD_LINK));
        player.sendMessage("§a");
    }
}
