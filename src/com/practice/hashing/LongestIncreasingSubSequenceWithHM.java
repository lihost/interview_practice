package com.practice.hashing;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Finding longest increasing subsequence with HashMap implementation
 * 
 * e.g. {5,7,3,99,25,33,55,2,9,1}, size of LIS is 5 with sequence {5,7,25,22,55}
 */
public class LongestIncreasingSubSequenceWithHM {
    
	public static void main(String[] args) {
    	
        int sequenceSize;
        
        Scanner in = new Scanner(System.in);
        sequenceSize = in.nextInt();
        
        HashMap<Integer, Integer> sequenceMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<sequenceSize; i++){
            sequenceMap.put(i, in.nextInt());
        }
        in.close();
        
        HashMap<Integer, Integer> subSequenceMap = new HashMap<Integer, Integer>();

        int lengthOfLIS = 1;

        for(int i=0; i<sequenceSize; i++){
        	subSequenceMap.put(i, 1);
        	for(int j=0; j<i; j++){
        		if((sequenceMap.get(i) > sequenceMap.get(j)) 
        				&& (subSequenceMap.get(j) >= subSequenceMap.get(i))){
        			subSequenceMap.put(i, subSequenceMap.get(j)+1);
        		}
        		lengthOfLIS = (subSequenceMap.get(i) > lengthOfLIS) ? subSequenceMap.get(i) : lengthOfLIS;
        	}
        }

        System.out.println(lengthOfLIS);
    }
}