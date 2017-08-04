package com.DinoPlayz.ExplodingAnimals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
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
			if (sender instanceof Player) {
				Player player = (Player) sender;

				Location bl;
				float yaw = player.getLocation().getYaw();
				yaw = yaw < 0 ? yaw * -1 : yaw;
				if (yaw < 315 && yaw >= 225) {
					bl = new Location(player.getWorld(), player.getLocation().getX() - 2, player.getLocation().getY(),
							player.getLocation().getZ());
				} else if (yaw < 135 && yaw >= 45) {
					bl = new Location(player.getWorld(), player.getLocation().getX() + 2, player.getLocation().getY(),
							player.getLocation().getZ());
				} else if (yaw < 225 && yaw >= 135) {
					bl = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(),
							player.getLocation().getZ() - 2);
				} else {
					bl = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(),
							player.getLocation().getZ() + 2);
				}

				Entity epig = bl.getWorld().spawnEntity(bl, EntityType.PIG);

				epig.getLocation().getWorld().playEffect(epig.getLocation(), Effect.SMOKE, 1, 1);
				epig.setInvulnerable(true);

				if (epig instanceof LivingEntity) {
					LivingEntity pigLiving = (LivingEntity) epig;
					pigLiving.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 48, 1));
				}

				Bukkit.getServer().getScheduler().runTaskLater(this, new PigExplosionTask(epig), 60);

			}

			return true;
		}
		return false;
	}

}
