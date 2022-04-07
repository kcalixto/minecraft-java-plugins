package kaua.studies.customessentials;

import org.bukkit.plugin.java.JavaPlugin;

import kaua.studies.customessentials.commands.FlyCommand;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		saveDefaultConfig();
		new FlyCommand(this);
	}
	
}
