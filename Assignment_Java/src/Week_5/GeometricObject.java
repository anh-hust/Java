package Week_5;

import java.util.Date;

public class GeometricObject {
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
	
	public String toString() {
		return  "\nColor: " + this.color + "\nStatus: " + (isFilled() ? "Filled" : "Not filled yet") + "\nDate created: " + this.dateCreated.toString(); 
	}

}
