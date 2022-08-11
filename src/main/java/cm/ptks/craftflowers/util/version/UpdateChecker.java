package cm.ptks.craftflowers.util.version;

import cm.ptks.craftflowers.CraftFlowers;
import cm.ptks.craftflowers.storage.LanguageFile;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UpdateChecker {

	private FlowersVersion newestVersion = fetchNewestVersion();
	private final FlowersVersion currentVersion;

	private final CraftFlowers plugin;

	public UpdateChecker(CraftFlowers plugin) {
		this.plugin = plugin;
		this.currentVersion = FlowersVersion.read(plugin.getDescription().getVersion());

		plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, () -> this.newestVersion = fetchNewestVersion(),
				TimeUnit.HOURS.toSeconds(24) * 20, TimeUnit.HOURS.toSeconds(24) * 20);
	}

	public FlowersVersion fetchNewestVersion() {
		try {
			HttpsURLConnection con = (HttpsURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=82407")).openConnection();
			con.setDoOutput(true);
			con.setRequestMethod("GET");
			String version = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
			con.disconnect();
			return FlowersVersion.read(version);
		} catch (Exception var3) {
			var3.printStackTrace();
			Bukkit.getServer().getConsoleSender().sendMessage(CraftFlowers.prefix + ChatColor.RED + LanguageFile.ACTION_FAILED_CHECK_VERSION);
			return FlowersVersion.read(plugin.getDescription().getVersion());
		}
	}

	public FlowersVersion getNewestVersion() {
		return newestVersion;
	}

	public boolean isUpdated() {
		return this.currentVersion.equals(getNewestVersion());
	}

	public boolean isOutdated() {
		return this.currentVersion.isOlder(this.newestVersion);
	}
}
