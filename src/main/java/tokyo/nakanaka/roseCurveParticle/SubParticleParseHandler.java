package tokyo.nakanaka.roseCurveParticle;

import java.util.List;

import tokyo.nakanaka.particle.Particle;
/**
 * Handles each particle parse.
 */
public interface SubParticleParseHandler {
	/**
	 * Returns a particle parsed
	 * @param args arguments for particle parse
	 * @return a particle parsed
	 */
	Particle onParse(String[] args);
	/**
	 * Return a list for tab complete about the particle parse
	 * @param args arguments for particle parse
	 * @return a list for tab complete about the particle parse
	 */ 
	List<String> onTabComplete(String[] args);
}
