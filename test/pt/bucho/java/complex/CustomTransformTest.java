package pt.bucho.java.complex;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class CustomTransformTest extends CommonTestClass{

	CustomComplex num1, num2;
	Rectangular rec1;
	Polar p1;
	
	@Before
	public void setUp(){
		num1 = new CustomComplex();
		num2 = EasyMock.createMock(CustomComplex.class);
		rec1 = EasyMock.createMock(Rectangular.class);
		p1 = EasyMock.createMock(Polar.class);
	}
	
	@Test
	public void transformCustomToCustomTest(){
		
		EasyMock.expect(num2.toRectangular()).andReturn(rec1);
		setExpectations();
		
		EasyMock.replay(num2, rec1);
		num1.transform(num2);
		EasyMock.verify(num2, rec1);
		
		makeAssertions();
		
	}
	
	@Test
	public void transformRectangularToCustomTest(){
		
		EasyMock.expect(rec1.toRectangular()).andReturn(rec1);
		setExpectations();
		
		EasyMock.replay(rec1);
		num1.transform(rec1);
		EasyMock.verify(rec1);
		
		makeAssertions();
		
	}
	
	@Test
	public void transformPolarToCustomTest(){
		
		EasyMock.expect(p1.toRectangular()).andReturn(rec1);
		setExpectations();
		
		EasyMock.replay(p1, rec1);
		num1.transform(p1);
		EasyMock.verify(p1, rec1);
		
		makeAssertions();
		
	}
	
	private void setExpectations(){
		EasyMock.expect(rec1.getRealPart()).andReturn(re1);
		EasyMock.expect(rec1.getImaginaryPart()).andReturn(im1);
	}
	
	private void makeAssertions(){
		assertEquals(re1, num1.getX(), 0.0);
		assertEquals(im1, num1.getY(), 0.0);
	}

}
