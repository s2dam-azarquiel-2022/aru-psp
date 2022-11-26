package model;

public class Shared {
  private int state;
  public boolean alive;
  TimedEvent firstStateEvent;
  TimedEvent secondStateEvent;

  public Shared() {
    this.state = 0;
    this.alive = true;

    secondStateEvent = new TimedEvent(2000) {
      public void codeAfter() {
        state = 2;
        notifyAll();
      }
    };

    firstStateEvent = new TimedEvent(2000) {
      public void codeAfter() {
        state = 1;
        notifyAll();
        if (secondStateEvent.isAlive()) notifyEvent(secondStateEvent);
        else secondStateEvent.start();
      }
    };
    firstStateEvent.start();
  }

  private void notifyEvent(TimedEvent e) {
    synchronized (e) { e.notify(); }
  }

  public synchronized void checkState(int windowID) {
    switch (state) {
    case 2: if (windowID == 3) state = 3; break;
    case 3: {
      if (windowID == 4) state = 4;
      else { state = 0; notifyEvent(firstStateEvent); }
      break;
    }
    }
    notifyAll();
  }

  public synchronized boolean move(int windowID) {
    switch (windowID) {
    case 1: return state == 0 || state == 4;
    case 2: return state < 2 || state == 4;
    case 3: return state != 3;
    default: return true;
    }
  }
}
