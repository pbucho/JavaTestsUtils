package pt.bucho.java.complex;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.java.complex.Polar;
import pt.bucho.java.complex.Rectangular;

public class PolarTransformTest extends CommonTestClass{

	Polar num1, num2;
	Rectangular rec1;
	CustomComplex cc1;
	
	@Before
	public void setUp() throws Exception {
		num1 = new Polar(r1, t1);
		num2 = EasyMock.createMock(Polar.class);
		rec1 = EasyMock.createMock(Rectangular.class);
		cc1 = EasyMock.createMock(CustomComplex.class);
	}

	@Test
	public void transformPolarToPolarTest() {
		
		EasyMock.expect(num2.toPolar()).andReturn(num2);
		setExpectations();
		
		EasyMock.replay(num2);
		num1.transform(num2);
		EasyMock.verify(num2);
		
		makeAssertions();
	}
	
	@Test
	public void transformRectangularToPolarTest(){
		
		EasyMock.expect(rec1.toPolar()).andReturn(num2);
		setExpectations();
		
		EasyMock.replay(rec1, num2);
		num1.transform(rec1);
		EasyMock.verify(rec1, num2);
		
		makeAssertions();
	}
	
	@Test
	public void transformCustomToPolarTest(){
		
		EasyMock.expect(cc1.toPolar()).andReturn(num2);
		setExpectations();
		
		EasyMock.replay(cc1, num2);
		num1.transform(cc1);
		EasyMock.verify(cc1, num2);
		
		makeAssertions();
	}
	
	private void setExpectations(){
		EasyMock.expect(num2.getR()).andReturn(r2);
		EasyMock.expect(num2.getTheta()).andReturn(t2);
	}
	
	private void makeAssertions(){
		assertEquals(r2, num1.getR(), 0.0001);
		assertEquals(t2, num1.getTheta(), 0.0001);
	}

}
