package ua.smartHome.switchers;

import ua.smartHome.constants.MqttTopic;
import ua.smartHome.constants.UiConstant;
import org.eclipse.paho.client.mqttv3.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lamp extends Relay implements MqttCallback, Runnable {

	static MqttClient LampClient;
	{
		try {
			LampClient = new MqttClient(UiConstant.IP_ADDRESS.getUiConstant(), "Lamp");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			LampClient.connect();
			LampClient.setCallback(this);
			LampClient.subscribe(MqttTopic.LAMP.getTopicPath());
			LampClient.subscribe(MqttTopic.LAMP_STATUS.getTopicPath());
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable cause) {

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}

	public void lampSwitchStatus() {
		if(getSensorId().equals("lamp") && getSensorDataValue().contains(getRelayStatus())){
			System.out.println("The lamp is off");
		}
		else {
			System.out.println("The lamp is on");
		}
	}

//	@Override
//	public void connectMqttServer() {
//			try {
//				MqttConnectOptions options = new MqttConnectOptions();
//				options.setCleanSession(true);
//				LampClient = new MqttClient(UiConstant.IP_ADDRESS.getUiConstant(), "Lamp");
//				LampClient.connect();
//				LampClient.setCallback(this);
//				LampClient.subscribe(MqttTopic.LAMP.getTopicPath());
//				LampClient.subscribe(MqttTopic.LAMP_STATUS.getTopicPath());
//			} catch (MqttException e) {
//				e.printStackTrace();
//			}
//	}




	public static class LampListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MqttMessage message = new MqttMessage();
			MqttMessage statusMessage = new MqttMessage();
			message.setPayload("toggle"
					.getBytes());
			try {
				LampClient.publish(MqttTopic.LAMP.getTopicPath(), message);
//				LampClient.subscribe(TopicConstants.LAMP_STATUS);
//				System.out.println(statusMessage);
			} catch (MqttException ex) {
				ex.printStackTrace();
			}
		}
	}
}
