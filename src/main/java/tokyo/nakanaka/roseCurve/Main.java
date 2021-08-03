package tokyo.nakanaka.roseCurve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.commandSender.CommandSender;

public class Main {
	private Map<String, CommandHandler> cmdHandlerMap = new HashMap<>();
	
	public void onRcpCommand(CommandSender cmdSender, String label, String[] args) {
		CommandHandler cmdHandler = this.cmdHandlerMap.get(label);
		if(cmdHandler != null) {
			cmdHandler.onCommand(cmdSender, args);
		}
	}
	
	public List<String> onRcpTabComplete(CommandSender cmdSender, String label, String[] args) {
		CommandHandler cmdHandler = this.cmdHandlerMap.get(label);
		if(cmdHandler != null) {
			return cmdHandler.onTabComplete(cmdSender, args);
		}
		return new ArrayList<>();
	}
	
}
