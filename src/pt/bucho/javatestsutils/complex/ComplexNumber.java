package pt.bucho.javatestsutils.complex;

public interface ComplexNumber {

	public ComplexNumber add(ComplexNumber number);

	public ComplexNumber subtract(ComplexNumber number);

	public ComplexNumber multiply(ComplexNumber number);

	public ComplexNumber divide(ComplexNumber number);

	public ComplexNumber sqrt();

	public ComplexNumber pow(double power);

	public ComplexNumber conjugate();

	public Quadrant getQuadrant();

	public Rectangular toRectangular();

	public Polar toPolar();

}
