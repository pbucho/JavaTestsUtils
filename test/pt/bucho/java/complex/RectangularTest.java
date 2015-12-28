package pt.bucho.java.complex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class RectangularTest extends CommonTestClass {

	Rectangular num1, num2;
	Polar p1;

	@Before
	public void setUp() throws Exception {
		num1 = new Rectangular(re1, im1);
		num2 = EasyMock.createMock(Rectangular.class);
		p1 = EasyMock.createMock(Polar.class);
	}

	@Test
	public void rectangularAdditionTest() {

		mockExpectation();

		EasyMock.replay(num2);

		num1.add(num2);

		EasyMock.verify(num2);

		assertEquals(re1 + re2, num1.getRealPart(), 0.0);
		assertEquals(im1 + im2, num1.getImaginaryPart(), 0.0);

	}
	
	@Test
	public void polarAdditionTest(){
		
		EasyMock.expect(p1.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(p1, num2);
		num1.add(p1);
		EasyMock.verify(p1, num2);
		
		assertEquals(re1 + re2, num1.getRealPart(), 0.0);
		assertEquals(im1 + im2, num1.getImaginaryPart(), 0.0);
		
	}
	
	@Test
	public void rectangularSubtractionTest() {

		mockExpectation();

		EasyMock.replay(num2);

		num1.subtract(num2);

		EasyMock.verify(num2);

		assertEquals(re1 - re2, num1.getRealPart(), 0.0);
		assertEquals(im1 - im2, num1.getImaginaryPart(), 0.0);

	}
	
	@Test
	public void polarSubtractionTest(){
		
		EasyMock.expect(p1.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(p1, num2);
		num1.subtract(p1);
		EasyMock.verify(p1, num2);
		
		assertEquals(re1 - re2, num1.getRealPart(), 0.0);
		assertEquals(im1 - im2, num1.getImaginaryPart(), 0.0);
	}

	@Test
	public void rectangularMultiplicationTest() {

		EasyMock.expect(num2.toPolar()).andReturn(p1);
		EasyMock.expect(p1.getR()).andReturn(r1);
		EasyMock.expect(p1.getTheta()).andReturn(t1);

		EasyMock.replay(num2, p1);
		num1.multiply(num2);
		EasyMock.verify(num2, p1);

		double expectedRe = Math.pow(r1, 2) * Math.cos(2 * t1);
		double expectedIm = Math.pow(r1, 2) * Math.sin(2 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

	}
	
	@Test
	public void polarMultiplicationTest(){
		
		EasyMock.expect(p1.toPolar()).andReturn(p1);
		EasyMock.expect(p1.getR()).andReturn(r1);
		EasyMock.expect(p1.getTheta()).andReturn(t1);
		
		EasyMock.replay(p1);
		num1.multiply(p1);
		EasyMock.verify(p1);
		
		double expectedRe = Math.pow(r1, 2) * Math.cos(2 * t1);
		double expectedIm = Math.pow(r1, 2) * Math.sin(2 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);
		
	}

	@Test
	public void rectangularDivisionTest() {

		EasyMock.expect(num2.toPolar()).andReturn(p1);
		EasyMock.expect(p1.getR()).andReturn(r1);
		EasyMock.expect(p1.getTheta()).andReturn(t1);

		EasyMock.replay(num2, p1);
		num1.divide(num2);
		EasyMock.verify(num2, p1);

		double expectedRe = Math.cos(0.0);
		double expectedIm = Math.sin(0.0);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

	}
	
	@Test
	public void polarDivisionTest(){
		
		EasyMock.expect(p1.toPolar()).andReturn(p1);
		EasyMock.expect(p1.getR()).andReturn(r1);
		EasyMock.expect(p1.getTheta()).andReturn(t1);
		
		EasyMock.replay(p1);
		num1.divide(p1);
		EasyMock.verify(p1);
		
		double expectedRe = Math.cos(0.0);
		double expectedIm = Math.sin(0.0);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);
	}
	
	@Test
	public void rectangularPowerTest() {

		double expectedRe;
		double expectedIm;

		num1.pow(2);

		expectedRe = Math.pow(r1, 2) * Math.cos(2 * t1);
		expectedIm = Math.pow(r1, 2) * Math.sin(2 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

		resetNum1();
		num1.pow(3);

		expectedRe = Math.pow(r1, 3) * Math.cos(3 * t1);
		expectedIm = Math.pow(r1, 3) * Math.sin(3 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

		resetNum1();
		num1.pow(0);

		expectedRe = Math.cos(0.0);
		expectedIm = Math.sin(0.0);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

		resetNum1();
		num1.pow(-1);

		expectedRe = Math.pow(r1, -1) * Math.cos(-1 * t1);
		expectedIm = Math.pow(r1, -1) * Math.sin(-1 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);

		resetNum1();
		num1.pow(-8.9845);

		expectedRe = Math.pow(r1, -8.9845) * Math.cos(-8.9845 * t1);
		expectedIm = Math.pow(r1, -8.9845) * Math.sin(-8.9845 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);
	}
	
	@Test
	public void rectangularSqrtTest() {

		num1.sqrt();

		double expectedRe = Math.pow(r1, 0.5) * Math.cos(0.5 * t1);
		double expectedIm = Math.pow(r1, 0.5) * Math.sin(0.5 * t1);

		assertEquals(expectedRe, num1.getRealPart(), 0.0001);
		assertEquals(expectedIm, num1.getImaginaryPart(), 0.0001);
	}
	
	@Test
	public void rectangularToRectangularReturnsItself() {
		assertSame(num1, num1.toRectangular());
	}
	
	@Test
	public void rectangularToPolarTest() {

		Polar polar = num1.toPolar();

		assertEquals(r1, polar.getR(), 0.0);
		assertEquals(t1, polar.getTheta(), 0.0001);

	}
	
	@Test
	public void equalsTest() {

		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(re1);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im1);

		EasyMock.replay(num2);
		assertTrue(num1.equals(num2));
		EasyMock.verify(num2);

		EasyMock.reset(num2);
		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);

		EasyMock.replay(num2);
		assertFalse(num1.equals(num2));
		EasyMock.verify(num2);
	}
	
	@Test
	public void stringTest() {
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
	
	@Test
	public void conjugateTest(){
		
		num1.conjugate();
		
		assertEquals(re1, num1.getRealPart(), 0.0001);
		assertEquals(-1 * im1, num1.getImaginaryPart(), 0.0001);
	}
	
	@Test
	public void rectangularArgumentConstructorTest(){
		
		EasyMock.expect(num2.toRectangular()).andReturn(num2).times(2);
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(num2);
		num1 = new Rectangular(num2);
		EasyMock.verify(num2);
		
		assertEquals(re2, num1.getRealPart(), 0.0);
		assertEquals(im2, num1.getImaginaryPart(), 0.0);
		
	}
	
	@Test
	public void polarArgumentConstructorTest(){
		
		EasyMock.expect(p1.toRectangular()).andReturn(num2).times(2);
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(p1, num2);
		num1 = new Rectangular(p1);
		EasyMock.verify(p1, num2);
		
		assertEquals(re2, num1.getRealPart(), 0.0);
		assertEquals(im2, num1.getImaginaryPart(), 0.0);
		
	}
	
	@Test
	public void doubleArgumentConstructorTest(){
		
		num1 = new Rectangular(re2, im2);
		
		assertEquals(re2, num1.getRealPart(), 0.0);
		assertEquals(im2, num1.getImaginaryPart(), 0.0);
		
	}
	
	@Test
	public void noArgConstructorTest(){
		
		num1 = new Rectangular();
		
		assertEquals(0.0, num1.getRealPart(), 0.0);
		assertEquals(0.0, num1.getImaginaryPart(), 0.0);
		
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void complexArgumentConstructorTest(){
		
		ComplexNumber complex = EasyMock.createMock(ComplexNumber.class);
		EasyMock.expect(complex.toRectangular()).andReturn(num2).times(2);
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);
		
		EasyMock.replay(complex, num2);
		num1 = new Rectangular(complex);
		EasyMock.verify(complex, num2);
		
		assertEquals(re2, num1.getRealPart(), 0.0);
		assertEquals(im2, num1.getImaginaryPart(), 0.0);
		
	}
	
	private void mockExpectation() {
		EasyMock.expect(num2.toRectangular()).andReturn(num2);
		EasyMock.expect(num2.getRealPart()).andReturn(re2);
		EasyMock.expect(num2.getImaginaryPart()).andReturn(im2);
	}

	private void resetNum1() {
		num1.setRealPart(re1);
		num1.setImaginaryPart(im1);
	}
	
}
