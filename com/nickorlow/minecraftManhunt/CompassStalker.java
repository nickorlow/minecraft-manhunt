package com.nickorlow.minecraftManhunt;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;

public class CompassStalker extends BukkitRunnable {
	private Player stalkee;
	
	public CompassStalker(String uname)
	{
		stalkee = Bukkit.getPlayer(uname);
		if( stalkee != null && stalkee.isOnline() ) {
			return;
		}
	
		Bukkit.broadcastMessage(uname+" is not online!");
	}
	
    @Override
    public void run(){
        Bukkit.broadcastMessage("Checking Compass Location..");
        Bukkit.broadcastMessage(stalkee.getLocation().toString());
        
        for(Player p : Bukkit.getOnlinePlayers()){
            p.setCompassTarget(stalkee.getLocation());
        }
    }
}