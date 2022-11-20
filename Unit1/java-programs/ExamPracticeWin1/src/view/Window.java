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
  private JFrame window;
  private JButton button;

  private int id;
  private int count;
  private int state;
  private int timePassed;
  private Vector vector;

  public static Shared shared;

  public Window(int id) {
    this.id = id;
    this.count = 7;
    this.state = 0;
    this.timePassed = 0;
    this.vector = new model.Vector();

    setupWindow();
    setupButton();

    Thread thread = new Thread(this);
    thread.setName(String.format("V%d", id));
    thread.start();
  }

  private void setupWindow() {
    window = new JFrame(String.format("V%d", id));
    window.setType(Type.UTILITY);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(Config.windowSize);
    window.setResizable(false);
    window.setVisible(false);
  }

  private void setupButton() {
    button = new JButton("Parar");
    button.setSize(Config.windowSize);
    button.addActionListener(this);
    window.add(button);
  }

  public void run() {
    window.setVisible(true);
    while (shared.alive) {
      synchronized (this) {
        checkTime();
      }
      vector.move();
      window.setLocation(vector.x, vector.y);
      try { Thread.sleep(Config.SLEEP_TIME); } catch (Exception e) { };
    }
  }

  public void actionPerformed(ActionEvent evente) {
    switch (state) {
    case 0: {
      state = 1;
      button.setText("desactivado");
      button.setEnabled(false);
      updateTitle();
      break;
    }
    case 2: {
      synchronized (this) { this.notify(); }
      state = 3;
      button.setText("desactivado");
      button.setEnabled(false);
      break;
    }
    }
  }

  private void updateTitle() {
    window.setTitle(String.valueOf(count));
  }

  private void nextCount() {
    count = state == 1 ? count - 1 : count + 1;
    updateTitle();
    if (count == 1) {
      state = 2;
      shared.stopWindow();
      while (!shared.allStopped()) { try { this.wait(100); } catch (Exception e) {}; }
    } else if (count == 7) {
      state = 4;
      shared.moveWindow();
    }
  }

  private void checkTime() {
    if (state == 1) {
      timePassed += Config.SLEEP_TIME;
      if (timePassed >= 1000) {
        timePassed = 0;
        nextCount();
      }
    } else if (state == 4) {
      if (shared.allMoving()) {
        state = 0;
        window.setTitle(String.format("V%d", id));
        button.setText("parar");
        button.setEnabled(true);
      }
    }

    if (state == 2) {
      button.setText("mover");
      button.setEnabled(true);
      try { this.wait(); } catch (Exception e) { };
    }

    while (state == 3) {
      try { this.wait(1000); } catch (Exception e) { };
      nextCount();
    }
  }
}
