package me.jdog.motd.api;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ActionBarAPI extends JavaPlugin {
	
	/**
	 * 
	 * @param p
	 * 	The player who will receive the actionbar (example: Player p = event.getPlayer();
	 * @param message
	 * 	The Actionbar message the player will get.
	 */
	
	public static void sendActionBar(Player p, String message){
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', message+"\"}"));
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc,(byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
}

}
