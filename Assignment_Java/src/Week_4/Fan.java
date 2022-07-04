package Week_4;

public class Fan {
	static final int SLOW = 1;
	static final int MEDIUM = 2;
	static final int FAST = 3;

	private int speed;
	private boolean on;
	private double radius;
	private String color;

	public Fan() {
		this.speed = SLOW;
		this.on = false;
		this.radius = 5;
		this.color = "blue";
	}

	public void setSpeed(int speed) {
		if (speed < 1 || speed > 3) {
			System.out.println("ERROR --- Just take speed:\n1 ~ SLOW\n2 ~ MEDIUM\n3 ~ FAST\nDefault: SLOW");
		} else
			this.speed = speed;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return this.speed;
	}

	public boolean getSwitch() {
		return this.on;
	}

	public double getRadius() {
		return this.radius;
	}

	public String getColor() {
		return this.color;
	}

	public String toString() {
		String convertSpeed = "";
		if (this.speed == 1)
			convertSpeed = "SLOW";
		if (this.speed == 2)
			convertSpeed = "MEDIUM";
		if (this.speed == 3)
			convertSpeed = "FAST";
		if (this.on)
			return "The " + this.color + " fan has radius: " + Double.toString(this.radius) + " with speed: "
					+ convertSpeed;
		else
			return "The " + this.color + " fan has radius: " + Double.toString(this.radius) + ". It's turning off";
	}

}
