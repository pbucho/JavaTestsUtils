package pt.bucho.java.designpatterns.singleton;

public class Singleton {

	private static Singleton instance;
	private int value;
	
	private Singleton(){
		this.value = 0;
	}
	
	public static Singleton getSingleton(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
}
