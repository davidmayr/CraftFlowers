package cm.ptks.craftflowers.util;

import cm.ptks.craftflowers.CraftFlowers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class CheckVersion {

    private String newestVersion = getNewestVersion();
    private String currentVersion;
    private long lastUpdate = 0L;

    public CheckVersion() {
        this.currentVersion = CraftFlowers.plugin.getDescription().getVersion();
    }

    public String getNewestVersion() {
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
            return version;
        } catch (Exception var3) {
            var3.printStackTrace();
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Failed to check for an update on Spigot.");
            return CraftFlowers.plugin.getDescription().getVersion();
        }
    }

    public boolean isUpdated() {
        return this.currentVersion.equals(getNewestVersion());
    }

    public boolean isOutdated() {
        return Float.parseFloat(this.currentVersion) < Float.parseFloat(getNewestVersion());
    }
}
