package kaua.studies.server;

import org.bukkit.plugin.java.JavaPlugin;

import kaua.studies.server.commands.ChangeTrail;
import kaua.studies.server.commands.Kits;
import kaua.studies.server.commands.ToolsGui;
import kaua.studies.server.commands.TrailSlider;
import kaua.studies.server.listeners.LoginListener;
import kaua.studies.server.listeners.PlayerDeath;
import kaua.studies.server.listeners.tools.OpBowOneListener;
import kaua.studies.server.listeners.tools.OpPickaxeListener;
import kaua.studies.server.listeners.tools.OpShovelListener;
import kaua.studies.server.listeners.tools.OpSwordListener;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new LoginListener(this), this);
		getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
		getServer().getPluginManager().registerEvents(new OpBowOneListener(this), this);
		getServer().getPluginManager().registerEvents(new OpPickaxeListener(this), this);
		getServer().getPluginManager().registerEvents(new OpShovelListener(this), this);
		getServer().getPluginManager().registerEvents(new OpSwordListener(this), this);
		
		getCommand("tools").setExecutor(new ToolsGui(this));
		getCommand("kit").setExecutor(new Kits(this));
		getCommand("changetrail").setExecutor(new ChangeTrail(this));
		getCommand("trail").setExecutor(new TrailSlider(this));
		
		
	}
	
}
