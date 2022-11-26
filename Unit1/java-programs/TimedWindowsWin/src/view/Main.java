package view;

import java.awt.Toolkit;

import handler.ButtonClickHandler;
import model.Config;
import model.Shared;

public class Main {
  public static void main(String[] args) {
    Config.setupConfig(Toolkit.getDefaultToolkit().getScreenSize());
    Window.clickHandler = new ButtonClickHandler();
    Window.shared = new Shared();
    for (int i = 1; i <= Config.MAX_BUTTONS; i++) {
      new Window(i);
    }
  }
}
