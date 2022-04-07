package kaua.studies.persistentdatastorage;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	@Override
	public void onEnable() {

	}

	@Override
	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		NamespacedKey namespacedKey = new NamespacedKey(this, "money");

		PersistentDataContainer data = p.getPersistentDataContainer();
		
		if(!data.has(namespacedKey, PersistentDataType.DOUBLE)) {
			data.set(namespacedKey, PersistentDataType.DOUBLE, 0.0);
		}
		
		double balance = data.get(namespacedKey, PersistentDataType.DOUBLE);
		
		if (args.length == 0) {
			
			p.sendMessage("balance: " + balance);

		} else if (args.length == 2) {
			
			double qty = Double.parseDouble(args[1]);
			
			if (args[0].equalsIgnoreCase("d")) {
				balance += qty;
				data.set(namespacedKey, PersistentDataType.DOUBLE, balance);
				
				
				
			} else if (args[0].equalsIgnoreCase("w")) {

			}
		}

		return true;
	}

}
