package Week_10;

import java.util.Comparator;
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

	public abstract double getArea();

	public abstract double getPerimeter();

	public static void sort(GeometricObject[] list, Comparator<GeometricObject> c) {
		int size = list.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (c.compare(list[j], list[i]) == -1) {
					GeometricObject temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
}
