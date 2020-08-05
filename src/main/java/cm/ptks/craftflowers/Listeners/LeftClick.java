package cm.ptks.craftflowers.Listeners;

import cm.ptks.craftflowers.Util.GuiGenerator;
import cm.ptks.craftflowers.Util.GuiUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LeftClick implements Listener {
   @EventHandler(
      priority = EventPriority.MONITOR
   )
   public void leftClick(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      if ((e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) && p.getItemInHand().getType().equals(Material.FLOWER_POT_ITEM) && p.getItemInHand().getItemMeta().getDisplayName().equals("§2craftFlowers")) {
         if (!p.hasPermission("craftflowers.edit")) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
         } else {
            e.setCancelled(true);
            GuiUtils gu = new GuiUtils();
            GuiGenerator gui = new GuiGenerator();
            ItemStack pot = p.getItemInHand();
            gui.mainGUI(p);
            gu.edit(p.getOpenInventory(), pot);
         }
      }

   }
}
