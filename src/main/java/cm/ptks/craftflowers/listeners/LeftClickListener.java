package cm.ptks.craftflowers.listeners;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.util.GuiGenerator;
import cm.ptks.craftflowers.util.GuiUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LeftClickListener implements Listener {

    @EventHandler(
            priority = EventPriority.MONITOR
    )
    public void leftClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if ((event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) && player.getItemInHand().getType().equals(Material.FLOWER_POT) && player.getItemInHand().getItemMeta().getDisplayName().equals("§2craftFlowers")) {
            if (!player.hasPermission("craftflowers.edit")) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
            } else {
                event.setCancelled(true);
                GuiUtils guiUtils = GuiUtils.create(player);
                GuiGenerator guiGenerator = CraftFlowers.plugin.getGenerator();
                ItemStack potItemStack = player.getInventory().getItemInMainHand();
                guiGenerator.mainGUI(player);
                guiUtils.edit(player.getOpenInventory(), potItemStack);
            }
        }

    }
}
