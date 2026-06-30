package me.vixxel.chatcolor.listeners;

import me.vixxel.chatcolor.ChatColorPlugin;
import me.vixxel.chatcolor.enums.ChatColorType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;


public class GUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        // Make sure we're in our GUI
        if (!event.getView().getTitle().equals("§dChat Colors")) {
            return;
        }

        // Prevent players from taking items
        event.setCancelled(true);

        // Make sure it's a player
        if (!(event.getWhoClicked() instanceof Player player)) {
            return;
        }

        // Make sure an item was clicked
        ItemStack item = event.getCurrentItem();

        if (item == null || item.getType() == Material.AIR) {
            return;
        }

        // Check every chat color
        for (ChatColorType color : ChatColorType.values()) {

            // Did they click this wool?
            if (item.getType() == color.getWool()) {

                // Check permission
                if (!player.hasPermission(color.getPermission())) {
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this chat color.");
                    return;
                }

                // Save the player's selected color
                ChatColorPlugin.getInstance()
                        .getPlayerDataManager()
                        .setColor(player.getUniqueId(), color);

                // Tell them it worked
                player.sendMessage(ChatColor.GREEN +
                        "You selected " +
                        color.getChatColor() +
                        color.getDisplayName());

                // Close the inventory
                player.closeInventory();

                return;
            }
        }
    }
}