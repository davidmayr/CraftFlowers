package cm.ptks.craftflowers.languages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.fastasyncworldedit.core.configuration.file.YamlConfiguration;

import cm.ptks.craftflowers.CraftFlowers;

public class LanguageManager {
    
    private final CraftFlowers plugin;
    private final List<Language> languages = new ArrayList<>();

    public LanguageManager(CraftFlowers plugin) {
        this.plugin = plugin;
    
        for(String language : plugin.getConfig().getStringList("language.list")) {
            File languageFile = new File(plugin.getDataFolder(), "lang/" + language + ".yml");

            if(!languageFile.exists()) {
                InputStream inputStream = plugin.getResource("lang/" + language + ".yml");
                if(inputStream == null) {
                    plugin.getLogger().warning("Failed to load or copy " + language + "...");
                    continue;
                }
                languageFile.getParentFile().mkdirs();
                
                try {
                    languageFile.createNewFile();
                } catch (IOException e) {
                    plugin.getLogger().log(Level.SEVERE, "Failed to create language file for " + language + "...", e);
                    continue;
                }
                try (FileOutputStream os = new FileOutputStream(languageFile)) {
                    os.write(inputStream.readAllBytes());
                    inputStream.close();
                } catch (IOException e) {
                    plugin.getLogger().log(Level.SEVERE, "Failed to load or copy " + language + "...", e);
                    continue;
                }
            }
            YamlConfiguration configuration = YamlConfiguration.loadConfiguration(languageFile);
            this.languages.add(new Language(Language.parseKeys(configuration), language));

        }
    }

    


}
