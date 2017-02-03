package com.algorithms.strings;

public class StringReversionTailRecursion {

	public String reverse1(String str) {
        if ((null == str) || (str.length()  <= 1)) {
            return str;
        }
        return reverse(str, "");
    }

    private static String reverse(String str, String acc) {
      if (str.length() == 0) {
        return acc;
      } else {
        return reverse(str.substring(1), str.charAt(0) + acc);
      }
    }
    public static void main(String[] args) {
	    String str = "What's going on?";
	    System.out.println(StringReversionTailRecursion.reverse(str, ""));
	  }

}

/*
 * Tail recursion means, the last call in the recursive function is a call to
 * the function and there is nothing left to do when the recursive call returns.
 * Why tail recursion? With tail recursion it’s easy for the compiler to remove
 * the recursion and drop the growing stack. So with an optimized tail recursive
 * function you will not run out of stack space what you otherwise would quite
 * easily.
 */

/*
Update: For comparison the non-tail recursive solution.

        public String reverse(String str) {
            if ((null == str) || (str.length()  <= 1)) {
                return str;
            }
            return reverse(str.substring(1)) + str.charAt(0);
        }
Update 2: The call stack for the recursive solution for “ABC” would be:

-> reverse(”ABC”)
-> reverse(”BC”) + ‘A’
-> (reverse(”C”) + ‘B’) + ‘A’
-> (”C” + ‘B’) + ‘A’
-> “CB” + ‘A’
-> “CBA”

and for the tail recursive version:
-> reverse(”ABC”, “”)
-> reverse(”BC”, “A”)
-> reverse(”C”, “BA”)
-> reverse(”", “CBA”)
-> “CBA”
*/

/*
 * Comparing those two the first one increases the stack to a point until it
 * starts to pop the stack. The tail recursive version does not use the stack to
 * keep a “memory” what it has still to do, but calculates the result imediatly.
 * Comparing the source though, in my view the tail recursive version takes all
 * beauty out of the recursive implementation. It nearly looks iterative.
 */
