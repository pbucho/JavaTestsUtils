package pt.bucho.java.complex;


/**
 * Custom complex class used for testing. This class mimics the Rectangular
 * class with an additional (useless) field variable
 * 
 * @author Pedro Bucho
 *
 */
public class CustomComplex implements ComplexNumber {

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
		CustomComplex cusNum = new CustomComplex();
		cusNum.transform(number);
		
		x += cusNum.getX();
		y += cusNum.getY();
		
		return this;
	}

	@Override
	public CustomComplex subtract(ComplexNumber number) {
		CustomComplex cusNum = new CustomComplex();
		cusNum.transform(number);
		
		x -= cusNum.getX();
		y -= cusNum.getY();
		
		return this;
	}

	@Override
	public CustomComplex multiply(ComplexNumber number) {
		Polar polarNum = number.toPolar();
		Polar thisPol = toPolar();
		
		thisPol.setR(thisPol.getR() * polarNum.getR());
		thisPol.setTheta(thisPol.getTheta() + polarNum.getTheta());
		
		CustomComplex thisCustom = new CustomComplex();
		thisCustom.transform(thisPol);
		
		x = thisCustom.getX();
		y = thisCustom.getY();
		
		return this;
		
	}

	@Override
	public CustomComplex divide(ComplexNumber number) {
		Polar polarNum = number.toPolar();
		Polar thisPol = toPolar();
		
		thisPol.setR(thisPol.getR() / polarNum.getR());
		thisPol.setTheta(thisPol.getTheta() - polarNum.getTheta());
		
		CustomComplex thisCustom = new CustomComplex();
		thisCustom.transform(thisPol);
		
		x = thisCustom.getX();
		y = thisCustom.getY();
		
		return this;
	}

	@Override
	public CustomComplex sqrt() {
		return pow(0.5);
	}

	@Override
	public CustomComplex pow(double power) {
		Polar thisPol = toPolar();

		thisPol.setR(Math.pow(thisPol.getR(), power));
		thisPol.setTheta(power * thisPol.getTheta());

		CustomComplex thisCustom = new CustomComplex();
		thisCustom.transform(thisPol);
		
		x = thisCustom.getX();
		y = thisCustom.getY();

		return this;
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
		return new Rectangular(x, y);
	}

	@Override
	public CustomComplex transform(ComplexNumber number) {
		Rectangular numRec = number.toRectangular();
		
		x = numRec.getRealPart();
		y = numRec.getImaginaryPart();
		
		return this;
	}

	@Override
	public Polar toPolar() {
		return new Polar(getLength(), Math.asin(y / getLength()));
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
	
	private double getLength() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

}
