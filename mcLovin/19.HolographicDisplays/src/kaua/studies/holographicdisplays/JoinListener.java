package kaua.studies.holographicdisplays;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.gmail.filoghost.holographicdisplays.api.line.ItemLine;
import com.gmail.filoghost.holographicdisplays.api.line.TextLine;

public class JoinListener implements Listener {

	private final Main plugin;
	
	public JoinListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();
		
		p.sendMessage("holo ok");
		
		Location location = p.getLocation();
		
		Vector direction = location.getDirection();
		direction.multiply(2);
		
		location.add(direction).add(0,3,0);
		
		Hologram hologram = HologramsAPI.createHologram(plugin, location);
	
		TextLine line = hologram.insertTextLine(0, ChatColor.RED + "Welcome back " + ChatColor.GOLD + p.getDisplayName());
		ItemLine item = hologram.appendItemLine(new ItemStack(Material.DIAMOND));
		
		TextLine line2 = hologram.insertTextLine(1, "Second Line");
		
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
			
				hologram.delete();
				
			}
		}.runTaskLater(plugin, 200);
		
		
	}
	
}
