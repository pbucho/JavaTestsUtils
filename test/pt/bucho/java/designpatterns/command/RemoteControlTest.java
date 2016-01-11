package pt.bucho.java.designpatterns.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RemoteControlTest {

	Tv tv;
	RemoteControl rctrl;
	
	@Before
	public void setUp() throws Exception {
		tv = new Tv();
		rctrl = new TvRemoteControl(tv);
	}

	@Test
	public void changeToChannel2() {
		rctrl.changeChannel(2);
		assertEquals(2, tv.getCurrentChannel());
	}
	
	@Test
	public void changeToChannel3(){
		rctrl.changeChannel(3);
		assertEquals(3, tv.getCurrentChannel());
	}
	
	@Test
	public void increaseVolumeBy5(){
		int currentVolume = tv.getCurrentVolume();
		rctrl.changeVolume(5);
		assertEquals(currentVolume + 5, tv.getCurrentVolume());
	}
	
	@Test
	public void decreaseVolumeBy5(){
		int currentVolume = tv.getCurrentVolume();
		rctrl.changeVolume(-5);
		assertEquals(currentVolume - 5, tv.getCurrentVolume());
	}
	
	@Test
	public void turnOffTv(){
		rctrl.turnOff();
		assertFalse(tv.isTurnedOn());
	}
	
	@Test
	public void turnOnTv(){
		rctrl.turnOn();
		assertTrue(tv.isTurnedOn());
	}

}
