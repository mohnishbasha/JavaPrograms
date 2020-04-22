package com.leetcode.algorithms.generateparanthesis;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/articles/generate-parentheses/

Approach 2: Backtracking
Intuition and Algorithm

Instead of adding '(' or ')' every time as in Approach 1, let's only add them when we know it will remain a valid sequence. We can do this by keeping track of the number of opening and closing brackets we have placed so far.

We can start an opening bracket if we still have one (of n) left to place. And we can start a closing bracket if it would not exceed the number of opening brackets.


Complexity Analysis

Our complexity analysis rests on understanding how many elements there are in generateParenthesis(n). This analysis is outside the scope of this article, but it turns out this is the n-th Catalan number \dfrac{1}{n+1}\binom{2n}{n}
n+1
1
​
 (
n
2n
​
 ), which is bounded asymptotically by \dfrac{4^n}{n\sqrt{n}}
n
n
​

4
n

​
 .

Time Complexity : O(\dfrac{4^n}{\sqrt{n}})O(
n
​

4
n

​
 ). Each valid sequence has at most n steps during the backtracking procedure.

Space Complexity : O(\dfrac{4^n}{\sqrt{n}})O(
n
​

4
n

​
 ), as described above, and using O(n)O(n) space to store the sequence.

 */
public class LC_BackTracking_GenerateParanthesis {

    public List<String> printParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int n){
        if (cur.length() == n * 2) {
            ans.add(cur);
            return;
        }

        if (open < n)
            backtrack(ans, cur+"(", open+1, close, n);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, n);
    }

    public static void main(String args[]) {
        LC_BackTracking_GenerateParanthesis gp = new LC_BackTracking_GenerateParanthesis();
        System.out.println( gp.printParenthesis(4));
    }

}
