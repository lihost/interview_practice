/**
 * Generate string as A, B , C, D, E... Z, AA, AB...AZ... BA, BB,......
 * 
 * e.g. Excel sheet tabs
 * 
 * Optimized iteration with more corner cases attended
 */

package com.practice.strings;

import java.util.HashMap; 
import java.util.Map;

public class GenerateExcelSheetString {
	

		public static HashMap<Integer, StringBuilder> letterCode = new HashMap<Integer, StringBuilder>(); 

		static { 
			for (int i = 1; i < 26; i++) { 
				letterCode.put(i, new StringBuilder(Character.toString((char) (i + 96)))); 				
			} 
			letterCode.put(0, new StringBuilder(Character.toString((char) (26 + 96)))); 
		} 


		private static StringBuilder getTheStringAtKthPosition(int i) { 
			int lastIndex = i%26; 
			int step = (i-1)/26; 

			if(step==0) 
			{ 
				return new StringBuilder(letterCode.get(lastIndex)); 
			} 
	
			else 
			{ 
				return getTheStringAtKthPosition(step).append(letterCode.get(lastIndex)); 
	
			} 

		} 


		public static void main(String[] args) { 
			
			/**
			 * This loop will start with 'a' and lead till 'aac'
			 */
			for(int index=0;index<=705;index++) 
			{ 
				System.out.println(index+" "+getTheStringAtKthPosition(index)); 
			} 

		} 
}

