package kaua.studies.deathmessage;

import org.bukkit.plugin.java.JavaPlugin;

import kaua.studies.deathmessage.listeners.PlayerDeathListener;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		new PlayerDeathListener(this);
	}
	
}
