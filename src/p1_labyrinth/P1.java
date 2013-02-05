package p1_labyrinth;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import general.LineCounting;
import general.Movement;
import general.Settings;
import general.SirDanielArbitrator;

public class P1 implements Behavior {
		
	static Thread t;
	
   public static void main(String [] args) {
	   
	    UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S3);
		int speed = 1;
		int rotationSpeed = 1;
		int min_dist = 10;
		int shouldBe = 10;
		int minimumDifference = 30;
		
		//Calibration.labyrinth = true;
//		Settings.labyrinth = true;
		
		Behavior forward = new P1_DriveForward(200);
		Behavior correct = new P1_Correct(sonic, min_dist);
		Behavior turnRight = new P1_TurnRight(sonic, speed, rotationSpeed, shouldBe, minimumDifference);
		Behavior turnLeft = new P1_TurnLeft(speed, rotationSpeed);
		Behavior read = new LineCounting();
		Behavior [] b = {forward,correct, turnRight, turnLeft, read};
		SirDanielArbitrator arby = new SirDanielArbitrator(b,true);
		t =  new Thread(arby);

		
	}

@Override
public boolean takeControl() {
	// TODO Auto-generated method stub
	return true;
}

@Override
public void action() {
	LCD.drawString("I'm going to labyrinth", 0, 5);
	t.start();
}

@Override
public void suppress() {
//	Settings.labyrinth = false;
}


}
