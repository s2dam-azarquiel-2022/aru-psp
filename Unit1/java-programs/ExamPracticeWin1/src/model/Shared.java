package model;

public class Shared {
  public boolean alive;
  private int stoppedWindows;

  public Shared() {
    this.alive = true;
    this.stoppedWindows = 0;
  }

  public synchronized void stopWindow() {
    stoppedWindows++;
  }

  public synchronized void moveWindow() {
    stoppedWindows--;
    if (stoppedWindows == 0) notifyAll();
  }

  public synchronized boolean allStopped() {
    return stoppedWindows == Config.MAX_WINDOWS;
  }

  public synchronized boolean allMoving() {
    return stoppedWindows == 0;
  }
}
