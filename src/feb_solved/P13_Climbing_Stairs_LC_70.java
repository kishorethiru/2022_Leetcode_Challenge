package feb_solved;

import org.junit.Assert;
import org.junit.Test;

public class P13_Climbing_Stairs_LC_70 {

/*
	 * LeetCode Link : https://leetcode.com/problems/climbing-stairs/
	 * LeetCode Problem Number: 70. Climbing Stairs
	 *
	  Problem Statement
	  * You are climbing a staircase. It takes n steps to reach the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	   
     */

    /*
       1.
          Input(s) ? int
          Output ? int
         Constraint(s) ? Time Optimized
       2. Test data
          Positive : input 2 output 2
          Negative : input 1 output 1
          Edge     : input 10 output 89
       3.  Approaches Known
          Approach 1 : Bottom Up Technique
       4.  O - Notation
           Approach 1 : Bottom Up Technique Time : O(n)
       5.  Pseudocode
     */
    @Test
    public void testData01() { // Positive
        Assert.assertTrue(climbStairs(2)==2);
    }

    @Test
    public void testData02() { // Negative
        Assert.assertTrue(climbStairs(1)==1);
    }

    @Test
    public void testData03() { // Edge
        Assert.assertTrue(climbStairs(10)==89);
    }

    /*
     1. If n < 3, return n
     2. Create new array of length n+1
     3. Iterate from index 3 and iterate till last
            For the current index enter the value of current index -1 and -2
      4. Return the last index value

      Time : O(n)
      Space : O(n)

     */
    private int climbStairs(int n) {
        if(n < 3) return n;
        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i <=n; i++){
            memo[i] = memo[i-1]+memo[i-2];
        }
        return memo[n];

    }
}
