package cm.ptks.craftflowers.flower;

import com.google.gson.JsonObject;
import org.bukkit.Material;

public class BambooFlower extends AgingFlower {


    public BambooFlower(Material guiMaterial, String displayName, Material blockMaterial, int age) {
        super(guiMaterial, displayName, blockMaterial, age);
    }

    public BambooFlower(Material material, String displayName, int age) {
        super(material, displayName, age);
    }

    @Override
    public String getDisplayName() {
        return super.getDisplayName();
    }

    @Override
    public JsonObject serialize() {
        JsonObject serialize = super.serialize();

        return serialize;
    }

}