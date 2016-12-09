package com.practice.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DijkstrasGraph{
	private final int DEFAULTNUMVERTICES = 8;
	private Set<Integer> verticesSet;
	private int[][] adjMatrix;
	
	public DijkstrasGraph() {
		this.verticesSet = new TreeSet<Integer>();
		this.adjMatrix = new int[this.DEFAULTNUMVERTICES][this.DEFAULTNUMVERTICES];
		
		for(int[] row : this.adjMatrix)
			Arrays.fill(row, Integer.MAX_VALUE);
	}
	
	/**
	 * Adding a edge between start and end point with
	 * a predefined weight associated with edge
	 * 
	 * @param start - index of start of the edge
	 * @param end - index of end of the edge
	 * @param weight - weight associated with this edge
	 */
	public void addEdge(int start, int end, int weight) {
		this.adjMatrix[start][end] = weight;
		this.verticesSet.add(start);
		this.verticesSet.add(end);
	}
	
	/**
	 * Dijkstra's shortest path from any starting vertex
	 * 
	 * @param v - start vertex
	 * @return - Map of vertices and their distances from start vertex
	 */
	public Map<Integer, Integer> dijkstrasPath(int v) {
		//complete list of all vertices in graph
		Set<Integer> verticesSet = this.verticesSet;
		verticesSet.remove(v);
		
		//List of visited vertices during shortest path
		LinkedList<Integer> visitedVertices = new LinkedList<Integer>();
		visitedVertices.add(v);
		
		//Map of all vertices and their corresponding distances from start vertex
		Map<Integer, Integer> deltaDistance = new HashMap<Integer, Integer>();
		
		for(Integer i : verticesSet){
			deltaDistance.put(i, this.adjMatrix[v][i]);
		}
		
		// vertex being visited currently
		int w = 0;
		
		//distance from start to vertex w
		int deltaW = 0;
		
		
		// keep doing till vertices set is empty
		while(!verticesSet.isEmpty()) {
			
			//TreeMap having reverse combination<value, key> from deltaDistance<Key, Value> 
			//so that we can get our Map sorted by value(distance)
			Map<Integer, Integer> deltaDistanceSortedMap = new TreeMap<Integer, Integer>();
			for(Integer key : verticesSet) {
				if(deltaDistance.get(key) > 0) {
					deltaDistanceSortedMap.put(deltaDistance.get(key), key);
				}
			}

			
			Map.Entry<Integer, Integer> entry = deltaDistanceSortedMap.entrySet().iterator().next();
			//taking next vertex(w) with least distance(deltaW)
			deltaW = entry.getKey();
			w = entry.getValue();
						
			verticesSet.remove(w);
			
			visitedVertices.add(w);
			
			
			//Iterating over rest of vertices to calculate their smallest distance
			for(Integer j : verticesSet) {	
				
				//calculating distance from w to rest of vertices(verticesSet) and replacing(corresponding map entries)
				if(this.adjMatrix[w][j] != Integer.MAX_VALUE && deltaW+this.adjMatrix[w][j] < deltaDistance.get(j)) {
					deltaDistance.put(j, deltaW+this.adjMatrix[w][j]);
				} 
			}
			
		}
		
		return deltaDistance;
	}
	
	
	public static void main(String[] args) {
		DijkstrasGraph gMatrix = new DijkstrasGraph();
		
		//for Dijkstra's alg
		gMatrix.addEdge(1, 2, 5);
		gMatrix.addEdge(1, 3, 8);
		gMatrix.addEdge(1, 5, 7);
		gMatrix.addEdge(1, 6, 10);
		gMatrix.addEdge(2, 3, 1);
		gMatrix.addEdge(2, 5, 3);
		gMatrix.addEdge(3, 4, 6);
		gMatrix.addEdge(5, 4, 4);
		gMatrix.addEdge(5, 7, 7);
		gMatrix.addEdge(5, 6, 2);
		gMatrix.addEdge(6, 7, 3);
		gMatrix.addEdge(7, 3, 4);
		gMatrix.addEdge(7, 4, 5);
		
		//start vertex
		int start = 1;
				
		System.out.println("\nDijikstra's Shortest Path from vertex: "+start);
		System.out.println(gMatrix.dijkstrasPath(start).toString());
		
		
	}

}
