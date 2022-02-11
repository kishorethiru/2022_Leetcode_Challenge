package feb_solved;

import org.junit.Test;

import java.util.PriorityQueue;

public class P11_Remove_Stones_To_Minimalize_Total_LC_1962 {

/*
	 * LeetCode Link : https://leetcode.com/problems/remove-stones-to-minimize-the-total/
	 * LeetCode Problem Number: 1962. Remove Stones to Minimize the Total
	 *
	  Problem Statement
	  *
        You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile,
        and an integer k. You should apply the following operation exactly k times:

        Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
        Notice that you can apply the operation on the same pile more than once.

        Return the minimum possible total number of stones remaining after applying the k operations.

        floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).

      */

    /*
       1.
          Input(s) ? int[], int
          Output ? int
         Constraint(s) ? Time Optimized
       2. Test data
          Positive :piles = [5,4,9], k = 2 =>  12
          Edge     : [4,3,6,7], k = 3
       3.  Approaches Known
          Approach 1 : Priority Queues
       4.  O - Notation
          Approach 1 : Priority Queues - Time - O(nlog n) Space - O(nlog n)
       5.  Pseudocode
     */
    @Test
    public void testData01() { // Positive
        int[] piles = {5,4,9};
        int k = 2;

    }

    @Test
    public void testData02() { // Negative
        int[] piles = {5,4,9};
        int k = 2;
    }

    @Test
    public void testData03() { // Edge
        int[] piles = {4,3,6,7};
        int k = 3;
    }

    /*
      1. Create a new PQ and add geh values to it.
      2. Iterate k time
         Poll the max number and subtract the floor/2 value of the polled one
         Push to PQ
      3. Iterate PQ and add values to the variable
      4. Return the variable

      Time - O(n log n)
      Space - O(n log n)

     */
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b.compareTo(a));
        for(int i : piles) pq.offer(i);
        while(k-->0){
            int polled = pq.poll();
            pq.offer(polled-(int) Math.floor(polled/2));
        }
        int toReturn = 0;
        while(!pq.isEmpty()){
            toReturn += pq.poll();
        }
        return toReturn;
    }
}
