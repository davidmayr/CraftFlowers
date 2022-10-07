package cm.ptks.craftflowers.flower;

import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.bukkit.block.data.type.Bamboo;

public class BambooFlower extends AgingFlower {

    private Bamboo.Leaves leaveType;

    public BambooFlower(Material guiMaterial, String displayName, Material blockMaterial, int age, Bamboo.Leaves leaves) {
        super(guiMaterial, displayName, blockMaterial, age);
        this.leaveType = leaves;
    }

    public BambooFlower(Material material, String displayName, int age, Bamboo.Leaves leaves) {
        super(material, displayName, age);
        this.leaveType = leaves;
    }

    public BambooFlower(Material guiMaterial, String displayName, Material blockMaterial, int age) {
        this(guiMaterial, displayName, blockMaterial, age, Bamboo.Leaves.NONE);
    }

    public BambooFlower(Material material, String displayName, int age) {
        this(material, displayName, age, Bamboo.Leaves.NONE);
    }


    @Override
    public String getDisplayName() {
        //TODO: leave type
        return super.getDisplayName();
    }

    public BambooFlower cloneWithLeaveType(Bamboo.Leaves type) {
        return new BambooFlower(material, displayName, blockMaterial, age, type);
    
    }

    public BambooFlower cloneWithAge(int age) {
        return new BambooFlower(material, displayName, blockMaterial, age, this.leaveType);
    }


    @Override
    public JsonObject serialize() {
        JsonObject serialize = super.serialize();
        serialize.addProperty("leaveType", leaveType.name());
        return serialize;
    }

}