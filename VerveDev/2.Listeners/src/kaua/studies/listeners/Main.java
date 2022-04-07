package kaua.studies.listeners;

import org.bukkit.plugin.java.JavaPlugin;

import kaua.studies.listeners.join.JoinListener;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		saveDefaultConfig();
		new JoinListener(this);
	}
}
