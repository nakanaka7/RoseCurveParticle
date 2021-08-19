package tokyo.nakanaka.roseCurveParticle.commandHandler.particleHelp;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;

public class DustColorTransitionParticleHelp implements ParticleHelp {

	@Override
	public String toSingleLine() {
		return "minecraft:dust_color_transition " + LogColor.LIGHT_PURPLE + "<fromRed> <fromGreen> <fromBlue> <size> <toRed> <toGreen> <toBlue>";
	}

	@Override
	public List<String> toMultipleLines() {
		List<String> line = new ArrayList<>();
		line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "\"minecraft:dust\"] ---------------------");
		line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "\"minecraft:dust\" " + LogColor.LIGHT_PURPLE + "<red> <green> <blue> <size>");
		line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
		line.add("  " + LogColor.LIGHT_PURPLE + "<fromRed>: " + LogColor.RESET + "the initial red component of the color (0 ~ 1)");
		line.add("  " + LogColor.LIGHT_PURPLE + "<fromGreen>: " + LogColor.RESET + "the initial green component of the color (0 ~ 1)");
		line.add("  " + LogColor.LIGHT_PURPLE + "<fromBlue>: " + LogColor.RESET + "the initial blue component of the color (0 ~ 1)");
		line.add("  " + LogColor.LIGHT_PURPLE + "<size>: " + LogColor.RESET + "the particle size");
		line.add("  " + LogColor.LIGHT_PURPLE + "<toRed>: " + LogColor.RESET + "the final red component of the color (0 ~ 1)");
		line.add("  " + LogColor.LIGHT_PURPLE + "<toGreen>: " + LogColor.RESET + "the final green component of the color (0 ~ 1)");
		line.add("  " + LogColor.LIGHT_PURPLE + "<toBlue>: " + LogColor.RESET + "the final blue component of the color (0 ~ 1)");
		return line;
	}

}
