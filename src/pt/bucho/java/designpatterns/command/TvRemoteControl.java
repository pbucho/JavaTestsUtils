package pt.bucho.java.designpatterns.command;

public class TvRemoteControl implements RemoteControl {

	Tv tv;
	
	public TvRemoteControl(Tv tv){
		this.tv = tv;
	}
	
	@Override
	public void changeChannel(int newChannel) {
		if(newChannel >= 0){
			tv.setCurrentChannel(newChannel);
		}
	}

	@Override
	public void changeVolume(int diff) {
		int previousVolume = tv.getCurrentVolume();
		if(previousVolume + diff >= 0){
			tv.setCurrentVolume(previousVolume + diff);
		}
	}

	@Override
	public void turnOn() {
		tv.setTurnedOn(true);
	}

	@Override
	public void turnOff() {
		tv.setTurnedOn(false);
	}

}
