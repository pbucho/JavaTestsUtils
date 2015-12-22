package pt.bucho.javatestsutils.complex;

enum Signal {
	POSITIVE, NEGATIVE, ZERO;
}

public class Rectangular implements ComplexNumber {
	
	private double realPart;
	private double imaginaryPart;
	
	public Rectangular(){
		this.realPart = 0.0;
		this.imaginaryPart = 0.0;
	}
	
	public Rectangular(double real, double imaginary){
		this.realPart = real;
		this.imaginaryPart = imaginary;
	}
	
	@Override
	public ComplexNumber add(ComplexNumber number) {
		Rectangular rec = number.toRectangular();
		
		this.realPart += rec.getRealPart();
		this.imaginaryPart += rec.getImaginaryPart();
		
		return this;
	}

	@Override
	public ComplexNumber subtract(ComplexNumber number) {
		Rectangular rec = number.toRectangular();
		
		this.realPart -= rec.getRealPart();
		this.imaginaryPart -= rec.getImaginaryPart();
		
		return this;
	}

	@Override
	public ComplexNumber multiply(ComplexNumber number) {
		Polar numPol = number.toPolar();
		Polar thisPol = toPolar();
		
		thisPol.setR(thisPol.getR() * numPol.getR());
		thisPol.setTheta(thisPol.getTheta() + numPol.getTheta());
		
		Rectangular thisRec = thisPol.toRectangular();
		
		realPart = thisRec.getRealPart();
		imaginaryPart = thisRec.getImaginaryPart();
		
		return this;
	}

	@Override
	public ComplexNumber divide(ComplexNumber number) {
		// TODO Auto-generated method stub
		return null;
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
	public String toString() {
		String number = "" + realPart;
		if (imaginaryPart >= 0) {
			number += "+";
		}
		number += imaginaryPart + "i";

		return number;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof ComplexNumber)){
			return false;
		}
		Rectangular num = ((ComplexNumber) o).toRectangular();
		
		return num.getRealPart() == realPart & num.getImaginaryPart() == imaginaryPart;
	}

	@Override
	public Rectangular toRectangular() {
		return this;
	}

	@Override
	public Polar toPolar() {
		return new Polar(getLength(), Math.asin(imaginaryPart / getLength()));
	}

	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}
	
	private double getLength() {
		return Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2));
	}

	@Override
	public Quadrant getQuadrant() {
		Signal realSignal = getRealSignal();
		Signal imaginarySignal = getImaginarySignal();
		
		switch (realSignal) {
		case POSITIVE:
			if(imaginarySignal.equals(Signal.POSITIVE)) {
				return Quadrant.FIRST;
			}else if(imaginarySignal.equals(Signal.NEGATIVE)){
				return Quadrant.FOURTH;
			}else{
				return Quadrant.POSITIVE_REAL_AXIS;
			}
		case NEGATIVE:
			if(imaginarySignal.equals(Signal.POSITIVE)){
				return Quadrant.SECOND;
			}else if(imaginarySignal.equals(Signal.NEGATIVE)){
				return Quadrant.THRID;
			}else{
				return Quadrant.NEGATIVE_REAL_AXIS;
			}
		case ZERO:
			if(imaginarySignal.equals(Signal.POSITIVE)){
				return Quadrant.POSITIVE_IMAGINARY_AXIS;
			}else if(imaginarySignal.equals(Signal.NEGATIVE)){
				return Quadrant.NEGATIVE_IMAGINARY_AXIS;
			}else{
				return Quadrant.ORIGIN;
			}
		}
		return null;
	}
	
	private Signal getRealSignal(){
		if(realPart > 0){
			return Signal.POSITIVE; 
		}else if(realPart < 0){
			return Signal.NEGATIVE;
		}
		return Signal.ZERO;
	}
	
	private Signal getImaginarySignal(){
		if(imaginaryPart > 0){
			return Signal.POSITIVE; 
		}else if(imaginaryPart < 0){
			return Signal.NEGATIVE;
		}
		return Signal.ZERO;
	}

}
