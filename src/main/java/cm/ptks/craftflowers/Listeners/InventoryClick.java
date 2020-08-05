package cm.ptks.craftflowers.Listeners;

import cm.ptks.craftflowers.Util.GuiUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {
   @EventHandler
   public void inventoryClick(InventoryClickEvent e) {
      if (e.getInventory().getName().equals("§2craftFlowers")) {
         if (e.getClickedInventory() == null) {
            return;
         }

         if (!e.getClickedInventory().getName().equals("§2craftFlowers")) {
            return;
         }

         if (e.isShiftClick()) {
            e.setCancelled(true);
         } else if (!e.getCurrentItem().getType().equals(Material.AIR)) {
            if (!e.getClick().equals(ClickType.LEFT) && !e.getClick().equals(ClickType.RIGHT)) {
               e.setCancelled(true);
            } else {
               e.setCancelled(true);
               Player p = (Player)e.getWhoClicked();
               GuiUtils gu = new GuiUtils();
               switch(e.getSlot()) {
               case 0:
               case 1:
               case 2:
               case 3:
               case 4:
               case 5:
               case 6:
               case 7:
               case 8:
               case 9:
               case 10:
               case 11:
               case 12:
               case 13:
               case 14:
               case 15:
               case 16:
               case 17:
               case 18:
               case 19:
               case 20:
               case 21:
               case 22:
               case 23:
               case 24:
               case 25:
               case 26:
                  gu.add(e.getClickedInventory(), e.getCurrentItem().clone(), p);
                  break;
               case 27:
                  if (!e.getClickedInventory().getStorageContents()[0].getType().equals(Material.DOUBLE_PLANT)) {
                     gu.previous(e.getClickedInventory());
                  }
               case 28:
               case 29:
               case 33:
               case 34:
               default:
                  break;
               case 30:
                  if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Create flower")) {
                     gu.create(e.getClickedInventory(), p);
                  } else {
                     gu.update(e.getClickedInventory(), p);
                  }
                  break;
               case 31:
                  gu.remove(e.getClickedInventory(), p);
                  break;
               case 32:
                  gu.clear(e.getClickedInventory());
                  break;
               case 35:
                  if (!e.getClickedInventory().getStorageContents()[0].getType().equals(Material.SAPLING)) {
                     gu.next(e.getClickedInventory());
                  }
               }
            }
         }
      }

   }
}
