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
	}
	
	@Override
	public ComplexNumber add(ComplexNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ComplexNumber subtract(ComplexNumber number) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polar toPolar() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	@Override
	public Quadrant getQuadrant() {
		// TODO Auto-generated method stub
		return null;
	}
}
