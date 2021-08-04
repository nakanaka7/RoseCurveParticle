package tokyo.nakanaka.roseCurve.commandHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurve.Task;
import tokyo.nakanaka.roseCurve.commandHelp.RcpCommandHelps;

public class ListCommandHandler implements CommandHandler {
	private Map<String, Task> taskMap;
	
	public ListCommandHandler(Map<String, Task> taskMap) {
		this.taskMap = taskMap;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		String usageMsg = LogColor.RED + "Usage: " + RcpCommandHelps.LIST_HELP.getUsage();
		if(args.length != 0) {
			cmdSender.print(usageMsg);
			return;
		}
		List<String> taskList = this.taskMap.keySet().stream()
				.collect(Collectors.toList());
		cmdSender.print(LogColor.LIGHT_PURPLE.toString() + taskList.size() + " task(s): "
				+ String.join(", ", taskList));
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		return List.of();
	}

}
