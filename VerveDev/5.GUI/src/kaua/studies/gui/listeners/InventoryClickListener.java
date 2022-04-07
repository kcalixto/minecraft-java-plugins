package kaua.studies.gui.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import kaua.studies.gui.Main;
import kaua.studies.gui.ui.Ui;

public class InventoryClickListener implements Listener{

	private Main plugin;
	
	public InventoryClickListener(Main plugin) {
	
		this.plugin = plugin;
		
		Bukkit.getPluginManager().registerEvents(this, plugin);
	
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		String title = e.getView().getTitle();
		if (title.equals(Ui.inventory_name)) {
			e.setCancelled(true);
			if(e.getCurrentItem() == null) {
				return;
			}
			if(title.equals(Ui.inventory_name)) {
				Ui.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
			}
		}
	}
	
}
