package com.algorithms.palindrome;

public class Palindrome {
	private String pal;

	public Palindrome(String initPal) {
		pal = initPal.toUpperCase();
	}

	public boolean isPalindrome() {

		if (pal.length() <= 1) {
			// String has only one character so it
			// is a Palindrome by definition.
			return true; // BASE CASE.
		}

		// Get the first and last characters of the String.
		char first = pal.charAt(0);
		char last = pal.charAt(pal.length() - 1);

		if (Character.isLetter(first) && Character.isLetter(last)) {
			// The first and last characters are both letters..

			if (first != last) {
				// The first and last letters are different
				// so the string is not a Palindrome.
				return false; // BASE CASE.
			} else {
				// The first and last characters are both letters,
				// and they are both the same. So, the string is
				// a palindrome if the substring created by dropping
				// the first and last characters is a palindrome.
				Palindrome sub = new Palindrome(pal.substring(1,
						pal.length() - 1));
				return sub.isPalindrome(); // RECURSIVE CASE.
			}
		} else if (!Character.isLetter(first)) {
			// The first character in the string is not a letter.
			// So the string is a palindrome if the substring created
			// by dropping the first character is a palindrome.
			Palindrome sub = new Palindrome(pal.substring(1));
			return sub.isPalindrome(); // RECURSIVE CASE.
		} else {
			// The last character in the string is not a letter.
			// So the string is a palindrome if the substring created
			// by dropping the last character is a palindrome.
			Palindrome sub = new Palindrome(pal.substring(0, pal.length() - 1));
			return sub.isPalindrome(); // RECURSIVE CASE.
		}
	}

	public static void main(String[] args) {
		Palindrome p1 = new Palindrome("Madam, I'm Adam.");
		System.out.println(p1.isPalindrome());
		Palindrome p2 = new Palindrome("Nope!");
		System.out.println(p2.isPalindrome());
		Palindrome p3 = new Palindrome("dad");
		System.out.println(p3.isPalindrome());
		Palindrome p4 = new Palindrome("Go hang a salami, I'm a lasagna hog.");
		System.out.println(p4.isPalindrome());
	}
}
