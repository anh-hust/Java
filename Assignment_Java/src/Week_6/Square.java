package Week_6;

public class Square extends GeometricObject {
	private double side;

	public Square() {
		super();
		this.side = 1;
	}

	public Square(double side) {
		super();
		this.side = side;
	}

	public Square(double side, String color, boolean filled) {
		super(color, filled);
		this.side = side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getSide() {
		return this.side;
	}

	@Override
	public double getArea() {
		return Math.pow(this.side, 2);
	}

	@Override
	public double getPerimeter() {
		return 4 * this.side;
	}

	@Override
	public String toString() {
		return "Square parameter:\nSide: " + this.getSide() + "\n==> Perimeter: " + this.getPerimeter() + "\n==> Area: "
				+ this.getArea() + super.toString();
	}
}
