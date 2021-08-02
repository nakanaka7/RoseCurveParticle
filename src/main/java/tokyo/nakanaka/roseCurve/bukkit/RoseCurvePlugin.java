package tokyo.nakanaka.roseCurve.bukkit;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import tokyo.nakanaka.bukkit.BukkitFunctions;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.roseCurve.Main;

public class RoseCurvePlugin extends JavaPlugin {
	private Main main;
	
	@Override
	public boolean onCommand(org.bukkit.command.CommandSender cmdSender0, Command command, String label, String[] args) {
		CommandSender cmdSender = BukkitFunctions.convertCommandSender(cmdSender0);
		this.main.onRcpCommand(cmdSender, label, args);
		return true;
	}
	
	@Override
	public List<String> onTabComplete(org.bukkit.command.CommandSender cmdSender0, Command command, String alias, String[] args){
		CommandSender cmdSender = BukkitFunctions.convertCommandSender(cmdSender0);
		return this.main.onRcpTabComplete(cmdSender, alias, args);
	}
	
}
