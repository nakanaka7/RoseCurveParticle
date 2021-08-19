package tokyo.nakanaka.roseCurveParticle.commandHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.commandHelp.RcpCommandHelps;

/**
 * Handles "/rcp start" command
 */
public class StartCommandHandler implements CommandHandler {
	private Map<String, Task> taskMap;
	/**
	 * @param taskMap a map which stores tasks
	 */
	public StartCommandHandler(Map<String, Task> taskMap) {
		this.taskMap = taskMap;
	}
	
	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		if(args.length != 1) {
			cmdSender.print(LogColor.RED + "Usage: " + RcpCommandHelps.START_HELP.getUsage());
			return;
		}
		Task task = this.taskMap.get(args[0]);
		if(task == null) {
			cmdSender.print(LogColor.RED + "No such task, \"" + args[0] + "\"");
			return;
		}
		List<String> missings = new ArrayList<>();
		if(task.getAFactor() == null) {
			missings.add("a");
		}
		if(task.getNFactor() == null) {
			missings.add("n");
		}
		if(task.getDFactor() == null) {
			missings.add("d");
		}
		if(task.getAngularVelocity() == null) {
			missings.add("k");
		}
		if(task.getParticle() == null) {
			missings.add("particle");
		}
		if(task.getWorld() == null) {
			missings.add("world");
		}
		if(task.getCenter() == null) {
			missings.add("center");
		}
		if(missings.size() != 0) {
			cmdSender.print(LogColor.RED + "Missing value(s): " + String.join(", ", missings));
			return;
		}
		task.start(cmdSender);
		cmdSender.print(LogColor.LIGHT_PURPLE + "Started the task " + "\"" + args[0] + "\"");
	}
	
	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 1) {
			return this.taskMap.entrySet().stream()
				.map(s -> s.getKey())
				.collect(Collectors.toList());
		}else {
			return List.of();
		}
	}

}
