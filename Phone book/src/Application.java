import java.io.IOException;
import java.util.Scanner;

public class Application {

	/**
	 * This is the main method that is used to run the application and interact
	 * with the user.
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("\n\n \t\t\t\t           Welcome in PhoneBook");
		boolean b = true;
		while (b) {
			System.out
					.println("\t\t\t***********************************************************");
			System.out
					.println("\t\t\t_____________________________________________________________");
			System.out
					.println("\t\t\t|If you want to  :                                          |");
			System.out
					.println("\t\t\t|================                                           |");
			System.out
					.println("\t\t\t|1)  Add a new Contact.-----------------------------press(1)|");
			System.out
					.println("\t\t\t|2)  Edit an existing Contact.----------------------press(2)|");
			System.out
					.println("\t\t\t|3)  Delete an existing Contact.--------------------press(3)|");
			System.out
					.println("\t\t\t|4)  View all existing Contacts.--------------------press(4)|");
			System.out
					.println("\t\t\t|5)  Search for Contacts by First Name.-------------press(5)|");
			System.out
					.println("\t\t\t|6)  Search for Contacts by Last Name.--------------press(6)|");
			System.out
					.println("\t\t\t|7)  Search for Contacts by Phone Number.-----------press(7)|");
			System.out
					.println("\t\t\t|8)  To close.--------------------------------------press(8)|");
			System.out
					.println("\t\t\t|___________________________________________________________|");
			System.out.println("");
			System.out
					.println("\t\t\t*************************************************************");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String in = sc.nextLine();

			if (in.equals("1")) {
				PhoneBook.addNewContact();
			} else if (in.equals("2")) {
				PhoneBook.set_I_To_Zero();
				Contact userChoice = null;
				System.out
						.println("To edit a Contact you must search on it in the first!!!!!");
				System.out.println("If you want to  : ");
				System.out.println("=================");
				System.out
						.println("  1)  Search for Contacts by First Name.-------------press(1)");
				System.out
						.println("  2)  Search for Contacts by Last Name.--------------press(2)");
				System.out
						.println("  3)  Search for Contacts by Phone Number.-----------press(3)");
				boolean b1 = true;
				while (b1) {
					@SuppressWarnings("resource")
					Scanner sc1 = new Scanner(System.in);
					String in1 = sc1.nextLine();
					if (in1.equals("1")) {
						userChoice = PhoneBook.toSearchByFirstName();
						b1 = false;
					} else if (in1.equals("2")) {
						userChoice = PhoneBook.toSearchByLastName();
						b1 = false;
					} else if (in1.equals("3")) {
						userChoice = PhoneBook.toSearchByPhoneNumber();
						b1 = false;
					} else {
						System.out
								.println("You have entered an invalid input !!!!!\nPlease enter again : ");
					}
				}
				if (userChoice != null) {
					PhoneBook.edit_A_Contact(userChoice);
				} else {
					System.out.println("    Not Found !!!!!");
				}
			} else if (in.equals("3")) {
				PhoneBook.set_I_To_Zero();
				Contact userChoice = null;
				System.out
						.println("To delete a Contact you must search on it in the first!!!!!");
				System.out.println("If you want to  : ");
				System.out.println("=================");
				System.out
						.println("_______________________________________________________________");
				System.out
						.println("|  1)  Search for Contacts by First Name.-------------press(1)|");
				System.out
						.println("|  2)  Search for Contacts by Last Name.--------------press(2)|");
				System.out
						.println("|  3)  Search for Contacts by Phone Number.-----------press(3)|");
				System.out
						.println("|______________________________________________________________|");
				boolean b1 = true;
				while (b1) {
					@SuppressWarnings("resource")
					Scanner sc1 = new Scanner(System.in);
					String in1 = sc1.nextLine();
					if (in1.equals("1")) {
						userChoice = PhoneBook.toSearchByFirstName();
						b1 = false;
					} else if (in1.equals("2")) {
						userChoice = PhoneBook.toSearchByLastName();
						b1 = false;
					} else if (in1.equals("3")) {
						userChoice = PhoneBook.toSearchByPhoneNumber();
						b1 = false;
					} else {
						System.out
								.println("You have entered an invalid input !!!!!\nPlease enter again : ");
					}
				}

				if (userChoice != null) {
					PhoneBook.deleteContact(userChoice);
				} else {
					System.out.println("    Not Found !!!!!");
				}
			} else if (in.equals("4")) {
				PhoneBook.set_I_To_Zero();
				PhoneBook.viewAllContacts();
			} else if (in.equals("5")) {
				Contact userChoice = PhoneBook.toSearchByFirstName();
				System.out.println(userChoice.getFirstName()
						+ userChoice.getLastName()
						+ userChoice.getPhoneNumber() + userChoice.getE_mail()
						+ userChoice.getAddress() + userChoice.getNote());
			} else if (in.equals("6")) {
				Contact userChoice = PhoneBook.toSearchByLastName();
				System.out.println(userChoice.getFirstName()
						+ userChoice.getLastName()
						+ userChoice.getPhoneNumber() + userChoice.getE_mail()
						+ userChoice.getAddress() + userChoice.getNote());
			} else if (in.equals("7")) {
				Contact userChoice = PhoneBook.toSearchByPhoneNumber();
				System.out.println(userChoice.getFirstName()
						+ userChoice.getLastName()
						+ userChoice.getPhoneNumber() + userChoice.getE_mail()
						+ userChoice.getAddress() + userChoice.getNote());
			} else if (in.equals("8")) {
				b = false;
				System.out.println("\t\t\t		The program is closed");
				System.out.println("	\t\t\t	  ***Thank you***");
			} else {
				System.out.println("You have entered an invalid input !!!!!");
				System.out
						.println("1) To show the options again.---------------------press(1)");
				System.out
						.println("2) To close.--------------------------------------press(2)");
				System.out
						.println("___________________________________________________________");
				boolean t = true;
				while (t) {
					@SuppressWarnings("resource")
					Scanner sc2 = new Scanner(System.in);
					String in2 = sc2.nextLine();
					if (in2.equals("1")) {
						t = false;
					} else if (in2.equals("2")) {
						b = false;
						t = false;
						System.out.println("\t\t\t		The program is closed");
						System.out.println("		\t\t\t  ***Thank you***");
					} else {
						System.out
								.println("You have entered an invalid input !!!!!\nPlease enter (1) or (2)");
					}
				}
			}
		}
	}
}
