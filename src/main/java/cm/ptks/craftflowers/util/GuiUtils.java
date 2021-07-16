package cm.ptks.craftflowers.util;

import cm.ptks.craftflowers.CraftFlowers;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GuiUtils {

    public static HashMap<Player, GuiUtils> PLAYERS = new HashMap<>();
    private int page;

    public static GuiUtils create(Player player) {
        GuiUtils guiUtils = new GuiUtils();
        PLAYERS.put(player, guiUtils);

        return guiUtils;
    }

    private GuiUtils() {
    }

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
        JsonArray blockData = new JsonArray();

        for (int slot = 36; slot < 45; ++slot) {
            if (inv.getContents()[slot] != null) {
                ItemStack i = inv.getContents()[slot];

                Material type = i.getType();

                blockData.add(getDataFromItem(i));

                lore.add("§7" + type);
            }
        }

        im.setLore(lore);
        im.getPersistentDataContainer().set(new NamespacedKey(CraftFlowers.plugin, "craftFlowersMeta"), PersistentDataType.STRING, blockData.toString());
        pot.setItemMeta(im);
        if (inv.getContents()[36] != null) {
            p.getInventory().addItem(new ItemStack[]{pot});
        }

    }

    public JsonObject getDataFromItem(@Nonnull ItemStack i) {
        JsonObject jsonObject = new JsonObject();

        PersistentDataContainer container = Objects.requireNonNull(i.getItemMeta()).getPersistentDataContainer();
        jsonObject.addProperty("material", i.getType().name());

        if(container.has(new NamespacedKey(CraftFlowers.plugin, "customBlock"), PersistentDataType.STRING)) {
            jsonObject.addProperty("blockMaterial", Material.getMaterial(container
                    .get(new NamespacedKey(CraftFlowers.plugin, "customBlock"), PersistentDataType.STRING)).name());
        }

        if(container.has(new NamespacedKey(CraftFlowers.plugin, "customAge"), PersistentDataType.INTEGER)) {
            jsonObject.addProperty("age", container
                    .get(new NamespacedKey(CraftFlowers.plugin, "customAge"), PersistentDataType.INTEGER));
        }
        if(i.getItemMeta().hasDisplayName()) {
            jsonObject.addProperty("name", i.getItemMeta().getDisplayName());
        }
        return jsonObject;
    }


    public void edit(InventoryView inventoryView, Player player, ItemStack pot) {
        ItemMeta im = pot.getItemMeta();
        String craftFlowersMeta = im.getPersistentDataContainer().get(new NamespacedKey(CraftFlowers.plugin, "craftFlowersMeta"), PersistentDataType.STRING);
        if(craftFlowersMeta == null) {
            player.sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "You seem to have a flowerpot from an older version. These can not be converted.");
            inventoryView.close();
            return;
        }

        JsonArray jsonArray = new JsonParser().parse(craftFlowersMeta).getAsJsonArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            ItemStack item = new ItemStack(Material.getMaterial(jsonObject.get("material").getAsString()), 1);
            ItemMeta itemMeta = item.getItemMeta();
            PersistentDataContainer container = itemMeta.getPersistentDataContainer();
            if(jsonObject.has("blockMaterial")) {
                container.set(new NamespacedKey(CraftFlowers.plugin, "customBlock"), PersistentDataType.STRING, jsonObject.get("blockMaterial").getAsString());
            }
            if(jsonObject.has("age")) {
                container.set(new NamespacedKey(CraftFlowers.plugin, "customAge"), PersistentDataType.INTEGER, jsonObject.get("age").getAsInt());
            }
            if(jsonObject.has("name")) {
                itemMeta.setDisplayName(jsonObject.get("name").getAsString());
            }
            item.setItemMeta(itemMeta);
            int slot = i + 36;
            inventoryView.setItem(slot, item);
        }


    }

    public void update(Inventory inv, Player p) {
        ItemStack pot = new ItemStack(Material.FLOWER_POT, 1);
        ItemMeta im = pot.getItemMeta();
        im.setDisplayName("§2craftFlowers");
        ArrayList<String> lore = new ArrayList();
        JsonArray blockData = new JsonArray();

        for (int slot = 36; slot < 45; ++slot) {
            if (inv.getContents()[slot] != null) {
                ItemStack i = inv.getContents()[slot];

                blockData.add(getDataFromItem(i));
                lore.add("§7" + i.getType());
            }
        }

        im.getPersistentDataContainer().set(new NamespacedKey(CraftFlowers.plugin, "craftFlowersMeta"), PersistentDataType.STRING, blockData.toString());
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

    public void previous(Inventory inventory) {

        page--;
        if(page < 0) {
            page = 0;
        }

        ItemStack air = new ItemStack(Material.AIR, 1);
        move(inventory, air);

    }

    private void move(Inventory inventory, ItemStack air) {
        for (int slot = 0; slot < 27; ++slot) {
            inventory.setItem(slot, air);
        }

        for (int slot = 0; slot < 27; ++slot) {
            ItemStack itemStack = CraftFlowers.plugin.getGenerator().getItems().get(slot + (27 * this.page));
            if(itemStack == null)
                continue;
            inventory.setItem(slot, itemStack);
        }
    }

    public void next(Inventory inventory) {
        ItemStack air = new ItemStack(Material.AIR, 1);

        page++;

        //No Content
        if(CraftFlowers.plugin.getGenerator().getItems().get((27 * this.page)) == null) {
            page = 0;
        }
        move(inventory, air);
    }

}
