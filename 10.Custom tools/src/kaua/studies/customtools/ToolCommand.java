package kaua.studies.customtools;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ToolCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("pickaxe")) {
					
					ItemStack tool = new ItemStack(Material.DIAMOND_PICKAXE);
					ItemMeta meta = tool.getItemMeta();
					meta.setDisplayName(ChatColor.RESET + "Diamond Drill");
					tool.setItemMeta(meta);
					tool.addUnsafeEnchantment(Enchantment.DIG_SPEED, 100);
					tool.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
					
					Player p = (Player) sender;
					Inventory inv = p.getInventory();
					int slot = inv.firstEmpty();
					if(slot != 1) {
						inv.setItem(slot, tool);
						p.sendMessage("successfully made a Diamond drill");
					}
					
				}
				
			}
			
		}
		
		return true;
	}
 
}
