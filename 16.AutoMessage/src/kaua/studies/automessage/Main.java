package kaua.studies.automessage;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		if(!new File(getDataFolder(), "config.yml").exists()) {
			saveDefaultConfig();
		}
	
		int interval = getConfig().getInt("interval") * 20;
		
		new MessageTimer(this).runTaskTimer(this, 0, interval);
	
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
