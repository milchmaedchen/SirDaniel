package p5_turntable;

import bluetooth.TurnControl;
import general.Movement;
import general.SensorCache;
import lejos.robotics.subsumption.Behavior;

public class P5_Turntable implements Behavior {
	
	// ideally this is a divisor of 120;
	private static final int STEPS = 15;
	private static final int turnAngle = 115/STEPS;

	@Override
	public boolean takeControl() {
		//TODO only when the line is over.
		return true;
	}

	@Override
	public void action() {
		
		TurnControl turntableControl = new TurnControl();
		
		Movement.getInstance().setTravelSpeed(200);
		Movement.getInstance().forward();
		
		while (!SensorCache.getInstance().bumperPressed);
		
		Movement.getInstance().travel(-30);
		Movement.getInstance().turn_left(180);
		
		while (!turntableControl.connectionToTurntableSuccessful());
		for (int i = 0; i < STEPS; i++) {
			turntableControl.turnClockwise(turnAngle);
		}
		
		Movement.getInstance().travel(100);
		
		
		
		
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
	}

}
