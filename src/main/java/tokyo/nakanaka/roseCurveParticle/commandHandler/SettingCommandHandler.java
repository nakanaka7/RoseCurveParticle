package tokyo.nakanaka.roseCurveParticle.commandHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.BlockPositionalCommandSender;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub.ACommandHandler;
import tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub.NCommandHandler;
import tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub.SettingSubCommandHandler;

public class SettingCommandHandler implements CommandHandler {
	private Map<String, SettingSubCommandHandler> subCmdMap = new HashMap<>();
	private Map<String, Task> taskMap;
	/**
	 * @param taskMap a map which stores tasks
	 */
	public SettingCommandHandler(Map<String, Task> taskMap) {
		this.subCmdMap.put("a", new ACommandHandler());
		this.subCmdMap.put("n", new NCommandHandler());
		this.taskMap = taskMap;
	}
	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		String usageMsg = LogColor.RED + "Usage: /rcp setting <taskName> [subcommand]";
		String noTaskMsg = LogColor.RED + "No task";
		if(args.length == 0) {
			cmdSender.print(usageMsg);
			return;
		}
		Task task = this.taskMap.get(args[0]);
		if(task == null) {
			cmdSender.print(noTaskMsg);
			return;
		}
		CommandHandlerFunctions.createSettingLines(args[0], task).stream()
			.forEach(s -> cmdSender.print(s));
		if(args.length >= 2) {
			SettingSubCommandHandler subCmdHandler = this.subCmdMap.get(args[1]);
			if(subCmdHandler != null) {
				String[] subargs = new String[args.length - 2];
				System.arraycopy(args, 2, subargs, 0, args.length - 2);
				subCmdHandler.onCommand(cmdSender, subargs, args[0], task);
			}else {
				cmdSender.print(LogColor.RED + "unknown subcommand");
				return;
			}
		}
	}
	
	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 0) {
			return List.of();
		}else if(args.length == 1) {
			return this.taskMap.entrySet().stream()
					.map(s -> s.getKey())
					.collect(Collectors.toList());
		}else if(args.length == 2) {
			return List.of("a", "n", "d", "world", "center", "axis");
		}
		SettingSubCommandHandler subHandler = subCmdMap.get(args[1]);
		if(subHandler != null) {
			String[] subargs = new String[args.length - 2];
			System.arraycopy(args, 2, subargs, 0, args.length - 2);
			return subHandler.onTabComplete(cmdSender, subargs);
		}
		if(args[1].equals("d") && args.length == 3 ) {
			return List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
		}else if(args[1].equals("center")) {
			if(cmdSender instanceof BlockPositionalCommandSender posCmdSender) {
				if(args.length == 3) {
					return List.of("~");
				}else if(args.length == 4) {
					return List.of("~");
				}else if(args.length == 5) {
					return List.of("~");
				}
			}else {
				if(args.length == 3) {
					return List.of("<x>");
				}else if(args.length == 4) {
					return List.of("<y>");
				}else if(args.length == 5) {
					return List.of("<z>");
				}
			}
		}
		return List.of();
	}

}
