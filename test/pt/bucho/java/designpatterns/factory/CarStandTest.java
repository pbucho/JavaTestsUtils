package pt.bucho.java.designpatterns.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarStandTest {

	CarStand carStand;
	CarFactory carFactory;

	@Before
	public void setUp() {

		carFactory = new CarFactory();
		carStand = new CarStand(carFactory);

	}

	@Test
	public void redCarTest() {
		Car car = carStand.sellCar("red");
		assertEquals("red", car.getColor());
	}

	@Test
	public void greenCarTest() {
		Car car = carStand.sellCar("green");
		assertEquals("green", car.getColor());
	}

	@Test
	public void blueCarTest() {
		Car car = carStand.sellCar("blue");
		assertEquals("blue", car.getColor());
	}

	@Test
	public void whiteCarTest() {
		Car car = carStand.sellCar("white");
		assertEquals("white", car.getColor());
	}
	
	@Test
	public void jeepTest() {
		CarFactory carFactory = new JeepFactory();
		carStand.setCarFactory(carFactory);
		
		Car car = carStand.sellCar("jeep");
		assertEquals("black", car.getColor());
	}

}
