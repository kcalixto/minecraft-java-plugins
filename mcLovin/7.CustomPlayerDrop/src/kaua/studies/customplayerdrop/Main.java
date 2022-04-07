package kaua.studies.customplayerdrop;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	List<ItemStack> items = Arrays.asList(
			new ItemStack(Material.DIRT, 5),
			new ItemStack(Material.DIAMOND, 1),
			new ItemStack(Material.BEDROCK, 5)
			);
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(e.getEntity() instanceof Player) {
			
			Player p = (Player) e.getEntity();
			
			e.getDrops().clear();
			
			ItemStack drop = items.get((int)(Math.random()*3));
			p.getWorld().dropItemNaturally(p.getLocation(), drop);
			
		}
	}
	
	
	
	int randomRange(int min, int max) {
		int range = (max - min) - 1;
		return (int) (Math.random() * range) + min;
	}
	
}
