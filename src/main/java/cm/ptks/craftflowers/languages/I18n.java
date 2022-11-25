package cm.ptks.craftflowers.languages;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import cm.ptks.craftflowers.CraftFlowers;

public class I18n {
    
    public static String translate(@Nullable Player player, String key) {
        return CraftFlowers.getInstance().getLanguageManager().getLanguage(player).translate(key);
    }

}
