package tokyo.nakanaka.roseCurveParticle.commandHandler.particleHelp;

import java.util.List;

/**
 * Create help lines for a particle
 */
public interface ParticleHelp {
    /**
     * Create single line help for the particle
     * @return single line
     */
    public String toSingleLine();
    /**
     * Create multiple lines help for the particle
     * @return multiple lines
     */
    public List<String> toMultipleLines();
}
