package com.practice.hackerearth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Amazon Online Test
 * 
 * Telephone Keypad dialer problem
 * 
 *  - Need to take input from Screen and then print equivalent number formats in descending order.
 *    If any two numbers are same then we need to print numbers in alphabetical order of their string values.
 *    
 *    e.g. 
 *    Input -  
 *    3
 *    amazon
 *    mon
 *    omn
 *    
 *    Output - 
 *    262966 amazon
 *    666 mon
 *    666 omn
 *    
 *    Here first number in input defines number of strings to be accepted as input. Strings "mon" and "omn" have
 *    same equivalent numbers we need to sort output in alphabetical format.
 *    
 *    
 *    
 * @author Sohil
 *
 *
 */

public class SimilarDigits {

	Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	
	/**
	 * bootstrapping telephone keypad character list
	 */
	public SimilarDigits(){
		this.addKeyValue(2, "abc");
		this.addKeyValue(3, "def");
		this.addKeyValue(4, "ghi");
		this.addKeyValue(5, "jkl");
		this.addKeyValue(6, "mno");
		this.addKeyValue(7, "pqrs");
		this.addKeyValue(8, "tuv");
		this.addKeyValue(9, "wxyz");
	}
	
	public SimilarDigits addKeyValue(Integer val, String str) {
		for(Character c: str.toCharArray()){
			this.charMap.put(c, val);
		}
		
		return this;
	}
	
	public Integer getKey(Character c) {
		return this.charMap.get(c);
	}
	
	
	/**
	 * This method accepts string array and prints out required number-string format
	 * @param strArr
	 */
	public void similarDigits(String[] strArr) {
		
		/**
		 * Map to take care of adding keys(number) in decreasing order with relevant list of Strings
		 */
		Map<Integer, ArrayList<String>> map = new TreeMap<Integer, ArrayList<String>>(Collections.reverseOrder());
		
		for(int i=0; i<strArr.length; i++){
			StringBuilder sb = new StringBuilder();

			char[] cArr = strArr[i].toCharArray();
			
			for(int j=0; j<cArr.length; j++){
				sb.append(this.charMap.get(cArr[j]));
			}
			

			Integer key = Integer.parseInt(sb.toString().trim());

			ArrayList<String> valueList;
			
			//checking if list is present in map
			if(map.get(key) == null) {
				valueList = new ArrayList<String>();
			} else {
				valueList = map.get(key);
			}
			
			valueList.add(strArr[i]);
			map.put(key, valueList);
			
		}
				

		/**
		 * Printing out number-string pair in required output format
		 */
		for(Integer k: map.keySet()){
			ArrayList<String> aList = map.get(k);
			Collections.sort(aList);
			
			Iterator<String> listIterator = aList.iterator();
			while(listIterator.hasNext()){
				System.out.println(k+" "+listIterator.next());
			}
		}
	}
	
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        String[] strArr = new String[N];
        int itr=0;
        
        while(N>0){
        	strArr[itr++] = s.nextLine();
        	N--;
        }
        s.close();
        
        
        SimilarDigits sdObj = new SimilarDigits();
        
        sdObj.similarDigits(strArr);
	}
}
