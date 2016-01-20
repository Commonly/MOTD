package me.jdog.motd.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.jdog.motd.MOTD;
import me.jdog.motd.api.MessageAPI;

public class PlayerMOTD implements Listener {
	
	private MOTD plugin;
	
	public PlayerMOTD(MOTD pl) {
		plugin = pl;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		String welcomeMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("WelcomeMessage"));
		
		if (plugin.getConfig().getBoolean("ShowMessage")==true) {
			MessageAPI.sendMessage(p, welcomeMessage);
		}
		else {
			return;
		}
		
	}
}
