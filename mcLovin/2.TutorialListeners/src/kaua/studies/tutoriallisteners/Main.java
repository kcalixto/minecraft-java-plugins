package kaua.studies.tutoriallisteners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this,this);
	}
	
	@Override
	public void onDisable() {
		
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);

		Player p = event.getPlayer();
		
		String name = p.getName();
		
		String msg = ChatColor.translateAlternateColorCodes('&', "&c%p &ahas joined").replaceAll("%p", name);
		
		if(!p.hasPlayedBefore()) {
			msg = ChatColor.translateAlternateColorCodes('&', "&c%p &ahas joined for the first time").replaceAll("%p", name);
		}
		
		for (Player target : Bukkit.getServer().getOnlinePlayers()) {
			target.sendMessage(msg);
		}
		
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);

		Player p = event.getPlayer();
		
		String name = p.getName();
		
		String msg = ChatColor.translateAlternateColorCodes('&', "&c%p &ahas quit").replaceAll("%p", name);;
		
		for (Player target : Bukkit.getServer().getOnlinePlayers()) {
			target.sendMessage(msg);
		}
		
	}
	
}
