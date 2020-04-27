package com.leetcode.algorithms.recursion.pascalstriangle;


import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/3234/


In the previous approach, we end up making the same recursive calls repeatedly.

For example, to calculate getNum(5, 3) and getNum(5, 4), we end up calling getNum(3, 2) thrice. To generate, the entire fifth row (0-based row indexing), we'd have to call getNum(3, 2) four times.

It makes sense to store the results of intermediate recursive calls for later use.

Algorithm

Simple memoization caches results of deep recursive calls and provides significant savings on runtime.



 */


public class PascalsTriangle_DP {

    public List<Integer> getPascalsRow(int rowIndex) {

        List<Integer> curr,
                prev = new ArrayList<Integer>() {
                            {
                                add(1);
                            }
                        };

        for (int i = 1; i <= rowIndex; i++) {

            curr = new ArrayList<Integer>(i + 1) {
                        {
                            add(1);
                        }
                    };

            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }

            curr.add(1);
            prev = curr;

        }

        return prev;
    }


    /*
    Complexity Analysis

    Time complexity : O(k^2) Same as the previous dynamic programming approach.
    Space complexity : O(k). No extra space is used other than that required to hold the output.

    Although there is no savings in theoretical computational complexity, in practice there are some minor wins:

    - We have one vector/array instead of two. So memory consumption is roughly half.
    - No time wasted in swapping references to vectors for previous and current row.
    - Locality of reference shines through here. Since every read is for consecutive memory locations in the array/vector,
      we get a performance boost.

     */

    private List<Integer> getPascalsRow_memoryEfficient(int rowIndex) {

        List<Integer> row =
                new ArrayList<Integer>(rowIndex + 1) {
                    {
                        add(1);
                    }
                };

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }

        return row;
    }

    public static void main(String[] args) {

        PascalsTriangle_DP pt = new PascalsTriangle_DP();
        System.out.println(pt.getPascalsRow(3));
        System.out.println(pt.getPascalsRow(4));
        System.out.println("--------");
        System.out.println(pt.getPascalsRow_memoryEfficient(3));
        System.out.println(pt.getPascalsRow_memoryEfficient(4));
    }
}



