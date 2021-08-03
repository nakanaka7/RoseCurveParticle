package tokyo.nakanaka.roseCurve.commandHandler;

import java.util.List;
import java.util.Map;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurve.Task;

public class CreateCommandHandler implements CommandHandler {
	private Map<String, Task> taskMap;

	public CreateCommandHandler(Map<String, Task> taskMap) {
		this.taskMap = taskMap;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		String usageMsg = LogColor.RED + "Usage: rcp create <taskName>";
		Task task = null;
		if(args.length == 0) {
			cmdSender.print(usageMsg);
			return;
		}else if(args.length == 1) {
			task = new Task();
		}else if(args.length >= 2) {
			cmdSender.print(usageMsg);
			return;
		}
		if(this.taskMap.get(args[0]) != null) {
			cmdSender.print(LogColor.RED + "Task \"" + args[0] + "\" already exists! " 
				+ "For deleting a task, use \"/rcp del\" command.");
			return;
		}
		this.taskMap.put(args[0], task);
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		return List.of("task1", "task2", "task3");
	}

}
