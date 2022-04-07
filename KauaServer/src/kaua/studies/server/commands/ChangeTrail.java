package kaua.studies.server.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import kaua.studies.server.Main;

public class ChangeTrail  implements CommandExecutor{

	private Main plugin;
	
	public ChangeTrail(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		return true;
	}
}
