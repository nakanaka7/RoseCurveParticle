/**
 * 
 */
package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub;

import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.CommandHandlerFunctions;

/**
 * Handles "n" sub command of "/rcp setting &lt;taskName&gt;" command
 */
public class NCommandHandler implements SettingSubCommandHandler {

	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		if(args.length != 1) {
			cmdSender.print(LogColor.RED + "Usage: /rcp setting <taskName> n <positive int>");
			return;
		}
		int value;
		try{
			value = Integer.parseInt(args[0]);
		}catch(IllegalArgumentException e) {
			cmdSender.print(LogColor.RED + "Can not convert \"" + args[0] + "\" to int");
			return;
		}
		if(value <= 0) {
			cmdSender.print(LogColor.RED + "\"n\" value must be positive (input: n = " + value + ")");
			return;
		}
		task.setNFactor(value);
		CommandHandlerFunctions.createSettingLines(taskName, task).stream()
			.forEach(s -> cmdSender.print(s));
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 1) {
			return List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
		}else {
			return List.of();
		}
	}

}
