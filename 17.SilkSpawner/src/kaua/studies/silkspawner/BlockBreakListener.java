package kaua.studies.silkspawner;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlockBreakListener implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {

		Block brokenBlock = e.getBlock();

		if (brokenBlock.getType() == Material.SPAWNER) {

			ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();

			String toolName = tool.getItemMeta().getDisplayName();
			
			if ((toolName.contains("pickaxe") || toolName.contains("Pickaxe")) && tool.containsEnchantment(Enchantment.SILK_TOUCH)) {

				e.getPlayer().sendMessage("ok3");

				ItemStack spawnerItem = new ItemStack(Material.SPAWNER);
				ItemMeta spawnerMeta = spawnerItem.getItemMeta();

				CreatureSpawner spawner = (CreatureSpawner) brokenBlock.getState();
				EntityType entityType = spawner.getSpawnedType();

				spawnerMeta.setDisplayName(ChatColor.YELLOW + entityType.toString() + ChatColor.RED + " Spawner");
				spawnerItem.setItemMeta(spawnerMeta);

				brokenBlock.getWorld().dropItemNaturally(brokenBlock.getLocation(), spawnerItem);

			}

		}

	}

}
