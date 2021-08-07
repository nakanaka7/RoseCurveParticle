package tokyo.nakanaka.roseCurveParticle.commandHandler;

import java.util.List;
import java.util.Map;

import tokyo.nakanaka.BlockPosition;
import tokyo.nakanaka.CommandHandler;
import tokyo.nakanaka.Scheduler;
import tokyo.nakanaka.commandSender.BlockPositionalCommandSender;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.math.Vector3D;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHelp.RcpCommandHelps;
/**
 * Handles "/rcp create" command.
 */
public class CreateCommandHandler implements CommandHandler {
	private Map<String, Task> taskMap;
	private Scheduler scheduler;
	/**
	 * @param taskMap a map which stores tasks
	 */
	public CreateCommandHandler(Map<String, Task> taskMap, Scheduler scheduler) {
		this.taskMap = taskMap;
		this.scheduler = scheduler;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args) {
		String usageMsg = LogColor.RED + "Usage: " + RcpCommandHelps.CREATE_HELP.getUsage();
		Task task = null;
		if(args.length == 0) {
			cmdSender.print(usageMsg);
			return;
		}
		//check the same name task
		if(this.taskMap.get(args[0]) != null) {
			cmdSender.print(LogColor.RED + "Task \"" + args[0] + "\" already exists! " 
				+ "For deleting a task, use \"/rcp del\" command.");
			return;
		}
		//try to create new task
		if(args.length == 1) {
			if(cmdSender instanceof BlockPositionalCommandSender posCmdSender) {
				BlockPosition bp = posCmdSender.getBlockPosition();
				task = new Task(this.scheduler, bp.world(), new Vector3D(bp.x(), bp.y(), bp.z()));
			}else {
				task = new Task(this.scheduler);
			}
		}else if(args.length >= 2) {
			cmdSender.print(usageMsg);
			return;
		}
		//register task
		this.taskMap.put(args[0], task);
		cmdSender.print(LogColor.LIGHT_PURPLE + "Create new task \"" + args[0] + "\"");
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		return List.of("task1", "task2", "task3");
	}

}
