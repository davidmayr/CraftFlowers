package cm.ptks.craftflowers.flower;

import cm.ptks.craftflowers.languages.I18n;
import cm.ptks.craftflowers.languages.Messages;
import com.google.gson.JsonObject;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CandleFlower extends Flower {

    private final boolean lit;

    public CandleFlower(Material guiMaterial, String displayName, boolean lit) {
        super(guiMaterial, displayName);
        this.lit = lit;
    }

    @Override
    public String getDisplayName(Player player) {
        return super.getDisplayName(player) + (isLit() ? I18n.translate(player, Messages.FLOWER.CANDLE_LIT_INDICATOR) : "");
    }

    @Override
    public JsonObject serialize() {
        JsonObject serialize = super.serialize();
        serialize.addProperty("lit", this.lit);
        return serialize;
    }

    public boolean isLit() {
        return lit;
    }
}