package kaua.studies.server.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import kaua.studies.server.Main;

public class PlayerDeath implements Listener {

	private Main plugin;

	public PlayerDeath(Main plugin) {
		this.plugin = plugin;

	}

	@EventHandler
	public void onKill(PlayerDeathEvent e) {

		Player p = e.getEntity();
		Player pKiller = e.getEntity().getKiller();

		
		
	}

}
