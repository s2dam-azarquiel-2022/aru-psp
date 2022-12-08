package model;

public class Shared {
  public int state;
  public int clickedWindow;

  public int count;
  TimedEvent clock;

  public boolean alive;

  public String title;

  public Shared() {
    this.state = 0;
    this.alive = true;
    this.clickedWindow = Config.FIRST_WINDOW_ID-1;
    this.count = 0;
    this.title = null;

    clock = new TimedEvent(2000) {
      public void codeAfter() {
        count += 10;
        if (title != null) title = getTitle();
        if (count == 50) {
          if (state == 2) {
            state = 3;
            synchronized (this) {
              try { wait(200); } catch (Exception e) { }
              alive = false;
            }
          }
          kill();
        }
      }
    };
  }

  public synchronized void checkState(int windowID) {
    switch (state) {
    case 0:
      clock.start();
      state = 1;
      clickedWindow = windowID;
      break;
    case 1:
      if (windowID == clickedWindow) {
        state = 0;
        clock.stop();
        count = 0;
        title = null;
      } else {
        state = 2;
        title = getTitle();
        if (count == 50) {
          try { this.wait(200); } catch (Exception e) { }
          alive = false;
        }
      }
      clickedWindow = Config.FIRST_WINDOW_ID-1;
      break;
    }
  }

  public String getTitle() { return String.valueOf(count); }
}
