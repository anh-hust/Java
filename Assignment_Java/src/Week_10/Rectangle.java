package Week_10;

public class Rectangle extends GeometricObject {
	private double width;
	private double height;

	public Rectangle() {
//		super();
		this.width = 1;
		this.height = 1;
	}

	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Rectangle(double width, double height, String color, boolean filled) {
		super(color, filled);
		this.width = width;
		this.height = height;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return this.width;
	}

	public double getHeight() {
		return this.height;
	}

	@Override
	public double getArea() {
		return this.width * this.height;
	}

	@Override
	public double getPerimeter() {
		return 2 * (this.width + this.height);
	}

	@Override
	public int compareTo(GeometricObject o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
