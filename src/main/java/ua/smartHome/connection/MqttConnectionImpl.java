package ua.smartHome.connection;

import lombok.ToString;
import org.eclipse.paho.client.mqttv3.*;
import ua.smartHome.constants.MqttTopic;
import ua.smartHome.constants.UiConstant;
import ua.smartHome.sensors.InternetThing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ToString
public class MqttConnectionImpl extends InternetThing implements MqttCallback, ActionListener{
	//

	public MqttConnectionImpl(String sensorLocation, String sensorId, String mqttTopic, String sensorType){
		super(sensorLocation, sensorId, mqttTopic, sensorType);
	}

	public MqttConnectionImpl(String sensorLocation, String sensorId, String mqttTopic){
		super(sensorLocation, sensorId, mqttTopic);
	}

	public MqttConnectionImpl() {
	}

	@Override
	public void connectMqttServer() {
			try {
			super.setMqttClient(mqttClient = new MqttClient(UiConstant.IP_ADDRESS.getUiConstant(), getSensorId()));
			mqttClient.connect();
			mqttClient.setCallback(this);
			mqttClient.subscribe(getMqttTopic());
			mqttClient.messageArrivedComplete(1, 0);
			}
			catch (MqttException e){
				System.out.println("Can't connect to the server.");
			}
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) {
		setSensorDataValue(message.toString());
	}

	@Override
	public void connectionLost(Throwable cause) {
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MqttMessage message = new MqttMessage();
		message.setPayload("toggle"
				.getBytes());
		try {
			super.getMqttClient().publish(MqttTopic.LAMP_FLORA.getTopicPath(), message);
//			MqttClient cli = new MqttClient(UiConstant.IP_ADDRESS.getUiConstant(), "LampFlora");
//				cli.connect();
//				cli.publish(MqttTopic.LAMP_FLORA.getTopicPath(), message);
		} catch (MqttException ex) {
			ex.printStackTrace();
			System.out.println("Message from IMPL");
		}
	}
}
