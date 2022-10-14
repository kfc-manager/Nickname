package kalle.com.nickname.events;

import kalle.com.nickname.util.MyStringBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class NCPlayerDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        String msg = event.getDeathMessage();
        event.setDeathMessage(MyStringBuilder.buildMsg(player, msg));
    }

}
