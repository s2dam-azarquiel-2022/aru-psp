package view;

import javax.swing.JButton;

import handler.ButtonClickHandler;
import model.Config;
import model.Shared;
import model.Vector;

public class MovingButton implements Runnable {
	public JButton button;
	private int id;
	private Vector vector;

	public static ButtonClickHandler clickHandler;
	public static Shared shared;

	public MovingButton(int id) {
		this.id = id;
		this.vector = new model.Vector();

	  setupButton();

		Thread thread = new Thread(this);
		thread.setName(String.format("MovingButton %d", id));
		thread.start();
	}

	private void setupButton() {
		button = new JButton(String.format("MovingButton %d", id));
		button.setSize(Config.buttonSize);
		button.setVisible(false);
		button.setActionCommand(String.valueOf(id));
		button.addActionListener(clickHandler);
	}

	public void run() {
		button.setVisible(true);
		while (shared.alive) {
			synchronized (this) {
				while (!shared.move(id)) {
					try { shared.wait(); } catch (Exception e) {}
					if (!shared.alive) { Config.velocityMultiplier = 0; break; }
				}
			}
			vector.move();
			button.setLocation(vector.x, vector.y);
			try { Thread.sleep(33); } catch (InterruptedException e) { }
		}
		button.setText("GANADOR");
	}
}
