package ua.smartHome.constants;

public enum MqttTopic {
	DS_TEMPERATURE("boardAmica/sensorDS/temperature/DsOutdoorCelsius"),

	AMICA_BME_TEMPERATURE("boardAmica/sensorBme280/temperature/BmeIndoorCelsius"),
	AMICA_BME_HUMIDITY("boardAmica/sensorBme280/humidity/percentRelative"),
	AMICA_BME_BAROMETER("boardAmica/sensorBme280/barometer/hectoPascal"),

	LOLIN_BME_HUMIDITY("boardLolin/sensorBme280/humidity/percentRelative"),
	LOLIN_BME_TEMPERATURE("boardLolin/sensorBme280/temperature/BmeIndoorCelsius"),
	LOLIN_BME_BAROMETER("boardLolin/sensorBme280/barometer/hectoPascal"),

	LAMP("cmnd/sonoff_1.0/POWER"),
	LAMP_STATUS("tele/sonoff_1.0/STATE"),
	LAMP_PLUS("cmnd/sonoff_1.1/POWER"),
	LAMP_PLUS_STATUS("tele/sonoff_1.1/STATE"),
	LAMP_FLORA("cmnd/sonoff_1.2/POWER");


	private String topicPath;

	MqttTopic(String topicPath) {
		this.topicPath = topicPath;
	}

	public String getTopicPath() {
		return topicPath;
	}

}
