package feb_solved;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class P8_Longest_Palindrome_LC_405 {
    /*
	 * LeetCode Link : https://leetcode.com/problems/longest-palindrome/
	 * LeetCode Problem Number: 409. Longest Palindrome

	  Problem Statement
	   Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
	   that can be built with those letters.
	   Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
     */

/*
   1.
  	  Input(s) ? String
      Output ? int
	  Constraint(s) ? Time Optimized

   2. Test data
		Positive : s = "abccccdd" => OP 7
		Negative : s = "a" => OP 1
		Edge     : s = "bb" => OP 2
   3.  Approaches Known
		 Approach 1 : One Pass

   4.  O - Notation
		 Approach 1 : Time O(n), Space O(1)

   5.  Pseudocode

 */

    @Test
    public void testData01(){ // Positive
        String s = "abccccdd";
        Assert.assertTrue(longestPalindrome(s) == 7);
    }

    @Test
    public void testData02(){ // Negative
        String s = "a";
        Assert.assertTrue(longestPalindrome(s) == 1);
    }

    @Test
    public void testData03(){ // Edge
        String s = "bb";
        Assert.assertTrue(longestPalindrome(s) == 2);
    }

    /*
     1. Create new hash map and add character and its count to it
     2. Create a int as count  and boolean isOdd as false
     3. Iterate the values of the map
        a) if the current value is even add to count
        b) if its odd and isOdd is false add to count
        c) else if its odd then decrement the current val by -1 and add to count
     4. return count

    Time : O(2n) => O(n)
    Space : O(n)
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c , map.getOrDefault(c, 0)+1);
        int count = 0;
        boolean isOdd = false;
        for(Integer each : map.values()){
            if(each % 2 == 0) count += each;
            else if(!isOdd && each %2 == 1){
                isOdd = true;
                count += each;
            }
            else  count+= (each-1);
        }
        return count;
    }
}
