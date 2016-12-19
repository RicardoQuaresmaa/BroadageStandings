package Auto;

import java.util.Timer;
import java.util.TimerTask;

public class App {
	
    public static void main( String[] args )
    {

 	TimerTask task = new RunMeTask();
    	Timer timer = new Timer();
    	timer.schedule(task, 1000,5000);
    }

}
