package kaua.studies.customtools;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		getCommand("tool").setExecutor(new ToolCommand());
		getServer().getPluginManager().registerEvents(new ToolsListener(), this);
	}

	@Override
	public void onDisable() {
		
	}
	
}
