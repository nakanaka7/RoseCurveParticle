package tokyo.nakanaka.roseCurveParticle.commandHandler.commandHelp;

import java.util.List;

public interface CommandHelp {
	/**
	 * @return a usage, which is a simple plain text(It does not contain MOTD code)
	 */
	String getUsage();
	/**
	 * Return a single line which contains the information for the command.
	 * This is used by HelpCommandHandler class
	 * @return a single line which contains the information for the command
	 */
	String toSingleLine();
	/**
	 * Return multiple lines which contains the information for the command
	 * This is used by HelpCommandHandler class
	 * @return multiple lines which contains the information for the command
	 */
	List<String> toMultipleLines();
	
}
