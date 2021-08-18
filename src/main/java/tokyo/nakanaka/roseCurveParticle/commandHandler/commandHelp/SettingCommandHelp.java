package tokyo.nakanaka.roseCurveParticle.commandHandler.commandHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

class SettingCommandHelp implements CommandHelp {

	@Override
	public String getUsage() {
		return "/rcp setting <taskName> [subcommand]";
	}

	@Override
	public String toSingleLine() {
		return LogColor.LIGHT_PURPLE + "/rcp setting <taskName> [subcommand]" + ": " 
			+ LogColor.RESET + "Change a setting of a task";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "/rcp setting] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Description: " + LogColor.RESET + "Change a setting of a task");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "/rcp setting " + LogColor.LIGHT_PURPLE + "<taskName> [subcommand]");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<taskName>: " + LogColor.RESET + "the name of a task to change a setting of");
		line.add("  " + LogColor.LIGHT_PURPLE + "[subcommand]:");
		line.add("    " + LogColor.LIGHT_PURPLE + "<empty>: " + LogColor.RESET + "Nothing changes, just print the current settings");
		line.add("    " + LogColor.LIGHT_PURPLE + "a <double>: " + LogColor.RESET + "Change the " 
			+ LogColor.LIGHT_PURPLE + "\"a\" " + LogColor.RESET + "factor of the rose curve");
		line.add("    " + LogColor.LIGHT_PURPLE + "n <positive int>: " + LogColor.RESET + "Change the " 
			+ LogColor.LIGHT_PURPLE + "\"n\" " + LogColor.RESET + "factor of the rose curve");
		line.add("    " + LogColor.LIGHT_PURPLE + "d <positive int>: " + LogColor.RESET + "Change the "
			+ LogColor.LIGHT_PURPLE + "\"d\" " + LogColor.RESET + "factor of the rose curve");
		line.add("    " + LogColor.LIGHT_PURPLE + "k <double>: " + LogColor.RESET + "Change the angular velocity "
				+ LogColor.LIGHT_PURPLE + "\"k\" " + LogColor.RESET + "[degree/tick] of the rose curve");
		line.add("    " + LogColor.LIGHT_PURPLE + "particle <id> [extra]...: " + LogColor.RESET + "Specify particle");
		line.add("    " + LogColor.LIGHT_PURPLE + "world <worldName>: " + LogColor.RESET + "Change the world");
		line.add("    " + LogColor.LIGHT_PURPLE + "center <x> <y> <z>: " + LogColor.RESET + "Change the center coordinates");
		line.add("    " + LogColor.LIGHT_PURPLE + "axis x|y|z: " + LogColor.RESET + "Change the axis");
		return line;
	}

}
