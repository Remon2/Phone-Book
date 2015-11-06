public class Contact {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String e_mail;
	private String address;
	private String note;

	/**
	 * The constructor (Contact).
	 * 
	 * @param firstName
	 *            --String the first name of the person.
	 * @param lastName
	 *            --String the last name of the person.
	 * @param phoneNumber
	 *            --String the phone number of the person.
	 * @param e_mail
	 *            --String the e_mail of the person.
	 * @param address
	 *            --String the address of the person.
	 * @param note
	 *            --String the note of the person.
	 */
	Contact(String firstName, String lastName, String phoneNumber,
			String e_mail, String address, String note) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPhoneNumber(phoneNumber);
		this.setE_mail(e_mail);
		this.setAddress(address);
		this.setNote(note);
	}

	/**
	 * This method is used to get the first name of the object (Contact).
	 * 
	 * @return --the first name of the object .
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method is used to set the first name of the object (Contact).
	 * 
	 * @param firstName
	 *            --String first name of the object .
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method is used to get the last name of the object (Contact).
	 * 
	 * @return --the last name of the object .
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method is used to set the last name of the object (Contact).
	 * 
	 * @param lastName
	 *            --String last name of the object .
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * This method is used to get the phone number of the object (Contact).
	 * 
	 * @return --the phone number of the object .
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method is used to set the phone number of the object (Contact).
	 * 
	 * @param phoneNumber
	 *            --String phone number of the object .
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * This method is used to get the e_mail of the object (Contact).
	 * 
	 * @return --the e_mail of the object .
	 */
	public String getE_mail() {
		return e_mail;
	}

	/**
	 * This method is used to set the e_mail of the object (Contact).
	 * 
	 * @param e_mail
	 *            --String e_mail of the object .
	 */
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	/**
	 * This method is used to get the address of the object (Contact).
	 * 
	 * @return --the address of the object .
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method is used to set the address of the object (Contact).
	 * 
	 * @param address
	 *            --String address of the object .
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method is used to get the notes of the object (Contact).
	 * 
	 * @return --the notes of the object .
	 */
	public String getNote() {
		return note;
	}

	/**
	 * This method is used to set the notes of the object (Contact).
	 * 
	 * @param note
	 *            --String notes of the object .
	 */
	public void setNote(String note) {
		this.note = note;
	}
}
