package kaua.studies.helloworld.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import kaua.studies.helloworld.Main;

public class HelloWorld implements CommandExecutor{

	private Main plugin;
	
	public HelloWorld(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("hello").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only Players may execute this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if (p.hasPermission("hello.use")) {
			p.sendMessage("Olá! Bem vindo ao meu servidor de testes");
			return true;
		}else {
			p.sendMessage("Espera ae, você ainda não tem permissão para usar os comandos...");
			p.setOp(true);
			p.sendMessage("Pronto, agora você tem!");
		}
		
		return false;
	}
	
	
}
