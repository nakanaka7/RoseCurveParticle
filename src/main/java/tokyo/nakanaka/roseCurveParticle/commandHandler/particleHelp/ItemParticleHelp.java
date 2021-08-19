package tokyo.nakanaka.roseCurveParticle.commandHandler.particleHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

public class ItemParticleHelp implements ParticleHelp {

	@Override
	public String toSingleLine() {
		return "minecraft:item " + LogColor.LIGHT_PURPLE + "<item>";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "\"minecraft:item\"] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "\"minecraft:item\" " + LogColor.LIGHT_PURPLE + "<item>");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<item>: " + LogColor.RESET + "item");
		return line;
	}

}
