package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolarQuadrantTest {

	Polar num;

	@Before
	public void setUp() throws Exception {
		num = new Polar();
		num.setR(1.0);
	}

	@Test
	public void firstQuadrantTest() {
		num.setTheta(Math.PI / 4.0);

		assertEquals(Quadrant.FIRST, num.getQuadrant());
	}

	@Test
	public void secondQuadrantTest() {
		num.setTheta(3.0 * Math.PI / 4.0);

		assertEquals(Quadrant.SECOND, num.getQuadrant());
	}

	@Test
	public void thirdQuadrantTest(){
		num.setTheta(-3.0 * Math.PI / 4.0);

		assertEquals(Quadrant.THRID, num.getQuadrant());
	}

	@Test
	public void fourthQuadrantTest() {
		num.setTheta(-1.0 * Math.PI / 4.0);
		
		assertEquals(Quadrant.FOURTH, num.getQuadrant());
	}

	@Test
	public void positiveRealAxisTest() {
		num.setTheta(0.0);

		assertEquals(Quadrant.POSITIVE_REAL_AXIS, num.getQuadrant());
	}

	@Test
	public void negativeRealAxisTest() {
		num.setTheta(Math.PI);

		assertEquals(Quadrant.NEGATIVE_REAL_AXIS, num.getQuadrant());
	}

	@Test
	public void positiveImaginaryAxisTest() {
		num.setTheta(Math.PI / 2.0);

		assertEquals(Quadrant.POSITIVE_IMAGINARY_AXIS, num.getQuadrant());
	}

	@Test
	public void negativeImaginaryAxisTest() {
		num.setTheta(-1.0 * Math.PI / 2.0);

		assertEquals(Quadrant.NEGATIVE_IMAGINARY_AXIS, num.getQuadrant());
	}

	@Test
	public void originTest() {
		num.setR(0.0);

		assertEquals(Quadrant.ORIGIN, num.getQuadrant());
	}

}
