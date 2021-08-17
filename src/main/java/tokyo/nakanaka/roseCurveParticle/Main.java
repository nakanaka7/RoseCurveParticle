package tokyo.nakanaka.roseCurveParticle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.Scheduler;
import tokyo.nakanaka.WorldFinder;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.roseCurveParticle.commandHandler.*;

/**
 * A hub class for this project, which may be used by platform(s)' entry point. 
 */
public class Main {
	private Map<String, CommandHandler> cmdHandlerMap;
	/**
	 * Constructs a main.
	 * @param particleParser a particle parser for the platform that uses the main
	 * @param worldFinder a world finder for the platform that uses the main
	 */
	public Main(Scheduler scheduler, ParticleParseHandler particleParseHandler, WorldFinder worldFinder) {
		this.cmdHandlerMap = new HashMap<>();
		Map<String, Task> taskMap = new HashMap<>();
		this.cmdHandlerMap.put("help", new HelpCommandHandler());
		this.cmdHandlerMap.put("ptclhelp", new PtclhelpCommandHandler());
		this.cmdHandlerMap.put("create", new CreateCommandHandler(taskMap, scheduler));
		this.cmdHandlerMap.put("del", new DelCommandHandler(taskMap));
		this.cmdHandlerMap.put("list", new ListCommandHandler(taskMap));
		this.cmdHandlerMap.put("setting", new SettingCommandHandler(taskMap, particleParseHandler, worldFinder));
		this.cmdHandlerMap.put("start", new StartCommandHandler(taskMap));
		this.cmdHandlerMap.put("stop", new StopCommandHandler(taskMap));
	}
	/**
	 * Run a /rcp command
	 * @param cmdSender command sender who run the command
	 * @param args command arguments of the command
	 */
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
	/**
	 * Returns a tab complete list for a /rcp command 
	 * @param cmdSender command sender who run the command
	 * @param args command arguments of the command
	 * @return a tab complete list for a /rcp command
	 */
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
