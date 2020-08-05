package cm.ptks.craftflowers.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiUtils {
    public void add(Inventory inv, ItemStack i, Player p) {
        for (int slot = 36; slot < 45; ++slot) {
            if (inv.getContents()[slot] == null) {
                inv.setItem(slot, i);
                return;
            }
        }

        p.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Height 9 is maximum height of the flower.");
    }

    public void create(Inventory inv, Player p) {
        ItemStack pot = new ItemStack(Material.FLOWER_POT, 1);
        ItemMeta im = pot.getItemMeta();
        im.setDisplayName("§2craftFlowers");
        ArrayList<String> lore = new ArrayList();

        for (int slot = 36; slot < 45; ++slot) {
            if (inv.getContents()[slot] != null) {
                ItemStack i = inv.getContents()[slot];
                lore.add("§7" + i.getType());
            }
        }

        im.setLore(lore);
        pot.setItemMeta(im);
        if (inv.getContents()[36] != null) {
            p.getInventory().addItem(new ItemStack[]{pot});
        }

    }

    public void update(Inventory inv, Player p) {
        ItemStack pot = new ItemStack(Material.FLOWER_POT, 1);
        ItemMeta im = pot.getItemMeta();
        im.setDisplayName("§2craftFlowers");
        ArrayList<String> lore = new ArrayList();

        for (int slot = 36; slot < 45; ++slot) {
            if (inv.getContents()[slot] != null) {
                ItemStack i = inv.getContents()[slot];
                if (i.getType().equals(Material.VINE)) {
                    lore.add("§7" + i.getType() + ":15");
                }

                if (i.getType().equals(Material.SUGAR_CANE)) {
                    lore.add("§783:0");
                } else {
                    lore.add("§7" + i.getType() + ":" + i.getData().getData());
                }
            }
        }

        im.setLore(lore);
        pot.setItemMeta(im);
        if (inv.getContents()[36] != null) {
            p.getInventory().setItemInHand(pot);
        }

    }

    public void remove(Inventory inv, Player p) {
        ItemStack air = new ItemStack(Material.AIR, 1);

        for (int slot = 44; slot > 35; --slot) {
            if (inv.getContents()[slot] != null) {
                inv.setItem(slot, air);
                return;
            }
        }

    }

    public void clear(Inventory i) {
        ItemStack air = new ItemStack(Material.AIR, 1);

        for (int slot = 36; slot < 45; ++slot) {
            i.setItem(slot, air);
        }

    }

    public void previous(Inventory i) {
        for (int slot = 0; slot < 27; ++slot) {
            i.setItem(slot, (ItemStack) GuiGenerator.items.get(slot));
        }

    }

    public void next(Inventory i) {
        ItemStack air = new ItemStack(Material.AIR, 1);
        i.setItem(0, (ItemStack) GuiGenerator.items.get(27));

        int slot;
        for (slot = 1; slot < 13; ++slot) {
            i.setItem(slot, (ItemStack) GuiGenerator.items.get(slot + 27));
        }

        for (slot = 13; slot < 27; ++slot) {
            i.setItem(slot, air);
        }

    }

    public void edit(InventoryView inventoryView, ItemStack pot) {
        List<String> lore = pot.getItemMeta().getLore();
        if (pot.getItemMeta().hasLore() && lore.get(0) != null) {
            for (int i = 0; i < lore.size(); ++i) {
                String id = ((String) lore.get(i)).replace("§7", "");

                Material material = Material.getMaterial(id);

                ItemStack item;
                int slot;
                item = new ItemStack(material, 1);
                slot = i + 36;
                inventoryView.setItem(slot, item);
            }
        }

    }
}
