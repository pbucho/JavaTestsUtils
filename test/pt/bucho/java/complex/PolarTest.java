package pt.bucho.java.complex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.java.complex.Polar;
import pt.bucho.java.complex.Rectangular;

public class PolarTest extends CommonTestClass {

	Polar num1, num2;
	Rectangular rec;

	@Before
	public void setUp() throws Exception {
		num1 = new Polar(r1, t1);
		num2 = EasyMock.createMock(Polar.class);
		rec = EasyMock.createMock(Rectangular.class);
	}

	@Test
	public void polarAdditionTest() {

		EasyMock.expect(num2.toRectangular()).andReturn(rec);
		EasyMock.expect(rec.getRealPart()).andReturn(re2);
		EasyMock.expect(rec.getImaginaryPart()).andReturn(im2);
		EasyMock.replay(num2, rec);

		num1.add(num2);

		EasyMock.verify(num2, rec);
		
		double expectedR = Math.sqrt(Math.pow(re1 + re2, 2) + Math.pow(im1 + im2, 2));
		double expectedTheta = Math.asin((im1 + im2) / expectedR);

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);
	}
	
	@Test
	public void rectangularAdditionTest(){
		
		EasyMock.expect(rec.toRectangular()).andReturn(rec);
		EasyMock.expect(rec.getRealPart()).andReturn(re2);
		EasyMock.expect(rec.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(rec);
		num1.add(rec);
		EasyMock.verify(rec);
		
		double expectedR = Math.sqrt(Math.pow(re1 + re2, 2) + Math.pow(im1 + im2, 2));
		double expectedTheta = Math.asin((im1 + im2) / expectedR);

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);
		
	}
	
	@Test
	public void polarSubtractionTest() {

		EasyMock.expect(num2.toRectangular()).andReturn(rec);
		EasyMock.expect(rec.getRealPart()).andReturn(re2);
		EasyMock.expect(rec.getImaginaryPart()).andReturn(im2);
		EasyMock.replay(num2, rec);

		num1.subtract(num2);

		EasyMock.verify(num2, rec);

		double expectedR = Math.sqrt(Math.pow(re1 - re2, 2) + Math.pow(im1 - im2, 2));
		double expectedTheta = Math.asin((im1 - im2) / expectedR);

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);
	}
	
	@Test
	public void rectangularSubtractionTest(){
		
		EasyMock.expect(rec.toRectangular()).andReturn(rec);
		EasyMock.expect(rec.getRealPart()).andReturn(re2);
		EasyMock.expect(rec.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(rec);
		num1.subtract(rec);
		EasyMock.verify(rec);
		
		double expectedR = Math.sqrt(Math.pow(re1 - re2, 2) + Math.pow(im1 - im2, 2));
		double expectedTheta = Math.asin((im1 - im2) / expectedR);

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);
		
	}
	
	@Test
	public void polarMultiplicationTest() {

		EasyMock.expect(num2.toPolar()).andReturn(num2);
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);

		EasyMock.replay(num2);

		num1.multiply(num2);

		EasyMock.verify(num2);

		assertEquals(r1 * r2, num1.getR(), 0.0001);
		assertEquals(t1 + t2, num1.getTheta(), 0.0001);
	}
	
	@Test
	public void rectangularMultiplicationTest(){
		
		EasyMock.expect(rec.toPolar()).andReturn(num2);
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);
		
		EasyMock.replay(rec, num2);
		num1.multiply(rec);
		EasyMock.verify(rec, num2);
		
		assertEquals(r1 * r2, num1.getR(), 0.0001);
		assertEquals(t1 + t2, num1.getTheta(), 0.0001);
	}
	
	@Test
	public void polarDivisionTest() {

		EasyMock.expect(num2.toPolar()).andReturn(num2);
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);

		EasyMock.replay(num2);

		num1.divide(num2);

		EasyMock.verify(num2);

		assertEquals(r1 / r2, num1.getR(), 0.0001);
		assertEquals(t1 - t2, num1.getTheta(), 0.0001);
	}
	
	@Test
	public void rectangularDivisionTest(){
		
		EasyMock.expect(rec.toPolar()).andReturn(num2);
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);
		
		EasyMock.replay(rec, num2);
		num1.divide(rec);
		EasyMock.verify(rec, num2);
		
		assertEquals(r1 / r2, num1.getR(), 0.0001);
		assertEquals(t1 - t2, num1.getTheta(), 0.0001);
	}
	
	@Test
	public void polarPowerTest() {

		double expectedR;
		double expectedTheta;

		num1.pow(2);

		expectedR = Math.pow(r1, 2);
		expectedTheta = 2 * t1;

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);

		resetNum1();
		num1.pow(3);

		expectedR = Math.pow(r1, 3);
		expectedTheta = 3 * t1;

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);

		resetNum1();
		num1.pow(0);

		expectedR = Math.pow(r1, 0);
		expectedTheta = 0 * t1;

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);

		resetNum1();
		num1.pow(-1);

		expectedR = Math.pow(r1, -1);
		expectedTheta = -1 * t1;

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);

		resetNum1();
		num1.pow(-8.9845);

		expectedR = Math.pow(r1, -8.9845);
		expectedTheta = -8.9845 * t1;

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);
	}
	
	@Test
	public void polarSqrtTest() {

		num1.sqrt();

		double expectedR = Math.pow(r1, 0.5);
		double expectedTheta = 0.5 * t1;

		assertEquals(expectedR, num1.getR(), 0.0001);
		assertEquals(expectedTheta, num1.getTheta(), 0.0001);
	}

	@Test
	public void polarToPolarReturnsItself() {
		assertSame(num1, num1.toPolar());
	}
	
	@Test
	public void polarToRectangularTest() {

		rec = num1.toRectangular();

		assertEquals(re1, rec.getRealPart(), 0.0001);
		assertEquals(im1, rec.getImaginaryPart(), 0.0001);
	}
	
	@Test
	public void equalsTest() {

		EasyMock.expect(num2.toPolar()).andReturn(num2);
		EasyMock.expect(num2.getR()).andReturn(r1);
		EasyMock.expect(num2.getTheta()).andReturn(t1);

		EasyMock.replay(num2);
		assertTrue(num1.equals(num2));
		EasyMock.verify(num2);

		EasyMock.reset(num2);
		EasyMock.expect(num2.toPolar()).andReturn(num2);
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);

		EasyMock.replay(num2);
		assertFalse(num1.equals(num2));
		EasyMock.verify(num2);

	}
	
	@Test
	public void stringTest() {
		num1.setR(1.0);
		num1.setTheta(1.0);

		assertEquals("1.0 cis 1.0", num1.toString());

		num1.setR(2.0);
		assertEquals("2.0 cis 1.0", num1.toString());

		num1.setTheta(Math.PI / 2.0);
		assertEquals("2.0 cis " + (Math.PI / 2.0), num1.toString());

		num1.setTheta(-1 * Math.PI);
		assertEquals("2.0 cis " + Math.PI, num1.toString());

		num1.setTheta(-1 * Math.PI / 2.0);
		assertEquals("2.0 cis " + (-1 * Math.PI / 2.0), num1.toString());

		try {
			num1.setR(-5.0);
			fail("Exception not thrown");
		} catch (IllegalArgumentException e) {
			// all good
		}
	}
	
	@Test
	public void conjugateTest(){
		num1.conjugate();
		
		assertEquals(r1, num1.getR(), 0.0001);
		assertEquals(-1 * t1, num1.getTheta(), 0.0001);
	}
	
	@Test
	public void rectangularArgumentConstructorTest(){
		
		EasyMock.expect(rec.toPolar()).andReturn(num2).times(2);
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);
		
		EasyMock.replay(rec, num2);
		num1 = new Polar(rec);
		EasyMock.verify(rec, num2);
		
		assertEquals(r2, num1.getR(), 0.0);
		assertEquals(t2, num1.getTheta(), 0.0);
		
	}
	
	@Test
	public void polarArgumentConstructorTest(){

		EasyMock.expect(num2.toPolar()).andReturn(num2).times(2);
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);
		
		EasyMock.replay(rec, num2);
		num1 = new Polar(num2);
		EasyMock.verify(rec, num2);
		
		assertEquals(r2, num1.getR(), 0.0);
		assertEquals(t2, num1.getTheta(), 0.0);
		
	}
	
	@Test
	public void doubleArgumentConstructorTest(){
		
		num1 = new Polar(r2, t2);
		
		assertEquals(r2, num1.getR(), 0.0);
		assertEquals(t2, num1.getTheta(), 0.0);
		
	}
	
	@Test
	public void noArgConstructorTest(){
		
		num1 = new Polar();
		
		assertEquals(0.0, num1.getR(), 0.0);
		assertEquals(0.0, num1.getTheta(), 0.0);
	}
	
	@Test
	public void complexArgumentConstructorTest(){
		
		ComplexNumber complex = EasyMock.createMock(ComplexNumber.class);
		EasyMock.expect(complex.toPolar()).andReturn(num2).times(2);
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);
		
		EasyMock.replay(complex, num2);
		num1 = new Polar(complex);
		EasyMock.verify(complex, num2);
		
		assertEquals(r2, num1.getR(), 0.0);
		assertEquals(t2, num1.getTheta(), 0.0);
		
	}
	
	private void resetNum1() {
		num1.setR(r1);
		num1.setTheta(t1);
	}
	
}
