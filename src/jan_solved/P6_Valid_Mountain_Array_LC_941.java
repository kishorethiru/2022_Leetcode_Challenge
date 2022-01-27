package jan_solved;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class P6_Valid_Mountain_Array_LC_941 {
	
	/*
	 * Leet Code Link : https://leetcode.com/problems/valid-mountain-array/
	 * Leet Code Problem Number : 941. Valid Mountain Array
	  
	  Problem Statement
	   Given an array of integers arr, return true if and only if it is a valid mountain array.

		Recall that arr is a mountain array if and only if:
		
		arr.length >= 3
		There exists some i with 0 < i < arr.length - 1 such that:
		arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
		arr[i] > arr[i + 1] > ... > arr[arr.length - 1]		
	*/

/*
   1. 
  	  Input(s) ? int[], 
      Output ? boolean
	  Constraint(s) ? Time Optimized 
   
   2. Test data
		Positive : plants = [2,1]       => OP false
		Negative : plants = [3,5,5]     => OP false
		Edge     : plants = [0,3,2,1]   => OP true

   3.  Approaches Known 
		 Approach 1 : One Pass, Counting

   4.  O - Notation 
		 Approach 1 : Time O(n), Space O(1)

   5.  Pseudocode		

 */

// Test data(s)
@Test
public void testData01() { // Positive
	int[] input = {1,3,1,0};
	Assert.assertTrue(validMountainArray(input));
}

@Test
public void testData02() { // Negative
	int[] input = {3,5,5};
	Assert.assertFalse(validMountainArray(input));
}

@Test
public void testData03() { // Edge
	int[] input = {9,8,7,6,5,4,3,2,1};
	Assert.assertFalse(validMountainArray(input));
}


/* Pseudocode : Sinlge Pass
 * Create a boolean as isMet and isUp
 * Create temp and assign 0th index value
 * Iterate the input from 1 index 
 *   if the current element is  > than temp
 *    update temp and update isUp as true
 *   else if both temp and current value is same update temp
 * 
 */
private boolean validMountainArray(int[] arr) {
	if (arr.length < 3) return false;
    boolean isMet = false, isUp = false;
    int temp = arr[0];
    for(int i = 1; i < arr.length;i++){
        if(!isMet){
            if(arr[i]>temp) {
                temp = arr[i];
                isUp = true;
            }
            else if(arr[i]==temp) return false;
            else{
                isMet = true;
                temp = arr[i];
            }
        }
        else {
          if(arr[i]<temp) temp = arr[i];
          else if(arr[i]==temp) return false;
          else return false;
        }
    }
    if(!isUp) return false;
    return (!isMet) ? false : true;
}



}
