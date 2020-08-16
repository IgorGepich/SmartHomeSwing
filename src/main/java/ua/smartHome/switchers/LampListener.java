package ua.smartHome.switchers;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import ua.smartHome.constants.MqttTopic;
import ua.smartHome.sensors.InternetThingCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LampListener extends InternetThingCreator implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MqttMessage message = new MqttMessage();
        message.setPayload("toggle"
                .getBytes());
        try {
//            LampFlora.FloraLampClient.publish(MqttTopic.LAMP_FLORA.getTopicPath(), message);
                getLampFlora().getMqttClient().publish(MqttTopic.LAMP_FLORA.getTopicPath(), message);
                System.out.println("if");
        } catch (MqttException ex) {
            ex.printStackTrace();
            System.out.println("Can't publish message");
        }
    }

    public List<MqttClient> clients = new ArrayList<>();
    public void fillClients(){
        clients.add(LampFlora.FloraLampClient);
    }
}
