import lejos.robotics.subsumption.*;
import lejos.nxt.*;
public class Labyrinth implements Behavior {
	
	UltrasonicSensor sonic;
	TouchSensor touch;
	
	boolean isPressed;
	int sound_dist;
	//TODO durch globale Konstanten ersetzen
	int max_dist = 15;
	int min_dist = 9;
		
	public Labyrinth(SensorPort sonicPort, SensorPort touchPort){
		sonic = new UltrasonicSensor(sonicPort);
		touch = new TouchSensor(touchPort);
	}
	
	public boolean takeControl() {
		
		sound_dist = sonic.getDistance();
		isPressed = touch.isPressed();
		return (isInRange(sound_dist) || isPressed);
	}
	
	public void suppress(){
		
	}
	
	public void action(){
		
		if(isPressed) {
			Movement.stop();
		}
		
		
	}
	
	private boolean isInRange(int dist){
		return (dist < max_dist && dist > min_dist );
	}
}
