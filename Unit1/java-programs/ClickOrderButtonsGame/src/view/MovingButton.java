package view;

import javax.swing.JButton;

import controller.ButtonClickHandler;

public class MovingButton implements Runnable {
	public JButton button;
	private int id;
	private model.Vector vector;

	public static model.Config config;
	public static controller.ButtonClickHandler clickHandler =
		new controller.ButtonClickHandler();

	public MovingButton(int id) {
		this.id = id;
		this.vector = new model.Vector(config);

	  setupButton();

		Thread thread = new Thread(this);
		thread.setName(String.format("MovingButton %d", id));
		thread.start();
	}

	private void setupButton() {
		button = new JButton(String.format("MovingButton %d", id));
		button.setSize(config.buttonSize);
		button.setVisible(false);
		button.setActionCommand(String.valueOf(id));
		button.addActionListener(clickHandler);
	}

	public void run() {
		button.setVisible(true);
		while (config.alive) {
			synchronized (this) {
				while (!config.move(id)) {
					try { config.wait(); }
					catch (Exception e) {}
				}
			}
			vector.move();
			button.setLocation(vector.x, vector.y);
			try { Thread.sleep(33); } catch (InterruptedException e) { }
		}
		button.setText("GANADOR");
	}
}
