package kaua.studies.tutorial;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor{
	
	/*@Override
	public void onLoad() {
		
		//each plugin sends 2 enable msg: onEnable/onDisable, this runs before everything
	
	}*/
	
	@Override
	public void onEnable() {
		
		getCommand("test").setExecutor(this);
		getLogger().info("plugin enable");
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)) {
			
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2The command works"));
			return true;
		}
		
		return true;
	}
	

}
