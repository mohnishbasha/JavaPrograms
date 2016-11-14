package com.algorithms.factorial;

//numbers/Factorial.java - Computes factorial
//Fred Swartz - 2003-11-02
import java.math.BigInteger;


public class FactorialBigInteger {
 public static void main(String[] args) {
     
     //-- BigInteger solution.
     BigInteger n = BigInteger.ONE;
     for (int i=1; i<=20; i++) {
         n = n.multiply(BigInteger.valueOf(i));
         System.out.println(i + "! = " + n);
     }
     
     //-- int solution (BAD IDEA BECAUSE ONLY WORKS TO 12).
     int fact = 1;
     for (int i=1; i<=20; i++) {
         fact = fact * i;
         System.out.println(i + "! = " + fact);
     }
 }
}
