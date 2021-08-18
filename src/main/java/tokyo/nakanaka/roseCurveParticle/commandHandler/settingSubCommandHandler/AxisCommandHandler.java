package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSubCommandHandler;

import java.util.List;

import tokyo.nakanaka.Axis;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.CommandHandlerUtils;

/**
 * Handles "axis" sub command of "/rcp setting &lt;taskName&gt;" command
 */
public class AxisCommandHandler implements SettingSubCommandHandler {

	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		if(args.length != 1) {
			cmdSender.print(LogColor.RED + "Usage: /rcp setting <taskName> axis x|y|z");
			return;
		}
		Axis value;
		try{
			value = Axis.valueOf(args[0].toUpperCase());
		}catch(IllegalArgumentException e) {
			cmdSender.print(LogColor.RED + "Can not convert \"" + args[0] + "\" to axis");
			return;
		}
		task.setAxis(value);
		CommandHandlerUtils.createSettingLines(taskName, task).stream()
			.forEach(s -> cmdSender.print(s));
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 1) {
			return List.of("x", "y", "z");
		}else {
			return List.of();
		}
	}

}
