package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class PolarTest extends CommonTestClass{

	private double re1, re2, im1, im2;
	private double r1, r2, t1, t2;
	Polar num1, num2;
	Rectangular rec;
	
	@Before
	public void setUp() throws Exception {
		num1 = new Polar(1.0, 1.0);
		num2 = EasyMock.createMock(Polar.class);
		rec = EasyMock.createMock(Rectangular.class);
		
		re1 = 1;
		re2 = 2;
		im1 = 1;
		im2 = 2;
		
		r1 = Math.sqrt(Math.pow(re1, 2) + Math.pow(im1, 2));
		r2 = Math.sqrt(Math.pow(re2, 2) + Math.pow(im2, 2));
		t1 = Math.asin(im1 / r1);
		t2 = Math.asin(im2 / r2);
	}

	@Test
	public void polarAdditionTest() {
		num1.setR(r1);
		num1.setTheta(t1);
		
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
	public void polarSubtractionTest() {
		num1.setR(r1);
		num1.setTheta(t1);
		
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
	public void polarMultiplicationTest() {
		
		num1.setR(r1);
		num1.setTheta(t1);
		
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
	public void polarDivisionTest() {
		
		num1.setR(r1);
		num1.setTheta(t1);
		
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
	public void polarPowerTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void polarSqrtTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void polarToPolarReturnsItself(){
		assertSame(num1, num1.toPolar());
	}
	
	@Test
	public void polarToRectangularTest(){
		num1.setR(r1);
		num1.setTheta(t1);
		
		rec = num1.toRectangular();
		
		assertEquals(re1, rec.getRealPart(), 0.0001);
		assertEquals(im1, rec.getImaginaryPart(), 0.0001);
	}
	
	@Test
	public void equalsTest(){
		
		EasyMock.expect(num2.toPolar()).andReturn(num2);
		EasyMock.replay(num2);
		assertTrue(num1.equals(num2));
		EasyMock.verify(num2);
		
		EasyMock.reset(num2);
		EasyMock.expect(num2.toPolar()).andReturn(num2);
		EasyMock.expect(num2.getR()).andReturn(2.0);
		EasyMock.expect(num2.getTheta()).andReturn(1.0);
		
		EasyMock.replay(num2);
		assertFalse(num1.equals(num2));
		EasyMock.verify(num2);
	}
	
	@Test
	public void stringTest(){
		fail("NYI");
	}
	
}
