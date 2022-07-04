package Week_5;

import java.awt.Color;

public class Test {

	public static void main(String[] args) {

		/** Test task 1 */
//		Circle c1 = new Circle();
//		Circle c2 = new Circle(10.23);
//		Circle c3 = new Circle(11.4, "back and white", true);
//
//		System.out.println("----Circle 1 with no-arg constructor: ");
//		c1.printCircle();
//		System.out.println("\n----Circle 2 with radius arg constructor: ");
//		c2.printCircle();
//		System.out.println("\n----Circle 3 with three arguments constructor: ");
//		c3.printCircle();

		/** Test task 2 */
//		Person person1 = new Person("Bui Tuan Anh", "Where", "mail", "phone");
//
//		// Test Student
//		Person student1 = new Student(Student.Status.Junior, "Student 1", "School", "Private Email", "19001009");
//		Student student1_ = new Student(Student.Status.Senior, "Student 1_", "School_", "Private Email_", "19001009_");
//
//		// Test Employee
//		Person employee1 = new Employee("BKHN", 20000000, "Employee 1", "Where", "Email", "18001008");
//
//		// Test Lecturer
//		Person lecturer1 = new Lecturer(12, "Boss", "BKHN", 1000000000, "Lecturer 1", "Somewhere", "EMail for boss", "0912239283");
//		Employee lecturer1_ = new Lecturer(13, "Boss_", "BKHN", 1000000000);
//		Lecturer lecturer1__ = new Lecturer(14, "Boss__");
//
//		// Print stuff
//		System.out.println(person1.toString());
//
//		System.out.println("\n" + student1.toString());
//
//		System.out.println("\n" + student1_.toString());
//
//		System.out.println("\n" + employee1.toString());
//
//		System.out.println("\n" + lecturer1.toString());
//
//		System.out.println("\n" + lecturer1_.toString());
//		
//		System.out.println("\n" + lecturer1__.toString());

		/** Test task 3 */
		MyRectangle2D rectangle1 = new MyRectangle2D();
		MyRectangle2D rectangle1_ = new MyRectangle2D(5, 6, 2, 2);
		MyRectangle2D rectangle2 = new MyRectangle2D(4, 5, 10, 6);

		System.out.println("XY Inside: " + rectangle2.contains(6, 6));
		System.out.println("XY Inside: " + rectangle2.contains(5, 6));
		System.out.println("Rectangle 1 Inside: " + rectangle2.contains(rectangle1));
		System.out.println("Rectangle 1_ Inside: " + rectangle2.contains(rectangle1_));
	}

}
