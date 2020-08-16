package ua.smartHome.sensors;

import lombok.Getter;
import lombok.ToString;
import ua.smartHome.connection.MqttConnectionImpl;
import ua.smartHome.constants.MqttTopic;
import ua.smartHome.constants.UiConstant;

import java.util.ArrayList;
import java.util.List;

@ToString
public class InternetThingCreator {

	public List<InternetThing> sensorCollection = new ArrayList<>();

	public InternetThingCreator(){
	}

	public void fillSensorCollection(){
		sensorCollection.add(getDsTemperatureSensor());
		sensorCollection.add(lolinTemperatureSensor);
		sensorCollection.add(lolinHumiditySensor);
		sensorCollection.add(lolinBarometerSensor);
		sensorCollection.add(amicaTemperatureSensor);
		sensorCollection.add(amicaHumiditySensor);
		sensorCollection.add(amicaBarometerSensor);
		sensorCollection.add(lamp);
		sensorCollection.add(lampPlus);
		sensorCollection.add(lampFlora);
	}



	@Getter
	private final InternetThing dsTemperatureSensor = new MqttConnectionImpl("Outdoor",
			"DS",
			MqttTopic.DS_TEMPERATURE.getTopicPath(),
			UiConstant.DEGREE.getUiConstant());

	public InternetThing lolinTemperatureSensor = new MqttConnectionImpl("Room",
			"BmeRoomTemp",
			MqttTopic.LOLIN_BME_TEMPERATURE.getTopicPath(),
			UiConstant.DEGREE.getUiConstant());

	public InternetThing lolinHumiditySensor = new MqttConnectionImpl("Room",
			"BmeRoomHum",
			MqttTopic.LOLIN_BME_HUMIDITY.getTopicPath(),
			UiConstant.HUMIDITY.getUiConstant());

	public InternetThing lolinBarometerSensor = new MqttConnectionImpl("Room",
			"BmeRoomBaro",
			MqttTopic.LOLIN_BME_BAROMETER.getTopicPath(),
			UiConstant.BAROMETER.getUiConstant());

	public InternetThing amicaTemperatureSensor = new MqttConnectionImpl("Balcony",
			"BmeBalconyTemp",
			MqttTopic.AMICA_BME_TEMPERATURE.getTopicPath(),
			UiConstant.DEGREE.getUiConstant());

	public InternetThing amicaHumiditySensor = new MqttConnectionImpl("Balcony",
			"BmeBalconyHumidity",
			MqttTopic.AMICA_BME_HUMIDITY.getTopicPath(),
			UiConstant.HUMIDITY.getUiConstant());

	public InternetThing amicaBarometerSensor = new MqttConnectionImpl("Balcony",
			"BmeBalconyBarometer",
			MqttTopic.AMICA_BME_BAROMETER.getTopicPath(),
			UiConstant.BAROMETER.getUiConstant());

	public InternetThing lamp = new MqttConnectionImpl(
			"Room",
			"Lamp",
			MqttTopic.LAMP.getTopicPath());

	public InternetThing lampPlus = new MqttConnectionImpl(
			"Room",
			"Lamp+",
			MqttTopic.LAMP_PLUS.getTopicPath());

	@Getter
	private final InternetThing lampFlora = new MqttConnectionImpl(
			"Room",
			"LampFlora",
			MqttTopic.LAMP_FLORA.getTopicPath());
}
