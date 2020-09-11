package cm.ptks.craftflowers.commands;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.util.CheckVersion;
import cm.ptks.craftflowers.util.FlowersManage;
import cm.ptks.craftflowers.util.GuiGenerator;
import cm.ptks.craftflowers.util.GuiUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CraftFlowersCommand implements CommandExecutor {
    ItemStack pot;

    public CraftFlowersCommand() {
        this.pot = new ItemStack(Material.FLOWER_POT, 1);
        ItemMeta im = this.pot.getItemMeta();
        im.setDisplayName("§2craftFlowers");
        this.pot.setItemMeta(im);
    }

    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        Player player = (Player) commandSender;
        if (cmd.getName().equalsIgnoreCase("craftflowers")) {
            if (args.length == 0) {
                if (!(commandSender instanceof Player)) {
                    return false;
                }

                if (!player.hasPermission("craftflowers.use")) {
                    player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
                    return true;
                }

                GuiGenerator gui = new GuiGenerator();
                gui.mainGUI(commandSender);
                GuiUtils.create(player);
            } else {
                FlowersManage flowersManage = new FlowersManage();
                if (!args[0].equalsIgnoreCase("info") && !args[0].equalsIgnoreCase("i")) {
                    if (args[0].equalsIgnoreCase("save") || args[0].equalsIgnoreCase("s")) {
                        if (!player.hasPermission("craftflowers.save")) {
                            player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
                            return true;
                        } else if (args.length != 1 && args.length <= 2) {
                            if (player.getItemInHand().getType().equals(Material.FLOWER_POT) && player.getItemInHand().getItemMeta().getDisplayName().equals("§2craftFlowers")) {
                                List<String> ids = player.getItemInHand().getItemMeta().getLore();
                                String name = args[1].replaceAll("[^A-Za-z0-9]", "");
                                String id = ids.toString().replace("§7", "");
                                flowersManage.saveFlower(player, name, id);
                                return true;
                            } else {
                                player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You must held the pot.");
                                return true;
                            }
                        } else {
                            player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GOLD + "/craftflowers save <name>");
                            return true;
                        }
                    }

                    String name;
                    if (args[0].equalsIgnoreCase("load") || args[0].equalsIgnoreCase("l")) {
                        if (!player.hasPermission("craftflowers.load")) {
                            player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
                            return true;
                        }

                        if (args.length != 1 && args.length <= 2) {
                            name = args[1];
                            flowersManage.loadFlower(player, name);
                            return true;
                        }

                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GOLD + "/craftflowers load <name>");
                        return true;
                    }

                    if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("d")) {
                        if (!player.hasPermission("craftflowers.delete")) {
                            player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
                            return true;
                        }

                        if (args.length != 1 && args.length <= 2) {
                            name = args[1];
                            flowersManage.deleteFlower(player, name);
                            return true;
                        }

                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GOLD + "/craftflowers delete <name>");
                        return true;
                    }

                    if (!args[0].equalsIgnoreCase("help") && !args[0].equalsIgnoreCase("h")) {
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers help " + ChatColor.BLUE + "- For help");
                    } else {
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers " + ChatColor.BLUE + "- Opens GUI");
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers save <name> " + ChatColor.BLUE + "- Saves the currently held flower");
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers load <name> " + ChatColor.BLUE + "- Loads a saved flower");
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers delete <name> " + ChatColor.BLUE + "- Removes the saved flower");
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers info " + ChatColor.BLUE + "- Shows info about the plugin");
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers help " + ChatColor.BLUE + "- Shows this text");
                    }
                } else {
                    CheckVersion cv = new CheckVersion();
                    if (cv.isUpdated()) {
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "Version: " + ChatColor.GREEN + CraftFlowers.plugin.getDescription().getVersion());
                    } else {
                        player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "Version: " + ChatColor.RED + CraftFlowers.plugin.getDescription().getVersion());
                    }

                    player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "Author: " + ChatColor.BLUE + (String) CraftFlowers.plugin.getDescription().getAuthors().get(0));
                    player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "Website: " + ChatColor.BLUE + CraftFlowers.plugin.getDescription().getWebsite());
                }
            }
        }

        return false;
    }
}
