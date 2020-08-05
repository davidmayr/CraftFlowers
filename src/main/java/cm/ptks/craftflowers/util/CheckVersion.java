package cm.ptks.craftflowers.util;

import cm.ptks.craftflowers.CraftFlowers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class CheckVersion {

    float newestVersion = Float.parseFloat(this.getNewestVersion());
    float currentVersion;

    public CheckVersion() {
        this.currentVersion = Float.parseFloat(CraftFlowers.plugin.getDescription().getVersion());
    }

    public String getNewestVersion() {
        try {
            HttpsURLConnection con = (HttpsURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=49451")).openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            String version = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
            con.disconnect();
            return version;
        } catch (Exception var3) {
            var3.printStackTrace();
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Failed to check for an update on Spigot.");
            return CraftFlowers.plugin.getDescription().getVersion();
        }
    }

    public boolean isUpdated() {
        return this.currentVersion == this.newestVersion;
    }

    public boolean isOutdated() {
        return this.currentVersion < this.newestVersion;
    }
}
