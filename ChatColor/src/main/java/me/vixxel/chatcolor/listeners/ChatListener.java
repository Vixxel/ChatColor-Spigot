package me.vixxel.chatcolor.listeners;

import me.vixxel.chatcolor.ChatColorPlugin;
import me.vixxel.chatcolor.enums.ChatColorType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        ChatColorType color = ChatColorPlugin.getInstance()
                .getPlayerDataManager()
                .getColor(event.getPlayer().getUniqueId());

        event.setMessage(color.getChatColor() + event.getMessage());

    }
}