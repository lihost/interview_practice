package com.practice.misc;

import java.util.LinkedHashMap;
import java.util.Map;

class LRU extends LinkedHashMap<Integer, Integer>{
	
	private int capacity;
	
	
	public LRU(int capacity) {
		/**
	     * Constructs an empty LinkedHashMap instance with the
	     * specified initial capacity, load factor and ordering mode.
	     *
	     * @param  initialCapacity the initial capacity
	     * @param  loadFactor      the load factor
	     * @param  accessOrder     the ordering mode - true for
	     *         access-order, false for insertion-order
	     */
		super(capacity+1, 1.0f, true);
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if(super.get(key) == null) {
			return -1;
		} else {
			return super.get(key);
		}
		
	}
	
	public void set(int key, int value) {
		super.put(key, value);
	}
	
	
	protected boolean removeOldestEntry(Map.Entry<Integer, Integer> entry) {
		return (size() > this.capacity);
	}
}




public class LRUCache {
	
	public static void main(String[] args) {
		LRU lruCache = new LRU(5);
		
		lruCache.put(1, 101);
		lruCache.put(2, 111);
		lruCache.put(5, 121);
		lruCache.put(7, 109);
		lruCache.put(9, 110);
		lruCache.put(10, 131);
		lruCache.put(11, 113);
		lruCache.put(3, 115);
		
		System.out.println(lruCache.toString());
		
		System.out.println(lruCache.get(5));
		System.out.println(lruCache.get(7));
		System.out.println(lruCache.get(10));
		System.out.println(lruCache.get(1));
		
		System.out.println(lruCache.toString());
	}
}
