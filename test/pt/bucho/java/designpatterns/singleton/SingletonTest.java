package pt.bucho.java.designpatterns.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class SingletonTest {

	Singleton singleton1, singleton2;
	TestObject obj1, obj2;
	
	@Before
	public void setUp() throws Exception {
		singleton1 = Singleton.getSingleton();
		singleton2 = Singleton.getSingleton();
		obj1 = new TestObject();
		obj2 = new TestObject();
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
	
	@Test
	public void communicationThroughSingleton(){
		obj1.setSingleton(singleton1);
		obj2.setSingleton(singleton2);
		
		obj1.setValue(3);
		assertEquals(3, obj2.getValue());
	}

}
