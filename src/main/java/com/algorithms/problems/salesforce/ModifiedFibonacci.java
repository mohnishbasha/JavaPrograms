package com.algorithms.problems.salesforce;

/**
 * https://www.careercup.com/question?id=88742
 *
 *
 *  Question:
 *      what every one knows is one Fibonacci series which adds the previous 2 numbers i.e fib(n) = fib(n-1)+ fib(n-2).
 *      but there many Fibonacci series which adds the previous 2 numbers, previous 3 numbers and so on. so write a
 *      function fib(n,k) which gives you first n numbers of a Fibonacci series and k is the number of previous numbers
 *      you have to add ex. for fib(n,3) you have to add fib(n-1)+ fib(n-2)+ fib(n-3).
 *
 */

public class ModifiedFibonacci{
    public static void main(String[] args) {
        int n = 10;
        int k = 3;
        int [] array = new int[n];
        fibonacci(n-1,k,array);

        System.out.println("dss");
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    private static int fibonacci(int n, int k,int[] array){
        if(n <= 0)
            return 0;
        if(n == 1){
            array[1] = 1;
            return 1;
        }
		/*if(n == 2)
			return 1;
    	*/

        if(array[n]> 0){
            return array[n];
        }
        int sum =0;
        for(int i =k;i>=1;i--){
            sum += fibonacci(n-i, k, array);//+ fibonacci(n-1, k, array);// +fibonacci(n-3, k, array);
        }
        array[n]= sum;
        return array[n];
    }

}