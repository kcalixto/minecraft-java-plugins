package kaua.studies.voucher;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.milkbowl.vault.economy.Economy;

public class VoucherListener implements Listener {
	private Economy eco;

	public VoucherListener(Economy eco) {
		this.eco = eco;
	}

	@EventHandler
	public void onRedeem(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			ItemStack voucher = e.getItem();
			try {

				if (voucher.getType() == Material.PAPER) {
					ItemMeta voucherMeta = voucher.getItemMeta();
					if (voucherMeta.hasLore() && voucherMeta.hasDisplayName()) {
						String voucherMetaName = ChatColor.stripColor(voucherMeta.getDisplayName());
						if (voucherMetaName.equals("Bank Voucher")) {
							String lore = voucherMeta.getLore().get(0);
							String loreStrip = ChatColor.stripColor(lore);
							double amount = Double.parseDouble((loreStrip.substring(9).replace(",", ".")));
							Player p = e.getPlayer();
							p.getInventory().remove(voucher);
							eco.depositPlayer((OfflinePlayer) p, amount);
							p.sendMessage(ChatColor.GREEN + "+$" + amount);
							p.sendMessage("redeemed");
						}
					}
				}
			} catch (NullPointerException e2) {
				
			}
		}
	}
}
