package cm.ptks.craftflowers.listeners;

import cm.ptks.craftflowers.util.GuiUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void inventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("§2craftFlowers")) {
            if (event.getClickedInventory() == null) {
                return;
            }

            if (event.getCurrentItem() == null)
                return;

            if (event.isShiftClick()) {
                event.setCancelled(true);
            } else if (!event.getCurrentItem().getType().equals(Material.AIR)) {
                if (!event.getClick().equals(ClickType.LEFT) && !event.getClick().equals(ClickType.RIGHT)) {
                    event.setCancelled(true);
                } else {
                    event.setCancelled(true);
                    Player player = (Player) event.getWhoClicked();
                    GuiUtils gu = new GuiUtils();
                    switch (event.getSlot()) {
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
                            gu.add(event.getClickedInventory(), event.getCurrentItem().clone(), player);
                            break;
                        case 27:
                            if (!event.getClickedInventory().getStorageContents()[0].getType().equals(Material.LEGACY_DOUBLE_PLANT)) {
                                gu.previous(event.getClickedInventory());
                            }
                        case 28:
                        case 29:
                        case 33:
                        case 34:
                        default:
                            break;
                        case 30:
                            if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Create flower")) {
                                gu.create(event.getClickedInventory(), player);
                            } else {
                                gu.update(event.getClickedInventory(), player);
                            }
                            break;
                        case 31:
                            gu.remove(event.getClickedInventory(), player);
                            break;
                        case 32:
                            gu.clear(event.getClickedInventory());
                            break;
                        case 35:
                            if (!event.getClickedInventory().getStorageContents()[0].getType().equals(Material.OAK_SAPLING)) {
                                gu.next(event.getClickedInventory());
                            }
                    }
                }
            }
        }

    }
}
