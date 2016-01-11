package pt.bucho.java.designpatterns.command;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculationCommandTest {

	Command cmd;
	
	@Before
	public void setUp() throws Exception {
		cmd = new SumCommand(1, 2);
	}

	@Test
	public void executionTest() {
		cmd.execute();
		assertEquals(3, ((SumCommand) cmd).getResult());
	}

}
