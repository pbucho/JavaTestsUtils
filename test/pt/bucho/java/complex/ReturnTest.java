package pt.bucho.java.complex;

import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.java.complex.ComplexNumber;
import pt.bucho.java.complex.Polar;
import pt.bucho.java.complex.Rectangular;

public class ReturnTest extends CommonTestClass{

	ComplexNumber cn;
	Rectangular rec1, rec2;
	Polar pol1, pol2;
	
	@Before
	public void setUp() throws Exception{
		rec1 = new Rectangular();
		pol1 = new Polar();
		cn = EasyMock.createNiceMock(ComplexNumber.class);
		rec2 = EasyMock.createNiceMock(Rectangular.class);
		pol2 = EasyMock.createNiceMock(Polar.class);
	}
	
	@Test
	public void addReturn(){
		rectangularExpectations();
		
		EasyMock.replay(cn, rec2);
		assertNotNull(rec1.add(cn));
		assertNotNull(pol1.add(cn));
	}
	
	@Test
	public void subtractReturn(){
		rectangularExpectations();
		
		EasyMock.replay(cn, rec2);
		assertNotNull(rec1.subtract(cn));
		assertNotNull(pol1.subtract(cn));
	}
	
	@Test
	public void multiplyReturn(){
		polarExpectations();
		
		EasyMock.replay(cn, pol2);
		assertNotNull(rec1.multiply(cn));
		assertNotNull(pol1.multiply(cn));
	}
	
	@Test
	public void divideReturn(){
		polarExpectations();
		
		EasyMock.replay(cn, pol2);
		assertNotNull(rec1.divide(cn));
		assertNotNull(pol1.divide(cn));
	}
	
	@Test
	public void sqrtReturn(){
		assertNotNull(rec1.sqrt());
		assertNotNull(pol1.sqrt());
	}
	
	@Test
	public void powReturn(){
		assertNotNull(rec1.pow(2.0));
		assertNotNull(pol1.pow(2.0));
	}
	
	@Test
	public void conjugateReturn(){
		assertNotNull(rec1.conjugate());
		assertNotNull(pol1.conjugate());
	}
	
	@Test
	public void getQuadrantReturn(){
		assertNotNull(rec1.getQuadrant());
		assertNotNull(pol1.getQuadrant());
	}
	
	@Test
	public void toRectangularReturn(){
		assertNotNull(rec1.toRectangular());
		assertNotNull(pol1.toRectangular());
	}
	
	@Test
	public void toPolarReturn(){
		assertNotNull(rec1.toPolar());
		assertNotNull(pol1.toPolar());
	}
	
	@Test
	public void transformReturn(){
		rectangularExpectations();
		polarExpectations();
		
		EasyMock.replay(cn, rec2, pol2);
		assertNotNull(rec1.transform(cn));
		assertNotNull(pol1.transform(cn));
	}
	
	private void rectangularExpectations(){
		EasyMock.expect(cn.toRectangular()).andReturn(rec2).times(2);
		EasyMock.expect(rec2.getRealPart()).andReturn(re2);
		EasyMock.expect(rec2.getImaginaryPart()).andReturn(im2);
	}
	
	private void polarExpectations(){
		EasyMock.expect(cn.toPolar()).andReturn(pol2).times(2);
		EasyMock.expect(pol2.getR()).andReturn(r2);
		EasyMock.expect(pol2.getTheta()).andReturn(t2);
	}
}
