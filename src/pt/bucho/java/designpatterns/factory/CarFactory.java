package pt.bucho.java.designpatterns.factory;

public class CarFactory {
	
	public Car getCar(String type){
		if(type.equals("red")){
			return new RedCar();
		}else if(type.equals("green")){
			return new GreenCar();
		}else if(type.equals("blue")){
			return new BlueCar();
		}else{
			return new WhiteCar();
		}
	}

}
