package cm.ptks.craftflowers.languages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fastasyncworldedit.core.configuration.file.YamlConfiguration;

public class Language {
    
    private Map<String, String> keys;
    private String locale;
    private List<String> localeAliases;

    public Language(Map<String, String> keys, String locale) {
        this.keys = keys;
        this.locale = locale;
        this.localeAliases = new ArrayList<>();
    }

    public void addAliases(List<String> list) {
        this.localeAliases.addAll(list);
    }

    public boolean isLanguage(String locale) {
        return this.locale.contains(locale) || this.localeAliases.contains(locale);
    }

    public static Map<String, String> parseKeys(YamlConfiguration configuration) {
        Map<String, String> keys = new HashMap<>();

        for(String str : configuration.getKeys(true)) {
            if(configuration.isString(str)) {
                keys.put(str, configuration.getString(str));
            }
        }

        return keys;
    }

    public String translate(String key) {
        if(keys.containsKey(key))
            return keys.get(key);
        return key;
    }

}
