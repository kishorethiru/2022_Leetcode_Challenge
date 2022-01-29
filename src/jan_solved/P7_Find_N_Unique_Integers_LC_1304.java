package jan_solved;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
public class P7_Find_N_Unique_Integers_LC_1304 {
	/*
	 * LeetCode Link : https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
	 * LeetCode Problem Number : 1304. Find N Unique Integers Sum up to Zero
	  
	  Problem Statement
	   Given an integer n, return any array containing n unique integers such that they add up to 0.

/*
   1. 
  	  Input(s) ? int
      Output ? int[]
	  Constraint(s) ? Time Optimized 
   
   2. Test data
		Positive : n = 5 => OP [1,-1,2,-2,0]
		Negative : n = 1 => OP [0]
		Edge     : n = 3 => OP [1,-1,0]

   3.  Approaches Known 
		 Approach 1 : One Pass

   4.  O - Notation 
		 Approach 1 : Time O(n), Space O(1)

   5.  Pseudocode		

 */

// Test data(s)
@Test
public void testData01() { // Positive
	Assert.assertTrue(Arrays.equals(sumZero(3), new int[] {1,-1,0}));
}

@Test
public void testData02() { // Negative
	Assert.assertTrue(Arrays.equals(sumZero(0), new int[] {}));
}

@Test
public void testData03() { // Edge
	Assert.assertTrue(Arrays.equals(sumZero(4), new int[] {1,-1,2,-2}));
}


/* Pseudocode : Single Pass
 * Create a array of size n 
 * Create temp and index variable
 * Create valToAdd and a break variable to break
 * Iterate till temp is > than break variable
 *   Add the valToAdd at the index and increment index
 *   Negate valToAdd and add to index and increment index and valToAdd
 *   Increment temp by 2
 * if the n is add for the last val add 0 to the index
 * return retVal
 * 
 * Time : O(n/2)
 * Space : O(n).
 */

	
	public int[] sumZero(int n) {
		int[] retVal = new int[n];
        int temp = n, index = 0;
        int valToAdd = 1;
        int toBreak = (n%2 == 1) ? 1 : 0;
        while(temp > toBreak){
            retVal[index++] = valToAdd;
            retVal[index++] = -1 * (valToAdd++);
            temp = temp-2;
        }
        if(toBreak==1)retVal[index] = 0;
        return retVal;
    }
}
