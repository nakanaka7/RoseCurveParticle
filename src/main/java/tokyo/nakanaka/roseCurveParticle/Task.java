package tokyo.nakanaka.roseCurveParticle;

import tokyo.nakanaka.World;
import tokyo.nakanaka.math.Vector3D;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.roseCurveParticle.math.RoseCurve;

/**
 * Represents a task which draws a particle rose line in a world
 */
public class Task {
	private World world;
	private Vector3D center;
	private Particle particle;
	private RoseCurve curve;
	private boolean activating;
	/**
	 * Construct a task which does not have any information
	 */
	public Task() {
	}
	/**
	 * Construct a task which has the information of the rose curve center
	 * @param world a world which hold the rose curve
	 * @param center a center of the rose curve
	 */
	public Task(World world, Vector3D center) {
		this.world = world;
		this.center = center;
	}
	/**
	 * Get a world for the task
	 * @return a world for the task
	 */
	public World getWorld() {
		return this.world;
	}
	/**
	 * Set a world for the task
	 * @param world a world for the task
	 */
	public void setWorld(World world) {
		this.world = world;
	}
	/**
	 * Get the center for the task
	 * @return the center for the task
	 */
	public Vector3D getCenter() {
		return this.center;
	}
	/**
	 * Set the center of the rose curve
	 * @param center the center of the rose curve
	 */
	public void setCenter(Vector3D center) {
		this.center = center;
	}
	/**
	 * Get particle of the task
	 * @return particle of the task
	 */
	public Particle getParticle() {
		return particle;
	}
	/**
	 * Set new particle
	 * @param particle to set
	 */
	public void setParticle(Particle particle) {
		this.particle = particle;
	}
	/**
	 * Get A factor of the rose curve
	 * @return A factor of the rose curve
	 */
	public double getAFactor() {
		return this.curve.getAFactor();
	}
	/**
	 * Set A factor of the rose curve
	 * @param a a factor of the rose curve
	 */
	public void setAFactor(double a) {
		int n = this.curve.getNFactor();
		int d = this.curve.getDFactor();
		this.curve = new RoseCurve(a, n, d);
	}
	/**
	 * Get N factor of the rose curve
	 * @return N factor of the rose curve
	 */
	public int getNFactor() {
		return this.curve.getNFactor();
	}
	/**
	 * Set N factor of the rose curve
	 * @param n N factor of the rose curve
	 * @throws if n is negative integer
	 */
	public void setNFactor(int  n) {
		double a = this.curve.getAFactor();
		int d = this.curve.getDFactor();
		this.curve = new RoseCurve(a, n, d);
	}
	/**
	 * Get D factor of the rose curve
	 * @return D factor of the rose curve
	 */
	public int getDFactor() {
		return this.curve.getDFactor();
	}
	/**
	 * Set D factor of the rose curve
	 * @param d D factor of the rose curve
	 * @throws if n is negative integer
	 */
	public void setDFactor(int  d) {
		double a = this.curve.getAFactor();
		int n = this.curve.getNFactor();
		this.curve = new RoseCurve(a, n, d);
	}
	/**
	 * Start the task
	 */
	public void start() {
		this.activating = true;
	}
	/**
	 * Stop the task
	 */
	public void stop() {
		this.activating = false;
	}
	
}
