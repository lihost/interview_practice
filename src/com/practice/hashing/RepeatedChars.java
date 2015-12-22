package com.practice.hashing;

/**
 * Find first repeating character in a string
 * 
 */
public class RepeatedChars {
	
	public static char findRepeatingChar(String str){
		int len = str.length();
		int[] count = new int[256];
		char c=0;
		
		for(int i=0; i<len; i++){
			if(count[str.charAt(i)] == 1){
				c = str.charAt(i);
				break;
			} else {
				count[str.charAt(i)]++;
			}
		}
 		return c;
	}
	
	public static void main(String[] args){
		String str = "binaryarithmatic";
		
		char repeatingChar = findRepeatingChar(str);
		System.out.println("First repeating char is: "+repeatingChar);
		
	}

}
