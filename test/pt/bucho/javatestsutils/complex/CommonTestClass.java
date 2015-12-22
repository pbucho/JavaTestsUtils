package pt.bucho.javatestsutils.complex;

import java.util.Random;

public abstract class CommonTestClass {
	
	protected double getRandomDouble(){
		Random r = new Random();
		return 100.0 * r.nextDouble();
	}
	
	protected double[] getFourRandomDoubles(){
		double[] doubles = new double[4];
		
		for(int i = 0; i < doubles.length; i++){
			doubles[i] = getRandomDouble();
		}
		
		return doubles;
	}

}
