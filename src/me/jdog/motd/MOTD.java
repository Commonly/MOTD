package me.jdog.motd;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.jdog.motd.api.MessageAPI;
import me.jdog.motd.events.*;

public class MOTD extends JavaPlugin {
	
	public void onEnable() {
		
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		regEvents();
		regConfig();
		
		logger.info(pdfFile.getName() + " By: " + pdfFile.getAuthors() + " has been enabled!");
		logger.warning("This is a beta version of MOTD! Please be careful ~ Jdog(Firee_)");
	}
	
	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		logger.info(pdfFile.getName() + " By: " + pdfFile.getAuthors() + " has been disabled!");
	}
	
	public void regEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerMOTD(this), this);
		pm.registerEvents(new PlayerActionbar(this), this);
		pm.registerEvents(new PlayerTitle(this), this);
		pm.registerEvents(new PlayerTab(this), this);
	}
	
	public void regConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		String prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Prefix"));
		
		Player p = (Player) sender;
		if(label.equalsIgnoreCase("motd")) {
			if(args.length == 0) {
			p.sendMessage(prefix+ChatColor.AQUA+"unknown cmd... try /motd cmds");
			return true;
			}
		}
		
		if (args[0].equalsIgnoreCase("reload")) {
			reloadConfig();
			p.sendMessage(prefix+ChatColor.AQUA+"Config reloaded.");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("help")) {
			p.sendMessage(ChatColor.RED+"MOTD vb2.4");
			p.sendMessage(ChatColor.RED+"Help>");
			p.sendMessage(ChatColor.GREEN+"Go to MOTD > config.yml and there you can edit messages");
			p.sendMessage(ChatColor.RED+"Don't forget to rate the plugin!");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("spigot")) {
			p.sendMessage(prefix+ChatColor.RED+"You got the plugin 'MOTD' from: https://www.spigotmc.org/resources/motd-comes-with-an-api-and-more.15032/");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("cmds")) {
			p.sendMessage(ChatColor.AQUA+"/motd help | reload | cmds | spigot | enabled | changelog | version");
			p.sendMessage(ChatColor.AQUA+"/vote");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("enabled")) {
			p.sendMessage(prefix+"motd version b2.5 enabled...");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("changelog")) {
			p.sendMessage("changelog...");
			MessageAPI.sendMessage(p, "2.5: Edit the prefix from in game.");
			MessageAPI.sendMessage(p, "b2.4: api update");
			p.sendMessage("b2.3: bugfix");
			p.sendMessage("b2.2: removed the need for extra plugins, and new config options.");
			p.sendMessage("b2.1: recoded most of plugin.");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("version")) {
			p.sendMessage(prefix+"b2.5");
			return true;
		}
		
		if (args[0].equalsIgnoreCase("prefix")) {
			StringBuilder builder = new StringBuilder();
			for(int i = 1; i < args.length; i++) {
				builder.append(args[i]+" ");
			}
			
			String msg = builder.toString();
			this.getConfig().set("Prefix", msg);
			this.saveConfig();
			MessageAPI.sendMessage(p, "Set the new prefix to: "+msg);
			return true;
			
		}
		
		else {
			p.sendMessage(prefix+ChatColor.AQUA+"unknown cmd '/" + args[0] + "'... try /motd cmds");
		}
		
		return true;
}
	
}	
