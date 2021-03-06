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
 * Handles "/rcp del" command.
 */
public class DelCommandHandler implements CommandHandler {
	private Map<String, Task> taskMap;
	/**
	 * @param taskMap a map which stores tasks
	 */
	public DelCommandHandler(Map<String, Task> taskMap) {
		this.taskMap = taskMap;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		String usageMsg = LogColor.RED + "Usage: " + RcpCommandHelps.DEL_HELP.getUsage();
		if(args.length != 1) {
			cmdSender.print(usageMsg);
			return;
		}
		Task task = this.taskMap.get(args[0]);
		if(task == null) {
			cmdSender.print(LogColor.RED + "No such task, \"" + args[0] + "\"");
			return;
		}
		task.stop();
		this.taskMap.remove(args[0]);
		cmdSender.print(LogColor.LIGHT_PURPLE + "Delete the task \"" + args[0] + "\"");
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 1) {
			return this.taskMap.keySet().stream()
				.collect(Collectors.toList());
		}else {
			return List.of();
		}
	}

}
