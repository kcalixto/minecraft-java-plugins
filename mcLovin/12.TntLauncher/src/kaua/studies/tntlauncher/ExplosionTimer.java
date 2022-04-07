package kaua.studies.tntlauncher;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.FallingBlock;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ExplosionTimer extends BukkitRunnable {

	private FallingBlock fallingBlock;
	Vector initialVector;
	
	public ExplosionTimer(FallingBlock fallingBlock, Vector vector) {
		this.fallingBlock = fallingBlock;
		this.initialVector = vector;
		
	
	}
	
	@Override
	public void run() {

		if(!(fallingBlock.getVelocity().equals(initialVector))) {
			Location loc = fallingBlock.getLocation();
			fallingBlock.remove();
			World world =loc.getWorld();
			world.createExplosion(	loc, 10);
			this.cancel();
			return;
		}
		
	}

	
	
}
