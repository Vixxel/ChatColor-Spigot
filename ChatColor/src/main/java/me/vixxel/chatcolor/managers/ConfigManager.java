package me.vixxel.chatcolor.managers;

import me.vixxel.chatcolor.ChatColorPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private final ChatColorPlugin plugin;

    private File playersFile;
    private FileConfiguration playersConfig;

    public ConfigManager(ChatColorPlugin plugin) {
        this.plugin = plugin;
        setupPlayersFile();
    }

    private void setupPlayersFile() {

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        playersFile = new File(plugin.getDataFolder(), "players.yml");

        if (!playersFile.exists()) {
            plugin.saveResource("players.yml", false);
        }

        playersConfig = YamlConfiguration.loadConfiguration(playersFile);
    }

    public FileConfiguration getPlayersConfig() {
        return playersConfig;
    }

    public void savePlayersConfig() {

        try {
            playersConfig.save(playersFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void reloadPlayersConfig() {
        playersConfig = YamlConfiguration.loadConfiguration(playersFile);
    }

}