package cm.ptks.craftflowers.gui;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.flower.BambooFlower;
import cm.ptks.craftflowers.flower.FlowerPot;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;

public class BambooAgeGui implements InventoryProvider {


    public static void openGui(Player player, SmartInventory parent, int page, BambooFlower flower,
            FlowerPot flowerPot) {
        SmartInventory.builder()
                .provider(new BambooAgeGui(flower))
                .size(6, 9)
                .parent(parent)
                .manager(CraftFlowers.getInventoryManager())
                //.title(CraftFlowers.arrow + LanguageFile.GUI.FLOWER_GROUP_TITLE_COLOR + flowerGroup.getDisplayName()) //TODO:
                .build().open(player);
        player.playSound(player.getLocation(), Sound.BLOCK_BARREL_OPEN, 1, 1);
    }
    
    private BambooFlower flower;

    private BambooAgeGui(BambooFlower flower) {
        this.flower = flower;
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        contents.fillRow(0, ClickableItem.empty(GuiConstants.GLASS));

        contents.fillRow(4, ClickableItem.empty(GuiConstants.GLASS));
    }

    @Override
    public void update(Player player, InventoryContents contents) {        
    }
    
    

}
