package cm.ptks.craftflowers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MetricsLite {
   public static final int B_STATS_VERSION = 1;
   private static final String URL = "https://bStats.org/submitData/bukkit";
   private static boolean logFailedRequests;
   private static String serverUUID;
   private final JavaPlugin plugin;

   static {
      if (System.getProperty("bstats.relocatecheck") == null || !System.getProperty("bstats.relocatecheck").equals("false")) {
         String defaultPackage = new String(new byte[]{111, 114, 103, 46, 98, 115, 116, 97, 116, 115, 46, 98, 117, 107, 107, 105, 116});
         String examplePackage = new String(new byte[]{121, 111, 117, 114, 46, 112, 97, 99, 107, 97, 103, 101});
         if (MetricsLite.class.getPackage().getName().equals(defaultPackage) || MetricsLite.class.getPackage().getName().equals(examplePackage)) {
            throw new IllegalStateException("bStats Metrics class has not been relocated correctly!");
         }
      }

   }

   public MetricsLite(JavaPlugin plugin) {
      if (plugin == null) {
         throw new IllegalArgumentException("Plugin cannot be null!");
      } else {
         this.plugin = plugin;
         File bStatsFolder = new File(plugin.getDataFolder().getParentFile(), "bStats");
         File configFile = new File(bStatsFolder, "config.yml");
         YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
         if (!config.isSet("serverUuid")) {
            config.addDefault("enabled", true);
            config.addDefault("serverUuid", UUID.randomUUID().toString());
            config.addDefault("logFailedRequests", false);
            config.options().header("bStats collects some data for plugin authors like how many servers are using their plugins.\nTo honor their work, you should not disable it.\nThis has nearly no effect on the server performance!\nCheck out https://bStats.org/ to learn more :)").copyDefaults(true);

            try {
               config.save(configFile);
            } catch (IOException var9) {
            }
         }

         serverUUID = config.getString("serverUuid");
         logFailedRequests = config.getBoolean("logFailedRequests", false);
         if (config.getBoolean("enabled", true)) {
            boolean found = false;
            Iterator var7 = Bukkit.getServicesManager().getKnownServices().iterator();

            while(var7.hasNext()) {
               Class service = (Class)var7.next();

               try {
                  service.getField("B_STATS_VERSION");
                  found = true;
                  break;
               } catch (NoSuchFieldException var10) {
               }
            }

            Bukkit.getServicesManager().register(MetricsLite.class, this, plugin, ServicePriority.Normal);
            if (!found) {
               this.startSubmitting();
            }
         }

      }
   }

   private void startSubmitting() {
      final Timer timer = new Timer(true);
      timer.scheduleAtFixedRate(new TimerTask() {
         public void run() {
            if (!MetricsLite.this.plugin.isEnabled()) {
               timer.cancel();
            } else {
               Bukkit.getScheduler().runTask(MetricsLite.this.plugin, new Runnable() {
                  public void run() {
                     MetricsLite.this.submitData();
                  }
               });
            }
         }
      }, 300000L, 1800000L);
   }

   public JSONObject getPluginData() {
      JSONObject data = new JSONObject();
      String pluginName = this.plugin.getDescription().getName();
      String pluginVersion = this.plugin.getDescription().getVersion();
      data.put("pluginName", pluginName);
      data.put("pluginVersion", pluginVersion);
      JSONArray customCharts = new JSONArray();
      data.put("customCharts", customCharts);
      return data;
   }

   private JSONObject getServerData() {
      int playerAmount;
      try {
         Method onlinePlayersMethod = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers");
         playerAmount = onlinePlayersMethod.getReturnType().equals(Collection.class) ? ((Collection)onlinePlayersMethod.invoke(Bukkit.getServer())).size() : ((Player[])onlinePlayersMethod.invoke(Bukkit.getServer())).length;
      } catch (Exception var10) {
         playerAmount = Bukkit.getOnlinePlayers().size();
      }

      int onlineMode = Bukkit.getOnlineMode() ? 1 : 0;
      String bukkitVersion = Bukkit.getVersion();
      bukkitVersion = bukkitVersion.substring(bukkitVersion.indexOf("MC: ") + 4, bukkitVersion.length() - 1);
      String javaVersion = System.getProperty("java.version");
      String osName = System.getProperty("os.name");
      String osArch = System.getProperty("os.arch");
      String osVersion = System.getProperty("os.version");
      int coreCount = Runtime.getRuntime().availableProcessors();
      JSONObject data = new JSONObject();
      data.put("serverUUID", serverUUID);
      data.put("playerAmount", playerAmount);
      data.put("onlineMode", onlineMode);
      data.put("bukkitVersion", bukkitVersion);
      data.put("javaVersion", javaVersion);
      data.put("osName", osName);
      data.put("osArch", osArch);
      data.put("osVersion", osVersion);
      data.put("coreCount", coreCount);
      return data;
   }

   private void submitData() {
      final JSONObject data = this.getServerData();
      JSONArray pluginData = new JSONArray();
      Iterator var4 = Bukkit.getServicesManager().getKnownServices().iterator();

      while(var4.hasNext()) {
         Class service = (Class)var4.next();

         try {
            service.getField("B_STATS_VERSION");
            Iterator var6 = Bukkit.getServicesManager().getRegistrations(service).iterator();

            while(var6.hasNext()) {
               RegisteredServiceProvider provider = (RegisteredServiceProvider)var6.next();

               try {
                  pluginData.add(provider.getService().getMethod("getPluginData").invoke(provider.getProvider()));
               } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NullPointerException var8) {
               }
            }
         } catch (NoSuchFieldException var9) {
         }
      }

      data.put("plugins", pluginData);
      (new Thread(new Runnable() {
         public void run() {
            try {
               MetricsLite.sendData(data);
            } catch (Exception var2) {
               if (MetricsLite.logFailedRequests) {
                  MetricsLite.this.plugin.getLogger().log(Level.WARNING, "Could not submit plugin stats of " + MetricsLite.this.plugin.getName(), var2);
               }
            }

         }
      })).start();
   }

   private static void sendData(JSONObject data) throws Exception {
      if (data == null) {
         throw new IllegalArgumentException("Data cannot be null!");
      } else if (Bukkit.isPrimaryThread()) {
         throw new IllegalAccessException("This method must not be called from the main thread!");
      } else {
         HttpsURLConnection connection = (HttpsURLConnection)(new URL("https://bStats.org/submitData/bukkit")).openConnection();
         byte[] compressedData = compress(data.toString());
         connection.setRequestMethod("POST");
         connection.addRequestProperty("Accept", "application/json");
         connection.addRequestProperty("Connection", "close");
         connection.addRequestProperty("Content-Encoding", "gzip");
         connection.addRequestProperty("Content-Length", String.valueOf(compressedData.length));
         connection.setRequestProperty("Content-Type", "application/json");
         connection.setRequestProperty("User-Agent", "MC-Server/1");
         connection.setDoOutput(true);
         DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
         outputStream.write(compressedData);
         outputStream.flush();
         outputStream.close();
         connection.getInputStream().close();
      }
   }

   private static byte[] compress(String str) throws IOException {
      if (str == null) {
         return null;
      } else {
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         GZIPOutputStream gzip = new GZIPOutputStream(outputStream);
         gzip.write(str.getBytes("UTF-8"));
         gzip.close();
         return outputStream.toByteArray();
      }
   }
}
