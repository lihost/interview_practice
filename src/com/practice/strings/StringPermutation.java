package com.practice.strings;
/**
 * Get all permutation of a string
 *
 */
public class StringPermutation {
	
	public static void getPermutation(String pre, String str){
		int len = str.length();
		if(len > 0){
			for(int i=0; i<len; i++){
				getPermutation(pre+str.charAt(i), str.substring(0, i)+str.substring(i+1, len));
			}
		}
		System.out.println(pre);
	}
	public static void main(String[] args){
		getPermutation("", "india");
	}
	
}

