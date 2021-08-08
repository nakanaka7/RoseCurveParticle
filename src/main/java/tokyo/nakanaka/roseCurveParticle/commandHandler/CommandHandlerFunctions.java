package tokyo.nakanaka.roseCurveParticle.commandHandler;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.World;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.particle.Particle;
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
		lines.add(LogColor.LIGHT_PURPLE + "  eq1. " + LogColor.RESET + "r = " + LogColor.LIGHT_PURPLE + "a " 
			+ LogColor.RESET + "* sin[(" + LogColor.LIGHT_PURPLE + "n" + LogColor.RESET + "/" + LogColor.LIGHT_PURPLE + "d " 
			+ LogColor.RESET + ") * θ]");
		lines.add(LogColor.LIGHT_PURPLE + "  eq2. " + LogColor.RESET + "θ = " + LogColor.LIGHT_PURPLE + "k " + "* t [degree]");
		{//a
			String strValue = "";
			Double value = task.getAFactor();
			if(value != null) {
				strValue = value.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "a = " + LogColor.RESET + strValue);
		}
		{//n
			String strValue = "";
			Integer value = task.getNFactor();
			if(value != null) {
				strValue = value.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "n = " + LogColor.RESET + strValue);
		}
		{//d
			String strValue = "";
			Integer value = task.getDFactor();
			if(value != null) {
				strValue = value.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "d = " + LogColor.RESET + strValue);
		}
		{//k
			String strValue = "";
			Integer value = task.getAngularVelocity();
			if(value != null) {
				strValue = value.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "k = " + LogColor.RESET + strValue + " [degree/tick]");
		}
		lines.add("---------------------------------------");
		String particleStr = null;
		Particle particle = task.getParticle();
		if(particle != null) {
			particleStr = particle.getId().toString();
		}
		lines.add(LogColor.LIGHT_PURPLE + "Particle: " + LogColor.RESET + particleStr);
		String worldName = null;
		World world = task.getWorld();
		if(world != null) {
			worldName = world.getName();
		}
		lines.add(LogColor.LIGHT_PURPLE + "World: " + LogColor.RESET + worldName);
		lines.add(LogColor.LIGHT_PURPLE + "Center: " + LogColor.RESET + task.getCenter());
		lines.add(LogColor.LIGHT_PURPLE + "Axis: " + LogColor.RESET + task.getAxis().toString().toLowerCase());
		return lines;
	}
}
