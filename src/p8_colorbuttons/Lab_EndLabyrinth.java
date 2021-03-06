package p8_colorbuttons;

import lejos.robotics.subsumption.*;
import general.ClaudisMain;
import general.SensorCache;
import general.Settings;

public class Lab_EndLabyrinth implements Behavior{

   private boolean suppressed = false;
   
   public boolean takeControl() {
	   return (SensorCache.getInstance().lightValue > Settings.LIGHT_THRESHOLD);
   }

   public void suppress() {
      suppressed = true;
   }

   public void action() {
	   System.out.println("Bridge Ende");
	   ClaudisMain.searchBarcode();
   }
		

}
