package tokyo.nakanaka.roseCurve.commandHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

class CreateCommandHelp implements CommandHelp {
	private String usage = "/rcp create <taskName>";
	
	@Override
	public String getUsage() {
		return this.usage;
	}

	@Override
	public String toSingleLine() {
		return LogColor.LIGHT_PURPLE + this.usage + ": " + LogColor.RESET + "Create new task";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "/rcp create] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Description: " + LogColor.RESET + "Create new task");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "/rcp create " + LogColor.LIGHT_PURPLE + "<taskName>");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<taskName>: " + LogColor.RESET + "task name of new task");
		return line;
	}

}
