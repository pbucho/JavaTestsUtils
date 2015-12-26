package pt.bucho.java.designpatterns.observer;

public class ObserverImpl implements Observer{

	Object myState = null;
	
	@Override
	public void update(Object o) {
		myState = o;
	}
	
	public void setState(Object o){
		myState = o;
	}
	
	public Object getState(){
		return myState;
	}
	
	@Override
	public String toString() {
		if (myState != null) {
			return myState.toString();
		} else {
			return "null";
		}
	}
	
}
