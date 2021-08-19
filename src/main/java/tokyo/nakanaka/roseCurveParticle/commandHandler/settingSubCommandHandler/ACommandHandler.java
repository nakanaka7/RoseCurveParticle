package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSubCommandHandler;

import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.CommandHandlerUtils;

/**
 * Handles "a" sub command of "/rcp setting &lt;taskName&gt;" command
 */
public class ACommandHandler implements SettingSubCommandHandler {
	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		if(args.length != 1) {
			cmdSender.print(LogColor.RED + "Usage: /rcp setting <taskName> a <double>");
			return;
		}
		double value;
		try{
			value = Double.parseDouble(args[0]);
		}catch(IllegalArgumentException e) {
			cmdSender.print(LogColor.RED + "Can not convert \"" + args[0] + "\" to double");
			return;
		}
		if(value <= 0) {
			cmdSender.print(LogColor.RED + "\"a\" value must be positive (input: a = " + value + ")");
			return;
		}
		task.setAFactor(value);
		CommandHandlerUtils.createSettingLines(taskName, task).stream()
			.forEach(s -> cmdSender.print(s));
	}
	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 1) {
			return List.of("1.0", "2.0", "3.0", "4.0", "5.0", "6.0", "7.0", "8.0", "9.0");
		}else {
			return List.of();
		}
	}

}
