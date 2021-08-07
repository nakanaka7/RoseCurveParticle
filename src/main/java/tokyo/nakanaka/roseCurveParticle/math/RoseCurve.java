package tokyo.nakanaka.roseCurveParticle.math;
/**
 * Represents a rose curve, r = a * sin((n/d) * θ)
 */
public class RoseCurve {
	private double a;
	private int n;
	private int d;
	/**
	 * Construct a rose curve, r = a * sin((n/d) * θ)
	 * @param a a factor
	 * @param n n factor, which must be positive integer
	 * @param d d factor, which must be positive integer
	 * @throws if n or d is negative integer
	 */
	public RoseCurve(double a, int n, int d) {
		if(n <= 0 || d <= 0) {
			throw new IllegalArgumentException();
		}
		this.a = a;
		this.n = n;
		this.d = d;
	}
	/**
	 * Get A factor of the curve
	 * @return A factor of the curve
	 */
	public double getAFactor() {
		return a;
	}
	/**
	 * Get N factor of the curve
	 * @return N factor of the curve
	 */
	public int getNFactor() {
		return n;
	}
	/**
	 * Get D factor of the curve
	 * @return D factor of the curve
	 */
	public int getDFactor() {
		return d;
	}
	/**
	 * @return a * sin((n/d) * θ)
	 */
	public double getRadius(double θ) {
		return a * Math.sin((double)n / (double)d * θ);
	}
	
}
