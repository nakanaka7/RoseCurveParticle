package tokyo.nakanaka.roseCurveParticle.bukkit;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import tokyo.nakanaka.bukkit.BukkitFunctions;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.roseCurveParticle.Main;

import java.util.List;

/**
 * An entry point of this plugin
 */
public class RoseCurvePlugin extends JavaPlugin {
	private Main main = new Main();
	
	@Override
	public boolean onCommand(org.bukkit.command.CommandSender cmdSender0, Command command, String label, String[] args) {
		CommandSender cmdSender = BukkitFunctions.convertCommandSender(cmdSender0);
		this.main.onRcpCommand(cmdSender, args);
		return true;
	}
	
	@Override
	public List<String> onTabComplete(org.bukkit.command.CommandSender cmdSender0, Command command, String alias, String[] args){
		CommandSender cmdSender = BukkitFunctions.convertCommandSender(cmdSender0);
		return this.main.onRcpTabComplete(cmdSender, args);
	}
	
}
