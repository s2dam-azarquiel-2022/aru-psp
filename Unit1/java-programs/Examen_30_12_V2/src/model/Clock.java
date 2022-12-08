package model;

public class Clock implements Runnable {
  public boolean clocking;
  public Thread thread;
  private int timeToWait;
  private ClockI tasks;

  public Clock(int timeToWait, ClockI tasks) {
    this.timeToWait = timeToWait;
    this.thread = new Thread(this);
    this.tasks = tasks;
  }

  public void run() {
    while (clocking) {
      synchronized (this) {
        try {
          this.wait(timeToWait);
          if (clocking) tasks.codeAfter();
          System.out.println("clocked");
        }
        catch (Exception e) { tasks.interrupted(); }
      }
    }
  }
}
