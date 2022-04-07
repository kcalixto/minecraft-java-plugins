package kaua.studies.gui;

import org.bukkit.plugin.java.JavaPlugin;

import kaua.studies.gui.commands.Commands;
import kaua.studies.gui.listeners.InventoryClickListener;
import kaua.studies.gui.ui.Ui;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		new Commands(this);
		new InventoryClickListener(this);
		Ui.initialize();
	}
	
}
