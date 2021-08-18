package tokyo.nakanaka.roseCurveParticle.commandHandler.commandHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

public class PtclhelpCommandHelp implements CommandHelp {

	@Override
	public String getUsage() {
		return "/rcp ptclhelp [particle]";
	}

	@Override
	public String toSingleLine() {
		return LogColor.LIGHT_PURPLE + "/rcp ptclhelp [particle]" + ": " + LogColor.RESET + "Print the help for special particle(s)";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "/rcp ptclhelp] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Description: " + LogColor.RESET + "Print the help for special particle(s)");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "/rcp ptclhelp " + LogColor.LIGHT_PURPLE + "[particle]");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "[particle]: " + LogColor.RESET + "particle to print the help");
		return line;
	}

}
