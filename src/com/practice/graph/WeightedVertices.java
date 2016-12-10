package com.practice.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Microsoft FTF Interview Question - Nov-16
 * 
 * @author Sohil
 * 
 */
public class WeightedVertices extends GraphAdjMatrix{

	/**
	 * Get the sorted list(reverse order) of weighted vertices where
	 * weights of each vertex is sum of in-degree and out-degree count
	 *  
	 * @return - Sorted ArrayList of weighted vertices
	 */
	public List<Integer> getCustomWeightedListOfVertices(GraphAdjMatrix gMatrix) {
		List<Integer> customWeightedVertices = new ArrayList<Integer>();
		int[][] matrix = gMatrix.getAdjMatrix();
		int len = matrix.length;
		
		for(int i=0; i<len; i++) {
			int colTemp=0;
			int rowTemp=0;
			for(int j=0; j<len; j++) {
				colTemp += matrix[i][j];
				rowTemp += matrix[j][i];				
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
		
		//graph with weights
		gMatrix.addEdge(1, 2, 100);
		gMatrix.addEdge(1, 3, 200);
		gMatrix.addEdge(1, 4, 50);
		gMatrix.addEdge(2, 3, 75);
		gMatrix.addEdge(4, 2, 45);
		gMatrix.addEdge(4, 3, 85);
		
		WeightedVertices WVObj = new WeightedVertices();
		
		System.out.println("Sorted List of custom weighted vertices: ");
		System.out.println(WVObj.getCustomWeightedListOfVertices(gMatrix));
	}
}
