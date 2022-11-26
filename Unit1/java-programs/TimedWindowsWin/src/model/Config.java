package model;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Config {
  public static final int MAX_BUTTONS = 5;
  public static float velocityMultiplier = 1;
  public static Dimension screenSize;
  public static Dimension windowSize;

  public static void setupConfig(Dimension screenSize) {
    Config.screenSize = screenSize;
    Config.windowSize = new Dimension(
      Config.screenSize.width / 10,
      Config.screenSize.height / 10
    );
  }
}
