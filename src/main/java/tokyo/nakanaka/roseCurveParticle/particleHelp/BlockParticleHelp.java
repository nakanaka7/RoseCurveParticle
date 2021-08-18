package tokyo.nakanaka.roseCurveParticle.particleHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

public class BlockParticleHelp implements ParticleHelp {

	@Override
	public String toSingleLine() {
		return "minecraft:block " + LogColor.LIGHT_PURPLE + "<block>";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "\"minecraft:block\" particle] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "\"minecraft:block\" " + LogColor.LIGHT_PURPLE + "<block>");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<block>: " + LogColor.RESET + "block");
		return line;
	}

}
