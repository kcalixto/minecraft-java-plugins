package kaua.studies.gui.ui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import kaua.studies.gui.utils.Utils;

public class Ui {

	public static Inventory inv;
	public static String inventory_name;
	public static int inv_rows = 4 * 9;

	public static void initialize() {
		inventory_name = Utils.chat("&6&lGUI");

		inv = Bukkit.createInventory(null, inv_rows);
	}

	public static Inventory GUI(Player p) {
		Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);
		
		Utils.createItem(inv, Material.STONE, 1, 1, "&cTestItem", "&7This is lore line 1","&8This is lore line 2","&9This is lore line 3");
		
		toReturn.setContents(inv.getContents());
		return toReturn;
	}
	
	public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
		if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&cTestItem"))) {
			p.setDisplayName(Utils.chat("&8[&6*&8] &6&lYou have successfully made a GUI!"));
		}
	}

}
