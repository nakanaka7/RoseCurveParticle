package tokyo.nakanaka.roseCurveParticle;

import java.util.List;

import tokyo.nakanaka.particle.Particle;
/**
 * Handles the parse for particles
 */
public interface ParticleParseHandler {
	/**
	 * Return a particle about the inputs
	 * @param label the first String for particle parsing
	 * @param args the arguments that follows label
	 * @return a particle about the inputs
	 * @throws if it can not parse the inputs to a particle
	 */
	Particle onParse(String label, String[] args);
	/**
	 * Return a list for tab complete about the particle parse
	 * @param label the first String for particle parsing
	 * @param args the arguments that follows label
	 * @return a list for tab complete about the particle parse
	*/
	List<String> onTabComplete(String label, String[] args);
}
