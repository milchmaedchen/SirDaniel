package p1_labyrinth;


import general.Movement;
import lejos.robotics.subsumption.Behavior;


public class P1_DriveRightArc implements Behavior {
	
	boolean suppressed;
	
	public P1_DriveRightArc(int speed) {
		Movement.getInstance().setSpeed(speed);
	}
	
	public boolean takeControl(){
		return true;
	}
	
	public void suppress(){
		
		suppressed= true;
	}
	
	public void action(){
		suppressed = false;

		Movement.getInstance().arc(-800, -360, true);
		
		while(!suppressed){
			Thread.yield();
		}
		
	}

}
