package p9_swamp;
import p1_labyrinth.P1_Correct;
import p1_labyrinth.P1_DriveForward;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

import general.SirDanielArbitrator;
import general.SuperMotor;

public class P9 {
	
	private SirDanielArbitrator arby;
	private UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
	
	private int min_dist = 13;

	
   public void start() {
	   System.out.println("Swamp started.");
    
	    SuperMotor.turnTo(180, false);
	    
		//Calibration.labyrinth = true;
//		Settings.labyrinth = true;
		
		Behavior forward = new P1_DriveForward(150);
		Behavior correct = new P9_Correct(sonic, min_dist);
		Behavior endSwamp = new EndSwamp();
		Behavior [] b = {forward,correct, endSwamp};
		arby = new SirDanielArbitrator(b,true);
		Thread t =  new Thread(arby);
		t.start();
	}
   
   public void stop() {
	   System.out.println("Swamp stopped.");
	   arby.stop();
   }



}
