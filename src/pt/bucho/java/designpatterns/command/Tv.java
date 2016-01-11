package pt.bucho.java.designpatterns.command;

public class Tv {

	private boolean turnedOn;
	private int currentVolume;
	private int currentChannel;
	
	public Tv(){
		turnedOn = false;
		currentVolume = 5;
		currentChannel = 1;
	}
	
	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public void setTurnedOn(boolean turnedOn) {
		this.turnedOn = turnedOn;
	}
	
	public boolean isTurnedOn(){
		return turnedOn;
	}
	
}
