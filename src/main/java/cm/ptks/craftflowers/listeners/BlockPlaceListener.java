package cm.ptks.craftflowers.listeners;


import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.flower.AgingFlower;
import cm.ptks.craftflowers.flower.Flower;
import cm.ptks.craftflowers.flower.FlowerPot;
import cm.ptks.craftflowers.languages.I18n;
import cm.ptks.craftflowers.languages.Messages;
import com.fastasyncworldedit.core.FaweAPI;
import com.fastasyncworldedit.core.util.TaskManager;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.registry.state.Property;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockType;
import com.sk89q.worldedit.world.block.BlockTypes;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class BlockPlaceListener implements Listener {

    private final CraftFlowers plugin;

    public BlockPlaceListener(CraftFlowers plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.LOW,
            ignoreCancelled = true
    )
    public void placeOfBlock(final BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (!event.getItemInHand().getType().equals(Material.FLOWER_POT))
            return;
        FlowerPot flowerPot = FlowerPot.parsePot(event.getItemInHand());
        if (flowerPot == null)
            return;
        event.setCancelled(true);
        if (!player.hasPermission("craftflowers.place")) {
            player.sendMessage(CraftFlowers.prefix + I18n.translate(player, Messages.ACTION.NO_PERMISSION_PLACE));
            return;
        }

        if (plugin.isSurvivalMode() && player.getGameMode() == GameMode.SURVIVAL) {
            List<Flower> requiredFlowers = new ArrayList<>();
            Location currentLocation = event.getBlockPlaced().getLocation().clone();
            for (Flower flower : flowerPot.getFlowers()) {
                if (!currentLocation.equals(event.getBlockPlaced().getLocation())
                        && (!currentLocation.getBlock().getType().equals(Material.AIR)
                        && !currentLocation.getBlock().getType().equals(Material.WATER)))
                    continue;
                requiredFlowers.add(flower);
                currentLocation.add(0.0D, 1.0D, 0.0D);
            }
            Map<String, Integer> missingFlowerMap = new LinkedHashMap<>();
            for (Flower flower : requiredFlowers) {
                if (player.getInventory().contains(flower.getMaterial()))
                    continue;
                Integer integer = missingFlowerMap.getOrDefault(flower.getDisplayName(player), 0) + 1;
                missingFlowerMap.put(flower.getDisplayName(player), integer);
            }
            if (!missingFlowerMap.isEmpty()) {
                player.sendMessage(CraftFlowers.prefix + I18n.translate(player, Messages.ACTION.MISSING_FOLLOWING_ITEMS));
                missingFlowerMap.forEach((flower, integer) -> player.sendMessage(Messages.getActionMissingFollowingItemsList(player, CraftFlowers.arrow, flower, integer)));
                return;
            }

            for (Flower requiredFlower : requiredFlowers) {
                removeOne(requiredFlower.getMaterial(), player);
            }
        }

        TaskManager.taskManager().async(() -> {
            World world = FaweAPI.getWorld(player.getWorld().getName());
            final BukkitPlayer bukkitPlayer = BukkitAdapter.adapt(player);
            final EditSession editSession = WorldEdit.getInstance().newEditSessionBuilder()
                    .world(world)
                    .actor(bukkitPlayer).build();

            bukkitPlayer.queueAction(() -> {
                Location currentLocation = event.getBlockPlaced().getLocation();

                for (Flower flower : flowerPot.getFlowers()) {
                    if (!currentLocation.equals(event.getBlockPlaced().getLocation())
                            && (!currentLocation.getBlock().getType().equals(Material.AIR)
                            && !currentLocation.getBlock().getType().equals(Material.WATER)))
                        continue;
                    BlockType blockType = BlockTypes.parse(flower.getBlockMaterial().name());
                    BaseBlock block = new BaseBlock(Objects.requireNonNull(blockType).getDefaultState());

                    Property<Boolean> prop = block.getBlockType().getProperty("waterlogged");
                    if (prop != null) {
                        block = block.with(prop, false);
                    }

                    if (flower instanceof AgingFlower) {
                        Property<Integer> ageProp = block.getBlockType().getProperty("age");
                        block = block.with(ageProp, ((AgingFlower) flower).getAge());
                    }

                    editSession.setBlock(currentLocation.getBlockX(), currentLocation.getBlockY(), currentLocation.getBlockZ(), block);

                    currentLocation.add(0.0D, 1.0D, 0.0D);
                }

                editSession.flushQueue();
                bukkitPlayer.getSession().remember(editSession);
            });
        });
    }

    private static void removeOne(Material material, Player player) {
        ItemStack[] contents = player.getInventory().getStorageContents();

        for (ItemStack item : contents) {
            if (item != null && item.getType() == material) {
                item.setAmount(item.getAmount() - 1);
                return;
            }
        }
    }


}
