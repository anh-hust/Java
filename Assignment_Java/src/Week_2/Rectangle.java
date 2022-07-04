package Week_2;

public class Rectangle {
	private double width;
	private double height;
	
	public Rectangle() {
		this.width = 0;
		this.height = 0;
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void setWidth(double setValue) {
		this.width = setValue;
	}
	
	public void setHeight(double setValue) {
		this.height = setValue;
	}
	
	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return (width + height) * 2;
	}
}
