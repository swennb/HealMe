package com.github.swennb;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	public final Logger logger = Logger.getLogger("minecraft");
	public static main Plugin;

	 @Override
	 public void onEnable(){
	 		PluginDescriptionFile pdfFile = this.getDescription();
	       this.logger.info(pdfFile.getName() + "version " + pdfFile.getVersion() + " has been enabled ");
	    }
	 
	    @Override
	    public void onDisable() {
	        PluginDescriptionFile pdfFile = this.getDescription();
	        this.logger.info(pdfFile.getName() + "version " + pdfFile.getVersion() + " has been disabled ");
	    }
	

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	Player player = (Player) sender;
	
	if(commandLabel.equalsIgnoreCase("healme") || commandLabel.equalsIgnoreCase("hme"));
	if(args.length == 0){ 
		//healme = 0 /heal Swen = 1 
		player.setHealth(20);
		player.setFoodLevel(20);
		player.sendMessage(ChatColor.RED +"you\'ve been healed");
		
		
	}
	else if(args.length == 1){
		Player targetPlayer = player.getServer().getPlayer(args[0]);
		player.sendMessage(ChatColor.BLUE + "You have been healed by " + player.getPlayer());
	}
	
	return false;
	
} 
}

