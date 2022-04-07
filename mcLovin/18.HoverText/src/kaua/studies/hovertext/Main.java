package kaua.studies.hovertext;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;

public class Main extends JavaPlugin implements CommandExecutor{

	@Override
	public void onEnable() {
		getCommand("help").setExecutor(this);
	}
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			TextComponent message = new TextComponent("need help?");
			message.setFont("minecraft:uniform");
			
			message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("click me")));
			message.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "your not getting any help"));
			p.spigot().sendMessage(message);
			
			
		}
		
		return true;
		
	}
	
}
