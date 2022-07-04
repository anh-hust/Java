package Week_5;

import java.util.Date;

public class Employee extends Person {
	private String office;
	private double salary;
	Date startDate;

	public Employee() {
		super(); // if we don't declare this, JVM auto execute and hidden it against programmer
		this.startDate = new Date();
	}

	public Employee(String office, double salary) {
		this.office = office;
		this.salary = salary;
		this.startDate = new Date();
	}

	public Employee(String office, double salary, String name, String address, String email, String phoneNumber) {
		// TODO set constructor for its parent: Person
		super(name, address, email, phoneNumber);
		this.office = office;
		this.salary = salary;
		this.startDate = new Date();
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getOffice() {
		return this.office;
	}

	public double getSalary() {
		return this.salary;
	}

	public String getStartDate() {
		return this.startDate.toString();
	}

	@Override
	public String toString() {
		return super.toString() + "\nOffice: " + this.office + "\nSalary: " + this.salary + "\nStart date: "
				+ this.getStartDate();
	}
}
