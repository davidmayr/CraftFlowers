package cm.ptks.craftflowers.gui;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.storage.LanguageFile;
import cm.ptks.craftflowers.storage.SavedFlowerPot;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import fr.minuskube.inv.content.Pagination;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SavedFlowerListGui implements InventoryProvider {

	private final List<SavedFlowerPot> flowerPots;

	public SavedFlowerListGui(List<SavedFlowerPot> flowerPots) {
		this.flowerPots = flowerPots;
	}

	public static void openGui(Player player, List<SavedFlowerPot> pots) {
		SmartInventory.builder()
				.provider(new SavedFlowerListGui(pots))
				.size(6, 9)
				.manager(CraftFlowers.getInventoryManager())
				.title(CraftFlowers.arrow + LanguageFile.GUI_SAVED_FLOWERPOTS)
				.build().open(player);
		player.playSound(player.getLocation(), Sound.BLOCK_BARREL_OPEN, 1, 1);
	}

	@Override
	public void init(Player player, InventoryContents contents) {
		contents.fillRow(0, ClickableItem.empty(GuiConstants.GLASS));

		contents.fillRow(5, ClickableItem.empty(GuiConstants.GLASS));

		ClickableItem[] items = new ClickableItem[flowerPots.size()];
		for (int i = 0; i < flowerPots.size(); i++) {
			SavedFlowerPot savedFlowerPot = flowerPots.get(i);
			ItemStack itemStack = savedFlowerPot.getFlowerPot().createItemStack();

			ItemMeta itemMeta = itemStack.getItemMeta();
			itemMeta.setDisplayName(CraftFlowers.prefix + LanguageFile.GUI_SAVED_FLOWERPOTS_NAME_COLOR + savedFlowerPot.getName());
			itemStack.setItemMeta(itemMeta);

			items[i] = ClickableItem.of(itemStack,
					event -> {
						player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1, 1);
						player.getInventory().addItem(savedFlowerPot.getFlowerPot().createItemStack());
					});
		}
		Pagination pagination = contents.pagination().setItems(items).setItemsPerPage(36);

		for (ClickableItem pageItem : pagination.getPageItems()) {
			contents.add(pageItem);
		}

		contents.set(5, 1, ClickableItem.of(GuiConstants.PREV, event -> {
			contents.inventory().open(player, contents.pagination().previous().getPage());
			player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
		}));

		contents.set(5, 7, ClickableItem.of(GuiConstants.NEXT, event -> {
			contents.inventory().open(player, contents.pagination().next().getPage());
			player.playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
		}));

	}

	@Override
	public void update(Player player, InventoryContents inventoryContents) {

	}
}
