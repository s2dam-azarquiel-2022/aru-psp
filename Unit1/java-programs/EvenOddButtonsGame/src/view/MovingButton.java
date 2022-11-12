package view;

import javax.swing.JButton;

import controller.ButtonClickHandler;

public class MovingButton extends JButton implements Runnable {
	private int id;
	private model.Vector vector;
	private boolean alive;

	public static model.Config config;
	public static controller.ButtonClickHandler clickHandler =
		new controller.ButtonClickHandler();
	
	public MovingButton(int id) {
		super(String.format("MovingButton %d", id));

		this.id = id;
		this.vector = new model.Vector(config);

		this.setSize(config.buttonSize);
		this.setVisible(false);
		this.setActionCommand(String.valueOf(id));
		this.addActionListener(clickHandler);
		
		Thread thread = new Thread(this);
		thread.setName(String.format("MovingButton %d", id));
		thread.start();
	}

	public void run() {
		this.alive = true;
		this.setVisible(true);
		while (alive) {
			synchronized (this) {
				while (!config.move(id)) {
					try { config.wait(); }
					catch (Exception e) {}
				}
			}
			vector.move();
			this.setLocation(vector.x, vector.y);
			try { Thread.sleep(33); } catch (InterruptedException e) { }
		}
		this.setVisible(false);
	}
}
