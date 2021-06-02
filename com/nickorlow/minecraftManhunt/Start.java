package com.nickorlow.minecraftManhunt;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.Material;

public class Start extends JavaPlugin {

	// this is where the user's name goes
	private String trackingPlayer = "USER_NAME";

	private final JavaPlugin plugin = this;
	private CompassStalker task;

	@Override
	public void onEnable() {
		task = new CompassStalker(trackingPlayer);
		task.runTaskTimer(plugin, 0, 1);
	}

	@Override
	public void onDisable() {
		task.cancel();
	}

	@EventHandler
	void onloginPlayer(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		PlayerInventory pi = player.getInventory();

		ItemStack compass = new ItemStack(Material.COMPASS, 1);

		pi.addItem(compass);
		player.sendMessage("Good Job");
	}

	@EventHandler
	public void onRespawnPlayer(PlayerRespawnEvent e) {
		Player player = e.getPlayer();
		PlayerInventory pi = player.getInventory();

		ItemStack compass = new ItemStack(Material.COMPASS, 1);

		pi.addItem(compass);
		player.sendMessage("Good Job");
	}
}
