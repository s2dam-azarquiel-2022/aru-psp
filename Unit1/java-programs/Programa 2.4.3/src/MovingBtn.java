import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MovingBtn extends JButton implements Runnable, ActionListener {
	private Thread hilo;
	private boolean nosalir;
	private VectorImproved vec;
	private static ClickCount clickCount = new ClickCount();
	public int localClickCount = 0;
	private MovingBtn[] btns;

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
		hilo = new Thread(this);
		hilo.setName(String.valueOf(id));
		hilo.start();
		addActionListener(this);
	}

	public void run() {
		nosalir = true;
		setVisible(true);
		while (nosalir) {
			vec.move();
			this.setLocation(vec.x, vec.y);
			try { Thread.sleep(33); } catch (InterruptedException e) { }
		}
		this.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		clickCount.inc();
		localClickCount++;
		for (MovingBtn btn : btns)
			btn.setText(String.format("%02d:%02d", btn.localClickCount, clickCount.getClickCount()));
		checkEven();
	}
	
	private synchronized void checkEven() {
		if (Integer.valueOf(hilo.getName()) % 2 == 0)
			try { Thread.sleep(2000); }
			catch (InterruptedException e) { e.printStackTrace(); }
	}
}
