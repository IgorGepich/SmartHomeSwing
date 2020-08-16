package ua.smartHome.switchers;

import ua.smartHome.constants.MqttTopic;
import ua.smartHome.constants.UiConstant;
import org.eclipse.paho.client.mqttv3.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LampFlora implements MqttCallback, Runnable{

	static MqttClient FloraLampClient;

	{
		try {
			FloraLampClient = new MqttClient(UiConstant.IP_ADDRESS.getUiConstant(), "FloraLamp");
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			MqttConnectOptions options = new MqttConnectOptions();
			options.setCleanSession(true);
			FloraLampClient.connect();
			FloraLampClient.setCallback(this);
			FloraLampClient.subscribe(MqttTopic.LAMP_FLORA.getTopicPath());
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable cause) {

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		//	setRelayStatus(message.toString());
//			System.out.println("Relay status: " + message);
////fixme обновление состояния кнопки
//		if(message.toString().contains("\"POWER\"")){
//			System.out.println("!!!CONTAINS!!!");
//			lampSwitchStatus();
//		}

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {

	}

	public static class FloraLampListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MqttMessage message = new MqttMessage();
			message.setPayload("toggle"
					.getBytes());
			try {
				FloraLampClient.publish(MqttTopic.LAMP_FLORA.getTopicPath(), message);
			} catch (MqttException ex) {
				ex.printStackTrace();
				System.out.println("Can't publish message");
			}
		}
	}
}
