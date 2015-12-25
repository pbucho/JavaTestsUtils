package pt.bucho.javatestsutils.complex;

@SuppressWarnings("rawtypes")
public interface ComplexNumber<T extends ComplexNumber<T>> {
	
	public T add(ComplexNumber number);

	public T subtract(ComplexNumber number);

	public T multiply(ComplexNumber number);

	public T divide(ComplexNumber number);

	public T sqrt();

	public T pow(double power);

	public T conjugate();

	public Quadrant getQuadrant();

	public Rectangular toRectangular();
	
	public T transform(ComplexNumber number);
	
	public Polar toPolar();

}
