package me.vixxel.chatcolor.enums;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum ChatColorType {

    BLACK("Black", ChatColor.BLACK, Material.BLACK_WOOL, "chatcolor.black", 10),
    DARK_BLUE("Dark Blue", ChatColor.DARK_BLUE, Material.BLUE_WOOL, "chatcolor.darkblue", 11),
    DARK_GREEN("Dark Green", ChatColor.DARK_GREEN, Material.GREEN_WOOL, "chatcolor.darkgreen", 12),
    DARK_AQUA("Dark Aqua", ChatColor.DARK_AQUA, Material.CYAN_WOOL, "chatcolor.darkaqua", 13),
    DARK_RED("Dark Red", ChatColor.DARK_RED, Material.RED_WOOL, "chatcolor.darkred", 14),
    DARK_PURPLE("Dark Purple", ChatColor.DARK_PURPLE, Material.PURPLE_WOOL, "chatcolor.darkpurple", 15),
    GOLD("Gold", ChatColor.GOLD, Material.ORANGE_WOOL, "chatcolor.gold", 16),

    GRAY("Gray", ChatColor.GRAY, Material.LIGHT_GRAY_WOOL, "chatcolor.gray", 19),
    DARK_GRAY("Dark Gray", ChatColor.DARK_GRAY, Material.GRAY_WOOL, "chatcolor.darkgray", 20),
    BLUE("Blue", ChatColor.BLUE, Material.LIGHT_BLUE_WOOL, "chatcolor.blue", 21),
    GREEN("Green", ChatColor.GREEN, Material.LIME_WOOL, "chatcolor.green", 22),
    AQUA("Aqua", ChatColor.AQUA, Material.CYAN_WOOL, "chatcolor.aqua", 23),
    RED("Red", ChatColor.RED, Material.RED_WOOL, "chatcolor.red", 24),

    LIGHT_PURPLE("Light Purple", ChatColor.LIGHT_PURPLE, Material.PINK_WOOL, "chatcolor.pink", 28),
    YELLOW("Yellow", ChatColor.YELLOW, Material.YELLOW_WOOL, "chatcolor.yellow", 29),
    WHITE("White", ChatColor.WHITE, Material.WHITE_WOOL, "chatcolor.white", 30);

    private final String displayName;
    private final ChatColor chatColor;
    private final Material wool;
    private final String permission;
    private final int slot;

    ChatColorType(String displayName,
                  ChatColor chatColor,
                  Material wool,
                  String permission,
                  int slot) {

        this.displayName = displayName;
        this.chatColor = chatColor;
        this.wool = wool;
        this.permission = permission;
        this.slot = slot;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public Material getWool() {
        return wool;
    }

    public String getPermission() {
        return permission;
    }

    public int getSlot() {
        return slot;
    }
}