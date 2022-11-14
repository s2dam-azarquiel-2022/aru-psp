package model;

public class Vector {
	public int x;
	public int y;
	public int iHat;
	public int jHat;

	private static int random(int max) { return (int) (Math.random() * (max + 1)); };

	public Vector() {
		this.x = random(Config.windowSize.width - Config.buttonSize.width);
		this.y = random(Config.windowSize.height - Config.buttonSize.height);
		this.iHat = random(5) + 1;
		this.jHat = random(5) + 1;
	}

	public void move() {
		x += iHat * Config.velocityMultiplier;
		y += jHat * Config.velocityMultiplier;
		if (x <= 0 || ((x + Config.buttonSize.width) >= Config.windowSize.width))
		  iHat = -iHat;
		if (y <= 0 || (y + Config.buttonSize.height >= Config.windowSize.height))
		  jHat = -jHat;
	}
}
