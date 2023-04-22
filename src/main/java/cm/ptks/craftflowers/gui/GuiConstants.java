package cm.ptks.craftflowers.gui;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.languages.I18n;
import cm.ptks.craftflowers.languages.Messages;
import cm.ptks.craftflowers.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GuiConstants {

    public static final ItemStack GLASS = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE)
            .setDisplayName("§a").build();


    public static ItemStack getNext(Player player) {
        return new ItemBuilder(Material.PLAYER_HEAD)
        .setDisplayName(CraftFlowers.arrow + I18n.translate(player, Messages.GUI.NEXT))
        .setTextureId("2a3b8f681daad8bf436cae8da3fe8131f62a162ab81af639c3e0644aa6abac2f").build();
    }

    public static ItemStack getPrev(Player player) {
        return new ItemBuilder(Material.PLAYER_HEAD)
        .setDisplayName(CraftFlowers.arrow + I18n.translate(player, Messages.GUI.PREVIOUS))
        .setTextureId("8652e2b936ca8026bd28651d7c9f2819d2e923697734d18dfdb13550f8fdad5f").build();
    }

    private GuiConstants() {
    }
}
