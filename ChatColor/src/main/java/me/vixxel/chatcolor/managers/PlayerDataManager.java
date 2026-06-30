package me.vixxel.chatcolor.managers;

import me.vixxel.chatcolor.ChatColorPlugin;
import me.vixxel.chatcolor.enums.ChatColorType;

import java.util.UUID;

public class PlayerDataManager {

    private final ChatColorPlugin plugin;

    public PlayerDataManager(ChatColorPlugin plugin) {
        this.plugin = plugin;
    }

    public void setColor(UUID uuid, ChatColorType color) {

        plugin.getConfigManager()
                .getPlayersConfig()
                .set("players." + uuid + ".color", color.name());

        plugin.getConfigManager().savePlayersConfig();

    }

    public ChatColorType getColor(UUID uuid) {

        String value = plugin.getConfigManager()
                .getPlayersConfig()
                .getString("players." + uuid + ".color");

        if (value == null) {
            return ChatColorType.WHITE;
        }

        try {
            return ChatColorType.valueOf(value);
        } catch (IllegalArgumentException e) {
            return ChatColorType.WHITE;
        }

    }

    public void removeColor(UUID uuid) {

        plugin.getConfigManager()
                .getPlayersConfig()
                .set("players." + uuid, null);

        plugin.getConfigManager().savePlayersConfig();

    }

}