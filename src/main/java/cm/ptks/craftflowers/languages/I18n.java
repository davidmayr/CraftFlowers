package cm.ptks.craftflowers.languages;

import org.bukkit.entity.Player;

import cm.ptks.craftflowers.CraftFlowers;

public class I18n {
    
    public static String translate(Player player, String key) {
        return CraftFlowers.getInstance().getLanguageManager().getLanguage(player).translate(key);
    }

}
