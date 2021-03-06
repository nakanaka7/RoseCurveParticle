package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSubCommandHandler;

import java.util.List;

import tokyo.nakanaka.BlockPosition;
import tokyo.nakanaka.Player;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.math.Vector3D;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.CommandHandlerUtils;

/**
 * Handles "center" sub command of "/rcp setting &lt;taskName&gt;" command
 */
public class CenterCommandHandler implements SettingSubCommandHandler {

	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		if(args.length != 3) {
			cmdSender.print(LogColor.RED + "Usage: /rcp setting <taskName> center <x> <y> <z>");
			return;
		}
		double x;
		try{
			x = Double.parseDouble(args[0]);
		}catch(IllegalArgumentException e) {
			cmdSender.print(LogColor.RED + "Can not convert \"" + args[0] + "\" to double");
			return;
		}
		double y;
		try{
			y = Double.parseDouble(args[1]);
		}catch(IllegalArgumentException e) {
			cmdSender.print(LogColor.RED + "Can not convert \"" + args[1] + "\" to double");
			return;
		}
		double z;
		try{
			z = Double.parseDouble(args[2]);
		}catch(IllegalArgumentException e) {
			cmdSender.print(LogColor.RED + "Can not convert \"" + args[2] + "\" to double");
			return;
		}
		Vector3D center = new Vector3D(x, y, z);
		task.setCenter(center);
		CommandHandlerUtils.createSettingLines(taskName, task).stream()
			.forEach(s -> cmdSender.print(s));
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(cmdSender instanceof Player player) {
			BlockPosition pos = player.getBlockPosition();
			if(args.length == 1) {
				double x = pos.x();
				return List.of(String.valueOf(x));
			}else if(args.length == 2) {
				double y = pos.y();
				return List.of(String.valueOf(y));
			}else if(args.length == 3) {
				double z = pos.z();
				return List.of(String.valueOf(z));
			}
		}else {
			if(args.length == 1) {
				return List.of("<x>");
			}else if(args.length == 2) {
				return List.of("<y>");
			}else if(args.length == 3) {
				return List.of("<z>");
			}
		}
		return List.of();
	}

}
