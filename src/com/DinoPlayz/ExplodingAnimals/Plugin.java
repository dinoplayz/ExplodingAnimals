package com.DinoPlayz.ExplodingAnimals;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Plugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Logger logger = getLogger();
		logger.log(Level.INFO, "ExplodingAnimals has been enabled!");
	}
	
	public void onDisable() {
		Logger logger = getLogger();
		logger.log(Level.INFO, "ExplodingAnimals has been disabled!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	    if (command.getName().equalsIgnoreCase("epig") || command.getName().equalsIgnoreCase("explodingpig")) {
	    	Player player = (Player) sender;
	    	Block block = player.getTargetBlock(new HashSet<Material>(), 100);
	    	Location bl = block.getLocation();
	    	World w = player.getWorld();
	    	
	    	if (bl.distance(player.getLocation()) < 30) {
	    		Entity epig = bl.getWorld().spawnEntity(bl, EntityType.PIG);
	    		
	    		epig.getLocation().getWorld().playEffect(epig.getLocation(), Effect.SMOKE, 1);
	    		
	    		epig.setGravity(false);
	    		
	    		try {
	    		    Thread.sleep(3000);
	    		} catch (InterruptedException e) {}
	    		
	    		w.playSound(epig.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
	    		
	    		epig.remove();
	    	}
	    	
	        return true;
	    }
	    return false;
	}

}
