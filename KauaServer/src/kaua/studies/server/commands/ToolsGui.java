package kaua.studies.server.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import kaua.studies.server.Main;
import kaua.studies.server.tools.OpPickaxe;

public class ToolsGui implements CommandExecutor {

	private Main plugin;
	
	private OpPickaxe tool = (OpPickaxe) new ItemStack(Material.DIAMOND_PICKAXE);
	
	public ToolsGui(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			
			Player p = (Player) sender;

			p.sendMessage("fuckoff");
			
			Inventory gui = Bukkit.createInventory(null, 45, ChatColor.GOLD + "OP TOOLS");
			
			//gui.setItem(((int)9/2), tool);
			gui.setItem(1, new ItemStack(Material.DIRT, 1));
			
			p.openInventory(gui);
		}
		
		sender.sendMessage("yeh");
		
		return true;
	}

}
