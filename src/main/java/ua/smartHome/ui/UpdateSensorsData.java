package ua.smartHome.ui;

//import ua.smartHome.connection.IMqttConnection;
import ua.smartHome.sensors.InternetThing;
import ua.smartHome.sensors.InternetThingCreator;
import ua.smartHome.constants.UiConstant;

import java.util.HashMap;
import java.util.Map;

/**
 Class UpdateDataTimer update data on screen
 */

public class UpdateSensorsData extends InternetThingCreator implements Runnable {

//	private IMqttConnection connection;
//
//	public void setConnection(IMqttConnection connection){
//		this.connection = connection;
//	}

	public void sensorConnector(){
		fillSensorCollection();
		super.sensorCollection.forEach(InternetThing :: connectMqttServer);
	}

	public Map<String, String> map = new HashMap<>();
		public void addValue(){
//			map.put(dsTemperatureSensor.getSensorId(), dsTemperatureSensor.getSensorDataValue());
			map.put(getDsTemperatureSensor().getSensorId(), getDsTemperatureSensor().getSensorDataValue());

			map.put(amicaTemperatureSensor.getSensorId(), amicaTemperatureSensor.getSensorDataValue());
			map.put(amicaHumiditySensor.getSensorId(), amicaHumiditySensor.getSensorDataValue());
			map.put(amicaBarometerSensor.getSensorId(), amicaBarometerSensor.getSensorDataValue());
			map.put(lolinTemperatureSensor.getSensorId(), lolinTemperatureSensor.getSensorDataValue());
			map.put(lolinHumiditySensor.getSensorId(), lolinHumiditySensor.getSensorDataValue());
			map.put(lolinBarometerSensor.getSensorId(), lolinBarometerSensor.getSensorDataValue());

			map.put(getLampFlora().getSensorId(), getLampFlora().relayStatus);
		}

		//Method print information about sensors and sensors value in console
	public void find(){
			for(Map.Entry<String, String> entry : map.entrySet()){
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
	}

	@Override
	public void run() {
		//unchecked
		addValue();
		find();
		BalconyPanel.dsTemperatureLabel.setText(map.get(getDsTemperatureSensor().getSensorId()) +
				UiConstant.DEGREE.getUiConstant());

		BalconyPanel.temperatureLabel.setText(map.get(amicaTemperatureSensor.getSensorId()) +
				UiConstant.DEGREE.getUiConstant());
		BalconyPanel.humidityLabel.setText(map.get(amicaHumiditySensor.getSensorId()) +
				UiConstant.HUMIDITY.getUiConstant());
		BalconyPanel.barometerLabel.setText(map.get(amicaBarometerSensor.getSensorId()) +
				UiConstant.BAROMETER.getUiConstant());

		RoomPanel.roomTemperatureLabel.setText(map.get(lolinTemperatureSensor.getSensorId()) +
				UiConstant.DEGREE.getUiConstant());
		RoomPanel.roomHumidityLabel.setText(map.get(lolinHumiditySensor.getSensorId()) +
				UiConstant.HUMIDITY.getUiConstant());
		RoomPanel.roomBarometerLabel.setText(map.get(lolinBarometerSensor.getSensorId()) +
				UiConstant.BAROMETER.getUiConstant());
	}
}
