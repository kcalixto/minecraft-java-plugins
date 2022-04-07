package kaua.studies.deathmessage.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import kaua.studies.deathmessage.Main;
import kaua.studies.deathmessage.utils.Utils;

public class PlayerDeathListener implements Listener {

	private static Main plugin;

	public PlayerDeathListener(Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		if (e.getEntity().getKiller() instanceof Player) {
			Player killer = e.getEntity().getKiller();
			Player p = e.getEntity();

			for(Player target : Bukkit.getServer().getOnlinePlayers()) {
				if(!(target == p || target == killer)) {
					target.sendMessage(Utils.chat("&6" + killer.getDisplayName() + " &8derrotou &6" + p.getDisplayName()));
				}
			}
			
			killer.sendMessage(Utils.chat("&2[V] Você matou &6" + p.getDisplayName()));
			p.sendMessage(Utils.chat("&4[X] &6" + killer.getDisplayName() + " &4venceu o combate"));
			return;
		}
	}

}
