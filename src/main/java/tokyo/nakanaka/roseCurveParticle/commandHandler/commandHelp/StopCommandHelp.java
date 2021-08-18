package tokyo.nakanaka.roseCurveParticle.commandHandler.commandHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

/** 
 * CommandHelp for "/rcp stop" command
 */
class StopCommandHelp implements CommandHelp {

	@Override
	public String getUsage() {
		return "/rcp stop <taskName>";
	}

	@Override
	public String toSingleLine() {
		return LogColor.LIGHT_PURPLE + "/rcp stop <taskName>" + ": " + LogColor.RESET + "Stop a task";
		
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "/rcp stop] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Description: " + LogColor.RESET + "Stop a task");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "/rcp stop " + LogColor.LIGHT_PURPLE + "<taskName>");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<taskName>: " + LogColor.RESET + "a task name to stop");
		return line;
	}

}
