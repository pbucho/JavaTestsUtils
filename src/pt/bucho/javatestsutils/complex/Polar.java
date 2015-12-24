package pt.bucho.javatestsutils.complex;

public class Polar implements ComplexNumber {

	private double r;
	private double theta;
	
	private final double POSITIVE_REAL_AXIS = 0.0;
	private final double NEGATIVE_REAL_AXIS = Math.PI;
	private final double POSITIVE_IMAGINARY_AXIS = Math.PI / 2.0;
	private final double NEGATIVE_IMAGINARY_AXIS = -1.0 * Math.PI / 2.0;

	public Polar() {
		this.r = 0.0;
		this.theta = 0.0;
	}

	public Polar(double r, double theta) throws IllegalArgumentException {
		this.r = r;
		this.theta = theta;
		checkLength();
		convertToMainAngle();
	}
	
	@Override
	public ComplexNumber add(ComplexNumber number) {
		Rectangular numRec = number.toRectangular();
		Rectangular thisRec = toRectangular();

		thisRec.setRealPart(thisRec.getRealPart() + numRec.getRealPart());
		thisRec.setImaginaryPart(thisRec.getImaginaryPart() + numRec.getImaginaryPart());

		Polar thisPol = thisRec.toPolar();

		r = thisPol.getR();
		theta = thisPol.getTheta();

		return this;
	}

	@Override
	public ComplexNumber subtract(ComplexNumber number) {
		Rectangular numRec = number.toRectangular();
		Rectangular thisRec = toRectangular();
		
		thisRec.setRealPart(thisRec.getRealPart() - numRec.getRealPart());
		thisRec.setImaginaryPart(thisRec.getImaginaryPart() - numRec.getImaginaryPart());
		
		Polar thisPol = thisRec.toPolar();
		
		r = thisPol.getR();
		theta = thisPol.getTheta();
		
		return this;
	}

	@Override
	public ComplexNumber multiply(ComplexNumber number) {
		Polar polar = number.toPolar();
		
		this.r *= polar.getR();
		this.theta += polar.getTheta();
		
		return this;
	}

	@Override
	public ComplexNumber divide(ComplexNumber number) {
		Polar polar = number.toPolar();
		
		this.r /= polar.getR();
		this.theta -= polar.getTheta();
		
		return this;
	}

	@Override
	public ComplexNumber sqrt() {
		pow(0.5);
		return this;
	}

	@Override
	public ComplexNumber pow(double power) {
		r = Math.pow(r, power);
		theta = power * theta;
		
		return this;
	}

	@Override
	public ComplexNumber conjugate() {
		
		theta *= -1;
		
		return this;
	}

	@Override
	public String toString(){
		return r + " cis " + theta;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ComplexNumber)) {
			return false;
		}

		Polar num = ((ComplexNumber) o).toPolar();

		return r == num.getR() & theta == num.getTheta();
	}

	@Override
	public Rectangular toRectangular() {
		return new Rectangular(r * Math.cos(theta), r * Math.sin(theta));
	}

	@Override
	public Polar toPolar() {
		return this;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) throws IllegalArgumentException {
		this.r = r;
		checkLength();
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
		convertToMainAngle();
	}

	@Override
	public Quadrant getQuadrant() {
		
		if(r == 0){
			return Quadrant.ORIGIN;
		}
		
		convertToMainAngle();
		
		if(theta > NEGATIVE_REAL_AXIS - 2.0 * Math.PI && theta < NEGATIVE_IMAGINARY_AXIS){
			return Quadrant.THIRD;
		}
		if(theta > NEGATIVE_IMAGINARY_AXIS && theta < POSITIVE_REAL_AXIS){
			return Quadrant.FOURTH;
		}
		if(theta > POSITIVE_REAL_AXIS && theta < POSITIVE_IMAGINARY_AXIS){
			return Quadrant.FIRST;
		}
		if(theta > POSITIVE_IMAGINARY_AXIS && theta < NEGATIVE_REAL_AXIS){
			return Quadrant.SECOND;
		}
		if(theta == POSITIVE_REAL_AXIS){
			return Quadrant.POSITIVE_REAL_AXIS;
		}
		if(theta == NEGATIVE_REAL_AXIS){
			return Quadrant.NEGATIVE_REAL_AXIS;
		}
		if(theta == POSITIVE_IMAGINARY_AXIS){
			return Quadrant.POSITIVE_IMAGINARY_AXIS;
		}
		if(theta == NEGATIVE_IMAGINARY_AXIS){
			return Quadrant.NEGATIVE_IMAGINARY_AXIS;
		}
		return null;
	}

	private void convertToMainAngle() {
		if (theta <= Math.PI * -1) {
			theta += Math.PI * 2;
		} else if (theta > Math.PI) {
			theta -= Math.PI * 2;
		} else {
			return;
		}
		convertToMainAngle();
	}

	private void checkLength() throws IllegalArgumentException {
		if (r < 0) {
			throw new IllegalArgumentException("Length can't be negative");
		}
	}
}
