package kaua.studies.kitplugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	List<Kit> kits;

	@Override
	public void onEnable() {
		getCommand("kit").setExecutor(this);
	}

	@Override
	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("só pra players");
			return true;
		}

		Player p = (Player) sender;

		if (args.length == 2) {
			if (args[0].equalsIgnoreCase("create")) {

				Inventory playerInv = p.getInventory();

				String kitName = args[1];

				Inventory kitInv = Bukkit.createInventory(null, 45, kitName);

				boolean empty = true;
				for (int i = 0; i < playerInv.getSize(); i++) {

					ItemStack currentItem = playerInv.getItem(i);
					if (currentItem == null || currentItem.getType() == Material.AIR)
						continue;

					if (empty)
						empty = false;

					kitInv.setItem(i, currentItem);

				}

				if (empty) {
					p.sendMessage("no itens detected");
					return true;
				}

				if (kits == null) {
					kits = new ArrayList<>();
				}

				Kit kit = new Kit(kitName, kitInv);

				kits.add(kit);

				p.sendMessage("kit " + kitName + " has been created");
				return true;

			}

		} else if (args.length == 1) {

			boolean exists = false;
			Kit kit = null;

			//p.sendMessage("procurando o kit: " + args[0]);

			for (Kit currentKit : kits) {
				if (currentKit.getName().equalsIgnoreCase(args[0])) {

					//p.sendMessage("currentkit: \"" + currentKit.getName() + "\" - yourKit: \"" + args[0] + "\"");

					exists = true;
					kit = currentKit;
					break;
				}
			}
			
			if (!exists) {
				p.sendMessage("invalid kit :(");
				return true;
			}

			Inventory kitInv = kit.getItems();
			Inventory playerInv = p.getInventory();
			//p.sendMessage("um total de " + kitInv.getSize() + " itens para " + p);
			
			
			for (int j = 0; j < kitInv.getSize(); j++) {

				int slot = playerInv.firstEmpty();

				//p.sendMessage("primeiro slot vazio: " + slot);

				if (slot == -1) {
					p.sendMessage("your inventory is full");
					return true;
				}

				ItemStack currentItem = kitInv.getItem(j);

				playerInv.setItem(slot, currentItem);

			}

			p.sendMessage("kit " + kit.getName() + " recieved");

		}

		return false;
	}

}
