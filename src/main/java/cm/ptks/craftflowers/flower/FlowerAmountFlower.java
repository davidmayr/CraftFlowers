package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.languages.Messages;
import com.google.gson.JsonObject;
import com.sk89q.worldedit.registry.state.Property;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class FlowerAmountFlower extends Flower {

    protected final int flowerAmount;

    public FlowerAmountFlower(Material guiMaterial, String displayName, Material blockMaterial, int flowerAmount) {
        super(guiMaterial, displayName, blockMaterial);
        this.flowerAmount = flowerAmount;
    }

    public FlowerAmountFlower(Material material, String displayName, int flowerAmount) {
        super(material, displayName);
        this.flowerAmount = flowerAmount;
    }

    @Override
    public BaseBlock applyToBlock(BaseBlock block, BlockType type) {
        Property<Integer> ageProp = type.getProperty("flower_amount");
        if(ageProp != null)
            block = block.with(ageProp, flowerAmount);

        return super.applyToBlock(block, type);
    }

    @Override
    public String getDisplayName(@Nullable Player player) {
        return super.getDisplayName(player) + Messages.getFlowerInfoFlowerAmount(player, flowerAmount);
    }

    @Override
    public JsonObject serialize() {
        JsonObject serialize = super.serialize();
        serialize.addProperty("flower_amount", flowerAmount);
        return serialize;
    }

    public int getFlowerAmount() {
        return flowerAmount;
    }
}