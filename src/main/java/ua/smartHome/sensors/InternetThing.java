package ua.smartHome.sensors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import ua.smartHome.connection.IMqttConnection;

import java.awt.event.ActionListener;


@NoArgsConstructor
public abstract class InternetThing implements IMqttConnection{

    @Getter
    @Setter
    public MqttClient mqttClient;

    @Getter
    @Setter
    private String sensorDataValue;

    @Getter
    @Setter
    private String sensorId;

    @Getter
    @Setter
    private String mqttTopic;

    @Setter
    @Getter
    private String sensorType;

    @Getter
    @Setter
    private String sensorLocation;

    // LAMP AREA
    @Getter
    @Setter
    public String relayStatus = "OFF";

    @Setter
    @Getter
    public boolean Status;

    public InternetThing(String sensorLocation, String sensorId, String mqttTopic, String sensorType) {
        this.sensorLocation = sensorLocation;
        this.sensorId = sensorId;
        this.mqttTopic = mqttTopic;
        this.sensorType = sensorType;
    }

    public InternetThing(String sensorLocation, String sensorId, String mqttTopic) {
        this.sensorLocation = sensorLocation;
        this.sensorId = sensorId;
        this.mqttTopic = mqttTopic;
    }
}
