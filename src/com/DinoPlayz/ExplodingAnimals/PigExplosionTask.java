package com.DinoPlayz.ExplodingAnimals;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;

public class PigExplosionTask implements Runnable {

	private final Entity pig;
	
	public PigExplosionTask(Entity pig) {
		this.pig = pig;
	}
	
	@Override
	public void run() {
		pig.getLocation().getWorld().playSound(pig.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
		
		pig.remove();
	}
}
