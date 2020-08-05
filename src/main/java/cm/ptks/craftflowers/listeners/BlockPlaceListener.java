package cm.ptks.craftflowers.listeners;

import com.boydti.fawe.object.FawePlayer;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.blocks.BaseBlock;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class BlockPlaceListener implements Listener {
   @EventHandler(
      priority = EventPriority.LOW
   )
   public void placeOfBlock(final BlockPlaceEvent e) {
      Player p = e.getPlayer();
      if (e.getBlock().getType().equals(Material.FLOWER_POT) && p.getItemInHand().getType().equals(Material.FLOWER_POT_ITEM) && p.getItemInHand().getItemMeta().getDisplayName().equals("§2craftFlowers")) {
         if (!p.hasPermission("craftflowers.place")) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
         } else if (e.isCancelled()) {
            p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
         } else {
            e.setCancelled(true);
            ItemStack pot = p.getItemInHand();
            final List<String> lore = pot.getItemMeta().getLore();
            if (pot.getItemMeta().hasLore() && lore.get(0) != null) {
               final FawePlayer<Object> fp = FawePlayer.wrap(p);
               final EditSession editSession = fp.getNewEditSession();
               fp.queueAction(new Runnable() {
                  public void run() {
                     String[] id = ((String)lore.get(0)).replace("§7", "").split(":");
                     int _id = Integer.parseInt(id[0]);
                     int _data = Integer.parseInt(id[1]);
                     Location loc1 = e.getBlockPlaced().getLocation();

                     try {
                        editSession.setBlock(loc1.getBlockX(), loc1.getBlockY(), loc1.getBlockZ(), new BaseBlock(_id, _data));
                     } catch (Exception var9) {
                     }

                     Location loc2 = e.getBlockPlaced().getLocation().add(0.0D, 1.0D, 0.0D);

                     for(int i = 1; i < lore.size(); ++i) {
                        id = ((String)lore.get(i)).replace("§7", "").split(":");
                        _id = Integer.parseInt(id[0]);
                        _data = Integer.parseInt(id[1]);
                        if (loc2.getBlock().getType().equals(Material.AIR)) {
                           try {
                              editSession.setBlock(loc2.getBlockX(), loc2.getBlockY(), loc2.getBlockZ(), new BaseBlock(_id, _data));
                           } catch (Exception var8) {
                           }
                        }

                        loc2.add(0.0D, 1.0D, 0.0D);
                     }

                     editSession.flushQueue();
                     fp.getSession().remember(editSession);
                  }
               });
            }
         }
      }

   }
}
