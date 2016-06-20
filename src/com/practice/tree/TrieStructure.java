package com.practice.tree;

/**
 * Trie implementation for String addition and checking of whole word in a Trie
 * 
 * @author sohil
 *
 */
class TrieNode {
	char c;
	boolean endOfString;
	TrieNode[] children;
	
	public TrieNode() {
		this.c=0;
		this.children = new TrieNode[26];
		this.endOfString = false;
	}
	
	public void add(String s) {
		if(s.isEmpty()) {
			this.endOfString = true;
			return;
		}
		
		char letter = s.charAt(0);
		int index = letter - 'a';
		
		if(this.children[index] == null) {
			this.children[index] = new TrieNode();
		}
		
		this.children[index].add(s.substring(1));
	}
	
	public boolean isWord(String s) {
		if(s.isEmpty()) {
			return this.endOfString;
		}
		
		char letter = s.charAt(0);
		int index = letter - 'a';
		
		if(this.children[index] == null) {
			return false;
		}
		
		return this.children[index].isWord(s.substring(1));
	}
	
}


public class TrieStructure {
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		root.add("abcd");
		root.add("axyz");
		
		String checkWord = "bxyz";
		System.out.println("check if string: \'"+checkWord+"\' is a whole word in a Trie.\nResult: "+root.isWord(checkWord));
	}
}
