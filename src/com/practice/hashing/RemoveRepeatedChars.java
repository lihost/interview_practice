package com.practice.hashing;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Algorithm for removing repeated characters from String
 *
 */
public class RemoveRepeatedChars {
	
	/**
	 * LinkedHashMap implementation
	 */
	public static void findRepeatingCharThroughHashMap(String str){
		int len = str.length();
		Map<Character, Integer> noDuplicate = new LinkedHashMap<Character, Integer>();		

		for(int i=0; i<len; i++){
			if(noDuplicate.get(str.charAt(i))==null){
				noDuplicate.put(str.charAt(i), 1);
			}
		}
		System.out.println("no Duplicate: "+noDuplicate.toString());
	}
	
	
	/**
	 * LinkedHashSet implementation - Since set doesn't accept duplicate
	 * O(T) = O(n) or O(1)
	 */
	public static void findRepeatingChar(String str){
		int len = str.length();
		Set<Character> noDuplicate = new LinkedHashSet<Character>();		

		for(int i=0; i<len; i++){
			noDuplicate.add(str.charAt(i));
		}
		System.out.println("no Duplicate: "+noDuplicate.toString());
	}
	
	public static void main(String[] args){
		String str = "isthisacodesmell";
		
		findRepeatingChar(str);
		findRepeatingCharThroughHashMap(str);
		
	}

}
