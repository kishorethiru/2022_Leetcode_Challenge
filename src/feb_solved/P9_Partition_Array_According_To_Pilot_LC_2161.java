package feb_solved;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class P9_Partition_Array_According_To_Pilot_LC_2161 {
    /*
	 * LeetCode Link : https://leetcode.com/problems/partition-array-according-to-given-pivot/
	 * LeetCode Problem Number: 2161. Partition Array According to Given Pivot
	 *
	  Problem Statement
	   You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:

        Every element less than pivot appears before every element greater than pivot.
        Every element equal to pivot appears in between the elements less than and greater than pivot.
        The relative order of the elements less than pivot and the elements greater than pivot is maintained.
        More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element.
        For elements less than pivot, if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj. Similarly for elements greater than pivot,
        *  if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.
        Return nums after the rearrangement.


     */

/*
   1.
  	  Input(s) ? int[], int
      Output ? int[]
	  Constraint(s) ? Time Optimized

   2. Test data
		Positive : nums = [9,12,5,10,14,3,10], pivot = 10 => [9,5,3,10,10,12,14]
		Negative : nums = [1], pivot = 2 => [2]
		Edge     : nums = [-3,4,3,2], pivot = 2 => [-3,2,4,3]
   3.  Approaches Known
		 Approach 1 : Two Pass

   4.  O - Notation
		 Approach 1 : Time O(n), Space O(1)

   5.  Pseudocode

 */

    @Test
    public void testData01(){ // Positive
        Assert.assertTrue(Arrays.equals(pivotArray(new int[]{9,12,5,10,14,3,10}, 10), new int[]{9,5,3,10,10,12,14}));
    }

    @Test
    public void testData02(){ // Negative
        Assert.assertTrue(Arrays.equals(pivotArray(new int[]{1}, 2), new int[]{1}));
    }

    @Test
    public void testData03(){ // Edge
        Assert.assertTrue(Arrays.equals(pivotArray(new int[]{-3,4,3,2}, 2), new int[]{-3,2,4,3}));
    }

    /*
     1. Create a new return array of length nums
     2. Create a variable as pivotCount as 0 and index as 0
     3. Iterarte the input nums
        a) if the current number is less than pivot add to return array and increment index
        b) if the current number is equal to pivot increment pivotCount
     4. Untill pivotCount becomes zero push the value to the retArray
     5. Iterate the input and push the number that are > pivot
     6. return retArr

    Time : O(2n) => O(n)
    Space : O(n)
     */
    public int[] pivotArray(int[]  nums, int pivot) {
        int[] retArr = new int[nums.length];
        int pivotCount = 0, index = 0;
        for(int i : nums){
            if(i < pivot) retArr[index++] = i;
            if(i == pivot) pivotCount++;
        }
        while(pivotCount-- > 0) retArr[index++] = pivot;
        for(int i : nums) if(i > pivot) retArr[index++] = i;
        return retArr;
    }
}
