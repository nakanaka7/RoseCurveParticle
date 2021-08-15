package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub;

import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.roseCurveParticle.ParticleParseHandler;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.CommandHandlerUtils;

public class ParticleCommandHandler implements SettingSubCommandHandler {
	private ParticleParseHandler particleParser;
	
	public ParticleCommandHandler(ParticleParseHandler particleParser) {
		this.particleParser = particleParser;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		if(args.length == 0) {
			cmdSender.print(LogColor.RED + "Usage: /rcp setting <taskName> particle <id> [extra]...");
			return;
		}
		Particle particle;
		String label = args[0];
		String[] subArgs = new String[args.length - 1];
		System.arraycopy(args, 1, subArgs, 0, args.length - 1);
		try{
			particle = this.particleParser.onParse(label, subArgs);
		}catch(IllegalArgumentException e) {
			cmdSender.print(LogColor.RED + "Can not convert \"" + String.join(" ", args) + "\" to particle");
			return;
		}
		task.setParticle(particle);
		CommandHandlerUtils.createSettingLines(taskName, task).stream()
			.forEach(s -> cmdSender.print(s));
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		if(args.length == 0) {
			return List.of();
		}
		String label = args[0];
		String[] subArgs = new String[args.length - 1];
		System.arraycopy(args, 1, subArgs, 0, args.length - 1);
		return this.particleParser.onTabComplete(label, subArgs);
	}

}
