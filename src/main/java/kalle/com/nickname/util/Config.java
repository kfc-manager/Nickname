package kalle.com.nickname.util;

import kalle.com.nickname.Nickname;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Config {

    private static Nickname plugin;

    private static FileConfiguration config;
    private static File file;

    public Config(Nickname plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        file = new File(plugin.getDataFolder(), "nickname.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.GREEN + " nickname.yml file has been created!");
            } catch (IOException e) {
                plugin.getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.RED + " CONFIG ERROR: could not create nickname.yml file!");
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public static void save() {
        try {
            config.save(file);
            config = YamlConfiguration.loadConfiguration(file);
        } catch (IOException e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.RED + " CONFIG ERROR: could not save nickname.yml file!");
        }
    }

    public static String getNick(Player player) {
        String uuid = player.getUniqueId().toString();
        try {
            if (config.get(uuid) != null) {
                config.set(uuid + ".Account Name", player.getName()); //in case player changed his account name to keep the entries up to date
                save();
                return config.get(uuid + ".Nickname").toString();
            }
        } catch (NullPointerException e) {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.RED + " CONFIG ERROR: could not read nickname.yml file, an entry is corrupted!");
        }
        config.set(uuid + ".Account Name", player.getName());
        config.set(uuid + ".Nickname", player.getName());
        save();
        return player.getName();
    }

    public static void setNick(Player player, String nickname) {
        String uuid = player.getUniqueId().toString();
        config.set(uuid + ".Nickname", nickname);
        save();
    }

}
