package Week_6;

import java.util.Date;

public abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color;
	private boolean filled;
	private Date dateCreated;

	public GeometricObject() {
		this.color = "white";
		this.filled = true;
		this.dateCreated = new Date();
	}

	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
		this.dateCreated = new Date();
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void seyFilled(boolean filled) {
		this.filled = filled;
	}

	public String getColor() {
		return this.color;
	}

	public boolean isFilled() {
		return this.filled;
	}

	public Date getDate() {
		return this.dateCreated;
	}

	public static double sumArea(GeometricObject[] arr) {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof Rectangle)
				sum += ((Rectangle) arr[i]).getArea();
			if (arr[i] instanceof Square)
				sum += ((Square) arr[i]).getArea();
			if (arr[i] instanceof Circle)
				sum += ((Circle) arr[i]).getArea();
		}
		return sum;
	}

	public static GeometricObject max(GeometricObject g1, GeometricObject g2) {
		if (g1 instanceof Circle && g2 instanceof Circle) {
			if (((Circle) g1).getRadius() >= ((Circle) g2).getRadius())
				return g1;
			else
				return g2;
		} else if (g1 instanceof Square && g2 instanceof Square) {
			if (((Square) g1).getSide() >= ((Square) g2).getSide())
				return g1;
			else
				return g2;
		} else if (g1 instanceof Rectangle && g2 instanceof Rectangle) {
			if (((Rectangle) g1).getArea() >= ((Rectangle) g2).getArea())
				return g1;
			else
				return g2;
		} else {
			System.out.println("2 Geometric Object must be the same declare type !");
			return null;
		}
	}

	@Override
	public void compare(GeometricObject g1, GeometricObject g2) {
		if (g1 instanceof Circle && g2 instanceof Circle) {
			if (((Circle) g1).getRadius() > ((Circle) g2).getRadius())
				System.out.println("..Object parameter 1 > Object parameter 2");
			else
				System.out.println("..Object parameter 2 > Object parameter 1");
		} else if (g1 instanceof Square && g2 instanceof Square) {
			if (((Square) g1).getSide() > ((Square) g2).getSide())
				System.out.println("..Object parameter 1 > Object parameter 2");
			else
				System.out.println("..Object parameter 2 > Object parameter 1");
		} else if (g1 instanceof Rectangle && g2 instanceof Rectangle) {
			if (((Rectangle) g1).getArea() > ((Rectangle) g2).getArea())
				System.out.println("..Object parameter 1 > Object parameter 2");
			else
				System.out.println("..Object parameter 2 > Object parameter 1");
		} else {
			System.out.println("2 Geometric Object must be the same declare type !");
		}
	}

	public abstract double getArea();

	public abstract double getPerimeter();

	public String toString() {
		return "\nColor: " + this.color + "\nStatus: " + (isFilled() ? "Filled" : "Not filled yet") + "\nDate created: "
				+ this.dateCreated.toString();
	}

}
