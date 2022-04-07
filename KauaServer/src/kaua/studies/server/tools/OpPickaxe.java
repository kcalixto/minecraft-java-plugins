package kaua.studies.server.tools;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OpPickaxe extends ItemStack{
	
	private ItemMeta meta;
	
	public OpPickaxe() {
		init();
	}
	
	public void init() {
		
		Material tool = Material.DIAMOND_PICKAXE;
		
		meta = this.getItemMeta();
		meta.setDisplayName(ChatColor.AQUA + "OP PICKAXE");
		
		List<String> lore = Arrays.asList(
				
				ChatColor.WHITE + "Fortune XX",
				ChatColor.WHITE + "Efficiency XX",
				ChatColor.RED + "INFINITE"
				
				);
		
		meta.setLore(lore);
		
		this.setItemMeta(meta);
		
		this.addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
		this.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 20);
		this.addUnsafeEnchantment(Enchantment.DURABILITY, 20);
		
	}

}
