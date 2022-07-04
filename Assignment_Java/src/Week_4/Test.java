package Week_4;

import java.util.*;

public class Test {
	public static void test(String[] args) {

		/** 
		 * Test Fan Class 
		 * */
		
//		Fan fan1 = new Fan();
//		Fan fan2 = new Fan();
//
//		fan1.setSpeed(Fan.FAST);
////		fan1.setSpeed(5);
//		fan1.setRadius(10);
//		fan1.setColor("yellow");
//		fan1.setOn(true);
//
//		fan2.setSpeed(Fan.MEDIUM);
//
//		System.out.println(fan1.toString());
//		System.out.println(fan2.toString());

		
		/**
		 *  Test MyInteger Class 
		 * */
		
//		MyInteger myInt1 = new MyInteger(3);
//		MyInteger myInt2 = new MyInteger(6);
//
//		// Test check if Even Odd Prime
//		// Check itself
//		System.out.println(myInt1.isEven());
//		System.out.println(myInt1.isOdd());
//		System.out.println(myInt1.isPrime());
//
//		// Check any integer number
//		System.out.println(MyInteger.isEven(13));
//		System.out.println(MyInteger.isOdd(13));
//		System.out.println(MyInteger.isPrime(13));
//
//		// Check other MyInteger
//		System.out.println(MyInteger.isEven(myInt2));
//		System.out.println(MyInteger.isOdd(myInt2));
//		System.out.println(MyInteger.isPrime(myInt2));
//
//		// Test if equals
//		myInt1.equals(3);
//		myInt1.equals(myInt2);
//
//		// Convert numeric char[], string to integer
//		char[] number = { '1', '2', '3', '4' };
//		char[] number1 = { '-', '1', '2', '3', '4' };
//
//		System.out.println(MyInteger.parseInt(number));
//		System.out.println(MyInteger.parseInt(number1));
//
//		String numberStr = "12043";
//		String numberStr1 = "-12043";
//
//		System.out.println(MyInteger.parseInt(numberStr));
//		System.out.println(MyInteger.parseInt(numberStr1));

		
		/**
		 * ATM check
		 * */
		
		Account acc1 = new Account(1012, 20000000);
		Account acc2 = new Account();
		acc1.setAnnualInterestRate(4.5);

		// Test withdraw
		System.out.println("Current account: " + acc1.getBalance());
		if(acc1.withdraw(1500000)) {
			System.out.println("Sucessfully!");
			System.out.println("After withdraw 1.500.000 account left: " + acc1.getBalance());
		}
		
		// Test deposit
		System.out.println("\nAccount acc2: " + acc2.getBalance());
		if(acc1.deposit(3000000, acc2)) {
			System.out.println("Deposit successfully!");
			System.out.println("After be deposited by acc1: " + acc2.getBalance());
		}
		
		// Test information check
		System.out.println("Acc1 information: ");
		System.out.println("ID: " + acc1.getID() + "\nBalance: " + acc1.getBalance() + "\nAnnual Interest Rate: "
				+ acc1.getAnnualInterestRate() * 100 + "%" + "\nCreated Date: " + acc1.getDateCreated().toString());
	}
}
