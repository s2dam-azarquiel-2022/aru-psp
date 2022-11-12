import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MovingBtn extends JButton implements Runnable, ActionListener {
	private Thread thread;
	private boolean alive;
	private VectorImproved vec;
	public int localClickCount = 0;
	private MovingBtn[] btns;
	private static Shared shared = new Shared();

	public MovingBtn(
		int id,
		Dimension d,
		Dimension size,
		MovingBtn[] btns
	) {
		super(String.format("Ventana: %d", id));
		setSize(size);
		setVisible(false);
		
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
				while (!shared.move(isEven())) try {shared.wait();} catch (Exception e) {}
			}
			vec.move();
			this.setLocation(vec.x, vec.y);
			try { Thread.sleep(33); } catch (InterruptedException e) { }
		}
		this.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		shared.clickCount.inc();
		localClickCount++;
		for (MovingBtn btn : btns) {
			btn.setText(String.format(
				"%02d:%02d",
				btn.localClickCount, shared.clickCount.getClickCount()
			));
		}

		shared.checkState(isEven());
	}
	
	private boolean isEven() {
		return Integer.valueOf(thread.getName()) % 2 == 0;
	}
}
