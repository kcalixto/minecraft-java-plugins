package kaua.studies.holographicdisplays;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
			getLogger().severe("*** HolographicDisplays is not installed or not enabled. ***");
			getLogger().severe("*** This plugin will be disabled. ***");
			this.setEnabled(false);
			return;
		}
		
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
	}

	@Override
	public void onDisable() {

	}

}
