package cm.ptks.craftflowers.flower;

import com.google.gson.JsonObject;
import org.bukkit.Material;

import java.util.List;

public class FlowerGroup extends Flower {

    private final List<Flower> children;

    public FlowerGroup(Material guiMaterial, String displayName, List<Flower> children) {
        super(guiMaterial, displayName, null);
        this.children = children;
    }

    @Override
    public JsonObject serialize() {
        throw new RuntimeException("Cannot serialize FlowerGroup");
    }

    public List<Flower> getChildren() {
        return children;
    }
}
