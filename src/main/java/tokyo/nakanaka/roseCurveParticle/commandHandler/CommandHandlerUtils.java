package tokyo.nakanaka.roseCurveParticle.commandHandler;

import java.util.ArrayList;
import java.util.List;

import tokyo.nakanaka.World;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.math.Vector3D;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.roseCurveParticle.Task;
/**
 * Hold Functions for command handling
 */
public class CommandHandlerUtils {
	private CommandHandlerUtils() {
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
		lines.add(LogColor.LIGHT_PURPLE + "eq.1: " + LogColor.RESET + "r = " + LogColor.LIGHT_PURPLE + "a " 
			+ LogColor.RESET + "* sin [(" + LogColor.LIGHT_PURPLE + "n " + LogColor.RESET + "/ " + LogColor.LIGHT_PURPLE + "d" 
			+ LogColor.RESET + ") * θ]");
		lines.add(LogColor.LIGHT_PURPLE + "eq.2: " + LogColor.RESET + "θ " + LogColor.RESET + "[degree] "
			+ LogColor.RESET + "= " + LogColor.LIGHT_PURPLE + "k " 
			+ LogColor.RESET + "* " + LogColor.LIGHT_PURPLE + "t " + LogColor.RESET + "[tick]");
		{//a
			String strValue = "";
			Double value = task.getAFactor();
			if(value != null) {
				strValue = value.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "  a = " + LogColor.RESET + strValue);
		}
		{//n
			String strValue = "";
			Integer value = task.getNFactor();
			if(value != null) {
				strValue = value.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "  n = " + LogColor.RESET + strValue);
		}
		{//d
			String strValue = "";
			Integer value = task.getDFactor();
			if(value != null) {
				strValue = value.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "  d = " + LogColor.RESET + strValue);
		}
		{//k
			String strValue = "";
			Double value = task.getAngularVelocity();
			if(value != null) {
				strValue = value.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "  k = " + LogColor.RESET + strValue + " [degree / tick]");
		}
		lines.add("------------------------------------------");
		{//particle
			String strParticle = "";
			Particle particle = task.getParticle();
			if(particle != null) {
				strParticle = particle.toString();
			}
			lines.add(LogColor.LIGHT_PURPLE + "Particle: " + LogColor.RESET + strParticle);
		}
		{//world
			String worldName = "";
			World world = task.getWorld();
			if(world != null) {
				worldName = world.getName();
			}
			lines.add(LogColor.LIGHT_PURPLE + "World: " + LogColor.RESET + worldName);
		}
		{//center
			String strCenter = "";
			Vector3D center = task.getCenter();
			if(center != null) {
				strCenter = center.getX() + " / " + center.getY() + " / " + center.getZ();
			}
			lines.add(LogColor.LIGHT_PURPLE + "Center: " + LogColor.RESET + strCenter);
		}
		lines.add(LogColor.LIGHT_PURPLE + "Axis: " + LogColor.RESET + task.getAxis().toString().toLowerCase());
		return lines;
	}
}
