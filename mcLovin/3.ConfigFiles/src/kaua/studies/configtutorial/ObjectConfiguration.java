package kaua.studies.configtutorial;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ObjectConfiguration {

	private ConfigurationPlugin main = ConfigurationPlugin.getInstance();

	File playerFile;
	FileConfiguration playerConfig;

	private ObjectConfiguration(UUID id) {
		this.playerFile = new File(main.getDataFolder() + File.separator + "playerData", id.toString() + ".yml");
		this.playerConfig = YamlConfiguration.loadConfiguration(playerFile);

		saveFile();
		
	}

	public void saveFile() {
		if (!playerFile.exists()) {
			try {
				playerFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			playerConfig.save(playerFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getPlayerFile() {
		return playerFile;
	}

	public FileConfiguration getPlayerConfig() {
		return playerConfig;
	}

}
