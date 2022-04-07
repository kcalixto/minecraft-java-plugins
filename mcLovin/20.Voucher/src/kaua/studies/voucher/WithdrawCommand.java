package kaua.studies.voucher;

import java.text.DecimalFormat;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class WithdrawCommand implements CommandExecutor {
	private Economy eco;
	public WithdrawCommand(Economy eco) {
		this.eco = eco;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			if (args.length == 1) {
				double amount;
				try {
					amount = Double.parseDouble(args[0]);
					sender.sendMessage("amount: " + amount);
				} catch (NumberFormatException e) {
					sender.sendMessage("invalid value");
					return true;
				}
				Player p = (Player) sender;
				double balance = eco.getBalance((OfflinePlayer) p);
				if (balance < amount) {
					p.sendMessage("insuficient founds");
				} else {
					Inventory inv = p.getInventory();
					int slot = inv.firstEmpty();
					if (slot == -1) {
						p.sendMessage("Inventory is full");
					} else {
						ItemStack voucher = new ItemStack(Material.PAPER);
						ItemMeta voucherMeta = voucher.getItemMeta();
						DecimalFormat format = new DecimalFormat("#,###,##0.00");
						String formatted = format.format(amount);
						voucherMeta.setDisplayName(ChatColor.RED + "Bank Voucher");
						voucherMeta.setLore(
								Arrays.asList(ChatColor.DARK_GRAY + "Amount: " + ChatColor.GREEN + "$" + formatted));
						voucher.setItemMeta(voucherMeta);
						eco.depositPlayer((OfflinePlayer) p, amount);
						inv.setItem(slot, voucher);
						p.sendMessage("Voucher recieved");
					}
				}
			}
		}
		return true;
	}
}