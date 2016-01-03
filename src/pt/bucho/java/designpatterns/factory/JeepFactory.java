package pt.bucho.java.designpatterns.factory;

public class JeepFactory extends CarFactory {

	@Override
	public Car getCar(String type){
		if(type == "jeep"){
			return new Jeep();
		}else{
			return super.getCar(type);
		}
	}
	
}
