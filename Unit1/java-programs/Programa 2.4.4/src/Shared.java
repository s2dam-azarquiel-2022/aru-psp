
public class Shared {
	public int state;

	public Shared() {
		this.state = 0;
	}

	public synchronized boolean checkState(int id) {
		boolean result = true;
		if (id == state) {
			state++;
			result = false;
		} else {
			state = 0;
		}

		notifyAll();
		return result;
	}
	
	public boolean move(int id) {
		return (id + 1) > state;
	}
}
