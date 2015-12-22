package pt.bucho.javatestsutils.complex;

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
		// TODO Auto-generated method stub
		return null;
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
		} else {
			number += "-";
		}
		number += imaginaryPart + "i";

		return number;
	}
	
	@Override
	public boolean equals(Object o){
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

}
