package Week_5;

public class MyRectangle2D {
	private double x_degreeOfRectangleCenter;
	private double y_degreeOfRectangleCenter;
	private double height;
	private double width;

	public MyRectangle2D() {
		System.out.println("Rectangle with its height follow x-axis, height follow y-axis");
		System.out.println("<______1______>");
		System.out.println("1-------------2	^");
		System.out.println("|------0------|	1");
		System.out.println("4-------------3	v");
		System.out.println("Four angle and (0,0) is center\n\n");
		this.x_degreeOfRectangleCenter = 0;
		this.y_degreeOfRectangleCenter = 0;
		this.width = 1;
		this.height = 1;
	}

	public MyRectangle2D(double x_degreeOfRectangleCenter, double y_degreeOfRectangleCenter, double width,
			double height) {
		System.out.println("Rectangle with its height follow x-axis, height follow y-axis");
		System.out.println("<____________width____________>");
		System.out.println("1-----------------------------2  ^");
		System.out.println("|-----------------------------|  |");
		System.out.println("|--------------x--------------| height");
		System.out.println("|-----------------------------|	 |");
		System.out.println("4-----------------------------3	 v");
		System.out.println("Four angle and x is center\n\n");
		this.x_degreeOfRectangleCenter = x_degreeOfRectangleCenter;
		this.y_degreeOfRectangleCenter = y_degreeOfRectangleCenter;
		this.height = height;
		this.width = width;
	}

	public void setX(double x_degreeOfRectangleCenter) {
		this.x_degreeOfRectangleCenter = x_degreeOfRectangleCenter;
	}

	public void setY(double y_degreeOfRectangleCenter) {
		this.y_degreeOfRectangleCenter = y_degreeOfRectangleCenter;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getX() {
		return this.x_degreeOfRectangleCenter;
	}

	public double getY() {
		return this.y_degreeOfRectangleCenter;
	}

	public double getHeight() {
		return this.height;
	}

	public double getWidth() {
		return this.width;
	}

	public double getArea() {
		return this.height * this.width;
	}

	public double getPerimeter() {
		return 2 * (this.height + this.width);
	}

	public boolean contains(double x_degree, double y_degree) {
		if (x_degree > this.x_degreeOfRectangleCenter - this.width / 2
				&& x_degree < this.x_degreeOfRectangleCenter + this.width / 2
				&& y_degree > this.y_degreeOfRectangleCenter - this.height / 2
				&& y_degree < this.y_degreeOfRectangleCenter + this.height / 2)
			return true;
		else
			return false;
	}

	public boolean contains(MyRectangle2D another) {
		if (contains(another.getX(), another.getY())) {
			if (another.getX() + another.getWidth() / 2 < this.x_degreeOfRectangleCenter + this.width / 2
					&& another.getX() - another.getWidth() / 2 > this.x_degreeOfRectangleCenter - this.width / 2
					&& another.getY() + another.getHeight() / 2 < this.y_degreeOfRectangleCenter + this.height / 2
					&& another.getY() - another.getHeight() / 2 > this.y_degreeOfRectangleCenter - this.height / 2)

				return true;
			else
				return false;
		} else
			return false;
	}
}
