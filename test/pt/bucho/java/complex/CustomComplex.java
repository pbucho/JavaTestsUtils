package pt.bucho.java.complex;

import pt.bucho.java.complex.ComplexNumber;
import pt.bucho.java.complex.Polar;
import pt.bucho.java.complex.Quadrant;
import pt.bucho.java.complex.Rectangular;

/**
 * Custom complex class used for testing. This class mimics the Rectangular
 * class with an additional (useless) field variable
 * 
 * @author Pedro Bucho
 *
 */
@SuppressWarnings("rawtypes")
public class CustomComplex implements ComplexNumber<CustomComplex> {

	private double x;
	private double y;
	private double z;
	
	public CustomComplex(){
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public CustomComplex(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public CustomComplex add(ComplexNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomComplex subtract(ComplexNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomComplex multiply(ComplexNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomComplex divide(ComplexNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomComplex sqrt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomComplex pow(double power) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomComplex conjugate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quadrant getQuadrant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangular toRectangular() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomComplex transform(ComplexNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polar toPolar() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

}
