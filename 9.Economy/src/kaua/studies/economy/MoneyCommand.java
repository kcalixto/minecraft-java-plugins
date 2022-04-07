package kaua.studies.economy;

import java.text.DecimalFormat;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.milkbowl.vault.economy.Economy;

public class MoneyCommand implements CommandExecutor {

	private Economy eco;

	public MoneyCommand(Economy eco) {
		this.eco = eco;

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}

		if (args.length == 2) {
			
			double amount = 0.0;
			
			try {
				amount = Double.parseDouble(args[1]);

			} catch (NumberFormatException e) {
				sender.sendMessage("insert a valid number");
				return true;
				
			}

			DecimalFormat format = new DecimalFormat("#,###,##0.00");
			String formatted = format.format(amount);
			
			Player p = (Player) sender;
			OfflinePlayer offp = (OfflinePlayer) p;
			
			
			
			if (args[0].equalsIgnoreCase("deposit")) {

				eco.depositPlayer(offp, amount);
				
				p.sendMessage("successfully deposited "+ formatted);
				
			} else if (args[0].equalsIgnoreCase("withdraw")) {
				eco.withdrawPlayer(offp, amount);
				
				p.sendMessage("successfully withdraw "+ formatted);
			}
		}

		return true;
	}

}
