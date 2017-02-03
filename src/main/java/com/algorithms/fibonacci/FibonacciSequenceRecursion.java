package com.algorithms.fibonacci;

import java.io.*;

public class 		FibonacciSequenceRecursion {

	public static void main(String[] args) {
		new FibonacciSequenceRecursion();
	}

	public FibonacciSequenceRecursion() {

		System.out.println("\n===FIBONACCI'S SEQUENCE===\n");

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			while (true) {

				System.out.print("Iterations: ");
				String line = br.readLine();
				int iteration = parseString(line);
				long answer = fibSeq(0, 1, iteration - 1);
				System.out.println("Answer: " + answer + "\n");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int parseString(String number) {

		try {
			int n = Integer.parseInt(number);
			return n;
		} catch (Exception e) {
			System.out.println("Error: Invalid Number");
			return 1;
		}

	}

	public long fibSeq(long n1, long n2, int iter) {

		iter--;
		return (iter < 1) ? (n1 + n2) : fibSeq(n2, (n1 + n2), iter);

	}

}
