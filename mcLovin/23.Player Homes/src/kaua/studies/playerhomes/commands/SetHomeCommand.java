package kaua.studies.playerhomes.commands;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaua.studies.playerhomes.HomePlugin;

public class SetHomeCommand implements CommandExecutor{

	private final HomePlugin plugin;
	
	public SetHomeCommand(HomePlugin plugin) {
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
		if(sender instanceof Player) {
			Player p = (Player) sender;
			UUID pId = p.getUniqueId();
			
			Location location = p.getLocation();
			
			
			
			p.sendMessage(ChatColor.GOLD + "Home set");
			
			plugin.getFiles().addHome(pId, location);
			
			if(plugin.hasHome(pId)) {
				p.sendMessage(ChatColor.GOLD + "Your previous home has been overridden");
			}
			
			plugin.addHome(pId, location);
			
		}
	
		return true;
	}

}
