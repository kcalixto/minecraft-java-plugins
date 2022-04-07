package kaua.studies.inventory;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor{

	@Override
	public void onEnable() {
		getCommand("gui").setExecutor(this);
	}
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		if(!(sender instanceof Player)) {
			sender.sendMessage("Só pra player isso garai");
			return true;
		}
		if(args.length == 1) {
			
			
			if(args[0].equalsIgnoreCase("dirt")) {
				
				Player p = (Player) sender;
				
				Inventory gui = Bukkit.createInventory(null, 45, ChatColor.GOLD + "É NADA");
				
				ItemStack dirt = new ItemStack(Material.DIRT, 1);
				ItemMeta dirtMeta = dirt.getItemMeta();
				
				dirtMeta.setDisplayName("omgggggg");
				
				List<String> lore = Arrays.asList(ChatColor.WHITE + "comi o cu de qm ta lendo");
				
				dirtMeta.setLore(lore);
				
				dirt.setItemMeta(dirtMeta);
				
				for (int i = 0; i < gui.getSize(); i++) {
					gui.setItem(i, dirt);
				}
				
				p.openInventory(gui);
				
			}
		}
		
		return true;
		
	}

	
}
