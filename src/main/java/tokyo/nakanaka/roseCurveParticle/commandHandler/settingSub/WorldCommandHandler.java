package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub;

import java.util.List;

import tokyo.nakanaka.WorldFinder;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.roseCurveParticle.Task;

public class WorldCommandHandler implements SettingSubCommandHandler {
	private WorldFinder worldFinder;
	
	public WorldCommandHandler(WorldFinder worldFinder) {
		this.worldFinder = worldFinder;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

}
