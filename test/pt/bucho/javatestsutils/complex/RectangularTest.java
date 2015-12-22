package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class RectangularTest extends CommonTestClass{

	Rectangular num1, num2;
	Polar p1;
	
	@Before
	public void setUp() throws Exception {
		num1 = new Rectangular(1.0, 1.0);
		num2 = EasyMock.createMock(Rectangular.class);
		p1 = EasyMock.createMock(Polar.class);
	}

	@Test
	public void rectanguarAdditionTest() {

		mockExpectation();
		
		EasyMock.replay(num2);
		
		num1.add(num2);
		
		EasyMock.verify(num2);
		
		assertEquals(2.0, num1.getRealPart(), 0.0);
		assertEquals(2.0, num1.getImaginaryPart(), 0.0);
		
	}
	
	@Test
	public void rectangularSubtractionTest() {
		
		mockExpectation();
		
		EasyMock.replay(num2);
		
		num1.subtract(num2);
		
		EasyMock.verify(num2);
		
		assertEquals(0.0, num1.getRealPart(), 0.0);
		assertEquals(0.0, num1.getImaginaryPart(), 0.0);
		
	}
	
	@Test
	public void rectuangularMultiplicationTest(){
		fail("NYI");
	}
	
	@Test
	public void rectuangularDivisionTest(){
		fail("NYI");
	}
	
	@Test
	public void rectuangularPowerTest(){
		fail("NYI");
	}
	
	@Test
	public void rectuangularSqrtTest(){
		fail("NYI");
	}
	
	@Test
	public void rectangularToRectangularReturnsItself(){
		assertSame(num1, num1.toRectangular());
	}
	
	@Test
	public void rectangularToPolarTest(){
		
		Polar polar = num1.toPolar();
		
		assertEquals(Math.sqrt(2.0), polar.getR(), 0.0);
		assertEquals(Math.PI / 4.0, polar.getTheta(), 0.0001);
		
	}
	
	@Test
	public void equalsTest(){

		mockExpectation();
		
		EasyMock.replay(num2);
		assertTrue(num1.equals(num2));
		EasyMock.verify(num2);
		
		EasyMock.reset(num2);
		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(0.0);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(1.0);
		
		EasyMock.replay(num2);
		assertFalse(num1.equals(num2));
		EasyMock.verify(num2);
	}
	
	@Test
	public void stringTest(){
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
	
	private void mockExpectation(){
		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(1.0);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(1.0);
	}
	
}
