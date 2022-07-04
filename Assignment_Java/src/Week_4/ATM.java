package Week_4;

import java.util.*;

public class ATM {

	public static void main(String[] args) {

		/* Initialization */
		Account[] arrayAcc = new Account[10];
		String[] password = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		/* assign ID, balance to 10 accounts */
		for (int i = 0; i < arrayAcc.length; i++) {
			arrayAcc[i] = new Account(i, 1000000); // 1,000,000
		}

		/* Print all available ID accounts */
		System.out.println(arrayAcc.length + " ID accounts available");

		Scanner input = new Scanner(System.in);
		String inputPassword = " ";
		int inputID = -1;

		while (true) {
			/* Enter ID and check password */
			do {
				System.out.print("Enter ID account: ");
				inputID = input.nextInt();

				/* Check ID step */
				for (int check = 0; check < arrayAcc.length; check++) {
					if (inputID == arrayAcc[check].getID()) {

						/* ID right --> Enter and check password */
						do {
							System.out.print("Password for id " + inputID + ": ");
							inputPassword = input.next();
							if (!inputPassword.equals(password[check])) {
								System.out.println("Wrong password try again !");
								inputPassword = " ";
							} else
								System.out.println("Successfully login !!!");
						} while (inputPassword == " ");
						break;
					}

					/* Case: Wrong ID */
					if (check == arrayAcc.length - 1 && !(inputID == arrayAcc[check].getID())) {
						System.out.println("Wrong ID. Please try again!");
						inputID = -1;
					}
				}
			} while (inputID == -1);

			/* Interface for user */
			int choice = 0;
			System.out.println("\n Main menu table: ");

			do {
				System.out.println("1. Check Balance\n2. Withdraw\n3. Deposit\n4. Exit");
				System.out.print("Enter: ");
				choice = input.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Current account: " + arrayAcc[inputID].getBalance());
					break;
				case 2:
					double money2 = 0;
					do {
						System.out.print("How much money do you want to withdraw? : ");
						money2 = input.nextDouble();
					} while (!arrayAcc[inputID].withdraw(money2));
					System.out.println("Successfully withdraw. Account left: " + arrayAcc[inputID].getBalance());
					break;
				case 3:
					int idDestination = -1;
					do {
						System.out.print("Which ID account do you want to deposit to? : ");
						idDestination = input.nextInt();
						
						/* Check if destID is user's ID */
						if (idDestination == inputID) {
							System.out.println("This is your ID");
							idDestination = -1;
							continue;
						}
						for (int check = 0; check < arrayAcc.length; check++) {
							if (idDestination == arrayAcc[check].getID()) {
								break;
							}
							
							/* Check if destID exists */
							if (check == arrayAcc.length - 1 && idDestination != arrayAcc[check].getID()) {
								System.out.println("ID destination not found!");
								idDestination = -1;
							}
						}
					} while (idDestination == -1);

					/* Enter the money */
					double money3 = 0;
					do {
						System.out.print("How much money do you want to withdraw? : ");
						money3 = input.nextDouble();
					} while (!arrayAcc[inputID].deposit(money3, arrayAcc[idDestination]));
					System.out.println("Successfully deposit");
					System.out.println("Account left: " + arrayAcc[inputID].getBalance());
					break;
				case 4:
					break;
				default:
					System.out.println("Please enter 1 2 3 or 4...\n");
					break;
				}
			} while (choice != 4);

			input.close();
		}
	}
}
