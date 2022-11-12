
public class Shared {
	public ClickCount clickCount = new ClickCount();
	public int state;

	public Shared() {
		this.clickCount = new ClickCount();
		this.state = 0;
	}

	public void checkState(boolean isEven) {
		if (isEven) {
			if (state == 0) state = 1;
			else if (state == 2) { state = 0; notifyAll(); }
		} else {
			if (state == 0) state = 2;
			else if (state == 1) { state = 0; notifyAll(); }
		}
	}
	
	public boolean move(boolean isEven) {
		return ((isEven && state != 1) || (!isEven && state != 2));
	}
}
