package Week_4;

public class MyInteger {
	private int value;

	public MyInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isOdd() {
		if (this.value % 2 != 0)
			return true;
		else
			return false;
	}

	public boolean isEven() {
		if (this.value % 2 == 0)
			return true;
		else
			return false;
	}

	public boolean isPrime() {
		if (this.value <= 1)
			return false;

		for (int i = 2; i < this.value; i++)
			if (this.value % i == 0)
				return false;

		return true;
	}

	public static boolean isOdd(int value) {
		if (value % 2 != 0)
			return true;
		else
			return false;
	}

	public static boolean isEven(int value) {
		if (value % 2 == 0)
			return true;
		else
			return false;
	}

	public static boolean isPrime(int value) {
		if (value <= 1)
			return false;

		for (int i = 2; i < value; i++)
			if (value % i == 0)
				return false;

		return true;
	}

	public static boolean isOdd(MyInteger myInt) {
		if (myInt.getValue() % 2 != 0)
			return true;
		else
			return false;
	}

	public static boolean isEven(MyInteger myInt) {
		if (myInt.getValue() % 2 == 0)
			return true;
		else
			return false;
	}

	public static boolean isPrime(MyInteger myInt) {
		if (myInt.getValue() <= 1)
			return false;

		for (int i = 2; i < myInt.getValue(); i++)
			if (myInt.getValue() % i == 0)
				return false;

		return true;
	}

	public boolean equals(int compareVal) {
		if (this.value == compareVal)
			return true;
		else
			return false;
	}

	public boolean equals(MyInteger myInt) {
		if (this.value == myInt.getValue())
			return true;
		else
			return false;
	}

	public static int parseInt(char[] numericString) {
		int destination = 0;
		if (numericString[0] == '-') {
			for (int i = 1; i < numericString.length; i++) {
				destination -= Character.getNumericValue(numericString[i]) * Math.pow(10, numericString.length - i - 1);
			}
		} else {
			for (int i = 0; i < numericString.length; i++) {
				destination += Character.getNumericValue(numericString[i]) * Math.pow(10, numericString.length - i - 1);
			}
		}
		return destination;
	}

	public static int parseInt(String numericString) {
		int destination = 0;
		char[] number = numericString.toCharArray();
		destination = MyInteger.parseInt(number);
		return destination;
	}

}
