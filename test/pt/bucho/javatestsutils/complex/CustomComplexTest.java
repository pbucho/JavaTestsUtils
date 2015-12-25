package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class CustomComplexTest extends CommonTestClass {

	CustomComplex num1, num2;
	Polar p1;
	Rectangular r1;

	@Before
	public void setUp() throws Exception {
		num1 = new CustomComplex(re1, im1, im1);
	}

	@Test
	public void customAdditionTest() {


		EasyMock.replay(num2);

		num1.add(num2);

		EasyMock.verify(num2);

		assertEquals(re1 + re2, num1.getRealPart(), 0.0);
		assertEquals(im1 + im2, num1.getImaginaryPart(), 0.0);

	}

	@Test
	public void customSubtractionTest() {

		mockExpectation();

		EasyMock.replay(num2);

		num1.subtract(num2);

		EasyMock.verify(num2);

		assertEquals(re1 - re2, num1.getRealPart(), 0.0);
		assertEquals(im1 - im2, num1.getImaginaryPart(), 0.0);

	}

	@Test
	public void customMultiplicationTest() {

		EasyMock.expect(num2.toPolar()).andReturn(p1);
		EasyMock.expect(p1.getR()).andReturn(r1);
		EasyMock.expect(p1.getTheta()).andReturn(t1);

		EasyMock.replay(num2, p1);
		num1.multiply(num2);
		EasyMock.verify(num2, p1);

		double expectedRe = Math.pow(r1, 2) * Math.cos(2 * t1);
		double expectedIm = Math.pow(r1, 2) * Math.sin(2 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

	}

	@Test
	public void customDivisionTest() {

		EasyMock.expect(num2.toPolar()).andReturn(p1);
		EasyMock.expect(p1.getR()).andReturn(r1);
		EasyMock.expect(p1.getTheta()).andReturn(t1);

		EasyMock.replay(num2, p1);
		num1.divide(num2);
		EasyMock.verify(num2, p1);

		double expectedRe = Math.cos(0.0);
		double expectedIm = Math.sin(0.0);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

	}

	@Test
	public void customPowerTest() {

		double expectedRe;
		double expectedIm;

		num1.pow(2);

		expectedRe = Math.pow(r1, 2) * Math.cos(2 * t1);
		expectedIm = Math.pow(r1, 2) * Math.sin(2 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

		resetNum1();
		num1.pow(3);

		expectedRe = Math.pow(r1, 3) * Math.cos(3 * t1);
		expectedIm = Math.pow(r1, 3) * Math.sin(3 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

		resetNum1();
		num1.pow(0);

		expectedRe = Math.cos(0.0);
		expectedIm = Math.sin(0.0);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

		resetNum1();
		num1.pow(-1);

		expectedRe = Math.pow(r1, -1) * Math.cos(-1 * t1);
		expectedIm = Math.pow(r1, -1) * Math.sin(-1 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

		resetNum1();
		num1.pow(-8.9845);

		expectedRe = Math.pow(r1, -8.9845) * Math.cos(-8.9845 * t1);
		expectedIm = Math.pow(r1, -8.9845) * Math.sin(-8.9845 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);
	}

	@Test
	public void customSqrtTest() {

		num1.sqrt();

		double expectedRe = Math.pow(r1, 0.5) * Math.cos(0.5 * t1);
		double expectedIm = Math.pow(r1, 0.5) * Math.sin(0.5 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);
	}

	@Test
	public void rectangularToRectangularReturnsItself() {
		assertSame(num1, num1.toRectangular());
	}

	@Test
	public void customToPolarTest() {

		Polar polar = num1.toPolar();

		assertEquals(r1, polar.getR(), 0.0);
		assertEquals(t1, polar.getTheta(), 0.0001);

	}

	@Test
	public void equalsTest() {

		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(re1);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im1);

		EasyMock.replay(num2);
		assertTrue(num1.equals(num2));
		EasyMock.verify(num2);

		EasyMock.reset(num2);
		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);

		EasyMock.replay(num2);
		assertFalse(num1.equals(num2));
		EasyMock.verify(num2);
	}

	@Test
	public void stringTest() {
		assertEquals("1.0+1.0i", num1.toString());

		num1.setRealPart(-1.0);
		assertEquals("-1.0+1.0i", num1.toString());

		num1.setImaginaryPart(-1.0);
		assertEquals("-1.0-1.0i", num1.toString());

		num1.setRealPart(1.0);
		assertEquals("1.0-1.0i", num1.toString());

		num1.setImaginaryPart(0.0);
		assertEquals("1.0+0.0i", num1.toString());

	}

	@Test
	public void conjugateTest() {

		num1.conjugate();

		assertEquals(re1, num1.getRealPart(), 0.0001);
		assertEquals(-1 * im1, num1.getImaginaryPart(), 0.0001);
	}

	private void resetNum1() {
		num1.setX(re1);
		num1.setY(im1);
		num1.setZ(im1);
	}

}
