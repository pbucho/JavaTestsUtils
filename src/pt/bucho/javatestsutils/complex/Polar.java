package pt.bucho.javatestsutils.complex;

public class Polar implements ComplexNumber {

	private double r;
	private double theta;
	
	public Polar(){
		this.r = 0.0;
		this.theta = 0.0;
	}
	
	public Polar(double r, double theta){
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplexNumber pow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplexNumber conjugate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object o){
		// TODO Auto-generated method stub
		return false;
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

	public void setR(double r) {
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
		// TODO Auto-generated method stub
		return null;
	}
	
	private void convertToMainAngle(){
		if(theta <= Math.PI * -1){
			theta += Math.PI * 2;
		}else if(theta > Math.PI){
			theta -= Math.PI * 2;
		}else{
			return;
		}
		convertToMainAngle();
	}
	
	private void checkLength() throws IllegalArgumentException{
		if(r < 0){
			throw new IllegalArgumentException("Length can't be negative");
		}
	}
}
