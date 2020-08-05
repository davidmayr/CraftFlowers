package cm.ptks.craftflowers.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class SwapHandListener implements Listener {
   @EventHandler
   public void onHandSwap(PlayerSwapHandItemsEvent e) {
      ItemStack hand = e.getOffHandItem();
      if (hand.getData().getItemType() == Material.FLOWER_POT_ITEM && hand.getItemMeta().getDisplayName().equals("§2craftFlowers")) {
         e.setCancelled(true);
      }

   }
}
