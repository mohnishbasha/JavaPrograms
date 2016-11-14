package org.algorithms.strings;

public class StringReverseRecursion {

	public static String reverse(String str) {
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}
	
	public static void reverseVersion2(String s){
		/* this version doesnt work */
		if (s.length() == 1){
			System.out.print(s);
		}
		else{
			reverseVersion2(s.substring(1, s.length()));  
			System.out.print(s.substring(0,1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}


	public static void reverseN() {

		String input = "Be in present";
		char[] temparray= input.toCharArray();

		int left,right=0;
		right=temparray.length-1;

		for (left=0; left < right ; left++ ,right--)
		{
			// Swap values of left and right
			char temp = temparray[left];
			temparray[left] = temparray[right];
			temparray[right]=temp;
		}

		for (char c : temparray)
			System.out.print(c);
	}

	public static void main(String[] args) {
		String str = "What's going on?";
		System.out.println(StringReverseRecursion.reverse(str));
		StringReverseRecursion.reverseVersion2(str);
	}

}
