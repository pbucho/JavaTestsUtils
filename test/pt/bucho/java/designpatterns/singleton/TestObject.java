package pt.bucho.java.designpatterns.singleton;

public class TestObject {
	
	Singleton singleton;
	
	public void setSingleton(Singleton singleton){
		this.singleton = singleton;
	}
	
	public void setValue(int value){
		singleton.setValue(value);
	}
	
	public int getValue(){
		return singleton.getValue();
	}

}
