package tokyo.nakanaka.roseCurveParticle;

import tokyo.nakanaka.Axis;
import tokyo.nakanaka.World;
import tokyo.nakanaka.math.Vector3D;
import tokyo.nakanaka.particle.Particle;

/**
 * Represents a task which draws a particle rose line in a world
 */
public class Task {
	private World world;
	private Vector3D center;
	private Axis axis = Axis.Y;
	private Particle particle;
	private Double a;
	private Integer n;
	private Integer d;
	private Double k;
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
	 * Get the axis of the rose curve
	 * @return the axis of the rose curve
	 */
	public Axis getAxis() {
		return axis;
	}
	/**
	 * Set the axis of the rose curve
	 * @param axis the axis of the rose curve
	 */
	public void setAxis(Axis axis) {
		this.axis = axis;
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
	 * @return A factor of the rose curve, or null if the factor is not set
	 */
	public Double getAFactor() {
		return this.a;
	}
	/**
	 * Set A factor of the rose curve
	 * @param a a factor of the rose curve
	 */
	public void setAFactor(double a) {
		this.a = a;
	}
	/**
	 * Get N factor of the rose curve
	 * @return N factor of the rose curve, or null if the factor is not set
	 */
	public Integer getNFactor() {
		return this.n;
	}
	/**
	 * Set N factor of the rose curve
	 * @param n N factor of the rose curve
	 * @throws IllegalArgumentException if n is 0 or negative integer
	 */
	public void setNFactor(int  n) {
		if(n <= 0) {
			throw new IllegalArgumentException();
		}
		this.n = n;
	}
	/**
	 * Get D factor of the rose curve, or null if the factor is not set
	 * @return D factor of the rose curve
	 */
	public Integer getDFactor() {
		return this.d;
	}
	/**
	 * Set D factor of the rose curve
	 * @param d D factor of the rose curve
	 * @throws IllegalArgumentException if d is negative integer or negative integer
	 */
	public void setDFactor(int  d) {
		if(d <= 0) {
			throw new IllegalArgumentException();
		}
		this.d = d;
	}
	/**
	 * Get the angular velocity of the rose curve
	 * @return the angular velocity of the rose curve
	 */
	public Double getAngularVelocity() {
		return k;
	}
	/**
	 * Set the angular velocity of the rose curve
	 * @param k the angular velocity of the rose curve
	 */
	public void setAngularVelocity(double k) {
		this.k = k;
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
