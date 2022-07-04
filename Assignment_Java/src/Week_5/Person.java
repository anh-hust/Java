package Week_5;

public class Person {
	private String name;
	private String address;
	private String email;
	private String phoneNumber;

	public Person() {
	}

	public Person(String name, String address, String email, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	@Override
	public String toString() {
		return "----About " + this.name + ":\n" + "Address: " + this.address + "\nEmail: " + this.email
				+ "\nPhone number: " + this.phoneNumber;
	}
}
