package pt.bucho.java.complex;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.java.complex.Quadrant;
import pt.bucho.java.complex.Rectangular;

public class RectangularQuadrantTest extends CommonTestClass {

	Rectangular num;

	@Before
	public void setUp() throws Exception {
		num = new Rectangular();
	}

	@Test
	public void firstQuadrantTest() {
		num.setRealPart(1.0);
		num.setImaginaryPart(1.0);

		assertEquals(Quadrant.FIRST, num.getQuadrant());
	}

	@Test
	public void secondQuadrantTest() {
		num.setRealPart(-1.0);
		num.setImaginaryPart(1.0);

		assertEquals(Quadrant.SECOND, num.getQuadrant());
	}

	@Test
	public void thirdQuadrantTest(){
		num.setRealPart(-1.0);
		num.setImaginaryPart(-1.0);

		assertEquals(Quadrant.THIRD, num.getQuadrant());
	}

	@Test
	public void fourthQuadrantTest() {
		num.setRealPart(1.0);
		num.setImaginaryPart(-1.0);

		assertEquals(Quadrant.FOURTH, num.getQuadrant());
	}

	@Test
	public void positiveRealAxisTest() {
		num.setRealPart(1.0);
		num.setImaginaryPart(0.0);

		assertEquals(Quadrant.POSITIVE_REAL_AXIS, num.getQuadrant());
	}

	@Test
	public void negativeRealAxisTest() {
		num.setRealPart(-1.0);
		num.setImaginaryPart(0.0);

		assertEquals(Quadrant.NEGATIVE_REAL_AXIS, num.getQuadrant());
	}

	@Test
	public void positiveImaginaryAxisTest() {
		num.setRealPart(0.0);
		num.setImaginaryPart(1.0);

		assertEquals(Quadrant.POSITIVE_IMAGINARY_AXIS, num.getQuadrant());
	}

	@Test
	public void negativeImaginaryAxisTest() {
		num.setRealPart(0.0);
		num.setImaginaryPart(-1.0);

		assertEquals(Quadrant.NEGATIVE_IMAGINARY_AXIS, num.getQuadrant());
	}

	@Test
	public void originTest() {
		num.setRealPart(0.0);
		num.setImaginaryPart(0.0);

		assertEquals(Quadrant.ORIGIN, num.getQuadrant());
	}
}
