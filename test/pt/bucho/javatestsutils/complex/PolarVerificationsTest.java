package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolarVerificationsTest {

	Polar num1;

	@Before
	public void setUp() throws Exception {
		num1 = new Polar();
	}

	@Test
	public void transformAngleToMainAngle() {

		num1 = new Polar(0.0, Math.PI * -1);
		assertEquals(Math.PI, num1.getTheta(), 0.0);

		num1.setTheta(Math.PI * 3);
		assertEquals(Math.PI, num1.getTheta(), 0.0);

		num1.setTheta(0);
		assertEquals(0.0, num1.getTheta(), 0.0);
	}

	@Test
	public void negativeLengthThrowsException() {

		try {
			num1.setR(-1.0);
			fail("Exception was not thrown");
		} catch (IllegalArgumentException e) {
			// all good
		}

		try {
			new Polar(-5.0, 0.0);
			fail("Exception was not thrown");
		} catch (IllegalArgumentException e) {
			// all good
		}

	}

}
