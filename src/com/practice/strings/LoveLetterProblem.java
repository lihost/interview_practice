package com.practice.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Love Letter Problem - A love letter to be written in code words and all those
 * words would be taken from number of newspapers.
 * 
 * Problem states, there is a string L which has been prepared from String N(newspaper),
 * write a method to check if characters in L matches to that of N including count.
 * 
 * @author Sohil
 *
 */
public class LoveLetterProblem {
	
	public static Boolean isRepresentable(String L, String N) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		int count = 0;
		
		for(char c : L.toCharArray()) {
			if(charMap.containsKey(c)) {
				charMap.put(c, charMap.get(c)+1);
			}
			charMap.put(c, count+1);
		}
		
		
		for(char m : N.toCharArray()) {
			if(charMap.containsKey(m) && !charMap.isEmpty()) {
				int rcount = charMap.get(m);
				
				if(rcount-1==0) {
					charMap.remove(m);
				} else {
					charMap.put(m, rcount-1);
				}
				
				
			}
			
		}
				
		if(charMap.isEmpty()){
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		System.out.println(isRepresentable("game of thrones", "a foremen ghost has been seen nearby river."));
	}
}
