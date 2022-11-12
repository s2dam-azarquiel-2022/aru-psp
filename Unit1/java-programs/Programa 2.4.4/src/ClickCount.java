
public class ClickCount {
	private int count = 0;
	
	public int getClickCount() {
		return count;
	}
	
	public synchronized void inc() {
		this.count++;
	}
}
