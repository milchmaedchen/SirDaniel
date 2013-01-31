import lejos.nxt.LightSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;


public class P3_TurnRight implements Behavior {
	Movement movement = new Movement();
	UltrasonicSensor sonic;
	TouchSensor touch;
	int speed;
	int rotationSpeed;
	int shouldBe; // i.e. 10
	int minimumDifference; // i.e. 20 (--> reacts at value 10 + 20 = 30)
	boolean suppressed;
	LightSensor light;

	public P3_TurnRight(UltrasonicSensor sonic, TouchSensor touch, int speed, int rotationSpeed, int shouldBe, int minimumDifference, LightSensor light) {
		this.sonic = sonic;
		this.touch = touch;
		this.speed = speed;
		this.rotationSpeed = rotationSpeed;
		this.shouldBe = shouldBe;
		this.minimumDifference = minimumDifference;
		this.light = light;
	}
	
	public boolean takeControl() {
		return (sonic.getDistance() > (shouldBe + minimumDifference) && !touch.isPressed()) && light.getNormalizedLightValue() < P3_Behavior.threshold;
	}
	
	public void action() {
		suppressed = false;
		movement.forward(speed);
		Delay.msDelay(1000);
		movement.turn_right(90, rotationSpeed);
		movement.forward(speed);
		Delay.msDelay(1000);
		movement.stop();
	}
	
	public void suppress() {
		suppressed = true;
	}
	
	
	

}
