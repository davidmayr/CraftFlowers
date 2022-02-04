package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.CraftFlowers;
import com.google.gson.JsonObject;
import org.bukkit.Material;

public class Flower {

    /**
     * The material required in the inventory when {@link CraftFlowers#isSurvivalMode()} is true and displayed in the gui
     */
    private final Material material;
    private final String displayName;

    /**
     * The actual block that gets placed.
     */
    private final Material blockMaterial;

    public Flower(Material material, String displayName, Material blockMaterial) {
        this.material = material;
        this.displayName = displayName;
        this.blockMaterial = blockMaterial;
    }

    public Flower(Material material, String displayName) {
        this.material = material;
        this.blockMaterial = material;
        this.displayName = displayName;
    }
    
    public static Flower parse(JsonObject jsonObject) {
        Material guiMaterial = Material.valueOf(jsonObject.get("material").getAsString());
        String displayName = jsonObject.get("displayName").getAsString();
        Material blockMaterial = Material.valueOf(jsonObject.get("blockMaterial").getAsString());

        if(jsonObject.has("age")) {
            int age = jsonObject.get("age").getAsInt();

            return new AgingFlower(guiMaterial, displayName, blockMaterial, age);
        }
        return new Flower(guiMaterial, displayName, blockMaterial);
    }

    public JsonObject serialize() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("material", material.name());
        jsonObject.addProperty("displayName", displayName);
        jsonObject.addProperty("blockMaterial", blockMaterial.name());
        return jsonObject;
    }

    public Material getBlockMaterial() {
        return blockMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getRawDisplayName() {
        return displayName;
    }
}
