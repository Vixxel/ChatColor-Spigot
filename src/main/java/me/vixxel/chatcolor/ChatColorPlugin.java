package me.vixxel.chatcolor;

import me.vixxel.chatcolor.commands.ChatColorCommand;
import me.vixxel.chatcolor.listeners.ChatListener;
import me.vixxel.chatcolor.listeners.GUIListener;
import me.vixxel.chatcolor.managers.ConfigManager;
import me.vixxel.chatcolor.managers.PlayerDataManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatColorPlugin extends JavaPlugin {

    // Plugin instance
    private static ChatColorPlugin instance;

    // Managers
    private ConfigManager configManager;
    private PlayerDataManager playerDataManager;

    @Override
    public void onEnable() {

        // Plugin instance
        instance = this;

        // Create default config if needed
        saveDefaultConfig();

        // Initialize managers
        configManager = new ConfigManager(this);
        playerDataManager = new PlayerDataManager(this);

        // Register command
        getCommand("chatcolor").setExecutor(new ChatColorCommand());

        // Register listeners
        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        getLogger().info("==================================");
        getLogger().info("ChatColor has been enabled!");
        getLogger().info("Developed by Vixxel");
        getLogger().info("==================================");
    }

    @Override
    public void onDisable() {
        getLogger().info("ChatColor has been disabled!");
    }

    public static ChatColorPlugin getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public PlayerDataManager getPlayerDataManager() {
        return playerDataManager;
    }
}