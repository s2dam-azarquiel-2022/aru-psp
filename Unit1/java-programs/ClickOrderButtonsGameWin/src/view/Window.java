package view;

import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JFrame;

import handler.ButtonClickHandler;
import model.Config;
import model.Shared;
import model.Vector;

public class Window implements Runnable {
  public JFrame window;
  public JButton button;
  private int id;
  private Vector vector;

  public static ButtonClickHandler clickHandler;
  public static Shared shared;

  public Window(int id) {
    this.id = id;
    this.vector = new model.Vector();

    setupWindow();
    setupButton();

    Thread thread = new Thread(this);
    thread.setName(String.format("v%d", id));
    thread.start();
  }

  private void setupWindow() {
    window = new JFrame(String.format("v%d", id));
    window.setType(Type.UTILITY);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(Config.windowSize);
    window.setResizable(false);
    window.setVisible(false);
  }

  private void setupButton() {
    button = new JButton("Parar");
    button.setSize(Config.windowSize);
    button.setActionCommand(String.valueOf(id));
    button.addActionListener(clickHandler);
    window.add(button);
  }

  public void run() {
    window.setVisible(true);
    while (shared.alive) {
      synchronized (this) {
        while (!shared.move(id)) {
          try { shared.wait(); } catch (Exception e) { }
          if (!shared.alive) { Config.velocityMultiplier = 0; break; }
        }
      }
      vector.move();
      window.setLocation(vector.x, vector.y);
      try { Thread.sleep(33); } catch (InterruptedException e) {
      }
    }
    button.setText("GANADOR");
  }
}
