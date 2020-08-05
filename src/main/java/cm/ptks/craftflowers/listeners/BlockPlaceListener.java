package cm.ptks.craftflowers.listeners;


import com.boydti.fawe.FaweAPI;
import com.boydti.fawe.util.EditSessionBuilder;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockTypes;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Objects;

public class BlockPlaceListener implements Listener {
    @EventHandler(
            priority = EventPriority.LOW
    )
    public void placeOfBlock(final BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getBlock().getType().equals(Material.FLOWER_POT) && p.getItemInHand().getType().equals(Material.FLOWER_POT) && p.getItemInHand().getItemMeta().getDisplayName().equals("§2craftFlowers")) {
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
                    World world = FaweAPI.getWorld(p.getWorld().getName());
                    final BukkitPlayer bukkitPlayer = BukkitAdapter.adapt(p);

                    final EditSession editSession = new EditSessionBuilder(world).player(bukkitPlayer).build();

                    bukkitPlayer.queueAction(new Runnable() {
                        public void run() {
                            String id = ((String) lore.get(0)).replace("§7", "");

                            Material material = Material.getMaterial(id);
                            Location loc1 = e.getBlockPlaced().getLocation();

                            try {
                                editSession.setBlock(loc1.getBlockX(), loc1.getBlockY(), loc1.getBlockZ(), new BaseBlock(Objects.requireNonNull(BlockTypes.parse(material.name()).getDefaultState())));
                            } catch (Exception var9) {
                            }

                            Location loc2 = e.getBlockPlaced().getLocation().add(0.0D, 1.0D, 0.0D);

                            for (int i = 1; i < lore.size(); ++i) {
                                id = ((String) lore.get(i)).replace("§7", "");
                                material = Material.getMaterial(id);

                                if (loc2.getBlock().getType().equals(Material.AIR)) {
                                    try {
                                        editSession.setBlock(loc2.getBlockX(), loc2.getBlockY(), loc2.getBlockZ(), new BaseBlock(Objects.requireNonNull(BlockTypes.parse(material.name()).getDefaultState())));
                                    } catch (Exception var8) {
                                    }
                                }

                                loc2.add(0.0D, 1.0D, 0.0D);
                            }

                            editSession.flushQueue();
                            bukkitPlayer.getSession().remember(editSession);
                        }
                    });
                }
            }
        }

    }
}
