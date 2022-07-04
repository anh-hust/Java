package Week_10;

public class Circle extends GeometricObject {
	private double radius;

	public Circle() {
		super(); // if don't declare, auto implement and hidden
		this.radius = 1;
	}

	public Circle(double radius) {
		super(); // if don't declare, auto implement and hidden against programmer
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}

	public double getDiameter() {
		return 2 * this.radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public int compareTo(GeometricObject o) {
		// TODO Auto-generated method stub
		return 0;
	}
}