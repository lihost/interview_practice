package com.practice.arrays;

/**
 * Kadane's Algorithm - https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane.27s_algorithm
 * 
 * Maximum subarray problem is the task of finding the contiguous subarray 
 * within a one-dimensional array of numbers which has the largest sum
 * 
 * e.g. Array {-2, 1, -3, 4, -1, 2, 1, -5, 4} the contiguous subarray 
 * with the largest sum is 4, -1, 2, 1 with sum 6.
 * 
 * @author sohil
 *
 */
public class MaximumSubArray {
	
	public static int maxSubArray(int[] arr) {
		int maxEndingHere = 0;
		int maxSoFar = 0;
		
		for(int i: arr)	{
			maxEndingHere = Integer.max(0, maxEndingHere+i);
			maxSoFar = Integer.max(maxSoFar, maxEndingHere);
		}
		
		return maxSoFar;
	}
	
	public static void main(String[] args) {
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		System.out.println(maxSubArray(arr));
	}
}
