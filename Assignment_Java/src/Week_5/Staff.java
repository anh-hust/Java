package Week_5;

public class Staff extends Employee {
	private int rank;

	public Staff() {
		super();
		this.rank = 1;
	}

	public Staff(int rank) {
		super();
		this.rank = rank;
	}

	public Staff(int rank, String office, double salary) {
		// TODO set constructor for its parent class: Employee
		super(office, salary);
		this.rank = rank;
	}

	public Staff(int rank, String office, double salary, String name, String address, String email,
			String phoneNumber) {
		// TODO set constructor for its parent class: Employee, and grand parent: Person
		super(office, salary, name, address, email, phoneNumber);
		this.rank = rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return this.rank;
	}

	@Override
	public String toString() {
		return super.toString() + "\nRank: " + this.rank;
	}
}
