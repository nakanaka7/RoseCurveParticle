package tokyo.nakanaka.roseCurveParticle.commandHandler.settingSub.particleHelpCreator;

import java.util.List;

/**
 * Create help lines for a particle
 */
public interface ParticleHelpCreator {
    /**
     * Create single line help for the particle
     * @return single line
     */
    public String createSingleLine();
    /**
     * Create multiple lines help for the particle
     * @return multiple lines
     */
    public List<String> createMultipleLines();
}
