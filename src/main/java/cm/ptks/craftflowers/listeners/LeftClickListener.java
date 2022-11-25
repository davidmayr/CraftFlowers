package cm.ptks.craftflowers.listeners;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.flower.FlowerPot;
import cm.ptks.craftflowers.gui.CraftFlowersGui;
import cm.ptks.craftflowers.languages.I18n;
import cm.ptks.craftflowers.languages.Messages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;

public class LeftClickListener implements Listener {

    @EventHandler(
            priority = EventPriority.MONITOR
    )
    public void leftClick(PlayerInteractEvent event) {
        //The player could have our menu open. This causes some issues with the drop function
        if (event.getPlayer().getOpenInventory().getTopInventory().getType() == InventoryType.CHEST)
            return;
        if (!event.getAction().equals(Action.LEFT_CLICK_AIR) && !event.getAction().equals(Action.LEFT_CLICK_BLOCK))
            return;
        Player player = event.getPlayer();
        if (event.getItem() == null || !event.getItem().getType().equals(Material.FLOWER_POT))
            return;
        FlowerPot flowerPot = FlowerPot.parsePot(event.getItem());
        if (flowerPot == null)
            return;
        event.setCancelled(true);
        if (!player.hasPermission("craftflowers.edit")) {
            player.sendMessage(CraftFlowers.prefix + I18n.translate(player, Messages.ACTION.NO_PERMISSION_EDIT));
            return;
        }
        CraftFlowersGui.openGui(player, flowerPot);
    }

}
