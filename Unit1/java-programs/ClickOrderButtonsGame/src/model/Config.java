package model;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Config {
	public static final int MAX_BUTTONS = 5;
	public static int velocityMultiplier = 1;
	public static Dimension windowSize;
	public static Dimension buttonSize;

	public static void setupConfig(JFrame mainFrame) {
		Config.windowSize = mainFrame.getSize();
		Config.buttonSize = new Dimension(
			Config.windowSize.width / 10,
			Config.windowSize.height / 10
		);
	}
}
