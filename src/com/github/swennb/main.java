package com.github.swennb;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;





import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin {
	private List<Player> cantDoCommand = new ArrayList<Player>();
	countdown d = new countdown();

	public final Logger logger = Logger.getLogger("minecraft");
	public static main Plugin;

	 @Override
	 public void onEnable(){
	 		PluginDescriptionFile pdfFile = this.getDescription();
	       this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " has been enabled ");
	    }

	    @Override
	    public void onDisable() {
	        PluginDescriptionFile pdfFile = this.getDescription();
	        this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " has been disabled ");
	    }


public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	Player player = (Player) sender;
	
	if(commandLabel.equalsIgnoreCase("healme") || commandLabel.equalsIgnoreCase("hme"));
	if(args.length == 0 ){ 
		if(!cantDoCommand.contains(player)){
		//healme = 0 /healme Swen = 1 
		player.setHealth(20);
		player.setFoodLevel(20);
		player.setFireTicks(0);
		player.sendMessage(ChatColor.BLUE +"you've been healed");
		cantDoCommand.add(player);
		d.setList(cantDoCommand);
		d.setPlayer(player);
		new Thread(d).start();
		player.sendMessage(ChatColor.BLUE + "You have user your one heal moment in the 20 minutes :(");
		getServer().broadcastMessage(ChatColor.RED +"Player " + player.getPlayer()+ " has healed himself");
		}
	
	}
	else if(args.length == 1){
		if(player.getServer().getPlayer(args[0])!=null){
		Player targetPlayer = player.getServer().getPlayer(args[0]);
		targetPlayer.sendMessage(ChatColor.BLUE + "You have been healed by " + player.getPlayer());
		targetPlayer.setHealth(20);
		targetPlayer.setFoodLevel(100);
		targetPlayer.setFireTicks(0);
		}
	}
	else{
		player.sendMessage(ChatColor.RED + "Player is not online at the moment");
	}
	
	return false;


} 
public class countdown implements Runnable{

	public Player player =  null;
	public List<Player> cantDoCommand1 = new ArrayList<Player>();

	public void setPlayer(Player player1){
         player1 = player;
	}

	public void setList(List<Player> list){
		this.cantDoCommand1 = list;

	}
	public List<Player> getList(){
	return cantDoCommand1;
	}

	@Override
	public void run() {
		try{
			Thread.sleep(1200000);
			cantDoCommand1.remove(player);
		} catch(Exception ignored) {

		}

	}
}
}
