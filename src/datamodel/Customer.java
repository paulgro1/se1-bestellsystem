package datamodel;

public class Customer {

	private final String id;
	private String firstName;
	private String lastName;
	private String name;
	private String contact;

	protected Customer(String id, String name, String contact) {
		this.id = id;
		
		setContact(contact);
		
		setLastName(name);
		
		this.firstName = "";

	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.equals("")) {
			this.firstName = "";
		} else {
			this.firstName = firstName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.equals("")) {
			this.lastName = "";
		} else {
			this.lastName = lastName;
		}
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		if (contact == null || contact.equals("")) {
			this.contact = "";
		} else {
			this.contact = contact;
		}
	}
}
