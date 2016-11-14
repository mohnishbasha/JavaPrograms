package org.algorithms;

class PrimeNumberRecursion {
	private int count = 2;
	private boolean isPrime = true;

	public static void main(String[] args) {
		// int n = Integer.parseInt(args[0]);
		int n = 1000;
		for (int i = 1; i < 1000; i++) {
			// System.out.println("\nThe number is prime = " + (new
			// PrimeNumberRecursion().is_prime(i, i/2)));
			if(new PrimeNumberRecursion().is_prime(i, i / 2))
			System.out.println("\nThe number "+ i + "is prime = "  
					+ (new PrimeNumberRecursion().is_prime(i, i / 2)));
		}
	}

	private boolean is_prime(int n, int i) {

		if (count >= i) // just check till half the val of the num and return
						// isPrime
		{
			return isPrime;
		}

		if (n % count != 0) // divisibility check
		{
			++count; // incr till its same val as i and stop checking
			is_prime(n, i);

		} else {
			isPrime = false;
		}

		return isPrime;
	}
}
