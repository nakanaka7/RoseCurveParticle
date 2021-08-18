package tokyo.nakanaka.roseCurveParticle.commandHandler.particleHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

public class FallingDustParticleHelp implements ParticleHelp {

	@Override
	public String toSingleLine() {
		return "minecraft:falling_dust " + LogColor.LIGHT_PURPLE + "<block>";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "\"minecraft:falling_dust\" particle] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "\"minecraft:falling_dust\" " + LogColor.LIGHT_PURPLE + "<block>");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<block>: " + LogColor.RESET + "block");
		return line;
	}

}
