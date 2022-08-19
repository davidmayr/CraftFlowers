package cm.ptks.craftflowers;

import cm.ptks.craftflowers.commands.CraftFlowersCommand;
import cm.ptks.craftflowers.languages.LanguageFile;
import cm.ptks.craftflowers.listeners.BlockPlaceListener;
import cm.ptks.craftflowers.listeners.LeftClickListener;
import cm.ptks.craftflowers.listeners.PlayerJoinListener;
import cm.ptks.craftflowers.storage.FlowerStorage;
import cm.ptks.craftflowers.storage.SqLiteStorage;
import cm.ptks.craftflowers.util.version.UpdateChecker;
import fr.minuskube.inv.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CraftFlowers extends JavaPlugin {

    private static InventoryManager inventoryManager;

    private static CraftFlowers instance;

    public static String prefix;
    public static String arrow;

    private UpdateChecker versionChecker;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private FlowerStorage flowerStorage;

    @Override
    public void onEnable() {
        instance = this;
        LanguageFile.LoadLanguageFile();

        CraftFlowers.inventoryManager = new InventoryManager(this);
        inventoryManager.init();
        saveDefaultConfig();

        CraftFlowers.prefix = ChatColor.translateAlternateColorCodes('&',
                Objects.requireNonNull(getConfig().getString("prefix")));
        CraftFlowers.arrow = ChatColor.translateAlternateColorCodes('&',
                Objects.requireNonNull(getConfig().getString("arrow")));

        if (Objects.equals(getConfig().getString("storage.type"), "sqlite")) {
            this.flowerStorage = new SqLiteStorage(new File(getDataFolder(), "database.db"));
        }

        this.versionChecker = new UpdateChecker(this);


        new Metrics(this, 2877);
        this.registerListener();
        this.registerCommands();


        if (versionChecker.isOutdated()) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            console.sendMessage(ChatColor.DARK_RED + "------------------[craftFlowers]------------------");
            console.sendMessage(ChatColor.RED + "    Plugin is outdated!");
            console.sendMessage(ChatColor.DARK_RED + "    Current version: " + ChatColor.RED + this.getDescription()
                    .getVersion() + ChatColor.DARK_GREEN + " The newest version: " + ChatColor.GREEN + this.versionChecker.getNewestVersion());
            console.sendMessage(ChatColor.GOLD + "Download new version: " + ChatColor.YELLOW
                    + "https://www.spigotmc.org/resources/craftflowers-1-16-port-allowed-by-main-developer.82407/");
            console.sendMessage(ChatColor.DARK_RED + "--------------------------------------------------");
        }
    }

    public static CraftFlowers getInstance() {
        return instance;
    }

    public FlowerStorage getFlowerStorage() {
        return flowerStorage;
    }

    @Override
    public void onDisable() {
        this.executorService.shutdown();
        this.flowerStorage.close();
    }

    public static InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public UpdateChecker getVersionChecker() {
        return versionChecker;
    }

    private void registerListener() {
        Bukkit.getServer().getPluginManager().registerEvents(new BlockPlaceListener(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LeftClickListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        // Bukkit.getServer().getPluginManager().registerEvents(new PlayerLocaleChangeListener(this), this);
    }

    private void registerCommands() {
        this.getCommand("craftflowers").setExecutor(new CraftFlowersCommand(this));
    }

    public boolean isSurvivalMode() {
        return getConfig().getBoolean("survivalMode");
    }

    public boolean isFAWE() {
        return Bukkit.getServer().getPluginManager().getPlugin("FastAsyncWorldEdit") != null;
    }
}