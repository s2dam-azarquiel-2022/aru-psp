package model;

public class Vector {
	public int x;
	public int y;
	public int iHat;
	public int jHat;
	private model.Config config;

	public static int velocityMultiplier = 1;

	private static int random(int max) { return (int) (Math.random() * (max + 1)); };

	public Vector(model.Config config) {
		this.config = config;
		this.x = random(config.windowSize.width - config.buttonSize.width);
		this.y = random(config.windowSize.height - config.buttonSize.height);
		this.iHat = random(5) + 1;
		this.jHat = random(5) + 1;
	}

	public void move() {
		x += iHat * velocityMultiplier;
		y += jHat * velocityMultiplier;
		if (x <= 0 || x + config.buttonSize.width >= config.windowSize.width)
			iHat = -iHat;
		if (y <= 0 || y + config.buttonSize.height >= config.windowSize.height)
			jHat = -jHat;
	}
}
