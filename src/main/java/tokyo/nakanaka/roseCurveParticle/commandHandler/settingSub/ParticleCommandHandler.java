package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub;

import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.logger.LogColor;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.particle.ParticleParser;
import tokyo.nakanaka.roseCurveParticle.Task;
import tokyo.nakanaka.roseCurveParticle.commandHandler.CommandHandlerUtils;

public class ParticleCommandHandler implements SettingSubCommandHandler {
	private ParticleParser particleParser;
	
	public ParticleCommandHandler(ParticleParser particleParser) {
		this.particleParser = particleParser;
	}

	@Override
	public void onCommand(CommandSender cmdSender, String[] args, String taskName, Task task) {
		if(args.length == 0) {
			cmdSender.print(LogColor.RED + "Usage: /rcp setting <taskName> particle <id> [extra]...");
			return;
		}
		Particle particle;
		try{
			particle = this.particleParser.parse(args);
		}catch(IllegalArgumentException e) {
			cmdSender.print(LogColor.RED + "Can not convert \"" + args[0] + "\" to particle");
			return;
		}
		task.setParticle(particle);
		CommandHandlerUtils.createSettingLines(taskName, task).stream()
			.forEach(s -> cmdSender.print(s));
	}

	@Override
	public List<String> onTabComplete(CommandSender cmdSender, String[] args) {
		return this.particleParser.onTabComplete(args);
	}

}
