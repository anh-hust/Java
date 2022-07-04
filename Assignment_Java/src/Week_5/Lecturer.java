package Week_5;

public class Lecturer extends Employee {
	private double officeHours;
	private String title;

	public Lecturer() {
//		super();
	}

	public Lecturer(double officeHours, String title) {
		super();
		this.officeHours = officeHours;
		this.title = title;
	}

	public Lecturer(double officeHours, String title, String office, double salary) {
		// TODO set constructor for its parent class: Employee
		super(office, salary);
		this.officeHours = officeHours;
		this.title = title;
	}

	public Lecturer(double officeHours, String title, String office, double salary, String name, String address,
			String email, String phoneNumber) {
		// TODO set constructor for its parent class: Employee, and grand parent: Person
		super(office, salary, name, address, email, phoneNumber);
		this.officeHours = officeHours;
		this.title = title;
	}

	public void setOfficeHours(double officeHours) {
		this.officeHours = officeHours;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getOfficeHours() {
		return this.officeHours;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return super.toString() + "\nOffice hours: " + this.officeHours + "\nTitle: " + this.title;
	}
}
