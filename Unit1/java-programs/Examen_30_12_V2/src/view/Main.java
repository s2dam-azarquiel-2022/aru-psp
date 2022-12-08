package view;

import java.awt.Toolkit;

import model.Config;
import model.Shared;

public class Main {
  public static void main(String[] args) {
    Config.setupConfig(Toolkit.getDefaultToolkit().getScreenSize());
    Window.shared = new Shared();
    for (int i = Config.FIRST_WINDOW_ID; i <= Config.MAX_BUTTONS; i++) {
      new Window(i);
    }
  }
}
