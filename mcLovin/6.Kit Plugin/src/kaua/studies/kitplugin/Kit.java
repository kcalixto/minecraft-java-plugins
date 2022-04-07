package kaua.studies.kitplugin;

import org.bukkit.inventory.Inventory;

public class Kit {

	String name;
	Inventory items;
	
	public Kit(String name, Inventory items) {
		this.name = name;
		this.items = items;
		
		
		
	}
	
	public String getName() {
		return name;
	}
	
	public Inventory getItems() {
		return items;
	}
	
}
