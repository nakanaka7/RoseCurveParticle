package tokyo.nakanaka.roseCurveParticle;

 import tokyo.nakanaka.Axis;
import tokyo.nakanaka.Scheduler;
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
	private Axis axis = Axis.Y;
	private Particle particle;
	private Double a;
	private Integer n;
	private Integer d;
	private Integer k;
	private int phase;
	private Scheduler scheduler;
	private boolean activating;
	/**
	 * Construct a task which does not have any information
	 * @param scheduler a scheduler which is used by the task
	 */
	public Task(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	/**
	 * Construct a task which has the information of the rose curve center
	 * @param scheduler a scheduler which is used by the task
	 * @param world a world which hold the rose curve
	 * @param center a center of the rose curve
	 */
	public Task(Scheduler scheduler, World world, Vector3D center) {
		this.scheduler = scheduler;
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
	public Integer getAngularVelocity() {
		return k;
	}
	/**
	 * Set the angular velocity of the rose curve
	 * @param k the angular velocity of the rose curve
	 */
	public void setAngularVelocity(int k) {
		this.k = k;
	}
	/**
	 * Start the task
	 */
	public void start() {
		if(this.world == null || this.center == null || this.particle == null 
			|| this.a == null || this.n == null || this.d == null || this.k == null) {
			throw new IllegalArgumentException();
		}
		this.activating = true;
		this.spawnParticle();
	}
	
	private void spawnParticle() {
		if(!this.activating) {
			return;
		}
		RoseCurve roseCurve = new RoseCurve(this.a, this.n, this.d);
		for(int i = this.phase; i < this.phase + k; ++i) {
			double r = roseCurve.getRadius(i * Math.PI / 180.0);
			double p = r * Math.cos(i * Math.PI / 180.0);
			double q = r * Math.sin(i * Math.PI / 180.0);
			double x = this.center.getX();
			double y = this.center.getY();
			double z = this.center.getZ();
			switch(this.axis) {
			case X:
				y = y + p;
				z = z + q;
				break;
			case Y:
				z = z + p;
				x = x + q;
				break;
			case Z:
				x = x + p;
				y = y + q;
				break;
			default:
				break;
			}
			try {
				this.world.spawnParticle(x, y, z, this.particle, 1);
			}catch(IllegalArgumentException e) {
				this.activating = false;
			}
		}
		this.phase += this.k;
		this.scheduler.scheduleLater(1, () -> this.spawnParticle());
	}
	/**
	 * Stop the task
	 */
	public void stop() {
		this.activating = false;
	}
	
}
