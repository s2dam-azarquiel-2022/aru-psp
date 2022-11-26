package model;

public class Vector {
  public int x;
  public int y;
  public int iHat;
  public int jHat;

  private static int random(int max) {
    return (int) (Math.random() * (max + 1));
  };

  public Vector() {
    this.x = random(Config.screenSize.width - Config.windowSize.width);
    this.y = random(Config.screenSize.height - Config.windowSize.height);
    this.iHat = random(5) + 1;
    this.jHat = random(5) + 1;
  }

  public void move() {
    x += iHat * Config.velocityMultiplier;
    y += jHat * Config.velocityMultiplier;
    if (x <= 0 || ((x + Config.windowSize.width) >= Config.screenSize.width))
      iHat = -iHat;
    if (y <= 0 || (y + Config.windowSize.height >= Config.screenSize.height))
      jHat = -jHat;
  }
}
