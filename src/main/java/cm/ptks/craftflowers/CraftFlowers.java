package cm.ptks.craftflowers;

import cm.ptks.craftflowers.commands.CraftFlowersCommand;
import cm.ptks.craftflowers.listeners.*;
import cm.ptks.craftflowers.util.version.CheckVersion;
import cm.ptks.craftflowers.util.GuiGenerator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class CraftFlowers extends JavaPlugin {
    public static CraftFlowers plugin;

    private GuiGenerator generator;
    private CheckVersion versionChecker;

    public void onEnable() {
        plugin = this;
        this.generator = new GuiGenerator(this);
        this.versionChecker = new CheckVersion();
        if (this.isFAWE()) {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "------------------[craftFlowers]------------------");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    FastAsyncWorldEdit was found");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "    craftFlowers v" + this.getDescription().getVersion() + " has been enabled.");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "--------------------------------------------------");
            new MetricsLite(this);
            this.registerListener();
            this.registerCommands();
            this.checkYmls();

            if (versionChecker.isOutdated()) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "------------------[craftFlowers]------------------");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "    Plugin is outdated!");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "    Current version: " + ChatColor.RED + this.getDescription().getVersion() + ChatColor.DARK_GREEN + " The newest version: " + ChatColor.GREEN + this.versionChecker.getNewestVersion());
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Download new version: " + ChatColor.YELLOW + "https://www.spigotmc.org/resources/craftflowers-1-16-port-allowed-by-main-developer.82407/");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "--------------------------------------------------");
            }
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "------------------[craftFlowers]------------------");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "    FastAsyncWorldEdit not found");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "    craftFlowers has been disabled.");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "Download FAWE: " + ChatColor.YELLOW + "https://goo.gl/sVxZrg");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "--------------------------------------------------");
            Bukkit.getServer().getPluginManager().disablePlugin(this);
        }

    }

    public CheckVersion getVersionChecker() {
        return versionChecker;
    }

    public GuiGenerator getGenerator() {
        return generator;
    }

    private void registerListener() {
        Bukkit.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LeftClickListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new SwapHandListener(), this);
    }

    private void registerCommands() {
        this.getCommand("craftflowers").setExecutor(new CraftFlowersCommand());
    }

    public void checkYmls() {
        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }

        if (!(new File(this.getDataFolder(), "flowers.yml")).exists()) {
            try {
                (new File(this.getDataFolder(), "flowers.yml")).createNewFile();
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "------------------[craftFlowers]------------------");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "    flowers.yml not found");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "    File has been created");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "--------------------------------------------------");
            } catch (IOException var2) {
                var2.printStackTrace();
            }
        }

    }

    public boolean isFAWE() {
        return Bukkit.getServer().getPluginManager().getPlugin("FastAsyncWorldEdit") != null;
    }
}
