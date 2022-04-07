package kaua.studies.configtutorial;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigurationPlugin extends JavaPlugin{

	private File configFile = new File(getDataFolder(),"config.yml");
	
	private static ConfigurationPlugin instance;
	
	@Override
	public void onEnable() {
		
		if(!configFile.exists()) {
			saveDefaultConfig();
		}else {
			String msgname = "new-message";
			
			getConfig().set(msgname, "The config file is working!");
			saveConfig(); //NÃO ESQUEÇA DE SALVAR SEMPRE Q FIZER ALTERAÇÕES NO CONFIG
			
			getLogger().info("new message: "+getConfig().getString(msgname));
			//USE GETlOGGER().INFO();
		}
		
	}
	
	@Override
	public void onDisable() {
		
	}

	public static ConfigurationPlugin getInstance() {
		return instance;
	}
	
}
