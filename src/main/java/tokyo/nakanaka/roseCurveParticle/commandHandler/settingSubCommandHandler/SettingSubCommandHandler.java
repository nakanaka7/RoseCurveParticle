package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSubCommandHandler;

import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.roseCurveParticle.Task;
/**
 * Handles sub command of setting command. Used in SettingCommandHandler class
 */
public interface SettingSubCommandHandler {
	/**
	 * Invoked when the sub command is run
	 * @param cmdSender a command sender who run the command
	 * @param args arguments of the sub command
	 * @param taskName the name of the task that the sub command handles
	 * @param task the task that the sub command handles
	 */
	void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task);
	/**
	 * Returns a String list which will be used on auto tab complete for the sub command
	 * @param cmdSender a command sender who run the command
	 * @param args arguments of the sub command
	 * @return a String list for the sub command
	 */
	List<String> onTabComplete(CommandSender cmdSender, String[] args);
			
}
