import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MovingBtn extends JButton implements Runnable, ActionListener {
	private Thread hilo;
	private boolean nosalir;
	private VectorImproved vec;

	public MovingBtn(String titulo, Dimension d, Dimension size) {
		super(titulo);
		setSize(d.width / 10, d.height / 10);
		setVisible(false);

		vec = new VectorImproved(size, d);
		hilo = new Thread(this);
		hilo.setName(titulo);
		hilo.start();
		addActionListener(this);
	}

	public void run() {
		nosalir = true;
		setVisible(true);
		while (nosalir) {
			vec.move();
			this.setLocation(vec.x, vec.y);
			if (nosalir) try { Thread.sleep(33); } catch (InterruptedException e) { }
		}
		this.setVisible(false);
	}

	public void actionPerformed(ActionEvent e) {
		nosalir = false;
	}
}
