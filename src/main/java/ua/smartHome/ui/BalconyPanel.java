package ua.smartHome.ui;

import ua.smartHome.constants.UiConstant;
import ua.smartHome.constants.UiConstants;

import javax.swing.*;
import java.awt.*;

import static ua.smartHome.constants.UiConstants.*;

public class BalconyPanel {
	public static JPanel balconyPanel = new JPanel(new FlowLayout());
	public static JLabel temperatureLabel = new JLabel();
	public static JLabel humidityLabel = new JLabel();
	public static JLabel barometerLabel = new JLabel();

	public static JLabel dsTemperatureLabel = new JLabel();

	public void createUIBme280Balcony() {
		balconyPanel.setBorder(BorderFactory.createTitledBorder(UiConstant.BORDER_TITLE_BALCONY.getUiConstant()));

// TEMPERATURE
		temperatureLabel.setFont(UiConstants.FONT);
		temperatureLabel.setOpaque(true);
		temperatureLabel.setVerticalAlignment(JLabel.CENTER);
		temperatureLabel.setHorizontalAlignment(JLabel.CENTER);
		temperatureLabel.setBorder(BorderFactory.createTitledBorder(UiConstant.BORDER_TITLE_TEMPERATURE.getUiConstant()));
		temperatureLabel.setPreferredSize(UiConstants.LABELSIZE);
		temperatureLabel.setIcon(new ImageIcon(UiConstant.TEMPERATURE_LABEL_IMAGE.getUiConstant()));
		balconyPanel.add(temperatureLabel);

// HUMIDITY
		humidityLabel.setFont(UiConstants.FONT);
		humidityLabel.setOpaque(true);
		humidityLabel.setVerticalAlignment(JLabel.CENTER);
		humidityLabel.setHorizontalAlignment(JLabel.CENTER);
		humidityLabel.setBorder(BorderFactory.createTitledBorder(UiConstant.BORDER_TITLE_HUMIDITY.getUiConstant()));
		humidityLabel.setPreferredSize(LABELSIZE);
		humidityLabel.setIcon(new ImageIcon(UiConstant.HUMIDITY_LABEL_IMAGE.getUiConstant()));
		balconyPanel.add(humidityLabel);

// BAROMETER
		barometerLabel.setFont(FONT);
		barometerLabel.setOpaque(true);
		barometerLabel.setVerticalAlignment(JLabel.CENTER);
		barometerLabel.setHorizontalAlignment(JLabel.CENTER);
		barometerLabel.setBorder(BorderFactory.createTitledBorder(UiConstant.BORDER_TITLE_BAROMETER.getUiConstant()));
		barometerLabel.setPreferredSize(LABELSIZE);
		barometerLabel.setIcon(new ImageIcon(UiConstant.BAROMETER_LABEL_IMAGE.getUiConstant()));
		balconyPanel.add(barometerLabel);

// DS Temperature
		dsTemperatureLabel.setFont(FONT);
		dsTemperatureLabel.setOpaque(true);
		dsTemperatureLabel.setVerticalAlignment(JLabel.CENTER);
		dsTemperatureLabel.setHorizontalAlignment(JLabel.CENTER);
		dsTemperatureLabel.setBorder(BorderFactory.createTitledBorder(UiConstant.BORDER_TITLE_DS_OUTDOOR.getUiConstant()));
		dsTemperatureLabel.setPreferredSize(LABELSIZE);
		dsTemperatureLabel.setIcon(new ImageIcon(UiConstant.TEMPERATURE_LABEL_IMAGE.getUiConstant()));
		balconyPanel.add(dsTemperatureLabel);
	}
}
