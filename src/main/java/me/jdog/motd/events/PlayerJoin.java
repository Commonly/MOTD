package me.jdog.motd.events;

import com.connorlinfoot.bountifulapi.Actionbar;
import com.connorlinfoot.titleapi.TitleAPI;
import me.jdog.motd.MOTD;
import me.jdog.murapi.api.Color;
import me.jdog.murapi.api.Title;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Muricans on 9/25/17.
 */
public class PlayerJoin implements Listener {

    private MOTD motd;

    public PlayerJoin(MOTD motd) {
        this.motd = motd;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(motd.getConfig().getBoolean("actionbar.use")) {
            Actionbar.sendActionBar(p, Color.addColor("actionbar.message", motd).replace("%player%", p.getName()));
        }

        if(motd.getConfig().getBoolean("motd.use")) {
            p.sendMessage(Color.addColor("motd.message", motd).replace("%player%", p.getName()));
        }

        if(motd.getConfig().getBoolean("join.showplayerjoinmessage")) {
            e.setJoinMessage(Color.addColor("join.playerjoinmessage", motd).replace("%player%", p.getName()));
        }

        if(motd.getConfig().getBoolean("title.use")) {
            Title.sendTitle(p, "l", 10, 5 * 10, 10);
        }
    }
}
