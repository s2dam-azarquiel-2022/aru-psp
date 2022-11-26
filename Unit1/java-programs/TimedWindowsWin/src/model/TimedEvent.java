package model;

public abstract class TimedEvent implements Runnable {
  private boolean alive;
  private int timeToWait;
  private Thread thread;

  public TimedEvent(int timeToWait) {
    this.timeToWait = timeToWait;
    this.alive = true;
    this.thread = new Thread(this);
  }

  public abstract void codeAfter();

  public void run() {
    while (alive) {
      synchronized (this) {
        try { this.wait(timeToWait); } catch (Exception e) { }
        this.codeAfter();
        try { this.wait(); } catch (Exception e) { }
      }
    }
  }

  public synchronized void start() {
    this.thread.start();
  }

  public boolean isAlive() { return this.thread.isAlive(); }
}
