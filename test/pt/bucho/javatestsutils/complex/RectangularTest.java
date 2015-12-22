package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class RectangularTest {

	Rectangular num1, num2;
	Polar p1;
	
	@Before
	public void setUp() throws Exception {
		num1 = new Rectangular();
		num2 = EasyMock.createMock(Rectangular.class);
		p1 = EasyMock.createMock(Polar.class);
	}

	@Test
	public void rectanguarAdditionTest() {
		num1.setRealPart(1.0);
		num1.setImaginaryPart(1.0);
		
		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(1.0);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(1.0);
		
		EasyMock.replay(num2);
		
		num1.add(num2);
		
		EasyMock.verify(num2);
		
		assertEquals(2.0, num1.getRealPart(), 0.0);
		assertEquals(2.0, num1.getImaginaryPart(), 0.0);
		
	}
	
	@Test
	public void rectanguarSubtractionTest() {
		num1.setRealPart(1.0);
		num1.setImaginaryPart(1.0);
		
		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(1.0);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(1.0);
		
		EasyMock.replay(num2);
		
		num1.subtract(num2);
		
		EasyMock.verify(num2);
		
		assertEquals(0.0, num1.getRealPart(), 0.0);
		assertEquals(0.0, num1.getImaginaryPart(), 0.0);
		
	}
	
	@Test
	public void rectangularToRectangularReturnsItself(){
		assertSame(num1, num1.toRectangular());
	}
	
	@Test
	public void polarToRectangularTest(){
		num1.setRealPart(1.0);
		num1.setImaginaryPart(1.0);
		
		Polar polar = num1.toPolar();
		
		assertEquals(Math.sqrt(2.0), polar.getR(), 0.0);
		assertEquals(Math.PI / 4.0, polar.getTheta(), 0.0001);
		
	}
}
