package kaua.studies.customtools;

import java.util.Collection;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ToolsListener implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		ItemStack tool = p.getInventory().getItemInMainHand();
		String toolName = tool.getItemMeta().getDisplayName();
		String toCheck = "Diamond Drill";

		if (toolName.equalsIgnoreCase(toCheck)) {

			Collection<ItemStack> drops = e.getBlock().getDrops(tool);
			e.setDropItems(false);

			Inventory inv = p.getInventory();

			for (ItemStack currentItem : drops) {

				p.getInventory().addItem(currentItem);
				
			}

		}

	}

}
