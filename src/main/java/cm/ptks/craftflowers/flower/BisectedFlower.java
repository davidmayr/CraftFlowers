package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.languages.Messages;
import com.google.gson.JsonObject;
import com.sk89q.worldedit.registry.state.Property;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockType;
import org.bukkit.Material;
import org.bukkit.block.data.Bisected;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class BisectedFlower extends Flower {

    protected final Bisected.Half half;

    public BisectedFlower(Material guiMaterial, String displayName, Material blockMaterial, Bisected.Half half) {
        super(guiMaterial, displayName, blockMaterial);
        this.half = half;
    }

    public BisectedFlower(Material material, String displayName, Bisected.Half half) {
        super(material, displayName);
        this.half = half;
    }

    @Override
    public BaseBlock applyToBlock(BaseBlock block, BlockType type) {
        Property<String> halfProperty = type.getProperty("half");
        if(halfProperty != null)
            block = block.with(halfProperty, half == Bisected.Half.BOTTOM ? "lower" : "upper");

        return super.applyToBlock(block, type);
    }

    @Override
    public String getDisplayName(@Nullable Player player) {
        return super.getDisplayName(player) + Messages.getFlowerInfoBisected(player, half);
    }

    @Override
    public JsonObject serialize() {
        JsonObject serialize = super.serialize();
        serialize.addProperty("half", this.half.name());
        return serialize;
    }

    public Bisected.Half getHalf() {
        return half;
    }
}