package view;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import model.Config;

public class MainWindow extends JFrame {
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					MainWindow frame = new MainWindow();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		this.setTitle("MainWindow");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setupContentPane();

		GraphicsEnvironment
			.getLocalGraphicsEnvironment()
			.getScreenDevices()[0]
			.setFullScreenWindow(this);
		
		setupMovingButtons();
	}
	
	private void setupContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
	}
	
	private void setupMovingButtons() {
		MovingButton.config = new model.Config(this);
		for (int i = 0; i < Config.MAX_BUTTONS; i++) {
			contentPane.add(new MovingButton(i));
		}
	}
}
