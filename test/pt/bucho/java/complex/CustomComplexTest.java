package pt.bucho.java.complex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class CustomComplexTest extends CommonTestClass{

	@SuppressWarnings("rawtypes")
	ComplexNumber cn;
	CustomComplex num1, num2;
	Rectangular rec1;
	Polar p1;

	@Before
	public void setUp() {
		num1 = new CustomComplex();
		num1.setX(re1);
		num1.setY(im1);
		num2 = EasyMock.createMock(CustomComplex.class);
		rec1 = EasyMock.createMock(Rectangular.class);
		p1 = EasyMock.createMock(Polar.class);
		cn = EasyMock.createMock(ComplexNumber.class);
	}

	@Test
	public void customAdditionTest() {

		EasyMock.expect(cn.toRectangular()).andReturn(rec1);
		EasyMock.expect(rec1.getRealPart()).andReturn(re2);
		EasyMock.expect(rec1.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(cn, rec1);
		num1.add(cn);
		EasyMock.verify(cn, rec1);
		
		assertEquals(re1 + re2, num1.getX(), 0.0);
		assertEquals(im1 + im2, num1.getY(), 0.0);

	}

	@Test
	public void customSubtractionTest() {

		EasyMock.expect(cn.toRectangular()).andReturn(rec1);
		EasyMock.expect(rec1.getRealPart()).andReturn(re2);
		EasyMock.expect(rec1.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(cn, rec1);
		num1.subtract(cn);
		EasyMock.verify(cn, rec1);
		
		assertEquals(re1 - re2, num1.getX(), 0.0);
		assertEquals(im1 - im2, num1.getY(), 0.0);

	}

	@Test
	public void customMultiplicationTest() {

		EasyMock.expect(cn.toPolar()).andReturn(p1);
		EasyMock.expect(p1.getR()).andReturn(r1);
		EasyMock.expect(p1.getTheta()).andReturn(t1);
		
		EasyMock.replay(cn, p1);
		num1.multiply(cn);
		EasyMock.verify(cn, p1);
		
		double expectedX = Math.pow(r1, 2) * Math.cos(2 * t1);
		double expectedY = Math.pow(r1, 2) * Math.sin(2 * t1);

		assertEquals(expectedX, num1.getX(), 0.0);
		assertEquals(expectedY, num1.getY(), 0.0);

	}

	@Test
	public void customDivisionTest() {

		EasyMock.expect(cn.toPolar()).andReturn(p1);
		EasyMock.expect(p1.getR()).andReturn(r1);
		EasyMock.expect(p1.getTheta()).andReturn(t1);
		
		EasyMock.replay(cn, p1);
		num1.divide(cn);
		EasyMock.verify(cn, p1);
		
		double expectedX = Math.cos(0.0);
		double expectedY = Math.sin(0.0);

		assertEquals(expectedX, num1.getX(), 0.0);
		assertEquals(expectedY, num1.getY(), 0.0);

	}

	@Test
	public void customPowerTest() {

		num1.pow(2);

		double expectedX = Math.pow(r1, 2) * Math.cos(2 * t1);
		double expectedY = Math.pow(r1, 2) * Math.sin(2 * t1);

		assertEquals(expectedX, num1.getX(), 0.0);
		assertEquals(expectedY, num1.getY(), 0.0);

	}

	@Test
	public void customSqrtTest() {

		num1.sqrt();

		double expectedX = Math.pow(r1, 0.5) * Math.cos(0.5 * t1);
		double expectedY = Math.pow(r1, 0.5) * Math.sin(0.5 * t1);

		assertEquals(expectedX, num1.getX(), 0.0);
		assertEquals(expectedY, num1.getY(), 0.0);
	}

	@Test
	public void customToCustomReturnsItself() {
		assertSame(num1, num1.transform(num1));
	}

	@Test
	public void rectangularToCustomTest() {

		EasyMock.expect(rec1.toRectangular()).andReturn(rec1);
		EasyMock.expect(rec1.getRealPart()).andReturn(re2);
		EasyMock.expect(rec1.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(rec1);
		num1.transform(rec1);
		EasyMock.verify(rec1);		
		
		assertEquals(re2, num1.getX(), 0.0);
		assertEquals(im2, num1.getY(), 0.0);
		
	}

}
