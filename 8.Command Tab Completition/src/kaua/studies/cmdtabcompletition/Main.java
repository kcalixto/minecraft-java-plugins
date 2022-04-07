package kaua.studies.cmdtabcompletition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements TabExecutor{

	@Override
	public void onEnable() {
		getCommand("tab").setExecutor(this);
		getCommand("tab").setTabCompleter(this);
	}
	
	@Override
	public void onDisable() {
		
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		
		List<String> list = Arrays.asList("one","two","three","chickennugget");
		String input = args[0].toLowerCase();
		
		List<String> completions = null;
		
		for (String s : list) {
			if(s.startsWith(input)) {
				
				if(completions == null) {
					completions = new ArrayList<>();
				}
				
				completions.add(s);
				
			}
		}
		
		
		if(completions != null)
			Collections.sort(completions);
		
		return completions;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		return  super.onCommand(sender, cmd, label, args);
	}
	
}
