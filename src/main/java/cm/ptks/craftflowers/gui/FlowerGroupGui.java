package cm.ptks.craftflowers.gui;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.flower.Flower;
import cm.ptks.craftflowers.flower.FlowerGroup;
import cm.ptks.craftflowers.flower.FlowerPot;
import cm.ptks.craftflowers.languages.Messages;
import cm.ptks.craftflowers.util.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class FlowerGroupGui implements InventoryProvider {

    public static void openGui(Player player, SmartInventory parent, int parentPage, FlowerGroup flowerGroup, FlowerPot flowerPot) {
        SmartInventory.builder()
                .provider(new FlowerGroupGui(flowerGroup, flowerPot, parentPage))
                .size(6, 9)
                .parent(parent)
                .manager(CraftFlowers.getInventoryManager())
                .title(CraftFlowers.arrow + Messages.GUI.FLOWER_GROUP_TITLE_COLOR + flowerGroup.getDisplayName(player))
                .build().open(player);
        player.playSound(player.getLocation(), Sound.BLOCK_BARREL_OPEN, 1, 1);
    }

    private final FlowerGroup flowerGroup;
    private final FlowerPot flowerPot;
    private final int parentPage;

    public FlowerGroupGui(FlowerGroup flowerGroup, FlowerPot flowerPot, int parentPage) {
        this.flowerGroup = flowerGroup;
        this.flowerPot = flowerPot;
        this.parentPage = parentPage;
    }


    @Override
    public void init(Player player, InventoryContents contents) {
        contents.fillRow(0, ClickableItem.empty(GuiConstants.GLASS));

        for (Flower flower : flowerGroup.getChildren()) {
            contents.add(ClickableItem.of(new ItemBuilder(flower.getMaterial())
                    .setDisplayName(flower.getDisplayName(player)).build(), event -> {
                if (flower instanceof FlowerGroup) {
                    return;
                }
                flowerPot.addFlower(player, flower);
                contents.inventory().getParent().ifPresent(smartInventory -> smartInventory.open(player, parentPage));
                player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
            }));
        }

        contents.fillRow(5, ClickableItem.empty(GuiConstants.GLASS));
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
