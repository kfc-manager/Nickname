package kalle.com.nickname;

import kalle.com.nickname.commands.NicknameCommand;
import kalle.com.nickname.events.NCPlayerDeath;
import kalle.com.nickname.events.NCPlayerJoin;
import kalle.com.nickname.events.NCPlayerQuit;
import kalle.com.nickname.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Nickname extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Config config = new Config(this);
        config.setup();
        registerEvents();
        registerCommands();
        //in case of a server reload updates all online player names
        for (Player online : Bukkit.getOnlinePlayers()) {
            String nickname = config.getNick(online);
            online.setDisplayName(nickname);
            online.setPlayerListName(nickname);
        }
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.GREEN + " Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.RED + " Plugin has been disabled!");
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new NCPlayerDeath(),this);
        getServer().getPluginManager().registerEvents(new NCPlayerJoin(),this);
        getServer().getPluginManager().registerEvents(new NCPlayerQuit(), this);
    }

    public void registerCommands() {
        getCommand("nickname").setExecutor(new NicknameCommand());
    }

    public static void rename(Player player) {
        String nickname = Config.getNick(player);
        player.setDisplayName(nickname);
        player.setPlayerListName(nickname);
    }

}
