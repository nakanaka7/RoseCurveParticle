package tokyo.nakanaka.roseCurve.commandHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurve.Task;
import tokyo.nakanaka.roseCurve.commandHelp.RcpCommandHelps;

public class DelCommandHandler implements CommandHandler {
	private Map<String, Task> taskMap;
	
	public DelCommandHandler(Map<String, Task> taskMap) {
		this.taskMap = taskMap;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		String usageMsg = LogColor.RED + "Usage: " + RcpCommandHelps.DEL_HELP;
		if(args.length != 1) {
			cmdSender.print(usageMsg);
			return;
		}
		Task task = this.taskMap.get(args[0]);
		if(task == null) {
			cmdSender.print(LogColor.RED + "No task which name is \"" + args[0] + "\"");
			return;
		}
		this.taskMap.remove(args[0]);
		cmdSender.print(LogColor.LIGHT_PURPLE + "Delete the task \"" + args[0] + "\"");
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		return this.taskMap.keySet().stream()
				.collect(Collectors.toList());
	}

}
