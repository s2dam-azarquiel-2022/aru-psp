package model;

public abstract class TimedEvent implements Runnable {
  public boolean clocking;
  private int timeToWait;
  private Thread thread;

  public TimedEvent(int timeToWait) {
    this.timeToWait = timeToWait;
    this.clocking = true;
    this.thread = new Thread(this);
    this.thread.start();
  }

  public abstract void codeAfter();

  public void run() {
    while (clocking) {
      synchronized (this) {
        try { this.wait(timeToWait); } catch (Exception e) { }
        this.codeAfter();
      }
    }
  }
}
