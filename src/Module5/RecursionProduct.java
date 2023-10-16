package Module5;

import java.util.Scanner;

public class RecursionProduct {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("The product of your five numbers is " + product(1d, 5));
	}
	
	static Double product(Double total, int timesLeft) {
		if(timesLeft == 0) {
			return total;
		} 
		System.out.print("Enter a number: ");
		Double multiplier = scanner.nextDouble();
		return product(total * multiplier, timesLeft - 1);
	}

}
