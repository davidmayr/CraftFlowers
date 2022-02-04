package cm.ptks.craftflowers.commands;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.flower.FlowerPot;
import cm.ptks.craftflowers.gui.CraftFlowersGui;
import cm.ptks.craftflowers.gui.SavedFlowerListGui;
import cm.ptks.craftflowers.storage.SavedFlowerPot;
import cm.ptks.craftflowers.util.version.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CraftFlowersCommand implements CommandExecutor, TabCompleter {

    private final CraftFlowers plugin;

    public CraftFlowersCommand(CraftFlowers plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;

        if (args.length == 0) {
            if (!player.hasPermission("craftflowers.use")) {
                player.sendMessage(CraftFlowers.prefix + "§cYou don't have permission!");
                return true;
            }
            CraftFlowersGui.openGui(player);
            return true;
        }


        if(args[0].equalsIgnoreCase("info") || args[0].equalsIgnoreCase("i")) {
            UpdateChecker versionChecker = plugin.getVersionChecker();
            if (versionChecker.isOutdated()) {
                player.sendMessage(CraftFlowers.prefix + "§7Version: §2" + ChatColor.RED + plugin.getDescription().getVersion());
            } else {
                player.sendMessage(CraftFlowers.prefix + "§7Version: §2" + ChatColor.GREEN + plugin.getDescription().getVersion());
            }

            player.sendMessage(CraftFlowers.prefix + "§7Author: §2" + plugin.getDescription().getAuthors().get(0));
            player.sendMessage(CraftFlowers.prefix + "§7Website: §2" + plugin.getDescription().getWebsite());
            return true;
        }

        if (args[0].equalsIgnoreCase("save") || args[0].equalsIgnoreCase("s")) {
            if (!player.hasPermission("craftflowers.save")) {
                player.sendMessage(CraftFlowers.prefix + ChatColor.RED + "You don't have permission!");
                return true;
            }

            if (args.length != 1 && args.length <= 2) {
                FlowerPot flowerPot = FlowerPot.parsePot(player.getInventory().getItemInMainHand());

                if (player.getInventory().getItemInMainHand().getType().equals(Material.FLOWER_POT) && flowerPot != null) {
                    String name = args[1].replaceAll("[^A-Za-z0-9]", "");

                    plugin.getExecutorService().submit(() -> {
                        plugin.getFlowerStorage().saveFlower(name, player.getUniqueId(), flowerPot);
                        player.sendMessage(CraftFlowers.prefix + "§7Successfully saved flowerpot.");
                    });
                } else {
                    player.sendMessage(CraftFlowers.prefix + ChatColor.RED + "You must hold a craftflowers flowerpot.");
                }
                return true;
            }

            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers save <name>");
            return true;
        }

        if (args[0].equalsIgnoreCase("load") || args[0].equalsIgnoreCase("l")) {
            if (!player.hasPermission("craftflowers.load")) {
                player.sendMessage(CraftFlowers.prefix + ChatColor.RED + "You don't have permission!");
                return true;
            }

            if (args.length != 1 && args.length <= 2) {
                plugin.getExecutorService().submit(() -> {
                    SavedFlowerPot flower = plugin.getFlowerStorage().getFlower(args[1], player.getUniqueId());
                    if(flower == null) {
                        player.sendMessage(CraftFlowers.prefix + "§cFlower not found.");
                        return;
                    }
                    plugin.getServer().getScheduler().runTask(plugin, () -> {
                        player.getInventory().addItem(flower.getFlowerPot().createItemStack());
                        player.sendMessage(CraftFlowers.prefix + "§7The Flower " + args[1] + " has been successfully loaded!");
                    });
                });
                return true;
            }

            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers load <name>");
            return true;
        }

        if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("d")) {
            if (!player.hasPermission("craftflowers.delete")) {
                player.sendMessage(CraftFlowers.prefix + ChatColor.RED + "You don't have permission!");
                return true;
            }

            if (args.length != 1 && args.length <= 2) {
                plugin.getExecutorService().submit(() -> {
                    if(!plugin.getFlowerStorage().deleteFlower(args[1], player.getUniqueId())) {
                        player.sendMessage(CraftFlowers.prefix + "§cThe Flower " + args[1] + " could not be deleted!");
                        return;
                    }
                    player.sendMessage(CraftFlowers.prefix + "§7The Flower " + args[1] + " has been successfully deleted!");
                });
                return true;
            }

            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers delete <name>");
            return true;
        }

        if (args[0].equalsIgnoreCase("list")) {
            if (!player.hasPermission("craftflowers.use")) {
                player.sendMessage(CraftFlowers.prefix + "§cYou don't have permission!");
                return true;
            }
            plugin.getExecutorService().submit(() -> {
                List<SavedFlowerPot> savedFlowers = plugin.getFlowerStorage().getSavedFlowers(player.getUniqueId());
                if(savedFlowers.size() == 0) {
                    player.sendMessage(CraftFlowers.prefix + "§cYou don't have any saved flowers.");
                    return;
                }
                plugin.getServer().getScheduler().runTask(plugin, () -> SavedFlowerListGui.openGui(player, savedFlowers));
            });
            return true;
        }





        if (!args[0].equalsIgnoreCase("help") && !args[0].equalsIgnoreCase("h")) {
            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers help §8- §7For help");
        } else {
            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers §8- §7Opens GUI");
            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers save <name> §8- §7Saves the currently held flower");
            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers load <name> §8- §7Loads a saved flower");
            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers delete <name> §8- §7Removes the saved flower");
            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers info §8- §7Shows info about the plugin");
            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers list §8- §7Opens a saved flower list gui");
            player.sendMessage(CraftFlowers.prefix + ChatColor.GREEN + "/craftflowers help §8- §7Shows this text");
        }

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(args.length > 1)
            return null;
        return Stream.of("help", "info", "list", "load", "delete", "save").filter(s -> s.startsWith(args[0])).collect(Collectors.toList());
    }
}
