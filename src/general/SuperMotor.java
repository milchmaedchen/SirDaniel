package general;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.MotorPort;
import lejos.nxt.NXTMotor;


public final class SuperMotor {

	static NXTMotor motorC = new NXTMotor(MotorPort.C);
	
	static int halfRotation = 0; 

	
	public static void turnTo(int angle, boolean ImmediateReturn) {
		
		float roundedAngle = (angle/180.0f)*halfRotation;		
		int currentTacho = motorC.getTachoCount();
		
		if (ImmediateReturn){
			Motor.C.rotate((int)(roundedAngle-currentTacho), true);
		}else {
			Motor.C.rotateTo((int)roundedAngle);
		}
		
		}
	
	public static void calibrate(){
		calibrateRight();
		calibrateLeft();
	}
	
	/**Faehrt den Schwenkarm nach rechts und setzt dort den Tacho auf Null**/
	private static void calibrateRight() {
		
		long lastTime = System.currentTimeMillis();
		long timePassed;
		int power = 20;
		
		boolean stalled = false;
		int tachoCountC = -1;

		//Fahre nachrechts bis du anstoesst und setze diesen wert auf null
		while (!stalled) {
			timePassed = System.currentTimeMillis() - lastTime;
			
		if( timePassed > 100) { 
			motorC.setPower(-power);
			
			int currentCountC = motorC.getTachoCount();
		
			if (currentCountC == tachoCountC ) {
				stalled = true;
				LCD.drawString("I stalled...", 0, 6);
				LCD.refresh();
			} else {
				LCD.drawString("I not stalled...", 0, 6);
				LCD.refresh();
			}
			
			tachoCountC = currentCountC;
			lastTime = System.currentTimeMillis();
		}

		}
		LCD.drawString("I reseted the TachoCount",1,1);
		motorC.resetTachoCount();
		motorC.setPower(0);
		
	}
	
	/**Faehrt den Schwenkarm nach links und speichert dessen TachoCount**/
	private static void calibrateLeft(){
		long lastTime = System.currentTimeMillis();
		long timePassed;
		int power = 20;
		boolean stalled = false;
		int tachoCountC = -100;

		//fahre so lange nach links, bis du anstoesst und setze diesen wert auf 180;
		while (!stalled) {
			timePassed = System.currentTimeMillis() - lastTime;
			
			if( timePassed > 100) { 
				motorC.setPower(power);
			
				int currentCountC = motorC.getTachoCount();
		
				if (currentCountC == tachoCountC ) {
					stalled = true;
					LCD.drawString("I stalled...", 0, 6);
					LCD.refresh();
				} else {
					LCD.drawString("I not stalled...", 0, 6);
					LCD.refresh();
				}	
			
				tachoCountC = currentCountC;
				lastTime = System.currentTimeMillis();
			}
		}
		LCD.drawString("I set the halfRotation", 1, 2);
		halfRotation = motorC.getTachoCount();

	}
	
	
}

