package com.practice.tree;

import sun.misc.Queue;

public class PrintLevelOrder {
	
	public static void printLevelOrder(Node root) throws InterruptedException {
		Queue<Node> qn = new Queue<Node>();
		Node temp;
		
		if(root == null){
			return;
		}
		
		qn.enqueue(root);
		
		while(!qn.isEmpty()){
			temp = qn.dequeue();
			
			System.out.println(temp.data);
			
			if(temp.left != null)
				qn.enqueue(temp.left);
			
			if(temp.right != null)
				qn.enqueue(temp.right);
		}
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		try {
			printLevelOrder(root);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
