package kaua.studies.playerhomes.commands;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import kaua.studies.playerhomes.HomePlugin;

public class HomeCommand implements CommandExecutor {

	private final HomePlugin plugin;

	public HomeCommand(HomePlugin plugin) {
		this.plugin = plugin;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			UUID pId = p.getUniqueId();

			if (!plugin.hasHome(pId)) {
				p.sendMessage(ChatColor.RED + "you do not have a home set");
			} else {
				plugin.addQue(pId);
				new BukkitRunnable() {
					int delay = 5;

					@Override
					public void run() {

						if (plugin.isQue(pId)) {
							if (delay == 0) {
								p.teleport(plugin.getHome(pId));
								p.sendMessage(ChatColor.GOLD + "teleporting...");
								plugin.cancelQue(pId);
								this.cancel();
							} else {
								p.sendMessage(ChatColor.GOLD + "teleporting in " + delay-- + " seconds");
							}
						}else {
							p.sendMessage(ChatColor.RED + "teleport cancelled");
							this.cancel();
						}

					}
				}.runTaskTimer(plugin, 0, 20);

			}

		}

		return true;
	}

}
