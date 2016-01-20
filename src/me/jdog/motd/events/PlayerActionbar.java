package me.jdog.motd.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.jdog.motd.MOTD;
import me.jdog.motd.api.ActionBarAPI;

public class PlayerActionbar implements Listener {
	
	private MOTD plugin;
	
	public PlayerActionbar(MOTD pl) {
		plugin = pl;
	}
	
	@EventHandler
	public void PlayerActionbarEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String actionMsg = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("ActionBarMsg"));
		
		if(plugin.getConfig().getBoolean("ShowActionbar")==true) {
			ActionBarAPI.sendActionBar(p, actionMsg);
		}
		else {
			return;
		}
		
	}
}
