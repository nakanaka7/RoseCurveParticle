package tokyo.nakanaka.roseCurveParticle.commandHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

public class SettingCommandHelp implements CommandHelp {

	@Override
	public String getUsage() {
		return "/rcp setting <taskName> [subcommand]";
	}

	@Override
	public String toSingleLine() {
		return LogColor.LIGHT_PURPLE + "/rcp setting <taskName> [subcommand]" + ": " 
			+ LogColor.RESET + "Change a setting of the task";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "/rcp setting] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Description: " + LogColor.RESET + "Change a setting of the task");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "/rcp setting " + LogColor.LIGHT_PURPLE + "<taskName> [subcommand]");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<taskName>: " + LogColor.RESET + "task name of new task");
		line.add("  " + LogColor.LIGHT_PURPLE + "[subcommand]: " + LogColor.RESET + "");
		return line;
	}

}
