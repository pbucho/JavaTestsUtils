package pt.bucho.javatestsutils.designpatterns.observer;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.javatestsutils.designpatterns.observer.Observer;
import pt.bucho.javatestsutils.designpatterns.observer.Subject;
import pt.bucho.javatestsutils.designpatterns.observer.SubjectImpl;

public class SubjectTest {

	Subject subject;
	Observer obs1, obs2;
	
	@Before
	public void setUp() throws Exception {
		subject = new SubjectImpl();
		obs1 = EasyMock.createMock(Observer.class);
		obs2 = EasyMock.createMock(Observer.class);
		subject.registerObserver(obs1);
		subject.registerObserver(obs2);
	}

	@Test
	public void observerObjectsAreNotified() {
		Object newObject = new String("New object");
		
		obs1.update(newObject);
		EasyMock.expectLastCall().times(2);
		obs2.update(newObject);
		EasyMock.expectLastCall().times(2);
		
		EasyMock.replay(obs1, obs2);
		
		((SubjectImpl) subject).setState(newObject);
		subject.notifyObservers();
		
		EasyMock.verify(obs1, obs2);
	}
}
