package tokyo.nakanaka.roseCurveParticle.commandHandler;

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
			cmdSender.print(LogColor.RED + "No task which name is \"" + args[0] + "\"");
			return;
		}
		task.start(cmdSender);
		cmdSender.print(LogColor.LIGHT_PURPLE + "Started the task " + "\"" + args[0] + "\"");
	}
	
	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		return this.taskMap.entrySet().stream()
				.map(s -> s.getKey())
				.collect(Collectors.toList());
	}

}
