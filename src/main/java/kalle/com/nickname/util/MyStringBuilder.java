package kalle.com.nickname.util;

import org.bukkit.entity.Player;

public class MyStringBuilder {

    public static String buildMsg(Player player, String msg) {
        char[] cMsg = msg.toCharArray();
        String color = extractColor(cMsg);
        char[] accountName = (color + player.getName()).toCharArray();
        String[] components = new String[3];
        components[0] = color;
        components[1] = Config.getNick(player);
        components[2] = extractMsg(accountName, cMsg);
        return components[0] + components[1] + components[2];
    }

    public static String extractColor(char[] msg) {
        if (Character.getNumericValue(msg[0]) != -1) return ""; //message is not color coded

        String result = "" + msg[0] + msg[1];
        return result;
    }

    public static String extractMsg(char[] accountName, char[] msg) {
        String result = "";
        for(int i = accountName.length ; i < msg.length ; i++) {
            result += msg[i];
        }
        return result;
    }

}
