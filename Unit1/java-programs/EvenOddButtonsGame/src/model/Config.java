package model;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Config {
	public static final int MAX_BUTTONS = 5;

	public Dimension windowSize;
	public Dimension buttonSize;
	private int state;

	public Config(view.MainWindow mainWindow) {
		this.windowSize = mainWindow.getSize();
		this.buttonSize = new Dimension(
			this.windowSize.width / 10,
			this.windowSize.height / 10
		);
		this.state = 0;
	}
	
	public synchronized void checkState(int buttonID) {
		if (buttonID % 2 == 0) {
			if (state == 0) state = 1;
			else if (state == 2) state = 0;
		} else {
			if (state == 0) state = 2;
			else if (state == 1) state = 0;
		}

		notifyAll();
	}
	
	public synchronized boolean move(int buttonID) {
		boolean isEven = buttonID % 2 == 0;
		return ((isEven && state != 1) || (!isEven && state != 2));
	}
}
