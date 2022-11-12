package model;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Config {
	public static final int MAX_BUTTONS = 5;

	public Dimension windowSize;
	public Dimension buttonSize;
	private int state;
	public boolean alive;

	public Config(JFrame mainFrame) {
		this.windowSize = mainFrame.getSize();
		this.buttonSize = new Dimension(
			this.windowSize.width / 10,
			this.windowSize.height / 10
		);
		this.state = 0;
		this.alive = true;
	}

	public synchronized void checkState(int buttonID) {
	  if (state == buttonID) {
	    state++;
	  } else {
	    state = 0;
	    Vector.velocityMultiplier++;
	  }

	  if (state == MAX_BUTTONS) alive = false;
		notifyAll();
	}

	public synchronized boolean move(int buttonID) {
		return buttonID >= state || !alive;
	}
}
