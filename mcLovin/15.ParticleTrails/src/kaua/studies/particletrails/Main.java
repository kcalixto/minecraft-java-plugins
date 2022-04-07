package kaua.studies.particletrails;

import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {

	}

	@EventHandler
	public void onWalk(PlayerMoveEvent e) {

		if (!e.getFrom().getBlock().equals(e.getTo().getBlock())) {
			Player p = e.getPlayer();
			World world = p.getWorld();
			world.spawnParticle(Particle.HEART, e.getFrom(), 3, 0, 0.5, 0);

		}

	}

}
