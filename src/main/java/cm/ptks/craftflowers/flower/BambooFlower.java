package cm.ptks.craftflowers.flower;

import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.bukkit.block.data.type.Bamboo;

public class BambooFlower extends AgingFlower {

    private final Bamboo.Leaves leaveType;

    public BambooFlower(Material guiMaterial, String displayName, Material blockMaterial, int age, Bamboo.Leaves leaves) {
        super(guiMaterial, displayName, blockMaterial, age);
        this.leaveType = leaves;
    }

    public BambooFlower(Material material, String displayName, int age, Bamboo.Leaves leaves) {
        super(material, displayName, age);
        this.leaveType = leaves;
    }

    @Override
    public String getDisplayName() {
        //TODO: leave type
        return super.getDisplayName();
    }

    @Override
    public JsonObject serialize() {
        JsonObject serialize = super.serialize();
        serialize.addProperty("leaveType", leaveType.name());
        return serialize;
    }

}