package cm.ptks.craftflowers.gui;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.storage.LanguageFile;
import cm.ptks.craftflowers.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GuiConstants {

    public static final ItemStack GLASS = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
            .setDisplayName("§a").build();

    public static final ItemStack PREV = new ItemBuilder(Material.PLAYER_HEAD)
            .setDisplayName(CraftFlowers.arrow + LanguageFile.GUI.PREVIOUS)
            .setTextureId("8652e2b936ca8026bd28651d7c9f2819d2e923697734d18dfdb13550f8fdad5f").build();

    public static final ItemStack NEXT = new ItemBuilder(Material.PLAYER_HEAD)
            .setDisplayName(CraftFlowers.arrow + LanguageFile.GUI.NEXT)
            .setTextureId("2a3b8f681daad8bf436cae8da3fe8131f62a162ab81af639c3e0644aa6abac2f").build();

    private GuiConstants() {
    }
}
