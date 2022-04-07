package kaua.studies.tntlauncher;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {

		getServer().getPluginManager().registerEvents(this, this);

	}

	@Override
	public void onDisable() {

	}

	@EventHandler
	public void onClick(PlayerInteractEvent e) {

		if (e.getAction() == Action.RIGHT_CLICK_AIR) {
			Player p = (Player) e.getPlayer();
			ItemStack item = p.getInventory().getItemInMainHand();

			if (item.getType() == Material.BOW
					&& item.getItemMeta().getDisplayName().equalsIgnoreCase("rocket launcher")) {

				e.setCancelled(true);

				World world = p.getWorld();

				Location location = p.getLocation().add(0, 1, 0);
				BlockData blockData = Material.TNT.createBlockData();

				FallingBlock fallingBlock = world.spawnFallingBlock(location, blockData);
 
				Block target = p.getTargetBlock(null, 100);

				fallingBlock
						.setVelocity((location.toVector().subtract(target.getLocation().toVector()).multiply(-0.5)));

				fallingBlock.setGravity(true);
				fallingBlock.setDropItem(true);
				fallingBlock.setHurtEntities(true);
				
				BukkitTask task = new ExplosionTimer(fallingBlock, fallingBlock.getVelocity()).runTaskTimer(this, 0, 1);
				
			}

		}

	}

}
