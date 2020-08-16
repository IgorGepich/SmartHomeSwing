/**
 * @author Ihor Sutulov
 * @version 2.1 Maven
 */

import ua.smartHome.switchers.Lamp;
import ua.smartHome.switchers.LampFlora;
import ua.smartHome.switchers.LampPlus;
import ua.smartHome.ui.MainFrame;
import ua.smartHome.ui.UpdateSensorsData;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MqttApplication  {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new MainFrame());

		UpdateSensorsData updateSensorsData = new UpdateSensorsData();
		updateSensorsData.sensorConnector();

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(updateSensorsData, 5,30, TimeUnit.SECONDS);

/**
* Lamp Switchers
*/
		executorService.execute(new Lamp());
		executorService.execute(new LampPlus());
		executorService.execute(new LampFlora());
	}
}
