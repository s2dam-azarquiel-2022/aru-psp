package view;

import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Config;
import model.Shared;
import model.Vector;

public class Window implements Runnable, ActionListener {
  public JFrame window;
  public JButton button;
  private int id;
  private Vector vector;

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
    button.addActionListener(this);
    window.add(button);
  }

  public void run() {
    window.setVisible(true);
    while (shared.alive) {
      if (shared.changingTitle) { shared.incCount(); updateTitle(); }
      vector.move();
      window.setLocation(vector.x, vector.y);
      try { Thread.sleep(Config.SLEEP_TIME); } catch (InterruptedException e) { }
    }
  }

  private synchronized void updateTitle() {
    switch (shared.state) {
    case 1: window.setTitle(String.valueOf(shared.count)); break;
    default: window.setTitle(String.format("v%d", id)); shared.titleChanged(); break;
    }
  }

  public void actionPerformed(ActionEvent event) { shared.checkState(); }
}
