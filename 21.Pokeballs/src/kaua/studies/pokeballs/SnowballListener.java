package kaua.studies.pokeballs;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class SnowballListener implements Listener {

	private Main plugin;

	private NamespacedKey key;

	private HashMap<UUID, String> cache;

	public SnowballListener(Main plugin) {
		this.plugin = plugin;
		this.key = new NamespacedKey(plugin, "captured");
		this.cache = new HashMap<>();
	}

	@EventHandler
	public void onUse(ProjectileHitEvent e) {

		if (e.getEntity() instanceof Snowball) {

			if (e.getHitEntity() != null) {

				if (!(e.getHitEntity() instanceof Player)) {

					PersistentDataContainer data = e.getEntity().getPersistentDataContainer();

					if (!data.has(key, PersistentDataType.STRING)) {

						ItemStack item = new ItemStack(Material.SNOWBALL);
						ItemMeta meta = item.getItemMeta();
						meta.setDisplayName(ChatColor.RED + "Pokeball");

						data = meta.getPersistentDataContainer();

						String type = e.getHitEntity().getType().toString();
						data.set(key, PersistentDataType.STRING, type);

						item.setItemMeta(meta);

						Player p = (Player) e.getEntity().getShooter();

						Inventory inv = p.getInventory();
						int slot = inv.firstEmpty();

						inv.setItem(slot, item);

						e.getHitEntity().remove();

					}

				}

			} else {

				PersistentDataContainer data = e.getEntity().getPersistentDataContainer();
				if (data.has(key, PersistentDataType.STRING)) {
					Location location = e.getHitBlock().getLocation().add(0, 1, 0);
					World world = location.getWorld();
					EntityType type = EntityType.valueOf(data.get(key, PersistentDataType.STRING));

					world.spawnEntity(location, type);

				}

			}

		}

	}

	@EventHandler
	public void onThrow(PlayerInteractEvent e) {

		if (e.getItem() != null) {

			ItemStack item = e.getItem();
			if (item.getType() == Material.SNOWBALL && item.hasItemMeta()) {

				ItemMeta meta = item.getItemMeta();
				if (meta.hasDisplayName()) {
					String name = ChatColor.stripColor(meta.getDisplayName());
					if (name.equals("Pokeball")) {

						String type = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
						this.cache.put(e.getPlayer().getUniqueId(), type);

					}

				}

			}

		}

	}

	@EventHandler
	public void onLaunch(ProjectileLaunchEvent e) {

		if (e.getEntity().getShooter() instanceof Player) {
			if (e.getEntity() instanceof Snowball) {
				Player p = (Player) e.getEntity().getShooter();

				if (this.cache.containsKey(p.getUniqueId())) {

					PersistentDataContainer data = e.getEntity().getPersistentDataContainer();
					data.set(key, PersistentDataType.STRING, this.cache.get(p.getUniqueId()));

				}

			}
		}

	}
}
