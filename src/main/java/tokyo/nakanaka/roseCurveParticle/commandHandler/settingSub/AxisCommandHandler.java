package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub;

import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.roseCurveParticle.Task;

public class AxisCommandHandler implements SettingSubCommandHandler {

	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		// TODO Auto-generated method stub
		
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
