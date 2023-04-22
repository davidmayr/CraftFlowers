package cm.ptks.craftflowers.gui;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.flower.BambooFlower;
import cm.ptks.craftflowers.flower.Flower;
import cm.ptks.craftflowers.flower.FlowerGroup;
import cm.ptks.craftflowers.flower.FlowerPot;
import cm.ptks.craftflowers.flower.FlowerRegistry;
import cm.ptks.craftflowers.languages.I18n;
import cm.ptks.craftflowers.languages.Messages;
import cm.ptks.craftflowers.util.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import fr.minuskube.inv.content.Pagination;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.util.ArrayList;
import java.util.List;

public class CraftFlowersGui implements InventoryProvider {

    private final FlowerPot flowerPot;

    public CraftFlowersGui(FlowerPot flowerPot) {
        this.flowerPot = flowerPot;
    }

    public static void openGui(Player player) {
        openGui(player, new FlowerPot(new ArrayList<>()));
    }

    public static void openGui(Player player, FlowerPot flowerPot) {
        SmartInventory.builder()
                .provider(new CraftFlowersGui(flowerPot))
                .size(6, 9)
                .manager(CraftFlowers.getInventoryManager())
                .title(CraftFlowers.arrow + I18n.translate(player, Messages.GUI.TITLE))
                .build().open(player);
        player.playSound(player.getLocation(), Sound.BLOCK_BARREL_OPEN, 1, 1);
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        contents.fillRow(4, ClickableItem.empty(GuiConstants.GLASS));

        ClickableItem[] items = new ClickableItem[FlowerRegistry.getFlowers().size()];
        for (int i = 0; i < FlowerRegistry.getFlowers().size(); i++) {
            Flower flower = FlowerRegistry.getFlowers().get(i);
            items[i] = ClickableItem.of(new ItemBuilder(flower.getMaterial())
                    .setDisplayName(flower.getDisplayName(player)).build(), event -> {
                if (flower instanceof FlowerGroup) {
                    FlowerGroupGui.openGui(player, contents.inventory(), contents.pagination().getPage(),
                            ((FlowerGroup) flower), flowerPot);
                    return;
                }
                if (flower instanceof BambooFlower) {
                    BambooAgeGui.openGui(player, contents.inventory(), contents.pagination().getPage(),
                        (BambooFlower) flower, flowerPot);
                    return;
                }
                flowerPot.addFlower(player, flower);
                fillPotRow(player, flowerPot, contents);
                player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
            });
        }
        Pagination pagination = contents.pagination().setItems(items).setItemsPerPage(36);

        for (ClickableItem pageItem : pagination.getPageItems()) {
            contents.add(pageItem);
        }

        contents.set(4, 1, ClickableItem.of(GuiConstants.getPrev(player), event -> {
            contents.inventory().open(player, contents.pagination().previous().getPage());
            player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
        }));

        contents.set(4, 3, ClickableItem.of(new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName(CraftFlowers.arrow + I18n.translate(player, Messages.GUI.CREATE_FLOWER))
                .setTextureId("b056bc1244fcff99344f12aba42ac23fee6ef6e3351d27d273c1572531f").build(), event -> {
            if (flowerPot.getFlowers().size() == 0) {
                player.sendMessage(CraftFlowers.prefix + I18n.translate(player, Messages.GUI.CANT_CREATE_EMPTY_FLOWER));
                return;
            }
            player.getInventory().addItem(flowerPot.createItemStack());
        }));

        contents.set(4, 4, ClickableItem.of(new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName(CraftFlowers.arrow + I18n.translate(player, Messages.GUI.REMOVE_FROM_TOP))
                .setTextureId("a9db1760dab1ed801a594a63cdc4a2e3b3e1d12e8056a702044774a52b1d18").build(), event -> {
            List<Flower> flowers = flowerPot.getFlowers();
            if (flowers.size() == 0)
                return;
            flowerPot.removeFlower(flowers.get(flowers.size() - 1));
            fillPotRow(player, flowerPot, contents);
        }));


        contents.set(4, 5, ClickableItem.of(new ItemBuilder(Material.PLAYER_HEAD)
                .setDisplayName(CraftFlowers.arrow + I18n.translate(player, Messages.GUI.CLEAR_ALL))
                .setTextureId("3cc470ae2631efdfaf967b369413bc2451cd7a39465da7836a6c7a14e877").build(), event -> {
            flowerPot.clearFlowers();
            fillPotRow(player, flowerPot, contents);
        }));


        contents.set(4, 7, ClickableItem.of(GuiConstants.getNext(player), event -> {
            contents.inventory().open(player, contents.pagination().next().getPage());
            player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
        }));

        fillPotRow(player, flowerPot, contents);
    }

    private void fillPotRow(Player player, FlowerPot flowerPot, InventoryContents contents) {
        for (int i = 0; i < 9; i++) {
            if (flowerPot.getFlowers().size() <= i) {
                contents.set(5, i, null);
                continue;
            }
            Flower flower = flowerPot.getFlowers().get(i);
            contents.set(5, i, ClickableItem.of(new ItemBuilder(flower.getMaterial())
                    .setDisplayName(flower.getDisplayName(player)).build(), event -> {
                if (event.getClick() == ClickType.DROP || event.getClick() == ClickType.CONTROL_DROP) {
                    flowerPot.removeFlower(flower);
                    fillPotRow(player, flowerPot, contents);
                }
            }));
        }
    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
