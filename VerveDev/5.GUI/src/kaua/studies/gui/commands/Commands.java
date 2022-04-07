package kaua.studies.gui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaua.studies.gui.Main;
import kaua.studies.gui.ui.Ui;

public class Commands implements CommandExecutor{
	
	private Main plugin;
	
	public Commands(Main plugin) {
		this.plugin = plugin;
		
		plugin.getCommand("gui").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) {
			
			return true;
		}
		
		Player p = (Player) sender;
		
		Ui.GUI(p);
		p.openInventory(Ui.GUI(p));
		
		/*if(p.hasPermission("blah.blah")) {
			Ui.GUI(p);
			p.openInventory(Ui.GUI(p));
		}*/
		
		return false;
	}
	
	

}
