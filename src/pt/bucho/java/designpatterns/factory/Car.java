package pt.bucho.java.designpatterns.factory;

public abstract class Car {
	
	String color;
	
	public Car(String color){
		setColor(color);
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}

}
