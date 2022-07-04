package Week_4;

import java.util.*;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;

	public Account() {
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date(System.currentTimeMillis());
	}

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = 0;
		this.dateCreated = new Date(System.currentTimeMillis());
	}

	public void setID(int id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setAnnualInterestRate(double annualInterestRate_percentType) {
		this.annualInterestRate = annualInterestRate_percentType / 100;
	}

	public int getID() {
		return this.id;
	}

	public double getBalance() {
		return this.balance;
	}

	public double getAnnualInterestRate() {
		return this.annualInterestRate;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public double getMonthlyRateInterestRate() {
		return this.annualInterestRate / 12;
	}

	public double getMonthlyInterest() {
		return this.balance * this.getMonthlyInterest();
	}

	public boolean withdraw(double money) {
		if (money > this.balance) {
			System.out.println("Money exceed your current account");
			return false;
		} else {
			this.balance -= money;
			return true;
		}
	}

	public boolean deposit(double money, Account accDestination) {
		// check account
		if (money > this.balance) {
			System.out.println("Money exceed your current account");
			return false;

		} 
		// check if account Destination is customer's own account
		else if (accDestination.getID() == this.id) {
			return false;
		} 
		// deposit after pass conditions
		else {
			this.balance -= money;
			double before = accDestination.balance;
			accDestination.balance += money;

			// check if destination get the right money
			if (accDestination.balance - before == money)
				return true;
			else {
				System.out.println("Technical failed. Contact ... for supporting");
				return false;
			}
		}
	}
}
