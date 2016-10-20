import java.util.TimerTask;
import java.util.Date;



public class ScheduleEmailTask extends TimerTask {
	
	Date whatsTheDate; //Lets display the date!
	
	@Override
	public void run() {
		whatsTheDate = new Date();
		System.out.println("The current time is : " +whatsTheDate);
	}
}
