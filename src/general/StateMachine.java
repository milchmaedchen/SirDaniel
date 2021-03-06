package general;

import p0_Race.Race;
import p10_btGateV2.P10;
import p1_labyrinth.P1;
import p2_Bridge.P2;
import p5_turntable.P5;
import p6_slider.P6;
import p7_rocker.P7;
import p8_Line.P8_Line;
import p8_colorbuttons.ColorButtons;
import p9_swamp.P9;
import general.Settings.State;

public class StateMachine {
	
	State state;
	P2 bridge = new P2();
	P1 labyrinth = new P1();
	P9 swamp = new P9();
	Race race = new Race();
	P8_Line line = P8_Line.getInstance();
	P5 turntable = P5.getInstance();
	P6 slider = P6.getInstance();
	P10 gate = new P10();
	P7 rocker = P7.getInstance();
	ColorButtons colorGate = ColorButtons.getInstance();	
	
	public StateMachine() {
		this.state = null;
	}
	
	public void setState(State newState) {
		if (state != null) abortState();
		this.state = newState;		
		
		switch (state) {
		case gate: System.out.println("Gate"); gate.start(); break;
		case swamp: System.out.println("Swamp"); swamp.start(); break;
		case bridge:  System.out.println("Bridge"); bridge.start(); break;
		case line: System.out.println("Line"); line.start(1); break;
		case labyrinth:  System.out.println("Labyrinth"); labyrinth.start(); break;
		case colorGate: System.out.println("ColorGate"); colorGate.start(false); break;
		case rocker: System.out.println("Rocker"); rocker.start(); break;
		case turntable: System.out.println("Turntable"); turntable.start(false); break;
		case slider: System.out.println("Slider"); slider.start(); break;
		case race: System.out.println("Race"); race.start(); break;
//		case boss: System.out.println("Boss"); break;
		}
	}
	
	public void abortState() {
		switch (state) {
		case gate: System.out.println("Abort Gate"); gate.stop(); break;
		case swamp: System.out.println("Abort Swamp"); swamp.stop(); break;
		case bridge:  System.out.println("Abort Bridge"); bridge.stop(); break;
		case line: System.out.println("Abort Line"); line.stop(); break;
		case labyrinth:  System.out.println("Abort Labyrinth"); labyrinth.stop(); break;
		case colorGate: System.out.println("ColorGate"); colorGate.stop(); break;
		case rocker: System.out.println("Abort Rocker"); rocker.stop(); break;
		case turntable: System.out.println("Abort Turntable"); turntable.stop(); break;
		case slider: System.out.println("Abort Slider"); slider.stop(); break;
		case race: System.out.println("Abort Race"); race.stop(); break;
//		case boss: System.out.println("Boss"); break;
		}
		state = null;
	}
	
}
