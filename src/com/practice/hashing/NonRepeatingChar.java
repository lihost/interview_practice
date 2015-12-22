package com.practice.hashing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Find first non-repeating character in a string with O(n^2) and O(n) complexity
 *
 */
public class NonRepeatingChar {
	/**
	 * O(n^2)
	 *  
 	 * @param str
	 * @return
	 */
	public static char findNonRepeatingChar(String str){
		int len = str.length();
		int repeated=0;
		char c=0;
		
		for(int i=0; i<len; i++){
			repeated=0;
			for(int j=0; j<len; j++){
				if(i!=j && str.charAt(i) == str.charAt(j)){
					repeated=1;
					break;
				}
			}
			if(repeated==0){
				return str.charAt(i);
			}
		}
		return c;
		
	}
	
	/**
	 * HashMap implementation with - O(n) complexity
	 * @param str
	 * @return
	 */
	public static char findNonRepeatingCharThroughHashMap(String str){
		int len = str.length();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		int c=1;
		char ch=0;
		
		for(int i=0; i<len;i++){
			if(map.get(str.charAt(i)) == null){
				map.put(str.charAt(i), c);
			} else {
				int count = map.get(str.charAt(i)).intValue();
				map.put(str.charAt(i), ++count);
			}
		}
		int j=0;
		for(j=0; j<len; j++){
			if(map.get(str.charAt(j)) == 1){
				ch = str.charAt(j);
				break;
			}
		}
		if(j==len) return '0';
		
		return ch;
	}
	
	
	public static void main(String[] args){
		String str = "is this a codesmell"; // A string to test
		
		System.out.println("First non repeating char - without HashMap: "+findNonRepeatingChar(str));
		System.out.println("First non repeating char - with HashMap: "+findNonRepeatingCharThroughHashMap(str));
	}

}
