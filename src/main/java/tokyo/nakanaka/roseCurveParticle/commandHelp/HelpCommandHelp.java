package tokyo.nakanaka.roseCurveParticle.commandHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

class HelpCommandHelp implements CommandHelp {

	@Override
	public String getUsage() {
		return "/rcp help [subcommand]";
	}
	
	@Override
	public String toSingleLine() {
		return LogColor.LIGHT_PURPLE + "/rcp help [subcommand]" + ": " + LogColor.RESET + "Print the help";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "/rcp help] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Description: " + LogColor.RESET + "Print the help");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "/rcp help " + LogColor.LIGHT_PURPLE + "[subcommand]");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "[subcommand]: " + LogColor.RESET + "subcommand to print the help");
		return line;
	}
	
}
