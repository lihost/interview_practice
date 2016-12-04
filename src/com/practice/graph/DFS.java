package com.practice.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * DFS implementation on Graph(having vertices recognized as graph of Characters)
 * 
 * @author Sohil
 *
 */
public class DFS extends GraphAdjList{
	
	public void dfs(GraphAdjList g, Character start, Character goal) {
		//keeps track of subsequent node visits
		Stack<Character> s = new Stack<Character>();
		//keeps track of visited nodes
		Set<Character> visitedNodes = new LinkedHashSet<Character>();
		//keeps track of parent-child relationship among visited nodes
		Map<Character, Character> parentChildMap = new HashMap<Character, Character>();
		
		Character curr;
		s.push(start);
		visitedNodes.add(start);
		
		while(!s.isEmpty()) {
			curr = s.pop();
			
			if(curr == goal) {
				System.out.println("\nGoal node reached... : "+curr);
				System.out.println("Visited nodes:  "+visitedNodes.toString());
				System.out.println("Parent-Child map: "+parentChildMap.toString());
				return;
			}
			
			System.out.print(curr+"->");
			
			for(Character c : g.getEdgeList(curr)) {
				visitedNodes.add(c);
				parentChildMap.put(curr, c);
				s.push(c);
			}
		}
	}
	
	
	public static void main(String[] args) {
		GraphAdjList g = new GraphAdjList();
		g.addVertex('a');
		g.addVertex('b');
		g.addVertex('c');
		g.addVertex('d');
		g.addVertex('e');
		g.addVertex('f');
		g.addVertex('g');
		g.addVertex('h');
		
		g.addEdge('a', 'b');
		g.addEdge('b', 'c');
		g.addEdge('b', 'h');
		g.addEdge('c', 'd');
		g.addEdge('c', 'e');
		g.addEdge('e', 'h');
		g.addEdge('e', 'g');
		g.addEdge('e', 'f');
		
		System.out.println("number of vertices: "+g.getNumOfVertices());
		System.out.println("number of edges: "+g.getNumOfEdges());
		
		DFS dfs = new DFS();
		dfs.dfs(g, 'a', 'g');
		
	}
}
