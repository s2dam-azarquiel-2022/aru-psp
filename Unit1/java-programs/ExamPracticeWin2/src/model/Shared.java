package model;

public class Shared {
  public int state;
  public boolean alive;
  public int count;
  public boolean changingTitle;
  public int changedTitles;

  private final int T_TIMES = 5000 / Config.SLEEP_TIME * Config.MAX_WINDOWS;
  private int times;

  public Shared() {
    this.state = 0;
    this.alive = true;
    this.count = 0;
    this.times = 0;
    this.changingTitle = false;
    this.changedTitles = 0;
  }

  public void checkState() {
    switch (state) {
    case 0: state = 1; count = 0; changingTitle = true; break;
    case 1: state = 2; break;
    case 2: state = 0; break;
    }
  }

  public synchronized void incCount() {
    times++;
    if (times >= T_TIMES) { count += 5; times = 0; }
  }

  public void titleChanged() {
    changedTitles++;
    if (changedTitles == Config.MAX_WINDOWS) {
      changingTitle = false;
      changedTitles = 0;
    }
  }
}
