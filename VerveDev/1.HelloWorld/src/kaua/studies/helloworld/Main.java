package kaua.studies.helloworld;

import org.bukkit.plugin.java.JavaPlugin;

import kaua.studies.helloworld.commands.HelloWorld;

public class Main extends JavaPlugin{

	@Override
	public void onEnable() {
		new HelloWorld(this);
	}
}
