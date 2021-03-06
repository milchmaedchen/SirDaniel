package p8_Line;

import p4_LineFollower.Config;
import p5_turntable.P5;
import p8_colorbuttons.ColorButtons;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.ClaudisMain;
import general.Movement;
import general.Section;
import general.Settings;
import general.SirDanielArbitrator;
import general.SuperMotor;

public class P8_Line {
	
	private SirDanielArbitrator arby;
	private UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	int calledBy = 0;
	
	private static P8_Line instance = null;
	

	public static P8_Line getInstance() {
		if(instance == null) {
			instance = new P8_Line();
		}
		return instance;
	}
	
	public void start(int calledBy) {
		this.calledBy = calledBy;
		
			P8_Config.numberOfSearches = 0;
			P8_Config.leftTurn = true;
			P8_Config.lost = false;
		
			Behavior findLine = new P8_FindLine();
			Behavior foundLine = new P8_FoundLine();
			Behavior lost = new P8_Lost();
			Behavior findEnd = new P8_FindEnd();
			Behavior avoidObstacle = new P8_AvoidObstacle(sonic);
			
			Behavior [] b = {foundLine, findLine, findEnd, lost, avoidObstacle};
			
			arby = new SirDanielArbitrator(b, true);
			
			Thread t = new Thread(arby);
			
			System.out.println("Line started");
//			SuperMotor.calibrate();
			SuperMotor.turnTo(90, false);
			// damit die Linie auch gefunden wird
			Movement.getInstance().setTravelSpeed(360);
			Movement.getInstance().travel(20);
			
			t.start();
//		}
	}

	public void stop() {
		arby.stop();
		if (calledBy == 0) {
			P5.getInstance().start(true);
		}
		else if (calledBy == 2) {
			ColorButtons.getInstance().start(true);
		} else {
			ClaudisMain.searchBarcode();
		}
	}
	
	
	
	
	
	
	
	
	   /*public static void main(String [] args) {
		    
			UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
			
//			Arbitrator arby = new Arbitrator(b, true);
			SirDanielArbitrator arby = new SirDanielArbitrator(b,true);
			
			Movement.getInstance().setTravelSpeed(360);
//			P8_Config.lost = false;
			P8_Config.numberOfSearches = 0;
			Thread t = new Thread(arby);			
			Button.waitForAnyPress();
			SuperMotor.setSpeed(380);
			SuperMotor.calibrate();
			SuperMotor.turnTo(90, false);
			t.start();
//			arby.start();
			LCD.drawString("rausgesprungen", 0, 0);
			Button.waitForAnyPress();
			
	   }

*/


}
