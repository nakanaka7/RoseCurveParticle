package tokyo.nakanaka.roseCurveParticle.commandHandler.particleHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

public class BlockParticleHelp implements ParticleHelp {

	@Override
	public String toSingleLine() {
		return "minecraft:block " + LogColor.LIGHT_PURPLE + "<block> [crack|dust]";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "\"minecraft:block\"] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "\"minecraft:block\" " + LogColor.LIGHT_PURPLE + "<block> [crack|dust]");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<block>: " + LogColor.RESET + "block");
		line.add("  " + LogColor.LIGHT_PURPLE + "[crack|dust]: " + LogColor.RESET + "crack or dust option, default is \"dust\"");
		return line;
	}

}
