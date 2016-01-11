package pt.bucho.java.designpatterns.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ObjectCommandTest {

	Command cmd;
	TestObject tobj;
	
	@Before
	public void setUp() throws Exception {
		tobj = new TestObject();
		cmd = new ObjectCommand(tobj);
	}

	@Test
	public void initialTest(){
		assertEquals("UNITIALIZED", tobj.toString());
	}
	
	@Test
	public void activateTest() {
		cmd.activate();
		assertEquals("ACTIVATED", tobj.toString());
	}
	
	@Test
	public void deactivateTest(){
		cmd.deactivate();
		assertEquals("DEACTIVATED", tobj.toString());
	}

}
