package com.practice.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import sun.misc.Queue;

/**
 * BFS implementation on Graph(having vertices recognized as graph of Characters)
 * 
 * @author Sohil
 *
 */
public class BFS extends GraphAdjList {
	
	public void bfs(GraphAdjList g, Character start, Character goal) throws InterruptedException {
		Queue<Character> q = new Queue<Character>();
		// Set to keep track of visited nodes
		Set<Character> visited = new HashSet<Character>();
		// Map to hold parent-child relationship among nodes
		Map<Character, Character> parentChildMap = new HashMap<Character, Character>();
		
		Character curr;
		q.enqueue(start);
		visited.add(start);
		
		while(!q.isEmpty()) {
			curr = q.dequeue();
			if(curr==goal) {
				System.out.println("\nGoal found..."+curr);
				System.out.println("visited nodes: "+visited.toString());
				System.out.println("parent child map: "+parentChildMap.toString());
				return;
			}
			
			System.out.print(curr+"->");
			
			for(Character c : g.getEdgeList(curr)) {
				if(!visited.contains(c)) {
					visited.add(c);
					parentChildMap.put(curr, c);
					q.enqueue(c);
				}
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
		
		BFS bfs = new BFS();
		try {
			bfs.bfs(g, 'a', 'g');
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
