package general;

import lejos.nxt.Button;

public class SMTest {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Bridge
		/*Button.waitForAnyPress();
		Settings.calibrateLight();	
		SuperMotor.calibrate();
		
		Button.waitForAnyPress();
		p2_Bridge.P2 p2 = new p2_Bridge.P2();
		p2.start();*/
		
		
		//Slider
		/*
		Button.waitForAnyPress();
		Settings.calibrateLight();
		SuperMotor.calibrate();
		
		p6_slider.P6 p6 = new p6_slider.P6();
		p6.start();
		*/
		
		//Race
		
		Button.waitForAnyPress();
		Settings.calibrateLight();
		SuperMotor.calibrate();
		
		Button.waitForAnyPress();
		p0_Race.Race race = new p0_Race.Race();
		race.start();
		}
	
	

}
