package com.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GraphAdjMatrix {

	private int numOfVertices;
	private int numOfEdges;
	private Set<Integer> verticesSet;
	private final int defaultNumVertices = 5;
	private int[][] adjMatrix;
	
	public GraphAdjMatrix() {
		this.numOfVertices = 0;
		this.numOfEdges = 0;
		this.verticesSet = new TreeSet<Integer>();
		this.adjMatrix = new int[this.defaultNumVertices][this.defaultNumVertices];
	}

	public int getNumOfVertices() {
		return numOfVertices;
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}
	
	/**
	 * Adding a vertex to a Matrix. If the matrix size is lesser
	 * than vertex to be added then we double the size of matrix.
	 *  
	 */
	public void addVertex() {
		int v = this.getNumOfVertices();
		if(v >= this.adjMatrix.length) {
			int[][] newAdjMatrix = new int[v*2][v*2];
			
			for(int i=0; i<this.adjMatrix.length; i++) {
				for(int j=0; j<this.adjMatrix.length; j++) {
					newAdjMatrix[i][j] = this.adjMatrix[i][j];
				}
			}
			this.adjMatrix = newAdjMatrix;
		}
		
		for(int k=0; k<this.adjMatrix.length; k++) {
			this.adjMatrix[v][k] = 0;
		}
	}
	
	/**
	 * Adding edge between two points start and end.
	 * Multiple edges are possible too.
	 * 
	 * @param start - index of start of the edge
	 * @param end - index of end of the edge
	 */
	public void addEdge(int start, int end) {
		this.adjMatrix[start][end] += 1;
		this.verticesSet.add(start);
		this.verticesSet.add(end);
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
	 * Returns an array of sum of In-Degree weights of vertices
	 * @return
	 */
	public int[] getInDegreeWeights() {
		int len = this.adjMatrix.length;
		int[] inDegree = new int[len];
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				inDegree[i] += this.adjMatrix[j][i];
			}
		}
		
		return inDegree;
	}
	
	/**
	 * Returns an array of sum of out-degree weights of vertices 
	 * @return
	 */
	public int[] getOutDegreeWeights() {
		int len = this.adjMatrix.length;
		int[] outDegree = new int[len];
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				outDegree[i] += this.adjMatrix[i][j];
			}
		}
		
		return outDegree;
	}
	
	/**
	 * Get all out-degree neighbors of a vertex in graph.
	 * Even if there are multiple edges among vertices still 
	 * vertex appears once in the list
	 * 
	 * @param u - vertex index 
	 * @return - List<integer> having all the neighboring vertices
	 */
	public List<Integer> getNeighbors(int u) {
		List<Integer> neighborList = new ArrayList<Integer>();
		int len = this.adjMatrix.length;
		
		for(int i=0; i<len; i++) {
			if(this.adjMatrix[u][i] > 0) {
				neighborList.add(i);
			}
		}
		
		return neighborList;
	}
	
	/**
	 * Get new matrix of all the vertices reachable by 2 hops.
	 * 
	 * @return
	 */
	public int[][] get2HopNeighborMatrix() {
		int len = this.adjMatrix.length;
		int[][] newAdjMatrix = new int[len][len];
		
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				newAdjMatrix[i][j] = this.adjMatrix[i][j] * newAdjMatrix[j][i];
			}
		}
		
		return newAdjMatrix;
	}
	
	/**
	 * Get all the neighbors of a vertex which are at distance
	 * of exactly 2 hops.
	 * It also includes neighbors reachable via alternative paths. 
	 * 
	 * @param v - index of the vertex
	 * @return - List<Integer> having list of all such neighbors
	 */
	public List<Integer> get2HopNeighbor(int v) {
		List<Integer> v2HopNeighbor = new ArrayList<Integer>();
		
		for(int i : this.getNeighbors(v)) {
			for(int j : this.getNeighbors(i)) {
				v2HopNeighbor.add(j);
			}
		}
		
		return v2HopNeighbor;
	}
	
	/**
	 * Get the sorted list(reverse order) of weighted vertices where
	 * weights of each vertex is sum of in-degree and out-degree count
	 *  
	 * @return - Sorted ArrayList of weighted vertices
	 */
	public List<Integer> getCustomWeightedVertices() {
		List<Integer> customWeightedVertices = new ArrayList<Integer>();
		int len = this.adjMatrix.length;
		
		for(int i=0; i<len; i++) {
			int colTemp=0;
			int rowTemp=0;
			for(int j=0; j<len; j++) {
				colTemp += this.adjMatrix[i][j];
				rowTemp += this.adjMatrix[j][i];				
			}
			// sum of in-degree and out-degree of each vertex added to list 
			customWeightedVertices.add(Math.addExact(colTemp, rowTemp));
		}
		//sorted in descending order
		Collections.sort(customWeightedVertices, Collections.reverseOrder());
		
		return customWeightedVertices; 
	}
	
	

	
	public static void main(String[] args) {
		GraphAdjMatrix gMatrix = new GraphAdjMatrix();
		/*gMatrix.addEdge(1, 2);
		gMatrix.addEdge(1, 3);
		gMatrix.addEdge(1, 4);
		gMatrix.addEdge(2, 3);
		gMatrix.addEdge(4, 2);
		gMatrix.addEdge(4, 3);
		*/
		gMatrix.addEdge(1, 2, 100);
		gMatrix.addEdge(1, 3, 200);
		gMatrix.addEdge(1, 4, 50);
		gMatrix.addEdge(2, 3, 75);
		gMatrix.addEdge(4, 2, 45);
		gMatrix.addEdge(4, 3, 85);
		
		System.out.println("Sum of InDegree weights for vertices:");
		int[] inDegreeWeights = gMatrix.getInDegreeWeights();
		
		for(int i=0; i<inDegreeWeights.length; i++) {
			System.out.println(inDegreeWeights[i]);
		}
		
		System.out.println("\nSum of OutDegree weights for vertices:");
		int[] outDegreeWeights = gMatrix.getOutDegreeWeights();
		
		for(int i=0; i<outDegreeWeights.length; i++) {
			System.out.println(outDegreeWeights[i]);
		}
		
		
		System.out.println("\nNeighbors of vertex: 4");
		System.out.println(gMatrix.getNeighbors(4).toString());
		
		
		System.out.println("\n2 hops neighbors of vertex: 1");
		System.out.println(gMatrix.get2HopNeighbor(1).toString());
		
		
		System.out.println("\nSorted List of custom weighted vertices: ");
		System.out.println(gMatrix.getCustomWeightedVertices().toString());
		
		//System.out.println("\nDijikstra's Shortest Path: ");
		//System.out.println(gMatrix.dijkstrasPath(1).toString());
	}
}
