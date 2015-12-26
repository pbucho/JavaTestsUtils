package pt.bucho.java.complex;

public abstract class CommonTestClass {

	protected final double re1 = 1;
	protected final double re2 = 2;
	protected final double im1 = 1;
	protected final double im2 = 2;
	protected final double r1 = Math.sqrt(Math.pow(re1, 2) + Math.pow(im1, 2));
	protected final double r2 = Math.sqrt(Math.pow(re2, 2) + Math.pow(im2, 2));
	protected final double t1 = Math.asin(im1 / r1);
	protected final double t2 = Math.asin(im2 / r2);

}
