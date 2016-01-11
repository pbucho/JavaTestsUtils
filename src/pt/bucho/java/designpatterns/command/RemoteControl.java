package pt.bucho.java.designpatterns.command;

public interface RemoteControl {

	public void changeChannel(int newChannel);

	public void changeVolume(int diff);
	
	public void turnOn();
	
	public void turnOff();
	
}
