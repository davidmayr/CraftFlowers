package cm.ptks.craftflowers.languages;

import java.util.ArrayList;
import java.util.List;

import cm.ptks.craftflowers.CraftFlowers;

public class LanguageManager {
    
    private final CraftFlowers plugin;
    private final List<Language> languages = new ArrayList<>();

    public LanguageManager(CraftFlowers plugin) {
        this.plugin = plugin;
    
        for(String language : plugin.getConfig().getStringList("language.list")) {

        }
    }

    


}
