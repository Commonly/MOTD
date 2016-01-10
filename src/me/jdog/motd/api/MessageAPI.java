package me.jdog.motd.api;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MessageAPI extends JavaPlugin {
	
	public static void sendMessage(Player p, String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		p.sendMessage(msg);
	}
	
	// String testMsg = ChatColor.translateAlternateColorCodes('&', getConfig.getString("TestMsg");
	// You can use color codes. Example: MessageAPI.sendMessage(testMsg);
	// Example usage: MessageAPI.sendMessage("&c&lHi"+p.getName());

}
