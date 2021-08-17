package tokyo.nakanaka.roseCurveParticle.bukkit.particleParseHandler;

import java.util.List;

import tokyo.nakanaka.particle.DustColorTransitionParticle;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.roseCurveParticle.SubParticleParseHandler;

public class DustColorTransitionParticleHandler implements SubParticleParseHandler {

	@Override
	public Particle onParse(String[] args) {
		if(args.length != 7) {
			throw new IllegalArgumentException();
		}
		float fromRed = Float.parseFloat(args[0]);
		float fromGreen = Float.parseFloat(args[1]);
		float fromBlue = Float.parseFloat(args[2]);
		float size = Float.parseFloat(args[3]);
		float toRed = Float.parseFloat(args[4]);
		float toGreen = Float.parseFloat(args[5]);
		float toBlue = Float.parseFloat(args[6]);
		return new DustColorTransitionParticle(fromRed, fromGreen, fromBlue, size, toRed, toGreen, toBlue);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		if(1 <= args.length && args.length <= 3) {
			return List.of("0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1");
		}else if(args.length == 4) {
			return List.of("0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0"
					, "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.5", "9.0", "9.5");
		}else if(5 <= args.length && args.length <= 7) {
			return List.of("0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1");
		}else {
			return List.of();
		}
	}

}
