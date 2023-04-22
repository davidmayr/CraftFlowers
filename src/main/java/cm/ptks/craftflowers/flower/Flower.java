package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.languages.I18n;

import com.google.gson.JsonObject;
import com.sk89q.worldedit.registry.state.Property;
import com.sk89q.worldedit.world.block.BaseBlock;
import com.sk89q.worldedit.world.block.BlockType;

import org.bukkit.Material;
import org.bukkit.block.data.type.Bamboo;
import org.bukkit.entity.Player;

public class Flower {

    /**
     * The material required in the inventory when {@link CraftFlowers#isSurvivalMode()} is true and displayed in the gui
     */
    protected final Material material;
    protected final String displayName;

    /**
     * The actual block that gets placed.
     */
    protected final Material blockMaterial;

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

        if(guiMaterial == Material.BAMBOO || guiMaterial == Material.BAMBOO_SAPLING) {
            int age = jsonObject.has("age") ? jsonObject.get("age").getAsInt() : 0;
            Bamboo.Leaves leaves = jsonObject.has("leaveType") ? Bamboo.Leaves
                    .valueOf(jsonObject.get("leaveType").getAsString()) : Bamboo.Leaves.NONE;

            return new BambooFlower(guiMaterial, displayName, blockMaterial, age, leaves);
        }
        if(jsonObject.has("age")) {
            int age = jsonObject.get("age").getAsInt();

            return new AgingFlower(guiMaterial, displayName, blockMaterial, age);
        }
        if(jsonObject.has("lit")) {
            boolean lit = jsonObject.get("lit").getAsBoolean();

            return new CandleFlower(guiMaterial, displayName, lit);
        }
        return new Flower(guiMaterial, displayName, blockMaterial);
    }

    public BaseBlock applyToBlock(BaseBlock block, BlockType type) {
        Property<Boolean> waterLogged = type.getProperty("waterlogged");
        if(waterLogged != null)
            block = block.with(waterLogged, false);

        return block;
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

    public String getDisplayName(Player player) {
        return I18n.translate(player, getRawDisplayName());
    }

    public String getRawDisplayName() {
        return displayName;
    }
}
