package ua.smartHome.ui;

/**
 * @class MainFrame creates UI frames and panels
 */
import ua.smartHome.constants.UiConstant;

import javax.swing.*;
import java.awt.*;

public class MainFrame implements Runnable{
	private JPanel mainPanel = new JPanel();

	@Override
	public void run() {

		/**
		 *Creating new Panels
		 */
		BalconyPanel balcony = new BalconyPanel();
		balcony.createUIBme280Balcony();

		RoomPanel roomPanel = new RoomPanel();
		roomPanel.createUIRoom();

		SwitchPanel switchPanel = new SwitchPanel();
		switchPanel.createUISwitch();

		/**
		 * Basic Frame preferences
		 */
		JFrame basicFrame = new JFrame();
		basicFrame.setVisible(true);
		basicFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		basicFrame.setBounds(400, 250, 800, 500);
		basicFrame.setLocationRelativeTo(null);// center
		basicFrame.setTitle(UiConstant.PROGRAM_TITLE.getUiConstant());

		/**
		 * JMenu
		 */
		JMenuBar menuBar = new JMenuBar();
		JMenu mainMenu = new JMenu("Menu");
		//EXIT Item
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(e -> {
			System.exit(0);
		});
		//End Exit Item
		JMenuItem settingsItem = new JMenuItem("Settings");
		mainMenu.add(settingsItem);
		mainMenu.add(exitItem);
		menuBar.add(mainMenu);

		/**
		 * Add panels on the MainFrame
		 */
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(BalconyPanel.balconyPanel, BorderLayout.NORTH);
		mainPanel.add(RoomPanel.roomPanel, BorderLayout.CENTER);
		mainPanel.add(SwitchPanel.switchPanel, BorderLayout.SOUTH);

		basicFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		/**
		 * Add MenuBar on the Frame
		 */
		basicFrame.setJMenuBar(menuBar);
	}
}
