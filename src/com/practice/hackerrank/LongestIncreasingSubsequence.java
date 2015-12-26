package com.practice.hackerrank;

import java.util.Scanner;

/**
 * Problem statement - https://www.hackerrank.com/challenges/longest-increasing-subsequent
 * 
 * Sample Input - 
 * 5
 * 2
 * 7
 * 4
 * 3
 * 8
 * 
 * Sample Output
 * 3
 *
 */
public class LongestIncreasingSubsequence {
    
   public static int binarySearch(int[] arr, int start, int end, int value){
		int mid;
		while(end - start > 1){
			mid = start + (end - start)/2;
			if(arr[mid] >= value){
				end = mid;
			} else {
				start = mid;
			}
		}

		return end;
		
	}
	
	public static int getLIS(int[] arr){
        int size = arr.length;
        int[] subSequenceArray = new int[size];
        int lengthOfLIS = 1;
        subSequenceArray[0] = arr[0];
        
        for(int i=1; i<size; i++){
            if(arr[i] < subSequenceArray[0]){
            	subSequenceArray[0] = arr[i];
            } else if(arr[i] > subSequenceArray[lengthOfLIS - 1]){
            	subSequenceArray[lengthOfLIS++] = arr[i];
            } else {
            	subSequenceArray[binarySearch(subSequenceArray, -1, lengthOfLIS-1, arr[i])] = arr[i];
            }
            
        }
        return lengthOfLIS;
    }
    
    public static void main(String[] args) {

        int sequenceSize;
        
        Scanner in = new Scanner(System.in);
        sequenceSize = in.nextInt();
        
        int[] sequence = new int[sequenceSize];
        
        for(int i=0; i<sequenceSize; i++){
            sequence[i] = in.nextInt();
        }
        in.close();
        
        int lengthOfLISres = getLIS(sequence);
        
        System.out.println(lengthOfLISres);
                
    }
}