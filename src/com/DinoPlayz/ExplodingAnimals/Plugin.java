package com.DinoPlayz.ExplodingAnimals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Logger logger = getLogger();
		logger.log(Level.INFO, "Exploding Animals has been enabled!");
	}

}
