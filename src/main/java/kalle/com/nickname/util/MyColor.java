package kalle.com.nickname.util;

import org.bukkit.ChatColor;

/**
 * Needed so we can get the color by string, otherwise we need the char of the color.
 * With this we can save Color: BLUE with the String: BLUE in the config file.
 */
public enum MyColor {

    AQUA(ChatColor.AQUA),
    BLACK(ChatColor.BLACK),
    BLUE(ChatColor.BLUE),
    DARK_AQUA(ChatColor.DARK_AQUA),
    DARK_BLUE(ChatColor.DARK_BLUE),
    DARK_GRAY(ChatColor.DARK_GRAY),
    DARK_GREEN(ChatColor.DARK_GREEN),
    DARK_PURPLE(ChatColor.DARK_PURPLE),
    DARK_RED(ChatColor.DARK_RED),
    GOLD(ChatColor.GOLD),
    GRAY(ChatColor.GRAY),
    GREEN(ChatColor.GREEN),
    LIGHT_PURPLE(ChatColor.LIGHT_PURPLE),
    RED(ChatColor.RED),
    WHITE(ChatColor.WHITE),
    YELLOW(ChatColor.YELLOW);

    private ChatColor color;

    MyColor(ChatColor color) {
        this.color = color;
    }

    public ChatColor getColor() {
        return color;
    }

}
