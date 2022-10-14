package kalle.com.nickname.events;

import kalle.com.nickname.util.MyStringBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class NCPlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String msg = event.getQuitMessage();
        event.setQuitMessage(MyStringBuilder.buildMsg(player, msg));
    }
}
