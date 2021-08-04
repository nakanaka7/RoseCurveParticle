package tokyo.nakanaka.roseCurve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.roseCurve.commandHandler.CreateCommandHandler;
import tokyo.nakanaka.roseCurve.commandHandler.DelCommandHandler;
import tokyo.nakanaka.roseCurve.commandHandler.HelpCommandHandler;
import tokyo.nakanaka.roseCurve.commandHandler.ListCommandHandler;

public class Main {
	private Map<String, CommandHandler> cmdHandlerMap;
	
	public Main() {
		this.cmdHandlerMap = new HashMap<>();
		Map<String, Task> taskMap = new HashMap<>();
		this.cmdHandlerMap.put("help", new HelpCommandHandler());
		this.cmdHandlerMap.put("create", new CreateCommandHandler(taskMap));
		this.cmdHandlerMap.put("del", new DelCommandHandler(taskMap));
		this.cmdHandlerMap.put("list", new ListCommandHandler(taskMap));
	}
	
	public void onRcpCommand(CommandSender cmdSender, String[] args) {
		if(args.length == 0) {
			return;
		}
		String subLabel = args[0];
		String[] subArgs = new String[args.length - 1];
		System.arraycopy(args, 1, subArgs, 0, args.length - 1);
		CommandHandler cmdHandler = this.cmdHandlerMap.get(subLabel);
		if(cmdHandler != null) {
			cmdHandler.onCommand(cmdSender, subArgs);
		}
	}
	
	public List<String> onRcpTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 0) {
			return new ArrayList<>();
		}else if(args.length == 1) {
			return this.cmdHandlerMap.keySet().stream()
					.collect(Collectors.toList());
		}
		String subLabel = args[0];
		String[] subArgs = new String[args.length - 1];
		System.arraycopy(args, 1, subArgs, 0, args.length - 1);
		CommandHandler cmdHandler = this.cmdHandlerMap.get(subLabel);
		if(cmdHandler != null) {
			return cmdHandler.onTabComplete(cmdSender, subArgs);
		}
		return new ArrayList<>();
	}
	
}
