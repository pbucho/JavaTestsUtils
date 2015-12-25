package pt.bucho.javatestsutils.complex;

import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class ReturnTest extends CommonTestClass{

	@SuppressWarnings("rawtypes")
	ComplexNumber cn;
	Rectangular rec1, rec2;
	Polar pol1, pol2;
	
	@Before
	public void setUp() throws Exception{
		cn = EasyMock.createNiceMock(ComplexNumber.class);
		rec2 = EasyMock.createNiceMock(Rectangular.class);
		pol2 = EasyMock.createNiceMock(Polar.class);
		rec1 = new Rectangular();
		pol1 = new Polar();
	}
	
	@Test
	public void addReturn(){
		rectangularExpectations();
		
		EasyMock.replay(cn, rec2);
		assertNotNull(rec1.add(cn));
		assertNotNull(pol1.add(cn));
		EasyMock.verify(cn, rec2);
	}
	
	@Test
	public void subtractReturn(){
		rectangularExpectations();
		
		EasyMock.replay(cn, rec2);
		assertNotNull(rec1.subtract(cn));
		assertNotNull(pol1.subtract(cn));
		EasyMock.verify(cn, rec2);
	}
	
	@Test
	public void multiplyReturn(){
		polarExpectations();
		
		EasyMock.replay(cn, pol2);
		assertNotNull(rec1.multiply(cn));
		assertNotNull(pol1.multiply(cn));
		EasyMock.verify(cn, pol2);
	}
	
	@Test
	public void divideReturn(){
		polarExpectations();
		
		EasyMock.replay(cn, pol2);
		assertNotNull(rec1.divide(cn));
		assertNotNull(pol1.divide(cn));
		EasyMock.verify(cn, pol2);
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
