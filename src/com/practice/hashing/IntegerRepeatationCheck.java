package com.practice.hashing;

import java.util.HashMap;
import java.util.Map;
/**
 * I have an integer array where every number appears even number of times and only one appears odd times. 
 * Find the number. 
 */
public class IntegerRepeatationCheck {
	
	public static int findOddlyRepeatedNumber(int[] inputArr){
		int len = inputArr.length;
		Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		int count = 1;
		int result = 0;
		
		for(int i=0; i<len; i++){
			if(hMap.get(inputArr[i]) == null){
				hMap.put(inputArr[i], count);
			} else {
				int currentValue = hMap.get(inputArr[i]);
				hMap.put(inputArr[i], ++currentValue);
			}
		}
		
		for(Integer key: hMap.keySet()){
			if(hMap.get(key)%2 != 0){
				result = key;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		/**
		 * for accepting set of integer as System.in
		 * 
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter integer values separated by space");
		String str = sc.nextLine();
		sc.close();
		
		String[] split = str.split("\\s+");
		int[] inputArr = new int[split.length];
		
		for(int i=0; i<split.length; i++){
			inputArr[i] = Integer.parseInt(split[i]);
		}
		  		
		System.out.println("Array is:"+Arrays.toString(inputArr));
		
		**/
		
		int[] inputArr = {2, 3, 55, 3, 21, 34, 3, 2, 34, 55, 21};
		
		System.out.println("Odd time repeating number is: "+findOddlyRepeatedNumber(inputArr));
	}

}
