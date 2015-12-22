package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class PolarTest {

	Polar num1, num2;
	Rectangular r1;
	
	@Before
	public void setUp() throws Exception {
		num1 = new Polar(1.0, 1.0);
		num2 = EasyMock.createMock(Polar.class);
		r1 = EasyMock.createMock(Rectangular.class);
	}

	@Test
	public void polarAdditionTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void polarSubtractionTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void polarMultiplicationTest() {
mockExpectation();
		
		EasyMock.replay(num2);
		
		num1.multiply(num2);
		
		EasyMock.verify(num2);
		
		assertEquals(1.0, num1.getR(), 0.0);
		assertEquals(2.0, num1.getTheta(), 0.0);
	}
	
	@Test
	public void polarDivisionTest() {
		fail("Not yet implemented");
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
		fail("NYI");
	}
	
	@Test
	public void rectangularToPolarTest(){
		fail("NYI");
	}
	
	@Test
	public void equalsTest(){
		fail("NYI");
	}
	
	@Test
	public void stringTest(){
		fail("NYI");
	}
	
	private void mockExpectation(){
		EasyMock.expect(num2.toPolar()).andReturn(num2);
		EasyMock.expect(num2.getR()).andReturn(1.0);
		EasyMock.expect(num2.getTheta()).andReturn(1.0);
	}
}
