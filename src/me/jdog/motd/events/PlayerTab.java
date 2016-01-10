package me.jdog.motd.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

import me.jdog.motd.Custom;

public class PlayerTab implements Listener {
	
	private Custom plugin;
	
	public PlayerTab(Custom pl) {
		plugin = pl;
	}
	
	@EventHandler
	public void PlayerTabEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String header = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("TabHeader"));
		String footer = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("TabFooter"));
		
		if(plugin.getConfig().getBoolean("ShowTab")==true) {
			TitleAPI.sendTabTitle(p, header, footer);
		}
		else {
			return;
		}
	}
	
	// Use to need extra plugin, I found the source of it and put it in my project. Enjoy! :3

}
