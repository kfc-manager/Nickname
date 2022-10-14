package kalle.com.nickname.events;

import kalle.com.nickname.Nickname;
import kalle.com.nickname.util.MyStringBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NCPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String msg = event.getJoinMessage();
        event.setJoinMessage(MyStringBuilder.buildMsg(player, msg));
        Nickname.rename(player);
    }

}
