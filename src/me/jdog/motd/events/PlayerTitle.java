package me.jdog.motd.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

import me.jdog.motd.MOTD;

public class PlayerTitle implements Listener {
	
	private MOTD plugin;
	
	public PlayerTitle(MOTD pl) {
		plugin = pl;
	}
	
	@EventHandler
	public void PlayerTitleEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String tMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("HeaderMessage"));
		String sMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("FooterMessage"));
		
		if(plugin.getConfig().getBoolean("ShowTitle")==true) {
			TitleAPI.sendTitle(p,10,5 * 20,10,tMessage,sMessage);
		}
		else {
			return;
		}
	}

}
