package com.algorithms.numbers;

/**
 * Simple Java program to reverse a number in Java using loop and operator
 * This program also shows example of using division operator(/) and Remainder Operator(%)
 *
 * Output:
 Please enter number to be reversed using Java program:
 1234
 Reverse of number: 1234 is 4321

 Read more: http://javarevisited.blogspot.com/2012/04/java-program-to-reverse-number-example.html#ixzz4VIIL2ZSu
 *
 */
public class ReverseNumber {

    public static void main(String args[]) {
        //input number to reverse
        int number = 4352;
        int reverse = reverse(number);
        System.out.println("Reverse of number: " + number + " is " + reverse(number));

    }

    /*
     * reverse a number in Java using iteration
     * @return reverse of number
     */
    public static int reverse(int x){
        int reverse = 0;
        int remainder = 0;

        do{
            remainder = x%10;
            reverse = reverse*10 + remainder;
            x = x/10;

        }while(x > 0);

        return reverse;
    }

}