package kaua.studies.pokeballs;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new SnowballListener(this), this);
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
