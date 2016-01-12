package me.jdog.motd.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BroadcastAPI extends JavaPlugin {
	
	/**
	 * 
	 * @param msg
	 * 		The message that will be sent to the WHOLE server (excluding bungeecord)
	 */
	
	public static void broadcastMsg(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		Bukkit.getServer().broadcastMessage(msg);
	}

}
