package kaua.studies.server.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import kaua.studies.server.Main;

public class LoginListener implements Listener {

	private Main plugin;
	
	public LoginListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		
		Player p = e.getPlayer();
		
		p.sendMessage(ChatColor.GRAY + "Bem vindo " + ChatColor.GOLD + p.getDisplayName() + ChatColor.GRAY + " ao meu Server de teste!");
		
		for(Player target:Bukkit.getOnlinePlayers()) {
			if(p != target) {
				target.sendMessage(ChatColor.GOLD + p.getDisplayName() +ChatColor.GRAY +" entrou!");
			}
		}
		
		
	}
	
	
}
