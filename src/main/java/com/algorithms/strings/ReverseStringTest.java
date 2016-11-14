package org.algorithms.strings;

public class ReverseStringTest {
	  public static void main(String[] args) {
	    String str = "What's going on?";
	    System.out.println(ReverseString.reverseIt(str));
	  }
	}

	class ReverseString {
	  public static String reverseIt(String source) {
	    int i, len = source.length();
	    StringBuffer dest = new StringBuffer(len);

	    for (i = (len - 1); i >= 0; i--)
	      dest.append(source.charAt(i));
	    return dest.toString();
	  }
	}

