package pt.bucho.java.complex;

enum Signal {
	POSITIVE, NEGATIVE, ZERO;
}

/**
 * This is one of the two well-known implementations of complex number. It
 * represents a complex number of the form a+<b>i</b>b, being a the real part
 * and b the imaginary part.
 * 
 * @author Pedro Bucho
 *
 */
@SuppressWarnings("rawtypes")
public class Rectangular implements ComplexNumber<Rectangular> {
	
	private double realPart;
	private double imaginaryPart;

	public Rectangular(double real, double imaginary) {
		this.realPart = real;
		this.imaginaryPart = imaginary;
	}
	
	public Rectangular() {
		this(0.0, 0.0);
	}

	public Rectangular(ComplexNumber number){
		this(number.toRectangular().getRealPart(), number.toRectangular().getImaginaryPart());
	}
	
	@Override
	public Rectangular add(ComplexNumber number) {
		Rectangular rec = number.toRectangular();

		this.realPart += rec.getRealPart();
		this.imaginaryPart += rec.getImaginaryPart();

		return this;
	}

	@Override
	public Rectangular subtract(ComplexNumber number) {
		Rectangular rec = number.toRectangular();

		this.realPart -= rec.getRealPart();
		this.imaginaryPart -= rec.getImaginaryPart();

		return this;
	}

	@Override
	public Rectangular multiply(ComplexNumber number) {
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
	public Rectangular divide(ComplexNumber number) {
		Polar numPol = number.toPolar();
		Polar thisPol = toPolar();

		thisPol.setR(thisPol.getR() / numPol.getR());
		thisPol.setTheta(thisPol.getTheta() - numPol.getTheta());

		Rectangular thisRec = thisPol.toRectangular();

		realPart = thisRec.getRealPart();
		imaginaryPart = thisRec.getImaginaryPart();

		return this;
	}

	@Override
	public Rectangular sqrt() {
		pow(0.5);

		return this;
	}

	@Override
	public Rectangular pow(double power) {
		Polar thisPol = toPolar();

		thisPol.setR(Math.pow(thisPol.getR(), power));
		thisPol.setTheta(power * thisPol.getTheta());

		Rectangular thisRec = thisPol.toRectangular();

		realPart = thisRec.getRealPart();
		imaginaryPart = thisRec.getImaginaryPart();

		return this;
	}

	@Override
	public Rectangular conjugate() {
		
		imaginaryPart *= -1;
		
		return this;
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
	public boolean equals(Object o) {
		if (!(o instanceof ComplexNumber)) {
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
			if (imaginarySignal.equals(Signal.POSITIVE)) {
				return Quadrant.FIRST;
			} else if (imaginarySignal.equals(Signal.NEGATIVE)) {
				return Quadrant.FOURTH;
			} else {
				return Quadrant.POSITIVE_REAL_AXIS;
			}
		case NEGATIVE:
			if (imaginarySignal.equals(Signal.POSITIVE)) {
				return Quadrant.SECOND;
			} else if (imaginarySignal.equals(Signal.NEGATIVE)) {
				return Quadrant.THIRD;
			} else {
				return Quadrant.NEGATIVE_REAL_AXIS;
			}
		case ZERO:
			if (imaginarySignal.equals(Signal.POSITIVE)) {
				return Quadrant.POSITIVE_IMAGINARY_AXIS;
			} else if (imaginarySignal.equals(Signal.NEGATIVE)) {
				return Quadrant.NEGATIVE_IMAGINARY_AXIS;
			} else {
				return Quadrant.ORIGIN;
			}
		}
		return null;
	}
	
	@Override
	public Rectangular transform(ComplexNumber number) {
		Rectangular numRec = number.toRectangular();
		
		realPart = numRec.getRealPart();
		imaginaryPart = numRec.getImaginaryPart();
		
		return this;
	}

	private Signal getRealSignal() {
		if (realPart > 0) {
			return Signal.POSITIVE;
		} else if (realPart < 0) {
			return Signal.NEGATIVE;
		}
		return Signal.ZERO;
	}

	private Signal getImaginarySignal() {
		if (imaginaryPart > 0) {
			return Signal.POSITIVE;
		} else if (imaginaryPart < 0) {
			return Signal.NEGATIVE;
		}
		return Signal.ZERO;
	}

}
