package ua.smartHome.ui;

import ua.smartHome.constants.UiConstant;
import ua.smartHome.connection.MqttConnectionImpl;
import ua.smartHome.switchers.Lamp;
import ua.smartHome.switchers.LampFlora;
import ua.smartHome.switchers.LampListener;
import ua.smartHome.switchers.LampPlus;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SwitchPanel{
	static JPanel switchPanel = new JPanel(new FlowLayout());
	static Dimension buttonLabelSize = new Dimension(140, 60);

	ActionListener lampPlusListener = new LampPlus.LampPlusListener();
	ActionListener lampListener = new Lamp.LampListener();
	ActionListener floraLampListener = new LampListener();
	ActionListener floraLampListener1 = new LampFlora.FloraLampListener();
	ActionListener floraLampListener2 = new MqttConnectionImpl();

	public void createUISwitch(){
		switchPanel.setBorder(BorderFactory.createTitledBorder(UiConstant.BORDER_TITLE_SWITCH.getUiConstant()));

		/**
		 * Lamp + Button area
		 */
		JToggleButton lampPlusPowerButton = new JToggleButton("Lamp+");
		lampPlusPowerButton.setVerticalAlignment(JLabel.CENTER);
		lampPlusPowerButton.setHorizontalAlignment(JLabel.CENTER);
		lampPlusPowerButton.setPreferredSize(buttonLabelSize);
		lampPlusPowerButton.addActionListener(lampPlusListener);
//
		lampPlusPowerButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				String buttonText = (lampPlusPowerButton.isSelected()) ? "Lamp+" : "Lamp+";
				lampPlusPowerButton.setText(buttonText);
			}
		});
		/**
		 * END Lamp + Button area
		 */

		/**
		 * Lamp Button area
		 */
		JToggleButton lampPowerButton = new JToggleButton("Lamp");
		lampPowerButton.setVerticalAlignment(JLabel.CENTER);
		lampPowerButton.setHorizontalAlignment(JLabel.CENTER);
		lampPowerButton.setPreferredSize(buttonLabelSize);
		lampPowerButton.addActionListener(lampListener);

		lampPowerButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String buttonText = (lampPowerButton.isSelected()) ? "Lamp on" : "Lamp";
				lampPowerButton.setText(buttonText);
			}
		});
// TODO StateChanged
		lampPowerButton.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
			}
		});
		/**
		 * END Lamp Button area
		 */

		/**
		 * Flora Lamp Button area
		 */
		JToggleButton floraLampButton = new JToggleButton("FloraLamp");
		floraLampButton.setHorizontalAlignment(JLabel.CENTER);
		floraLampButton.setVerticalAlignment(JLabel.CENTER);
		floraLampButton.setPreferredSize(buttonLabelSize);
		floraLampButton.addActionListener(floraLampListener1);

		floraLampButton.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String buttonText = (floraLampButton.isSelected()) ? "Flora on" : "Flora off";
				floraLampButton.setText(buttonText);
			}
		});
		/**
		 * END Flora Lamp Button area
		 */

		switchPanel.add(lampPowerButton);
		switchPanel.add(lampPlusPowerButton);
		switchPanel.add(floraLampButton);
	}
}
