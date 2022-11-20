package view;

import java.awt.Toolkit;

import model.Config;
import model.Shared;

public class Main {
  public static void main(String[] args) {
    Config.setupConfig(Toolkit.getDefaultToolkit().getScreenSize());
    Window.shared = new Shared();
    for (int i = 0; i < Config.MAX_WINDOWS; i++) {
      new Window(i);
    }
  }
}
