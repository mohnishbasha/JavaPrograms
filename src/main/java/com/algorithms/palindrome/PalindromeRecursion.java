package org.algorithms;
public class PalindromeRecursion
{
    public PalindromeRecursion()
        {
        }
        public boolean isPalindrome(String s)
        {
                if (s.length() <= 1)
                        return true;    // Base case
                else
                {
                        if (s.charAt(0) == s.charAt(s.length() - 1))
                                return isPalindrome(s.substring(1, s.length() - 1 ) );
                        else
                                return false;
                }
        } // isPalindrome()
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
} // 