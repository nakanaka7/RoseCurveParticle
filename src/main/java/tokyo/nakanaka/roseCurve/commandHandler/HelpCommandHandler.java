package tokyo.nakanaka.roseCurve.commandHandler;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurve.commandHelp.CommandHelp;
import tokyo.nakanaka.roseCurve.commandHelp.RcpCommandHelps;

public class HelpCommandHandler implements CommandHandler {
	private LinkedHashMap<String, CommandHelp> cmdHelpMap;
	
	public HelpCommandHandler() {
		this.cmdHelpMap = new LinkedHashMap<>();
		cmdHelpMap.put("help", RcpCommandHelps.HELP_HELP);
		cmdHelpMap.put("create", RcpCommandHelps.CREATE_HELP);
		cmdHelpMap.put("del", RcpCommandHelps.DEL_HELP);
		cmdHelpMap.put("list", RcpCommandHelps.LIST_HELP);
	}
	
	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		String helpCmdUsage = this.cmdHelpMap.get("help").getUsage();
		if(args.length == 0) {
			cmdSender.print("--- [" + LogColor.LIGHT_PURPLE + "Quick help for " + LogColor.RESET + "/rcp] ---------------------");
			this.cmdHelpMap.values().stream()
				.forEach(s -> cmdSender.print(s.toSingleLine()));
			cmdSender.print(LogColor.LIGHT_PURPLE + "Run " + LogColor.RESET + "\"" + helpCmdUsage + "\" " 
				+ LogColor.RESET + LogColor.LIGHT_PURPLE + "for details");
		}else if(args.length == 1) {
			CommandHelp cmdHelp = this.cmdHelpMap.get(args[0]);
			if(cmdHelp == null) {
				cmdSender.print(LogColor.RED + "Unknown subcommand");
				return;
			}
			cmdHelp.toMultipleLines().stream()
				.forEach(s -> cmdSender.print(s));
		}else if(args.length >= 2) {
			cmdSender.print(LogColor.RED + "Usage: " + helpCmdUsage);
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 0) {
			return List.of();
		}else if(args.length == 1) {
			return new ArrayList<>(this.cmdHelpMap.keySet());
		}else{
			return List.of();
		}
	}

}
