package tokyo.nakanaka.roseCurveParticle.commandHandler.commandHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

class DelCommandHelp implements CommandHelp {
	
	@Override
	public String getUsage() {
		return "/rcp del <taskName>";
	}

	@Override
	public String toSingleLine() {
		return LogColor.LIGHT_PURPLE + "/rcp del <taskName>" + ": " + LogColor.RESET + "Delete a task";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "/rcp del] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Description: " + LogColor.RESET + "Delete a task");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "/rcp del " + LogColor.LIGHT_PURPLE + "<taskName>");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<taskName>: " + LogColor.RESET + "the name of a task to delete");
		return line;
	}

}
