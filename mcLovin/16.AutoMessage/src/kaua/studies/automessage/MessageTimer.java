package kaua.studies.automessage;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class MessageTimer extends BukkitRunnable{

	private List<String> messages;
	private boolean random;
	private int lastMessage;
	
	public MessageTimer(Main plugin) {
		this.random = plugin.getConfig().getBoolean("random");
		this.messages = plugin.getConfig().getStringList("messages");
	
	}
	
	@Override
	public void run() {
		
		String message = null;
		
		if(!random) {
			try {
				message = messages.get(lastMessage + 1);
				lastMessage++;
			} catch (ArrayIndexOutOfBoundsException e) {
				message = messages.get(0);
				lastMessage = 0;
			}
		}else {
			Random random = new Random();
			int nextMessage = random.nextInt(messages.size());
			while(nextMessage == lastMessage) {
				nextMessage = random.nextInt(messages.size());
			}
			message = messages.get(nextMessage);
			lastMessage = nextMessage;
			
			
		}
		
		for(Player p : Bukkit.getOnlinePlayers()) {
			p.sendMessage(message);
		}
		
		
	}

}
