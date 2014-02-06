package util;

public class ArrayFunctions {
	
	
	public static double dot(double[] a, double[]b) {
		double sum = 0.0;
		for (int i=0; i<a.length; i++) {
			sum+=a[i]*b[i];
		}
		return sum;
	}
	
	public static double[] add(double[]a, double[]b) {
		double[] c = new double[a.length];
		for (int i=0; i<a.length; i++) {
			c[i]=a[i]+b[i];
		}
		return c;
	}

}
