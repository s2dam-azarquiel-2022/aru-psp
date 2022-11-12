package view;

import javax.swing.JButton;

import controller.ButtonClickHandler;

public class MovingButton implements Runnable {
	public JButton button;
	private int id;
	private model.Vector vector;
	private boolean alive;

	public static model.Config config;
	public static controller.ButtonClickHandler clickHandler =
		new controller.ButtonClickHandler();

	public MovingButton(int id) {
		button = new JButton(String.format("MovingButton %d", id));

		this.id = id;
		this.vector = new model.Vector(config);

		button.setSize(config.buttonSize);
		button.setVisible(false);
		button.setActionCommand(String.valueOf(id));
		button.addActionListener(clickHandler);

		Thread thread = new Thread(this);
		thread.setName(String.format("MovingButton %d", id));
		thread.start();
	}

	public void run() {
		this.alive = true;
		button.setVisible(true);
		while (alive) {
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
		button.setVisible(false);
	}
}
