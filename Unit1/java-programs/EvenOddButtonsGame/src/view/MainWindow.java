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

public class MainWindow {
	private JFrame mainFrame;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(
						UIManager.getSystemLookAndFeelClassName()
					);
					MainWindow mainWindow = new MainWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		setupFrame();
		setupContentPane();

		GraphicsEnvironment
			.getLocalGraphicsEnvironment()
			.getScreenDevices()[0]
			.setFullScreenWindow(mainFrame);
		
		setupMovingButtons();
	}
	
	private void setupFrame() {
		mainFrame = new JFrame();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.setTitle("MainWindow");
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
	}
	
	private void setupContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		mainFrame.setContentPane(contentPane);
	}
	
	private void setupMovingButtons() {
		MovingButton.config = new model.Config(mainFrame);
		for (int i = 0; i < Config.MAX_BUTTONS; i++) {
			contentPane.add((new MovingButton(i)).button);
		}
	}
}
