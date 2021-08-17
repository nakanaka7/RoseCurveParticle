package tokyo.nakanaka.roseCurveParticle.commandHandler.particleHelp;

import tokyo.nakanaka.logger.LogColor;

import java.util.ArrayList;
import java.util.List;

public class DustParticleHelp implements ParticleHelp {
    @Override
    public String toSingleLine() {
        return "minecraft:dust " + LogColor.LIGHT_PURPLE + "<red> <green> <blue> <size>";
    }

    @Override
    public List<String> toMultipleLines() {
        List<String> line = new ArrayList<>();
        line.add("--- [" + LogColor.LIGHT_PURPLE + "Help for " + LogColor.RESET + "\"minecraft:dust\" particle] ---------------------");
        line.add(LogColor.LIGHT_PURPLE + "Usage: " + LogColor.RESET + "\"minecraft:dust\" " + LogColor.LIGHT_PURPLE + "<red> <green> <blue> <size>");
        line.add(LogColor.LIGHT_PURPLE + "Parameters: ");
        line.add("  " + LogColor.LIGHT_PURPLE + "<red>: " + LogColor.RESET + "the red component of the color (0 ~ 1)");
        line.add("  " + LogColor.LIGHT_PURPLE + "<green>: " + LogColor.RESET + "the green component of the color (0 ~ 1)");
        line.add("  " + LogColor.LIGHT_PURPLE + "<blue>: " + LogColor.RESET + "the blue component of the color (0 ~ 1)");
        line.add("  " + LogColor.LIGHT_PURPLE + "<size>: " + LogColor.RESET + "the particle size");
        return line;
    }
}
