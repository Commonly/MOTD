package me.jdog.motd.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.jdog.motd.Custom;

public class PlayerMOTD implements Listener {
	
	private Custom plugin;
	
	public PlayerMOTD(Custom pl) {
		plugin = pl;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		String welcomeMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("WelcomeMessage"));
		
		if (plugin.getConfig().getBoolean("ShowMessage")==true) {
			p.sendMessage(welcomeMessage);
		}
		else {
			return;
		}
		
	}
}
