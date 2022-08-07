package cm.ptks.craftflowers.storage;

import cm.ptks.craftflowers.CraftFlowers;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStreamReader;

public class LanguageFile {
	public static void LoadLanguageFile() {
		CraftFlowers instance = CraftFlowers.getInstance();

		String path = "language.yml";

		File languageFile = new File(instance.getDataFolder(), path);

		if (!languageFile.exists()) {
			instance.saveResource(path, false);
		}

		YamlConfiguration defaultLanguage = YamlConfiguration.loadConfiguration(new InputStreamReader(instance.getResource(path)));

		YamlConfiguration language = YamlConfiguration.loadConfiguration(languageFile);

		language.addDefaults(defaultLanguage);
		

	}
}
