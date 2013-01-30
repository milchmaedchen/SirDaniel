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
		
		Behavior follow = new P3FollowLine(light);
		Behavior search = new P3SearchLine(light);
		Behavior end = new P3EndLine();
		Behavior searchStart = new P3SearchLineAtStart(light);
		Behavior gap = new P3CheckGap(light);
		Behavior checkEnd = new P3CheckEndOfLine(light);
		Behavior random = new P3Random();
//		Behavior [] bArray = {b5, b4, b5, b3, b2};
		Behavior [] bArray = {random, searchStart, end, gap, checkEnd, search, follow};
		Arbitrator arby = new Arbitrator(bArray,true);
	    arby.start();

	}

}
