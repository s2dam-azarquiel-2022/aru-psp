import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MovingBtn extends JButton implements Runnable, ActionListener {
	private Thread thread;
	private boolean alive;
	private VectorImproved vec;
	private MovingBtn[] btns;
	private static Shared shared = new Shared();
	private int id;

	public MovingBtn(
		int id,
		Dimension d,
		Dimension size,
		MovingBtn[] btns
	) {
		super(String.format("Ventana: %d", id));
		setSize(size);
		setVisible(false);
		
		this.id = id;
		this.btns = btns;

		vec = new VectorImproved(size, d);
		thread = new Thread(this);
		thread.setName(String.valueOf(id));
		thread.start();
		addActionListener(this);
	}

	public void run() {
		alive = true;
		setVisible(true);
		while (alive) {
			synchronized (this) {
				while (!shared.move(id)) try {shared.wait();} catch (Exception e) {}
			}
			vec.move();
			this.setLocation(vec.x, vec.y);
			try { Thread.sleep(33); } catch (InterruptedException e) { }
		}
		this.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		if (shared.checkState(id)) moveFaster();
		if (shared.state == btns.length) {
			for (MovingBtn btn : btns) {
				btn.setText("HAS GANADO");
				btn.removeActionListener(btn);
			}
		}
	}
	
	private void moveFaster() {
		for (MovingBtn btn: btns) {
			btn.vec.iHat *= 2;
			btn.vec.jHat *= 2;
		}
	}
}
