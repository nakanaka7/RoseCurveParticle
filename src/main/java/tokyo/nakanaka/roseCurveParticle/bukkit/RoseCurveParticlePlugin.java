package tokyo.nakanaka.roseCurveParticle.bukkit;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import tokyo.nakanaka.Scheduler;
import tokyo.nakanaka.WorldFinder;
import tokyo.nakanaka.bukkit.BukkitFunctions;
import tokyo.nakanaka.bukkit.BukkitScheduler;
import tokyo.nakanaka.bukkit.BukkitWorldFinder;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.roseCurveParticle.Main;

/**
 * An entry point of this plugin
 */
public class RoseCurveParticlePlugin extends JavaPlugin {
	private Main main;
	
	@Override
	public void onLoad() {
		Scheduler scheduler = new BukkitScheduler(this);
		WorldFinder worldFinder = new BukkitWorldFinder(this.getServer());
		this.main = new Main(scheduler, worldFinder);
	}
	
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
