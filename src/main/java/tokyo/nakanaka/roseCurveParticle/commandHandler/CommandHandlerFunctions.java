package tokyo.nakanaka.roseCurveParticle.commandHandler;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurveParticle.Task;
/**
 * Hold Functions for command handling
 */
public class CommandHandlerFunctions {
	private CommandHandlerFunctions() {
	}
	/**
	 * Create message lines to print on "/rcp setting" command
	 * @param taskName the name of task
	 * @param task the task
	 * @return message lines to print
	 */
	public static List<String> createSettingLines(String taskName, Task task){
		List<String> lines = new ArrayList<>();
		lines.add("--- [" + LogColor.LIGHT_PURPLE + "Settings of " + LogColor.RESET + taskName + "] ---------------------");
		lines.add(LogColor.LIGHT_PURPLE + "  eq. " + LogColor.RESET + "r = a * sin((n/d) * θ)");
		lines.add(  "θ = k * t");
		lines.add(LogColor.LIGHT_PURPLE + "a: " + LogColor.RESET + task.getAFactor());
		lines.add(LogColor.LIGHT_PURPLE + "n: " + LogColor.RESET + task.getNFactor());
		lines.add(LogColor.LIGHT_PURPLE + "d: " + LogColor.RESET + task.getDFactor());
		lines.add(LogColor.LIGHT_PURPLE + "k: " + LogColor.RESET + task.getAngularVelocity() + "[degree/ tick]");
		lines.add("---------------------------------------");
		lines.add(LogColor.LIGHT_PURPLE + "Particle: " + LogColor.RESET + task.getParticle().getId().toString());
		lines.add(LogColor.LIGHT_PURPLE + "World: " + LogColor.RESET + task.getWorld());
		lines.add(LogColor.LIGHT_PURPLE + "Center: " + LogColor.RESET + task.getCenter());
		lines.add(LogColor.LIGHT_PURPLE + "Axis: " + LogColor.RESET + task.getAxis().toString().toLowerCase());
		return lines;
	}
}
