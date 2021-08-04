package tokyo.nakanaka.roseCurve.commandHandler;

import java.util.List;
import java.util.Map;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurve.Task;
import tokyo.nakanaka.roseCurve.commandHelp.RcpCommandHelps;

public class CreateCommandHandler implements CommandHandler {
	private Map<String, Task> taskMap;

	public CreateCommandHandler(Map<String, Task> taskMap) {
		this.taskMap = taskMap;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		String usageMsg = LogColor.RED + "Usage: " + RcpCommandHelps.CREATE_HELP.getUsage();
		Task task = null;
		if(args.length == 0) {
			cmdSender.print(usageMsg);
			return;
		}
		//check the same name task
		if(this.taskMap.get(args[0]) != null) {
			cmdSender.print(LogColor.RED + "Task \"" + args[0] + "\" already exists! " 
				+ "For deleting a task, use \"/rcp del\" command.");
			return;
		}
		//try to create new task
		if(args.length == 1) {
			task = new Task();
		}else if(args.length >= 2) {
			cmdSender.print(usageMsg);
			return;
		}
		//register task
		this.taskMap.put(args[0], task);
		cmdSender.print(LogColor.LIGHT_PURPLE + "Create new task \"" + args[0] + "\"");
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		return List.of("task1", "task2", "task3");
	}

}
