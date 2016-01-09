package me.jdog.motd.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.jdog.motd.Custom;
import me.jdog.motd.api.ActionBarAPI;

public class PlayerActionbar implements Listener {
	
	private Custom plugin;
	
	public PlayerActionbar(Custom pl) {
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
