import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Container extends JFrame implements ActionListener {
	private JButton btn;
	public JPanel contentPane;
	private Dimension windowSize;
	private Dimension movingBtnSize;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					Container frame = new Container();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void setupContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
	}
	
	private void setupBtn() {
		btn = new JButton("START");
		btn.setSize(windowSize);
		contentPane.add(btn);
		btn.addActionListener(this);
	}

	public Container() {
		this.setTitle("Contenedor");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setResizable(false);

		GraphicsEnvironment
			.getLocalGraphicsEnvironment()
			.getScreenDevices()[0]
			.setFullScreenWindow(this);
		
		windowSize = this.getSize();
		movingBtnSize = new Dimension(windowSize.width/10, windowSize.height/10);
		setupContentPane();
		setupBtn();
	}
	
	public void actionPerformed(ActionEvent e) {
		btn.setVisible(false);
		int MAXV = 5;
		MovingBtn[] btns = new MovingBtn[MAXV];
		for (int i = 0; i < btns.length; i++) {
			MovingBtn btn = new MovingBtn(i, windowSize, movingBtnSize, btns);
			btns[i] = btn;
			contentPane.add(btn);
		}
	}
}
