package me.vixxel.chatcolor.gui;

import me.vixxel.chatcolor.enums.ChatColorType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChatColorGUI {

    public static void open(Player player) {

        Inventory gui = Bukkit.createInventory(
                null,
                45,
                "§dChat Colors"
        );

        // ===== Border =====

        ItemStack border = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta borderMeta = border.getItemMeta();

        borderMeta.setDisplayName(" ");
        border.setItemMeta(borderMeta);

        int[] borderSlots = {
                0,1,2,3,4,5,6,7,8,
                9,17,
                18,26,
                27,35,
                36,37,38,39,40,41,42,43,44
        };

        for (int slot : borderSlots) {
            gui.setItem(slot, border);
        }

        // ===== Chat Colors =====

        for (ChatColorType color : ChatColorType.values()) {

            ItemStack item;

            // Player has permission
            if (player.hasPermission(color.getPermission()) || player.hasPermission("chatcolor.*")) {

                item = new ItemStack(color.getWool());

                ItemMeta meta = item.getItemMeta();

                meta.setDisplayName(color.getChatColor() + color.getDisplayName());

                meta.setLore(java.util.List.of(
                        "§7Permission:",
                        "§f" + color.getPermission(),
                        "",
                        "§a✔ Click to select"
                ));

                item.setItemMeta(meta);

            }

            // Player does not have permission
            else {

                item = new ItemStack(Material.BARRIER);

                ItemMeta meta = item.getItemMeta();

                meta.setDisplayName("§c" + color.getDisplayName());

                meta.setLore(java.util.List.of(
                        "§7You do not have permission",
                        "§7to use this color.",
                        "",
                        "§7Required:",
                        "§c" + color.getPermission()
                ));

                item.setItemMeta(meta);

            }

            gui.setItem(color.getSlot(), item);

        }

        player.openInventory(gui);

    }

}