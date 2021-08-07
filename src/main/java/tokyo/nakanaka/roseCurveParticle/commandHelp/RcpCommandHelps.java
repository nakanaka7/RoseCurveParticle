package tokyo.nakanaka.roseCurveParticle.commandHelp;

public class RcpCommandHelps {
	/**
	 * Constant class for CommandHelp
	 */
	private RcpCommandHelps() {
	}
	public static CommandHelp HELP_HELP = new HelpCommandHelp();
	public static CommandHelp CREATE_HELP = new CreateCommandHelp();
	public static CommandHelp DEL_HELP = new DelCommandHelp();
	public static CommandHelp LIST_HELP = new ListCommandHelp();
	public static CommandHelp SETTING_HELP = new SettingCommandHelp();
}
