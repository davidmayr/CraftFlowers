package cm.ptks.craftflowers.util.version;

import cm.ptks.craftflowers.CraftFlowers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class CheckVersion {

    private final FlowersVersion newestVersion = getNewestVersion();
    private final FlowersVersion currentVersion;
    private long lastUpdate = 0L;

    public CheckVersion() {
        this.currentVersion = FlowersVersion.read(CraftFlowers.plugin.getDescription().getVersion());
    }

    public FlowersVersion getNewestVersion() {
        if(newestVersion != null && (System.currentTimeMillis() - lastUpdate) < 18000000) {
            return newestVersion;
        }
        try {
            HttpsURLConnection con = (HttpsURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=82407")).openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            String version = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
            this.lastUpdate = System.currentTimeMillis();
            con.disconnect();
            return FlowersVersion.read(version);
        } catch (Exception var3) {
            var3.printStackTrace();
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Failed to check for an update on Spigot.");
            return FlowersVersion.read(CraftFlowers.plugin.getDescription().getVersion());
        }
    }

    public boolean isUpdated() {
        return this.currentVersion.equals(getNewestVersion());
    }

    public boolean isOutdated() {
        return this.currentVersion.isOlder(this.newestVersion);
    }
}
