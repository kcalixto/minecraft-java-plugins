package kaua.studies.playerhomes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import kaua.studies.playerhomes.commands.HomeCommand;
import kaua.studies.playerhomes.commands.SetHomeCommand;
import kaua.studies.playerhomes.listeners.PlayerListeners;

public class HomePlugin extends JavaPlugin{

	private HashMap<UUID, Location> homes;
	private HomeFiles files;
	private List<UUID> que;
	
	@Override
	public void onEnable() {
		this.homes= new HashMap<>();
		this.files = new HomeFiles(this);
		this.que = new ArrayList<>();
		this.files.init();
		
		if(!getDataFolder().exists())
			getDataFolder().mkdir();
		
		
		getCommand("setHome").setExecutor(new SetHomeCommand(this));
		getCommand("home").setExecutor(new HomeCommand(this));
		
		getServer().getPluginManager().registerEvents(new PlayerListeners(this), this);
	}
	
	@Override
	public void onDisable() {
		this.files.terminate();
	}
	
	public void addHome(UUID id, Location location) {
		this.homes.put(id, location);
				
	}
	
	public Location getHome(UUID id) {
		return this.homes.get(id);
	}
	
	public boolean hasHome(UUID id) {
		return this.homes.containsKey(id);
	}
	
	public HashMap<UUID, Location> getHomes(){
		return homes;
	}
	public HomeFiles getFiles() {
		return files;
	}
	public void addQue(UUID id) {
		this.que.add(id);
	}
	public void cancelQue(UUID id) {
		this.que.remove(id);
	}
	public boolean isQue(UUID id) {
		return this.que.contains(id);
	}
}
