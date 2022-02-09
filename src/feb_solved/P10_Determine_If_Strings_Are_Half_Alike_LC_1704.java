package feb_solved;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class P10_Determine_If_Strings_Are_Half_Alike_LC_1704 {

/*
	 * LeetCode Link : https://leetcode.com/problems/determine-if-string-halves-are-alike/
	 * LeetCode Problem Number: 1704. Determine if String Halves Are Alike
	 *
	  Problem Statement
	  * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the
	    first half and b be the second half.

        Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
        Notice that s contains uppercase and lowercase letters.
        Return true if a and b are alike. Otherwise, return false.

 */

    /*
       1.
          Input(s) ? String
          Output ? Boolean
         Constraint(s) ? Time Optimized
       2. Test data
          Positive : "book" => true
          Negative : "textbook" => false
          Edge     : "Eatpie" => false
       3.  Approaches Known
          Approach 1 : Counting
       4.  O - Notation
           Approach 1 : Counting
           Time : O(n)
           Space : O(n)
       5.  Pseudocode
     */
    @Test
    public void testData01() { // Positive
        Assert.assertTrue(halvesAreAlike("book"));

    }

    @Test
    public void testData02() { // Negative
        Assert.assertFalse(halvesAreAlike("TextBook"));
    }

    @Test
    public void testData03() { // Edge
        Assert.assertTrue(halvesAreAlike("Eatpie"));
    }

    public boolean halvesAreAlike(String s) {
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('A');
        vowelSet.add('e');
        vowelSet.add('E');
        vowelSet.add('i');
        vowelSet.add('I');
        vowelSet.add('o');
        vowelSet.add('O');
        vowelSet.add('u');
        vowelSet.add('U');
        int first = 0, second = 0;
        int index = 0,incrementer = s.length()/2;
        while(index < s.length()/2){
            if(vowelSet.contains(s.charAt(index))) first++;
            if(vowelSet.contains(s.charAt(index+incrementer))) second++;
            index++;
        }
        return first==second;
    }
}
