package pt.bucho.java.designpatterns.command;

public class TestObject {
	
	private String status;
	
	public TestObject(){
		status = "UNITIALIZED";
	}
	
	public void activate(){
		status = "ACTIVATED";
	}
	
	public void deactivate(){
		status = "DEACTIVATED";
	}
	
	public String getStatus(){
		return status;
	}
	
	@Override
	public String toString(){
		return getStatus();
	}

}
