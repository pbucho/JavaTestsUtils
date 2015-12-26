package pt.bucho.java.complex;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.java.complex.Polar;
import pt.bucho.java.complex.Rectangular;

public class RectangularTransformTest extends CommonTestClass{

	Rectangular num1, num2;
	Polar p1;
	CustomComplex cc1;
	
	@Before
	public void setUp() throws Exception {
		num1 = new Rectangular(re1, im1);
		num2 = EasyMock.createMock(Rectangular.class);
		p1 = EasyMock.createMock(Polar.class);
		cc1 = EasyMock.createMock(CustomComplex.class);
	}

	@Test
	public void transformRectangularToRectangularTest(){
		
		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		setExpectations();
		
		EasyMock.replay(num2);
		num1.transform(num2);
		EasyMock.verify(num2);
		
		makeAssertions();
	}
	
	@Test
	public void transformPolarToRectangularTest(){
		
		EasyMock.expect(p1.toRectangular()).andReturn(num2);
		setExpectations();
		
		EasyMock.replay(p1, num2);
		num1.transform(p1);
		EasyMock.verify(p1, num2);
		
		makeAssertions();
	}
	
	@Test
	public void transformCustomToRectangularTest(){
		
		EasyMock.expect(cc1.toRectangular()).andReturn(num2);
		setExpectations();
		
		EasyMock.replay(cc1, num2);
		num1.transform(cc1);
		EasyMock.verify(cc1, cc1);
		
		makeAssertions();
	}
	
	private void setExpectations(){
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);
	}
	
	private void makeAssertions(){
		assertEquals(re2, num1.getRealPart(), 0.0001);
		assertEquals(im2, num1.getImaginaryPart(), 0.0001);
	}

}
