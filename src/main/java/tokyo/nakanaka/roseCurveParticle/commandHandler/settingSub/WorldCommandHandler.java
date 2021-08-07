package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub;

import java.util.List;
import java.util.stream.Collectors;

import tokyo.nakanaka.World;
import tokyo.nakanaka.WorldFinder;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.CommandHandlerFunctions;

public class WorldCommandHandler implements SettingSubCommandHandler {
	private WorldFinder worldFinder;
	
	public WorldCommandHandler(WorldFinder worldFinder) {
		this.worldFinder = worldFinder;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		if(args.length == 0) {
			cmdSender.print(LogColor.RED + "Usage: /rcp setting <taskName> world <worldName>");
			return;
		}
		World world = this.worldFinder.findBy(args[0]);
		if(world == null) {
			cmdSender.print(LogColor.RED + "Can not find the world \"" + args[0] + "\"");
			return;
		}
		task.setWorld(world);
		CommandHandlerFunctions.createSettingLines(taskName, task).stream()
			.forEach(s -> cmdSender.print(s));
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 1) {
			return this.worldFinder.getWorldList().stream()
				.map(s -> s.getName())
				.collect(Collectors.toList());
		}
		return List.of();
	}

}
