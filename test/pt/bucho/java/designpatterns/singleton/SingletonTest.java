package pt.bucho.java.designpatterns.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class SingletonTest {

	Singleton singleton1, singleton2;
	
	@Before
	public void setUp() throws Exception {
		singleton1 = Singleton.getSingleton();
		singleton2 = Singleton.getSingleton();
	}

	@Test
	public void getSingletonReturnsTheSameTest() {
		assertSame(singleton1, singleton2);
	}
	
	@Test
	public void changesPropagationTest(){
		singleton1.setValue(3);
		assertEquals(3, singleton2.getValue());
	}
	
}
