package feb_solved;

import org.junit.Assert;
import org.junit.Test;

public class P12_House_Robber_LC_198 {

/*
	 * LeetCode Link : https://leetcode.com/problems/house-robber/
	 * LeetCode Problem Number: 198. House Robber
	 *
	  Problem Statement
	  * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
	  *  the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
	  *  it will automatically contact the police if two adjacent houses were broken into on the same night.

         Given an integer array nums representing the amount of money of each house, return the maximum amount of money
         * you can rob tonight without alerting the police.
	   
     */

    /*
       1.
          Input(s) ? int[]
          Output ? int
          Constraint(s) ? Time Optimized
       2. Test data
            Positive : Input: nums = [1,2,3,1] Output: 4
            Negative : Input: nums = [0] Output: 0
            Edge     : Input: nums = [2,7,9,3,1] Output: 12
       3.  Approaches Known
            Approach 1 : DP Bottom Up Tabulation
            Approach 2 : DP Top Bottom Memoization
       4.  O - Notation
             Approach 1 : Approach 1 : DP Bottom Up Tabulation Time : O(n), Space : O(n)
             Approach 2 : DP Top Bottom Memoization Time : O(n) Space : O(n)
       5.  Pseudocode
     */
    @Test
    public void testData01() { // Positive
        int[] nums = {1,2,3,1};
        Assert.assertTrue(rob(nums)==4);


    }

    @Test
    public void testData02() { // Negative
        int[] nums = {0};
        Assert.assertTrue(rob(nums)==0);
    }

    @Test
    public void testData03() { // Edge
        int[] nums = {2,7,9,3,1};
        Assert.assertTrue(rob(nums)==12);

    }

    /* Pseudocode
       1. If the input length is 1 return 0 index value
       2. Create new array of length n, and add 0 index value of input and max of 0 and 1 index.
       3. Iterate from 2 index till input length
          a) For the current index find the max between current index -1 input value and current index - 2 + current index value
             and save it in the current index of created array
       4. return the last index value of created array
          Time : O(n)
          Space : O(n)

     */
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
