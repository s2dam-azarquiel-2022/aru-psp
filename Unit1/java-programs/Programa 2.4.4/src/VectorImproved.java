import java.awt.Dimension;

public class VectorImproved {
	public int x;
	public int y;
	public int iHat;
	public int jHat;
	private Dimension size;
	private Dimension windowSize;
	
	private static int random(int max) { return (int) (Math.random() * (max + 1)); };
	
	public VectorImproved(Dimension size, Dimension windowSize) {
		this.size = size;
		this.windowSize = windowSize;
		this.x = random(windowSize.width - size.width);
		this.y = random(windowSize.height - size.height);
		this.iHat = random(6);
		this.jHat = random(6);
	}
	
	public void move() {
		x += iHat;
		y += jHat;
		if (x <= 0 || x + size.width >= windowSize.width) { iHat = -iHat; }
		if (y <= 0 || y + size.height >= windowSize.height) { jHat = -jHat; }
	}
}
