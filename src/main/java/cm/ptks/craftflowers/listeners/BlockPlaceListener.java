package cm.ptks.craftflowers.listeners;


import cm.ptks.craftflowers.CraftFlowers;
import com.fastasyncworldedit.core.FaweAPI;
import com.fastasyncworldedit.core.util.TaskManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.registry.state.Property;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockType;
import com.sk89q.worldedit.world.block.BlockTypes;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Objects;

public class BlockPlaceListener implements Listener {
    @EventHandler(
            priority = EventPriority.LOW
    )
    public void placeOfBlock(final BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (event.getBlock().getType().equals(Material.FLOWER_POT) && player.getInventory().getItemInMainHand().getType().equals(Material.FLOWER_POT)
                && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§2craftFlowers")) {
            if (!player.hasPermission("craftflowers.place")) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
            } else if (event.isCancelled()) {
                player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
            } else {
                event.setCancelled(true);
                ItemStack pot = player.getInventory().getItemInMainHand();
                final List<String> lore = pot.getItemMeta().getLore();

                String craftFlowersMeta = pot.getItemMeta().getPersistentDataContainer()
                        .get(new NamespacedKey(CraftFlowers.plugin, "craftFlowersMeta"), PersistentDataType.STRING);
                if(craftFlowersMeta == null) {
                    player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You seem to have a flowerpot from an older version. These can not be converted.");
                    return;
                }
                JsonArray jsonArray = new JsonParser().parse(craftFlowersMeta).getAsJsonArray();
                if(jsonArray.size() <= 0)
                    return;

                TaskManager.IMP.async(() -> {
                    World world = FaweAPI.getWorld(player.getWorld().getName());
                    final BukkitPlayer bukkitPlayer = BukkitAdapter.adapt(player);
                    final EditSession editSession = WorldEdit.getInstance().newEditSessionBuilder()
                            .world(world)
                            .actor(bukkitPlayer).build();

                    bukkitPlayer.queueAction(() -> {
                        Location loc1 = event.getBlockPlaced().getLocation();

                        for (int i = 0; i < jsonArray.size(); ++i) {
                            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                            Material material = Material.getMaterial(jsonObject.has("blockMaterial")
                                    ? jsonObject.get("blockMaterial").getAsString() : jsonObject.get("material").getAsString());

                            if (material != null && loc1.getBlock().getType().equals(Material.AIR)) {
                                try {

                                    BlockType blockType = BlockTypes.parse(material.name());
                                    BaseBlock block = new BaseBlock(Objects.requireNonNull(blockType).getDefaultState());

                                    Property<Boolean> prop = block.getBlockType().getProperty("waterlogged");
                                    if (prop != null) {
                                        block = block.with(prop, false);
                                    }

                                    if(jsonObject.has("age")) {
                                        Property<Integer> ageProp = block.getBlockType().getProperty("age");
                                        if (ageProp != null) {
                                            try {
                                                block = block.with(ageProp, jsonObject.get("age").getAsInt());
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }

                                    editSession.setBlock(loc1.getBlockX(), loc1.getBlockY(), loc1.getBlockZ(), block);



                                } catch (Exception ignored) {
                                }
                            }

                            loc1.add(0.0D, 1.0D, 0.0D);
                        }

                        editSession.flushQueue();
                        bukkitPlayer.getSession().remember(editSession);
                    });
                });
            }
        }

    }
}
