package kaua.studies.slimelauncher;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {

	}

	@EventHandler
	public void onBlock(PlayerMoveEvent e) {

		Block block = e.getTo().getBlock().getRelative(BlockFace.DOWN);

		if (block.getType() == Material.SLIME_BLOCK) {
			Player p = e.getPlayer();
			Vector vectorPlayer = p.getLocation().getDirection();

			vectorPlayer.setY(0.5);

			p.setVelocity(vectorPlayer.multiply(10));

			World world = block.getWorld();
			world.playSound(block.getLocation(), Sound.ENTITY_WITHER_SHOOT, 50, 10);
		}
	}

}
