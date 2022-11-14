package model;

public class Shared {
	private int state;
	public boolean alive;

	public Shared() {
		this.state = 0;
		this.alive = true;
	}

	public synchronized void checkState(int buttonID) {
	  if (state == buttonID) {
	    state++;
	  } else {
	    state = 0;
	    Config.velocityMultiplier++;
	  }

	  if (state == Config.MAX_BUTTONS) alive = false;
		notifyAll();
	}

	public synchronized boolean move(int buttonID) {
		return buttonID >= state;
	}
}
