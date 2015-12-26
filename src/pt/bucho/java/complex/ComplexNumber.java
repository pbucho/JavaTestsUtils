package pt.bucho.java.complex;

/**
 * This interface is used to implement a complex number. There are two
 * well-known, already implemented complex number types: {@link Rectangular} and
 * {@link Polar}. Therefore, there are the methods
 * {@link ComplexNumber#toRectangular()} and {@link ComplexNumber#toPolar()}
 * that work as a link between other possible implementations.
 *
 * @see https://en.wikipedia.org/wiki/Complex_number
 * 
 * @author Pedro Bucho
 *
 * @param <T>
 *            the type of complex number being implemented
 */
@SuppressWarnings("rawtypes")
public interface ComplexNumber<T> {
	/**
	 * This method adds a complex number to the current complex number.
	 * @param number
	 * @return this
	 */
	public T add(ComplexNumber number);
	/**
	 * This method subtracts a complex number from the current complex number.
	 * @param number
	 * @return this
	 */
	public T subtract(ComplexNumber number);
	/**
	 * This method multiplies a complex number by this complex number.
	 * @param number
	 * @return this
	 */
	public T multiply(ComplexNumber number);
	/**
	 * This method divides this complex number by another complex number.
	 * @param number
	 * @return this
	 */
	public T divide(ComplexNumber number);
	/**
	 * This method calculates the square root of this complex number.
	 * @return this
	 */
	public T sqrt();
	/**
	 * This method calculates the power of this complex number.
	 * @param power
	 * @return this
	 */
	public T pow(double power);
	/**
	 * This method calculates the conjugate of this complex number.
	 * @return this
	 */
	public T conjugate();
	/**
	 * This method returns the quadrant of Argand's Plane where this complex number is located.
	 * @return quadrant
	 */
	public Quadrant getQuadrant();
	/**
	 * This method retuns the representation of this complex number in the Rectangular form.
	 * @return rectangular number
	 */
	public Rectangular toRectangular();
	
	/**
	 * This method transforms a ComplexNumber in any format into this type. For
	 * example, if you implement the type Polar and call this method with a
	 * Rectangular number as argument, this Polar object would represent the
	 * provided Rectangular number in the polar form.
	 * 
	 * @param number
	 * @return
	 */
	public T transform(ComplexNumber number);
	/**
	 * This method returns the representation of this complex number in the Polar form.
	 * @return polar number
	 */
	public Polar toPolar();

}
