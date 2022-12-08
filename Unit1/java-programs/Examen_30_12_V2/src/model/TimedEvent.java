package model;

public abstract class TimedEvent implements ClockI {
  public Clock clock;

  public TimedEvent(int timeToWait) {
    this.clock = new Clock(timeToWait, this);
  }

  public void start() {
    if (!clock.clocking) {
      clock.thread.start();
      clock.clocking = true;
    }
    else synchronized (clock) { clock.notify(); }
  }

  public void interrupted() {
    try { this.clock.wait(); } catch (Exception e) { }
  }

  public void stop() {
    synchronized (clock.thread) { clock.thread.interrupt(); }
  }

  public void kill() { clock.clocking = false; }
}
