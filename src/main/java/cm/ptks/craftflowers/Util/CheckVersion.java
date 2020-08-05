package cm.ptks.craftflowers.Util;

import cm.ptks.craftflowers.Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class CheckVersion {
   float newestVersion = Float.parseFloat(this.getNewestVersion());
   float currentVersion;

   public CheckVersion() {
      this.currentVersion = Float.parseFloat(Main.plugin.getDescription().getVersion());
   }

   public String getNewestVersion() {
      try {
         HttpsURLConnection con = (HttpsURLConnection)(new URL("https://api.spigotmc.org/legacy/update.php?resource=49451")).openConnection();
         con.setDoOutput(true);
         con.setRequestMethod("GET");
         String version = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();
         con.disconnect();
         return version;
      } catch (Exception var3) {
         var3.printStackTrace();
         Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "[craftFlowers] " + ChatColor.RED + "Failed to check for an update on Spigot.");
         return Main.plugin.getDescription().getVersion();
      }
   }

   public boolean isUpdated() {
      return this.currentVersion == this.newestVersion;
   }

   public boolean isOutdated() {
      return this.currentVersion < this.newestVersion;
   }
}
