package pt.bucho.java.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject{

	Object myStatus = null;
	List<Observer> observers = new ArrayList<Observer>();
	
	@Override
	public void notifyObservers() {
		for(Observer ob : observers){
			ob.update(myStatus);
		}
	}
	
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void removeObserver(Observer o){
		observers.remove(o);
	}
	
	public void setState(Object o){
		myStatus = o;
		notifyObservers();
	}
	
	public Object getState(){
		return myStatus;
	}
	
}
