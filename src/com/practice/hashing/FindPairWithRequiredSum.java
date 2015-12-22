package com.practice.hashing;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two sets A and B, and a number K. Write the algorithm for getting pair(x,y) such that {x+y=k | xEA, yEB}
 *
 */
public class FindPairWithRequiredSum {
	
	public static List<?> getPairWithRequiredSum(Map<Integer, Integer> hMap, int[] arr, int key){
		List<Integer> res = new ArrayList<Integer>();
		
 		for(int j : arr){
			int subKey = (j - key);
			subKey = subKey < 0 ? subKey * -1:subKey;			

			if(hMap.containsKey(subKey)){
				res.add(hMap.get(subKey));
				res.add(j);
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		int[] arr1 = {2,3,4,99,7,6,0,5};
		int[] arr2 = {10, 22, 34, 56, 45, 0, 8};
		int key = 25;
		
		Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		
		for(int k : arr1){
			hMap.put(k, k);
		}
		
		System.out.println("result is: "+getPairWithRequiredSum(hMap, arr2, key).toString());
	}
}
