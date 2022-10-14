package kalle.com.nickname.commands;

import kalle.com.nickname.Nickname;
import kalle.com.nickname.util.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NicknameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.RED + " You do not have the permission to execute this command!");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" +  ChatColor.RED + " The command requires at least one argument!");
            return false;
        }
        if (args.length > 2) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" +  ChatColor.RED + " The command accepts a maximum of two arguments!");
            return false;
        }
        if (args.length == 1) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Config.setNick(player, args[0]);
                Nickname.rename(player);
                sender.sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.GREEN + " Your nickname has been changed to " + ChatColor.GOLD + args[0] + ChatColor.GREEN + "!");
                return true;
            }
            //args length is 1 and sender is the console (can not change nickname of console)
            sender.sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.RED + " If executed by the console, the command requires two arguments!");
            return false;
        }
        //args length is 2:
        for (Player online : Bukkit.getOnlinePlayers()) {
            if (online.getName().equals(args[1])) {
                Config.setNick(online, args[0]);
                Nickname.rename(online);
                sender.sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.GREEN + " The nickname of " + ChatColor.GOLD + args[1]
                        + ChatColor.GREEN + " has been changed to " + ChatColor.GOLD + args[0] + ChatColor.GREEN + "!");
                return true;
            }
        }
        //specified player with name == args[1] has not been found
        sender.sendMessage(ChatColor.DARK_PURPLE + "[Nickname]" + ChatColor.RED + " The player " + ChatColor.GOLD + args[1] + ChatColor.RED + " is not online!");
        return true;
    }

}
