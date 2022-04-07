package kaua.studies.configtutorial;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfiguration {

	private ConfigurationPlugin main = ConfigurationPlugin.getInstance();

	private File dataFile = new File(main.getDataFolder(), "pluginData.yml");

	private FileConfiguration dataConfig = YamlConfiguration.loadConfiguration(dataFile);
	
	
	private File infoFile = new File(main.getDataFolder(), "pluginInfo.yml");
	
	public void loadData() {
		
		if(!dataFile.exists()) {
			main.saveResource("pluginData.yml", true);
		}
		
		if(!infoFile.exists()) {
			try {
				infoFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

			FileConfiguration infoConfig = YamlConfiguration.loadConfiguration(infoFile);
			
			infoConfig.set("test-path", "this is a test :D!");
			
			saveFile();
		}
		
	}
	
	public void saveFile() {
		FileConfiguration infoConfig = YamlConfiguration.loadConfiguration(infoFile);
		
		try {
			infoConfig.save(infoFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
