import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class P3 {

	static public boolean foundLineForFirstTime = false; // false!
	static public int numberOfSearches = 0;
	static public boolean stop = false;
	static public boolean search = true;
	static public boolean end = false;
	
	static LightSensor light = new LightSensor(SensorPort.S4);
	
	static public int threshold = 410;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Behavior p3 = new P3_Behavior();
		Behavior [] bArray = {p3};
		Arbitrator arby = new Arbitrator(bArray,true);
	    arby.start();

	}

}
