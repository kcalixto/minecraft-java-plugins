package kaua.studies.silkspawner;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockPlaceListener implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		
		ItemStack spawnerItem = e.getItemInHand();
		if(spawnerItem.getType() == Material.SPAWNER && spawnerItem.hasItemMeta()) {
			ItemMeta spawnerMeta = spawnerItem.getItemMeta();
			String name = ChatColor.stripColor(spawnerMeta.getDisplayName());
			int entityTypeLength = name.length() - 8;
			
			String entityTypeString = name.substring(0, entityTypeLength);
			EntityType entityType = EntityType.valueOf(entityTypeString);
			
			Block spawnerBlock = e.getBlock();
			
			CreatureSpawner spawner = (CreatureSpawner) spawnerBlock.getState();
			spawner.setSpawnedType(entityType);
			spawner.update();
		}
	}
	
}
