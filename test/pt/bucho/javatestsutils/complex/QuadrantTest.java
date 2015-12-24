package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuadrantTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void firstQuadrantTest(){
		assertEquals(new Integer(1), Quadrant.FIRST.getValue());
	}
	
	@Test
	public void secondQuadrantTest(){
		assertEquals(new Integer(2), Quadrant.SECOND.getValue());
	}
	
	@Test
	public void thirsQuadrantTest(){
		assertEquals(new Integer(3), Quadrant.THIRD.getValue());
	}
	
	@Test
	public void fourthQuadrantTest(){
		assertEquals(new Integer(4), Quadrant.FOURTH.getValue());
	}
	
	@Test
	public void positiveRealAxisTest(){
		assertNull(Quadrant.POSITIVE_REAL_AXIS.getValue());
	}
	
	@Test
	public void negativeRealAxisTest(){
		assertNull(Quadrant.NEGATIVE_REAL_AXIS.getValue());
	}
	
	@Test
	public void positiveImaginaryAxisTest(){
		assertNull(Quadrant.POSITIVE_IMAGINARY_AXIS.getValue());
	}
	
	@Test
	public void negativeImaginaryAxisTest(){
		assertNull(Quadrant.NEGATIVE_IMAGINARY_AXIS.getValue());
	}
	
	@Test
	public void originTest(){
		assertEquals(new Integer(0), Quadrant.ORIGIN.getValue());
	}

}
