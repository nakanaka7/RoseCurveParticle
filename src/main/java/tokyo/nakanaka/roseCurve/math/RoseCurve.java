package tokyo.nakanaka.roseCurve.math;

public class RoseCurve {
	private double a;
	private int n;
	private int d;
	
	public RoseCurve(double a, int n, int d) {
		this.a = a;
		this.n = n;
		this.d = d;
	}
	
	/**
	 * @return a * sin((n/d) * θ)
	 */
	public double getRadius(double θ) {
		return a * Math.sin((double)n / (double)d * θ);
	}
	
}
