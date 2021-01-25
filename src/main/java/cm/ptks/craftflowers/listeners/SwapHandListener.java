package cm.ptks.craftflowers.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class SwapHandListener implements Listener {
    @EventHandler
    public void onHandSwap(PlayerSwapHandItemsEvent event) {
        ItemStack hand = event.getOffHandItem();
        if (hand != null && hand.getType() == Material.FLOWER_POT && hand.getItemMeta() != null &&
                hand.getItemMeta().hasDisplayName() && hand.getItemMeta().getDisplayName().equals("§2craftFlowers")) {
            event.setCancelled(true);
        }

    }
}
