package me.jdog.motd.api;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageAPI extends JavaPlugin {
	
	/**
	 * 
	 * @param p
	 * 	The player it will be sent to (example: Player p = event.getPlayer();
	 * @param msg
	 * 	The message the player will receive.
	 */
	
	public static void sendMessage(Player p, String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		p.sendMessage(msg);
	}
}
