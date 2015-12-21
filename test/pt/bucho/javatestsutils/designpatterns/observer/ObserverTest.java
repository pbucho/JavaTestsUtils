package pt.bucho.javatestsutils.designpatterns.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import pt.bucho.javatestsutils.designpatterns.observer.Observer;
import pt.bucho.javatestsutils.designpatterns.observer.ObserverImpl;
import pt.bucho.javatestsutils.designpatterns.observer.Subject;
import pt.bucho.javatestsutils.designpatterns.observer.SubjectImpl;

public class ObserverTest {

	Subject subject;
	Observer obs1, obs2;
	
	@Before
	public void setUp() throws Exception {
		subject = new SubjectImpl();
		obs1 = new ObserverImpl();
		obs2 = new ObserverImpl();
		
		subject.registerObserver(obs1);
		subject.registerObserver(obs2);
	}

	@Test
	public void observersAreNotifiedOfChanges() {
		assertNull(((ObserverImpl) obs1).getState());
		assertNull(((ObserverImpl) obs2).getState());
		
		Object newObject = new String("New object");
		
		((SubjectImpl) subject).setState(newObject);
		
		assertEquals(newObject, ((ObserverImpl) obs1).getState());
		assertEquals(newObject, ((ObserverImpl) obs2).getState());
	}

}
