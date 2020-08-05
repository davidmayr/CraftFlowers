package cm.ptks.craftflowers.Commands;

import cm.ptks.craftflowers.Main;
import cm.ptks.craftflowers.Util.CheckVersion;
import cm.ptks.craftflowers.Util.FlowersManage;
import cm.ptks.craftflowers.Util.GuiGenerator;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Cmd implements CommandExecutor {
   ItemStack pot;

   public Cmd() {
      this.pot = new ItemStack(Material.FLOWER_POT_ITEM, 1);
      ItemMeta im = this.pot.getItemMeta();
      im.setDisplayName("§2craftFlowers");
      this.pot.setItemMeta(im);
   }

   public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
      Player p = (Player)s;
      if (cmd.getName().equalsIgnoreCase("craftflowers")) {
         if (args.length == 0) {
            if (!(s instanceof Player)) {
               return false;
            }

            if (!p.hasPermission("craftflowers.use")) {
               p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
               return true;
            }

            GuiGenerator gui = new GuiGenerator();
            gui.mainGUI(s);
         } else {
            FlowersManage fm = new FlowersManage();
            if (!args[0].equalsIgnoreCase("info") && !args[0].equalsIgnoreCase("i")) {
               if (args[0].equalsIgnoreCase("save") || args[0].equalsIgnoreCase("s")) {
                  if (!p.hasPermission("craftflowers.save")) {
                     p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
                     return true;
                  } else if (args.length != 1 && args.length <= 2) {
                     if (p.getItemInHand().getType().equals(Material.FLOWER_POT_ITEM) && p.getItemInHand().getItemMeta().getDisplayName().equals("§2craftFlowers")) {
                        List<String> ids = p.getItemInHand().getItemMeta().getLore();
                        String name = args[1].replaceAll("[^A-Za-z0-9]", "");
                        String id = ids.toString().replace("§7", "");
                        fm.saveFlower(p, name, id);
                        return true;
                     } else {
                        p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You must held the pot.");
                        return true;
                     }
                  } else {
                     p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GOLD + "/craftflowers save <name>");
                     return true;
                  }
               }

               String name;
               if (args[0].equalsIgnoreCase("load") || args[0].equalsIgnoreCase("l")) {
                  if (!p.hasPermission("craftflowers.load")) {
                     p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
                     return true;
                  }

                  if (args.length != 1 && args.length <= 2) {
                     name = args[1];
                     fm.loadFlower(p, name);
                     return true;
                  }

                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GOLD + "/craftflowers load <name>");
                  return true;
               }

               if (args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("d")) {
                  if (!p.hasPermission("craftflowers.delete")) {
                     p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You don't have permission!");
                     return true;
                  }

                  if (args.length != 1 && args.length <= 2) {
                     name = args[1];
                     fm.deleteFlower(p, name);
                     return true;
                  }

                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.GOLD + "/craftflowers delete <name>");
                  return true;
               }

               if (!args[0].equalsIgnoreCase("help") && !args[0].equalsIgnoreCase("h")) {
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers help " + ChatColor.BLUE + "- For help");
               } else {
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers " + ChatColor.BLUE + "- Opens GUI");
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers save <name> " + ChatColor.BLUE + "- Saves the currently held flower");
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers load <name> " + ChatColor.BLUE + "- Loads a saved flower");
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers delete <name> " + ChatColor.BLUE + "- Removes the saved flower");
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers info " + ChatColor.BLUE + "- Shows info about the plugin");
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "/craftflowers help " + ChatColor.BLUE + "- Shows this text");
               }
            } else {
               CheckVersion cv = new CheckVersion();
               if (cv.isUpdated()) {
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "Version: " + ChatColor.GREEN + Main.plugin.getDescription().getVersion());
               } else {
                  p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "Version: " + ChatColor.RED + Main.plugin.getDescription().getVersion());
               }

               p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "Author: " + ChatColor.BLUE + (String)Main.plugin.getDescription().getAuthors().get(0));
               p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.AQUA + "Website: " + ChatColor.BLUE + Main.plugin.getDescription().getWebsite());
            }
         }
      }

      return false;
   }
}
