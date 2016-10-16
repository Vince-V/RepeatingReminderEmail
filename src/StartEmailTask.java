import java.util.Timer;

public class StartEmailTask {

	public static void main(String[] args) {
		ScheduleEmailTask sendThatEmail = new ScheduleEmailTask();
		
		Timer userTimer = new Timer(); 
		ScheduleEmailTask emailTask = new ScheduleEmailTask();
		
		userTimer.schedule(emailTask, 0, 450000);
		userTimer.schedule(sendThatEmail, 0, 450000);//send email approximately every hour
	}

}
