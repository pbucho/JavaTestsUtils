package pt.bucho.java.designpatterns.factory;

public class CarStand {
	
	CarFactory carFactory;

	public CarStand(){
		this.carFactory = null;
	}
	
	public CarStand(CarFactory carFactory){
		this.carFactory = carFactory;
	}
	
	public void setCarFactory(CarFactory carFactory){
		this.carFactory = carFactory;
	}
	
	public Car sellCar(String type){
		
		return carFactory.getCar(type);
		
	}

}
