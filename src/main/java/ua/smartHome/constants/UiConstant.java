package ua.smartHome.constants;

import lombok.Getter;

public enum UiConstant {

	PROGRAM_TITLE("MQTT Smarthome v.2.1"),
	DEGREE(" C\u00b0"),
	HUMIDITY(" %"),
	BAROMETER(" hPa"),
/*
* Border Label Area
*/
	BORDER_TITLE_BALCONY("Balcony"),
	BORDER_TITLE_ROOM("Room"),
	BORDER_TITLE_SWITCH("Switch"),
	BORDER_TITLE_TEMPERATURE("Temperature"),
	BORDER_TITLE_HUMIDITY("Humidity"),
	BORDER_TITLE_BAROMETER("Barometer"),

	BORDER_TITLE_DS_OUTDOOR("DS Outdoor Temp"),
/*
* Image Area
*/
	TEMPERATURE_LABEL_IMAGE("./src/main/resources/images/tempIcon.png"),
	HUMIDITY_LABEL_IMAGE("./src/main/resources/images/humiIcon.png"),
	BAROMETER_LABEL_IMAGE("./src/main/resources/images/baroIcon.png"),

/*
* IP Address Area
*/
	IP_ADDRESS("tcp://77.122.26.246:1883");
//	IP_ADDRESS("tcp://10.0.1.7:1883"); // LOCAL IP

	@Getter
	private final String uiConstant;

	UiConstant(String uiConstant) {
		this.uiConstant = uiConstant;
	}
}
