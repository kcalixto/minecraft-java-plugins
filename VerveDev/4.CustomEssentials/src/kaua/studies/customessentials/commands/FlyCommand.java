package kaua.studies.customessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import kaua.studies.customessentials.Main;
import kaua.studies.customessentials.utils.Utils;

public class FlyCommand implements CommandExecutor {

	private static Main plugin;

	@SuppressWarnings("static-access")
	public FlyCommand(Main plugin) {
		this.plugin = plugin;

		plugin.getCommand("fly").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
			
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.hasPermission("custom.fly")) {
			if(p.isFlying()) {
				p.setAllowFlight(false);
				p.setFlying(false);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.flying_disabled")));
				return true;
			}else {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage(Utils.chat(plugin.getConfig().getString("FlyCommand.flying_enabled")));
				return true;
			}
		}else {
			p.sendMessage(Utils.chat(plugin.getConfig().getString("console_error_message")));
		}
		
		
		return true;
	}

}
