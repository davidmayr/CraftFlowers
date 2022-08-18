package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.storage.LanguageFile;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FlowerPot {

    private final List<Flower> flowers;

    public FlowerPot(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public void addFlower(Player player, Flower flower) {
        if (this.flowers.size() >= 9) {
            player.sendMessage(CraftFlowers.prefix + LanguageFile.FLOWER_INFO.LIMIT_REACHED);
            return;
        }
        this.flowers.add(flower);
    }

    public static FlowerPot parsePot(JsonObject jsonObject) {
        JsonArray array = jsonObject.get("flowers").getAsJsonArray();

        List<Flower> flowers = new ArrayList<>();
        for (JsonElement element : array) {
            flowers.add(Flower.parse(element.getAsJsonObject()));
        }
        return new FlowerPot(flowers);
    }

    public JsonObject serialize() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonElements = new JsonArray();

        for (Flower flower : flowers) {
            // This shouldn't happen. But just in case
            if (flower instanceof FlowerGroup) continue;
            jsonElements.add(flower.serialize());
        }
        jsonObject.add("flowers", jsonElements);
        return jsonObject;
    }

    public ItemStack createItemStack() {
        NamespacedKey key = new NamespacedKey(JavaPlugin.getPlugin(CraftFlowers.class), "flowerpot");

        ItemStack itemStack = new ItemStack(Material.FLOWER_POT);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;

        itemMeta.setDisplayName(CraftFlowers.prefix + LanguageFile.ITEM.FLOWER_POT);

        itemMeta
                .getPersistentDataContainer()
                .set(key, PersistentDataType.STRING, serialize().toString());

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static FlowerPot parsePot(ItemStack itemStack) {
        NamespacedKey key = new NamespacedKey(JavaPlugin.getPlugin(CraftFlowers.class), "flowerpot");
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) return null;
        if (!itemMeta.getPersistentDataContainer().has(key, PersistentDataType.STRING)) return null;
        String serialized = itemMeta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
        return parsePot(new JsonParser().parse(Objects.requireNonNull(serialized)).getAsJsonObject());
    }

    public List<Flower> getFlowers() {
        return Collections.unmodifiableList(flowers);
    }

    public void removeFlower(Flower flower) {
        this.flowers.remove(flower);
    }

    public void clearFlowers() {
        this.flowers.clear();
    }
}
