package kaua.studies.playerhomes.listeners;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import kaua.studies.playerhomes.HomePlugin;

public class PlayerListeners implements Listener{

	private HomePlugin plugin;
	
	public PlayerListeners(HomePlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(!e.getFrom().getBlock().equals(e.getTo().getBlock())) {
			Player p = e.getPlayer();
			
			UUID id = p.getUniqueId();
			
			if(plugin.isQue(id))
				plugin.cancelQue(id);
			
			
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		
		if(e.getEntity() instanceof Player) {
			
			Player p = (Player) e.getEntity();
			
			UUID id = p.getUniqueId();
			
			if(plugin.isQue(id))
				plugin.cancelQue(id);
			
		}
	}
	
}
