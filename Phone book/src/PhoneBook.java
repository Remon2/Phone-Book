import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBook {

	static int i = 0;

	/**
	 * This method is used to set the value of the static variable (I) to(zero).
	 */
	public static void set_I_To_Zero() {
		i = 0;
	}

	/**
	 * This method is used to load the file (Contact.txt)in an array of object
	 * then print all the array.
	 */
	public static void viewAllContacts() {
		try {
			int num = numOfContacts();
			Contact[] mine = loadFile();
			mine = sort(mine);
			copyToFile(mine);
			for (int h = 0; h < num; h++) {
				System.out.println(mine[h].getFirstName() + " "
						+ mine[h].getLastName() + " "
						+ mine[h].getPhoneNumber() + " " + mine[h].getE_mail()
						+ " " + mine[h].getAddress() + " " + mine[h].getNote());
				System.out.println();
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * This method is used to load the file in an array of object then add new
	 * object to the array (new Contact) then save all the array in the
	 * file(Contact.txt).
	 */
	public static void addNewContact() {
		try {
			Contact[] mine = loadFile();
			String x = "1";
			while (x.equals("1")) {
				String firstName = "";
				boolean t = true;
				while (t == true) {
					@SuppressWarnings("resource")
					Scanner add_f = new Scanner(System.in);
					System.out.println("Enter The First Name : ");
					firstName = add_f.nextLine();
					if (firstName.length() > 15) {
						System.out
								.println("You have entered an invalid first name (too long)");
					} else if (firstName.equals("") || firstName.length() == 0) {
						System.out
								.println("You must enter the first name !!!!!");
					} else {
						t = false;
					}
				}
				for (int i = 0; i < mine.length; i++) {
					if ((firstName + ",").equals(mine[i].getFirstName())) {
						System.out
								.println("This first name has already existed!!!!!");
					}
				}
				String lastName = "";
				boolean t1 = true;
				while (t1 == true) {
					@SuppressWarnings("resource")
					Scanner add_l = new Scanner(System.in);
					System.out.println("Enter The Last Name : ");
					lastName = add_l.nextLine();
					if (lastName.length() > 15) {
						System.out
								.println("You have entered an invalid Last name (too long)");
					} else if (lastName.equals("") || lastName.length() == 0) {
						System.out
								.println("You must enter the Last name !!!!!");
					} else {
						t1 = false;
					}
				}
				for (int i = 0; i < mine.length; i++) {
					if ((lastName + ",").equals(mine[i].getLastName())) {
						System.out
								.println("This last name has already existed!!!!!");
					}
				}
				@SuppressWarnings("resource")
				Scanner add_p = new Scanner(System.in);
				System.out.println("Enter The Phone Number : ");
				String phoneNumber = add_p.nextLine();
				boolean b = checkNumber(phoneNumber);
				while (b == false || phoneNumber.length() > 14) {
					System.out
							.println("You must enter a valid Phone Number!!!!!");
					@SuppressWarnings("resource")
					Scanner add3 = new Scanner(System.in);
					System.out
							.println("Please Enter The Phone Number again!: ");
					phoneNumber = add3.nextLine();
					b = checkNumber(phoneNumber);
				}
				if (phoneNumber.length() < 3) {
					System.out.println("It is not logic Phone Number !!!!!");
				}
				for (int i = 0; i < mine.length; i++) {
					if ((phoneNumber + ",").equals(mine[i].getPhoneNumber())) {
						System.out
								.println("This phone number has already existed!!!!!");
					}
				}

				System.out
						.println("If you want to add an e_mail------------press (1)");
				System.out
						.println("If you want not to add an e_mail--------press (2)");
				@SuppressWarnings("resource")
				Scanner add_i2 = new Scanner(System.in);
				String e = add_i2.nextLine();
				boolean b1 = true;
				String e_mail = "";
				while (b1 == true) {
					if (e.equals("1")) {
						boolean h = true;
						while (h == true) {
							@SuppressWarnings("resource")
							Scanner add_f2 = new Scanner(System.in);
							System.out.println("Enter The E_mail : ");
							e_mail = " " + add_f2.nextLine();
							if (e_mailValidation(e_mail)) {
								b1 = false;
								h = false;
							} else {
								System.out
										.println("You have entered an invalid e_mail!!!!!\nPlease enter again.");
							}
						}
					} else if (e.equals("2")) {
						e_mail = " -----";
						b1 = false;
					} else {
						System.out
								.println("You have entered an invalid input !!!!!");
						System.out.println("Please Enter again!: ");
						@SuppressWarnings("resource")
						Scanner add_i3 = new Scanner(System.in);
						e = add_i3.nextLine();
					}
				}
				for (int i = 0; i < mine.length; i++) {
					if ((e_mail + ",").equals(mine[i].getE_mail())) {
						System.out
								.println("This e_mail has already existed!!!!!");
					}
				}
				boolean b2 = true;
				String address = "";

				System.out
						.println("If you want to add an address------------press (1)");
				System.out
						.println("If you want not to add an address--------press (2)");
				@SuppressWarnings("resource")
				Scanner add_i3 = new Scanner(System.in);
				String a = add_i3.nextLine();
				while (b2 == true) {
					if (a.equals("1")) {
						@SuppressWarnings("resource")
						Scanner add_f3 = new Scanner(System.in);
						System.out.println("Enter The Address : ");
						address = " " + add_f3.nextLine();
						b2 = false;
					} else if (a.equals("2")) {
						address = " -----";
						b2 = false;
					} else {
						System.out
								.println("You have entered an invalid input !!!!!");
						System.out.println("Please Enter again!: ");
						@SuppressWarnings("resource")
						Scanner add_i4 = new Scanner(System.in);
						a = add_i4.nextLine();
					}
				}
				for (int i = 0; i < mine.length; i++) {
					if ((address + ",").equals(mine[i].getAddress())) {
						System.out
								.println("This address has already existed!!!!!");
					}
				}
				boolean b3 = true;
				String note = "";

				System.out
						.println("If you want to add an notes------------press (1)");
				System.out
						.println("If you want not to add an notes--------press (2)");
				@SuppressWarnings("resource")
				Scanner add_i4 = new Scanner(System.in);
				String n = add_i4.nextLine();
				while (b3 == true) {
					if (n.equals("1")) {
						@SuppressWarnings("resource")
						Scanner add_f4 = new Scanner(System.in);
						System.out.println("Enter The Notes : ");
						note = " " + add_f4.nextLine();
						b3 = false;
					} else if (n.equals("2")) {
						note = " -----";
						b3 = false;
					} else {
						System.out
								.println("You have entered an invalid input !!!!!");
						System.out.println("Please Enter again!: ");
						@SuppressWarnings("resource")
						Scanner add_i5 = new Scanner(System.in);
						n = add_i5.nextLine();
					}
					for (int i = 0; i < mine.length; i++) {
						if ((note + ",").equals(mine[i].getNote())) {
							System.out
									.println("This note has already existed!!!!!");
						}
					}
					mine[i] = new Contact(firstName, lastName, phoneNumber,
							e_mail, address, note);
					addToFile(firstName, lastName, phoneNumber, e_mail,
							address, note);
					Contact[] unSorted = loadFile();
					unSorted = sort(unSorted);
					copyToFile(unSorted);
					System.out
							.println("The contact has been addad Successfully");
					boolean b4 = false;
					while (b4 == false) {
						System.out.println("If you want to :");
						System.out
								.println("To add another contact---------press (1)");
						System.out
								.println("To exit press------------------press (2)");

						@SuppressWarnings("resource")
						Scanner press = new Scanner(System.in);
						x = press.nextLine();
						if (x.equals("1") || x.equals("2")) {
							b4 = true;
						} else {
							System.out
									.println("You have entered an invalid input !!!!!");
						}
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * This method used to add the contact information to the file(Contact.txt).
	 * 
	 * @param firstName
	 *            --The first parameter is the first name of the contact.
	 * @param lastName
	 *            --The second parameter is the first name of the contact.
	 * @param phoneNumber
	 *            --The third parameter is the first name of the contact.
	 * @param e_mail
	 *            --The fourth parameter is the first name of the contact.
	 * @param address
	 *            --The fifth parameter is the first name of the contact.
	 * @param note
	 *            --The sixth parameter is the first name of the contact.
	 */
	public static void addToFile(String firstName, String lastName,
			String phoneNumber, String e_mail, String address, String note) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"Contact.txt", true));
			bw.append(firstName + ", " + lastName + ", " + phoneNumber + ", "
					+ e_mail + ", " + address + "," + note + "\n");
			bw.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * This method used to count the number of contacts in the file
	 * (Contact.txt).
	 * 
	 * @return --int the number of contacts.
	 */
	public static int numOfContacts() {
		int num = 0;
		try {
			File file = new File("Contact.txt");
			@SuppressWarnings("resource")
			Scanner scn = new Scanner(file);
			while (scn.hasNextLine()) {
				num++;
				scn.nextLine();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return num;
	}

	/**
	 * This method takes the data from the file ("Contact.txt") and put it in an
	 * array of objects (Contact).
	 * 
	 * @return --An array of objects (Contact).
	 */
	public static Contact[] loadFile() {
		try {
			File file = new File("Contact.txt");
			Scanner scn = new Scanner(file);
			Contact[] mine = new Contact[numOfContacts()];
			int x = 0;
			while (scn.hasNextLine()) {
				String firstName = scn.next();
				String lastName = scn.next();
				String phoneNumber = scn.next();
				String e_mail = scn.next();
				String address = scn.next();
				String note = scn.nextLine();
				mine[x] = new Contact(firstName, lastName, phoneNumber, e_mail,
						address, note);
				x++;
			}
			scn.close();
			return mine;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;

	}

	/**
	 * This method is used to search for a contact by the first name or a the
	 * first part of it.<br>
	 * 1)load the file (Contact.txt) to an array of objects (Contact) .<br>
	 * 2)search in the array for the first name that the user want.<br>
	 * 3)print the result of the search to the user .<br>
	 * 4)the user choice the contact that he wanted.
	 * 
	 * @param firstName
	 *            --String the first name or the first part of it.
	 * @return -- an array of object contains the result of the search.
	 */
	public static Contact[] searchContactWithFirstName(String firstName) {
		int size = 0;
		int index = 0;
		int c = numOfContacts();
		Contact[] mine = loadFile();
		for (int k = 0; k < c; k++) {
			if (mine[k].getFirstName().toLowerCase()
					.contains(firstName.toLowerCase())
					&& mine[k].getFirstName().toLowerCase().charAt(0) == firstName
							.toLowerCase().charAt(0)) {
				size++;
			}
		}
		Contact[] searchResult = new Contact[size];
		if (size > 0) {
			for (int k = 0; k < c; k++) {
				if (mine[k].getFirstName().toLowerCase()
						.contains(firstName.toLowerCase())
						&& mine[k].getFirstName().toLowerCase().charAt(0) == firstName
								.toLowerCase().charAt(0)) {
					searchResult[index] = new Contact(mine[k].getFirstName(),
							mine[k].getLastName(), mine[k].getPhoneNumber(),
							mine[k].getE_mail(), mine[k].getAddress(),
							mine[k].getNote());
					index++;
				}
			}
		}
		return searchResult;
	}

	/**
	 * This method is used to interact with the user to search for a contact by
	 * the first name.
	 * 
	 * @return --an object (Contact) that the user want.
	 */
	public static Contact toSearchByFirstName() {
		int i;
		Contact userChoice = null;
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the First Name : ");
		String firstName = sc1.nextLine();
		Contact[] searchResult = searchContactWithFirstName(firstName);
		if (searchResult.length > 0) {
			for (i = 0; i < searchResult.length; i++) {
				System.out.println("  " + (i + 1) + ") "
						+ searchResult[i].getFirstName()
						+ searchResult[i].getLastName()
						+ searchResult[i].getPhoneNumber()
						+ searchResult[i].getE_mail()
						+ searchResult[i].getAddress()
						+ searchResult[i].getNote());
				System.out.println();
			}

			boolean b1 = true;
			while (b1 == true) {
				System.out
						.println("Enter the index of line that you want !!!!!");
				@SuppressWarnings("resource")
				Scanner sc2 = new Scanner(System.in);
				String index = sc2.nextLine();

				if (checkNumber(index)
						&& Integer.parseInt(index) <= searchResult.length) {
					userChoice = new Contact(
							searchResult[Integer.parseInt(index) - 1]
									.getFirstName(),
							searchResult[Integer.parseInt(index) - 1]
									.getLastName(), searchResult[Integer
									.parseInt(index) - 1].getPhoneNumber(),
							searchResult[Integer.parseInt(index) - 1]
									.getE_mail(), searchResult[Integer
									.parseInt(index) - 1].getAddress(),
							searchResult[Integer.parseInt(index) - 1].getNote());
					b1 = false;
				} else {
					System.out
							.println("You have entered an invalid input !!!!!");
				}
			}
		} else {
			System.out.println("Not found this name !!!!!");
		}
		return userChoice;
	}

	/**
	 * This method is used to search for a contact by the last name or the first
	 * part of it.<br>
	 * 1)load the file (Contact.txt) to an array of objects (Contact) .<br>
	 * 2)search in the array for the last name that the user want.<br>
	 * 3)print the result of the search to the user .<br>
	 * 4)the user choice the contact that he wanted.
	 * 
	 * @param lastName
	 *            --String the last name or the first part of it.
	 * @return -- an array of object contains the result of the search.
	 */
	public static Contact[] searchContactWithLastName(String lastName) {
		int size = 0;
		int index = 0;
		int c = numOfContacts();
		Contact[] mine = loadFile();
		for (int k = 0; k < c; k++) {
			if (mine[k].getLastName().toLowerCase()
					.contains(lastName.toLowerCase())
					&& mine[k].getLastName().toLowerCase().charAt(0) == lastName
							.toLowerCase().charAt(0)) {
				size++;
			}
		}
		Contact[] searchResult = new Contact[size];
		if (size > 0) {
			for (int k = 0; k < c; k++) {
				if (mine[k].getLastName().toLowerCase()
						.contains(lastName.toLowerCase())
						&& mine[k].getLastName().toLowerCase().charAt(0) == lastName
								.toLowerCase().charAt(0)) {
					searchResult[index] = new Contact(mine[k].getFirstName(),
							mine[k].getLastName(), mine[k].getPhoneNumber(),
							mine[k].getE_mail(), mine[k].getAddress(),
							mine[k].getNote());
					index++;
				}
			}
		}
		return searchResult;
	}

	/**
	 * This method is used to interact with the user to search for a contact by
	 * the last name.
	 * 
	 * @return an object (Contact) that the user want.
	 */
	public static Contact toSearchByLastName() {
		int i;
		Contact userChoice = null;
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the Last Name : ");
		String lastName = sc1.nextLine();
		Contact[] searchResult = searchContactWithLastName(lastName);
		if (searchResult.length > 0) {
			for (i = 0; i < searchResult.length; i++) {
				System.out.println("  " + (i + 1) + ") "
						+ searchResult[i].getFirstName()
						+ searchResult[i].getLastName()
						+ searchResult[i].getPhoneNumber()
						+ searchResult[i].getE_mail()
						+ searchResult[i].getAddress()
						+ searchResult[i].getNote());
				System.out.println();
			}

			boolean b1 = true;
			while (b1 == true) {
				System.out
						.println("Enter the index of line that you want !!!!!");
				@SuppressWarnings("resource")
				Scanner sc3 = new Scanner(System.in);
				String index = sc3.nextLine();

				if (checkNumber(index)
						&& Integer.parseInt(index) <= searchResult.length) {
					userChoice = new Contact(
							searchResult[Integer.parseInt(index) - 1]
									.getFirstName(),
							searchResult[Integer.parseInt(index) - 1]
									.getLastName(), searchResult[Integer
									.parseInt(index) - 1].getPhoneNumber(),
							searchResult[Integer.parseInt(index) - 1]
									.getE_mail(), searchResult[Integer
									.parseInt(index) - 1].getAddress(),
							searchResult[Integer.parseInt(index) - 1].getNote());
					b1 = false;
				} else {
					System.out
							.println("You have entered an invalid input !!!!!");
				}
			}
		} else {
			System.out.println("Not found this name !!!!!");
		}
		return userChoice;

	}

	/**
	 * This method is used to search for a contact by the PhoneNumber or the
	 * first part of it.<br>
	 * 1)load the file (Contact.txt) to an array of objects (Contact) .<br>
	 * 2)search in the array for the PhoneNumber that the user want.<br>
	 * 3)print the result of the search to the user .<br>
	 * 4)the user choice the contact that he wanted.
	 * 
	 * @param PhoneNumber
	 *            --String the PhoneNumber or the first part of it.
	 * @return -- an array of object contains the result of the search.
	 */
	public static Contact[] searchContactWithPhoneNumber(String PhoneNumber) {
		int size = 0;
		int index = 0;
		int c = numOfContacts();
		Contact[] mine = loadFile();
		for (int k = 0; k < c; k++) {
			if (mine[k].getPhoneNumber().contains(PhoneNumber)
					&& mine[k].getPhoneNumber().charAt(0) == PhoneNumber
							.charAt(0)) {
				size++;
			}
		}
		Contact[] searchResult = new Contact[size];
		if (size > 0) {
			for (int k = 0; k < c; k++) {
				if (mine[k].getPhoneNumber().contains(PhoneNumber)
						&& mine[k].getPhoneNumber().charAt(0) == PhoneNumber
								.charAt(0)) {
					searchResult[index] = new Contact(mine[k].getFirstName(),
							mine[k].getLastName(), mine[k].getPhoneNumber(),
							mine[k].getE_mail(), mine[k].getAddress(),
							mine[k].getNote());
					index++;
				}
			}
		}
		return searchResult;
	}

	/**
	 * This method is used to interact with the user to search for a contact by
	 * the phone number.
	 * 
	 * @return an object (Contact) that the user want.
	 */
	public static Contact toSearchByPhoneNumber() {
		int i;
		Contact userChoice = null;
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter the Phone Number : ");
		String phoneNumber = sc1.nextLine();
		boolean b2 = true;
		while (b2) {
			if (checkNumber(phoneNumber)) {
				Contact[] searchResult = searchContactWithPhoneNumber(phoneNumber);
				if (searchResult.length > 0) {
					for (i = 0; i < searchResult.length; i++) {
						System.out.println("  " + (i + 1) + ") "
								+ searchResult[i].getFirstName()
								+ searchResult[i].getLastName()
								+ searchResult[i].getPhoneNumber()
								+ searchResult[i].getE_mail()
								+ searchResult[i].getAddress()
								+ searchResult[i].getNote());
						System.out.println();
					}

					boolean b1 = true;
					while (b1 == true) {
						System.out
								.println("Enter the index of line that you want !!!!!");
						@SuppressWarnings("resource")
						Scanner sc3 = new Scanner(System.in);
						String index = sc3.nextLine();

						if (checkNumber(index)
								&& Integer.parseInt(index) <= searchResult.length) {
							userChoice = new Contact(
									searchResult[Integer.parseInt(index) - 1]
											.getFirstName(),
									searchResult[Integer.parseInt(index) - 1]
											.getLastName(),
									searchResult[Integer.parseInt(index) - 1]
											.getPhoneNumber(),
									searchResult[Integer.parseInt(index) - 1]
											.getE_mail(), searchResult[Integer
											.parseInt(index) - 1].getAddress(),
									searchResult[Integer.parseInt(index) - 1]
											.getNote());
							b1 = false;
						} else {
							System.out
									.println("You have entered an invalid input !!!!!");
						}
					}

				} else {
					System.out.println("Not found this number !!!!!");
				}
				b2 = false;
			} else {
				System.out
						.println("You have entered an invalid input !!!!!\nPlease enter again : ");
				@SuppressWarnings("resource")
				Scanner sc3 = new Scanner(System.in);
				phoneNumber = sc3.nextLine();
			}
		}

		return userChoice;

	}

	/**
	 * This method is used to check the phone number validation<br>
	 * the phone number must be a numbers only and not letters.
	 * 
	 * @param phoneNumber
	 *            --the phone number that the user has been input it.
	 * @return --boolean :<br>
	 *         true if the phone number is correct, <br>
	 *         false if the phone number is incorrect.
	 */
	public static boolean checkNumber(String phoneNumber) {
		if (phoneNumber.length() == 0 || phoneNumber == null) {
			return false;
		}
		for (int i = 0; i < phoneNumber.length(); i++) {
			if (!Character.isDigit(phoneNumber.charAt(i))) {
				return false;
			}
		}
		return true;

	}

	/**
	 * This method is used to edit an existing contact in the file(Contact.txt):<br>
	 * 1)load the file (Contact.txt) to an array of objects (Contact) .<br>
	 * 2)find the index of the contact that the user want to edit .<br>
	 * 3)edit it in the array then save it in the file.
	 * 
	 * @param userChoice
	 * <br>
	 *            --Object contact that the user want to edit.
	 * @throws IOException
	 */
	public static void edit_A_Contact(Contact userChoice) throws IOException {
		int c = numOfContacts();
		Contact[] mine = loadFile();
		String in = null;
		boolean x = true;
		while (x) {
			System.out.println("If you want to edit : ");
			System.out.println("1) First Name------------press (1).");
			System.out.println("2) Last Name-------------press (2).");
			System.out.println("3) Phone Number----------press (3).");
			System.out.println("4) E_mail----------------press (4).");
			System.out.println("5) Address---------------press (5).");
			System.out.println("6) Notes-----------------press (6).");
			@SuppressWarnings("resource")
			Scanner sc2 = new Scanner(System.in);
			in = sc2.nextLine();
			if (in.equals("1") || in.equals("2") || in.equals("3")
					|| in.equals("4") || in.equals("5") || in.equals("6")) {
				x = false;
			} else {
				System.out
						.println("You have entered an invalid input !!!!! \nPlease enter again!!!!!");
			}
		}
		if (in.equals("1")) {
			int index = -1;
			for (int i = 0; i < c; i++) {
				if (mine[i].getFirstName().equalsIgnoreCase(
						userChoice.getFirstName())) {
					index = i;
				}
			}
			if (index >= 0) {
				String newFirstName = "";
				boolean t = true;
				while (t == true) {
					@SuppressWarnings("resource")
					Scanner add_f = new Scanner(System.in);
					System.out.println("Enter The First Name : ");
					newFirstName = add_f.nextLine();
					if (newFirstName.length() > 15) {
						System.out
								.println("You have entered an invalid first name (too long)");
					} else if (newFirstName.equals("")
							|| newFirstName.length() == 0) {
						System.out
								.println("You must enter the first name !!!!!");
					} else {
						t = false;
					}
				}
				for (int i = 0; i < mine.length; i++) {
					if ((newFirstName + ",").equals(mine[i].getFirstName())) {
						System.out
								.println("This first name has already existed!!!!!");
					}
				}

				mine[index].setFirstName(newFirstName + ",");
				mine = sort(mine);
				copyToFile(mine);
				System.out
						.println("The contact has been edited successfully\n");
			} else {
				System.out.println("      Not Found !!!!!");
			}
		} else if (in.equals("2")) {

			int index = -1;
			for (int i = 0; i < c; i++) {
				if (mine[i].getFirstName().equalsIgnoreCase(
						userChoice.getFirstName())) {
					index = i;
				}
			}
			if (index >= 0) {
				String newLastName = "";
				boolean t = true;
				while (t == true) {
					@SuppressWarnings("resource")
					Scanner add_f = new Scanner(System.in);
					System.out.println("Enter The First Name : ");
					newLastName = add_f.nextLine();
					if (newLastName.length() > 15) {
						System.out
								.println("You have entered an invalid last name (too long)");
					} else if (newLastName.equals("")
							|| newLastName.length() == 0) {
						System.out
								.println("You must enter the last name !!!!!");
					} else {
						t = false;
					}
				}
				for (int i = 0; i < mine.length; i++) {
					if ((newLastName + ",").equals(mine[i].getLastName())) {
						System.out
								.println("This last name has already existed!!!!!");
					}
				}
				mine[index].setLastName(newLastName + ",");
				mine = sort(mine);
				copyToFile(mine);
				System.out
						.println("The contact has been edited successfully\n");
			} else {
				System.out.println("      Not Found !!!!!");
			}
		} else if (in.equals("3")) {
			int index = -1;
			for (int i = 0; i < c; i++) {
				if (mine[i].getPhoneNumber()
						.equals(userChoice.getPhoneNumber())) {
					index = i;
				}
			}
			if (index >= 0) {
				@SuppressWarnings("resource")
				Scanner add_p = new Scanner(System.in);
				System.out.println("Enter The Phone Number : ");
				String newPhoneNumber = add_p.nextLine();
				boolean b = checkNumber(newPhoneNumber);
				while (b == false || newPhoneNumber.length() > 14) {
					System.out
							.println("You must enter a valid Phone Number!!!!!");
					@SuppressWarnings("resource")
					Scanner add3 = new Scanner(System.in);
					System.out
							.println("Please Enter The Phone Number again!: ");
					newPhoneNumber = add3.nextLine();
					b = checkNumber(newPhoneNumber);
				}
				if (newPhoneNumber.length() < 3) {
					System.out.println("It is not logic Phone Number !!!!!");
				}
				for (int i = 0; i < mine.length; i++) {
					if ((newPhoneNumber + ",").equals(mine[i].getPhoneNumber())) {
						System.out
								.println("This phone number has already existed!!!!!");
					}
				}
				mine[index].setPhoneNumber(newPhoneNumber + ",");
				copyToFile(mine);
				System.out
						.println("The contact has been edited successfully\n");
			} else {
				System.out.println("      Not Found !!!!!");
			}
		} else if (in.equals("4")) {
			int index = -1;
			for (int i = 0; i < c; i++) {
				if (mine[i].getE_mail()
						.equalsIgnoreCase(userChoice.getE_mail())) {
					index = i;
				}
			}
			if (index >= 0) {
				@SuppressWarnings("resource")
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the new E_mail : ");
				String newE_mail = sc1.nextLine();
				mine[index].setE_mail(newE_mail + ", ");
				copyToFile(mine);
				System.out
						.println("The contact has been edited successfully\n");
			} else {
				System.out.println("      Not Found !!!!!");
			}
		} else if (in.equals("5")) {
			int index = -1;
			for (int i = 0; i < c; i++) {
				if (mine[i].getAddress().equalsIgnoreCase(
						userChoice.getAddress())) {
					index = i;
				}
			}
			if (index >= 0) {
				@SuppressWarnings("resource")
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the new Address : ");
				String newAddress = sc1.nextLine();
				mine[index].setAddress(newAddress + ", ");
				copyToFile(mine);
				System.out
						.println("The contact has been edited successfully\n");
			} else {
				System.out.println("      Not Found !!!!!");
			}
		} else if (in.equals("6")) {
			int index = -1;
			for (int i = 0; i < c; i++) {
				if (mine[i].getNote().equalsIgnoreCase(userChoice.getNote())) {
					index = i;
				}
			}
			if (index >= 0) {
				@SuppressWarnings("resource")
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Enter the new Notes : ");
				String newNotes = sc1.nextLine();
				mine[index].setNote(newNotes);
				copyToFile(mine);
				System.out
						.println("The contact has been edited successfully\n");
			} else {
				System.out.println("      Not Found !!!!!");
			}
		} else {
			System.out.println("You have entered an invalid input !!!!!");
		}
	}

	/**
	 * This method is used to copy an array of objects (Contact) to the file
	 * ("Contact.txt").
	 * 
	 * @param new_Array
	 * <br>
	 *            --the array of objects (Contact).
	 * @throws IOException
	 */
	public static void copyToFile(Contact[] new_Array) throws IOException {
		int c = numOfContacts();
		@SuppressWarnings("unused")
		File file = new File("Contact.txt");
		new_Array = sort(new_Array);
		PrintWriter out = new PrintWriter("Contact.txt");
		for (int f = 0; f < c; f++) {
			String write = new_Array[f].getFirstName() + " "
					+ new_Array[f].getLastName() + " "
					+ new_Array[f].getPhoneNumber() + " "
					+ new_Array[f].getE_mail() + " "
					+ new_Array[f].getAddress() + new_Array[f].getNote();
			out.println(write);
		}
		out.close();
	}

	/**
	 * This method is used to delete a contact from the file(Contact.txt).<br>
	 * 1)Search the contact that you want to delete.<br>
	 * 2)The user show the result of the search.<br>
	 * 3)Then enter the index of the line that the user want to delete it.<br>
	 * 4)Delete the Contact from the array and save the array in the file.
	 * 
	 * @throws IOException
	 */
	public static void deleteContact(Contact userChoice) throws IOException {
		int c = numOfContacts();
		int index = -1;
		Contact[] mine = loadFile();
		for (int i = 0; i < c; i++) {
			if (mine[i].getPhoneNumber().equals(userChoice.getPhoneNumber())
					&& mine[i].getFirstName().equalsIgnoreCase(
							userChoice.getFirstName())) {
				index = i;
			}
		}
		delete_Element(mine, index);
	}

	/**
	 * This method takes an array of objects(Contact) and an index of an element
	 * and delete it<br>
	 * then save it in the file (Contact.txt).
	 * 
	 * @param mine
	 * <br>
	 *            --an array of objects (Contact).
	 * @param index
	 * <br>
	 *            --an index of an element in the array.
	 * @throws IOException
	 */
	public static void delete_Element(Contact[] mine, int index)
			throws IOException {
		int c = numOfContacts();
		int size = 0;
		Contact[] mine2 = new Contact[c - 1];
		for (int i = 0; i <= mine2.length; i++) {
			if (i != index) {
				mine2[size] = mine[i];
				size++;
			}
		}

		copyToFile_Delete(mine2);
		System.out.println("The contact has been deleted successfully\n");
	}

	/**
	 * This method takes one parameter an array of objects(Contact) and print it
	 * in a file (Contact.txt).
	 * 
	 * @param new_Array
	 *            --It is an array of objects (Contact).
	 * @throws IOException
	 */
	public static void copyToFile_Delete(Contact[] new_Array)
			throws IOException {
		int c = numOfContacts();
		@SuppressWarnings("unused")
		File file = new File("Contact.txt");
		PrintWriter out = new PrintWriter("Contact.txt");
		for (int f = 0; f < c - 1; f++) {
			String write = new_Array[f].getFirstName() + " "
					+ new_Array[f].getLastName() + " "
					+ new_Array[f].getPhoneNumber() + " "
					+ new_Array[f].getE_mail() + " "
					+ new_Array[f].getAddress() + new_Array[f].getNote();
			out.println(write);
		}
		out.close();
	}

	/**
	 * This method check the e_mail validation.
	 * 
	 * @param e_mail
	 * <br>
	 *            --It takes one parameter the e_mail in a String.
	 * @return<br> --It returns boolean : True if the e_mail valid and false if
	 *             the e_mail in valid.
	 */
	public static boolean e_mailValidation(String e_mail) {
		if (e_mail.length() == 0)
			return false;
		if (e_mail.contains("@") && e_mail.contains(".")) {
			if (e_mail.indexOf("@") < e_mail.indexOf(".")) {
				return true;
			} else
				return false;
		}
		return false;

	}

	/**
	 * This method is used to sort an array of object by the first name by
	 * (Bubble Sort)
	 * 
	 * @param sor
	 *            --It takes an array of object (Contact) unsorted .
	 * @return --It returns array of object (Contact) sorted .
	 * @throws IOException
	 */
	public static Contact[] sort(Contact[] sor) throws IOException {
		int j;
		boolean flag = true;
		Contact temp;
		while (flag) {
			for (j = 0; j < sor.length - 1; j++) {
				if (sor[j].getFirstName().compareToIgnoreCase(
						sor[j + 1].getFirstName()) > 0) {
					temp = sor[j];
					sor[j] = sor[j + 1];
					sor[j + 1] = temp;
					flag = true;
				}
				flag = false;
			}
		}
		return sor;
	}

}