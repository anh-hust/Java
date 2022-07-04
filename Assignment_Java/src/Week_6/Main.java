package Week_6;

public class Main {

	public static void main(String[] args) {
		/* Test task 1 */
//		GeometricObject[] geo = new GeometricObject[3];
//		geo[0] = new Circle(5.5);
//		geo[1] = new Rectangle(7.6, 3.2);
//		geo[2] = new Square(4.3);
//
//		System.out.println("Area of all Object in Geo array: " + GeometricObject.sumArea(geo));
//
//		for (int i = 0; i < geo.length; i++) {
//			System.out.println("\n\n" + geo[i].toString());
//		}

		/* Test task 2 */

//		SortCircles sc = new SortCircles(9);
//		sc.printInfoSCircle();
//		
//		sc.sortCircle();
		
		/* Test task 3 */
		Circle c1 = new Circle(4.5);
		Circle c2 = new Circle(7.6);

		System.out.println(c1.toString() + "\n\n");
		System.out.println(c2.toString() + "\n\n");
		System.out.println("The greater circle is: ");
		System.out.println(GeometricObject.max(c1, c2).toString() + "\n\n");
	}
}
