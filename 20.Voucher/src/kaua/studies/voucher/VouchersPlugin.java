package kaua.studies.voucher;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class VouchersPlugin extends JavaPlugin {

	private static Economy eco = null;

	@Override
	public void onEnable() {
		if (!setupEconomy()) {
			this.getServer().getPluginManager().disablePlugin(this);
			return;
		}
		getCommand("withdraw").setExecutor(new WithdrawCommand(eco));
		getServer().getPluginManager().registerEvents(new VoucherListener(eco), this);

	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		eco = rsp.getProvider();
		return eco != null;
	}
}
