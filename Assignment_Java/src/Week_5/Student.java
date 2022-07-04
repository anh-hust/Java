package Week_5;

public class Student extends Person {
	static enum Status {
		Freshman, Sophomore,
		// a student studying in the second year of a course at a US college or high
		// school (= a school for students aged 15 to 18)
		Junior, Senior
	}

	private Status status;

	public Student() {
		super(); // if don't declare, Java auto implement and hidden
		this.status = Status.Freshman;
	}

	public Student(Status status) {
		this.status = status;
	}

	public Student(Status status, String name, String address, String email, String phoneNumber) {
		// TODO set constructor for its parent class: Person
		super(name, address, email, phoneNumber);
		this.status = status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getStatus() {
		switch (this.status) {
		case Freshman:
			return "Freshman";
		case Sophomore:
			return "Sophomore";
		case Junior:
			return "Junior";
		case Senior:
			return "Senior";
		default:
			System.out.println("Something wrong. Check it out!!");
			return "";
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\nStatus: " + this.getStatus();
	}
}
