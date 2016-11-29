package com.practice.tree;

import sun.misc.Queue;

public class HalfNodesInBinaryTree {
	
	public static int numberOfHalfNodes(Node root) throws InterruptedException {
		Queue<Node> qn = new Queue<Node>();
		Node temp;
		int count = 0;
		
		if(root == null){
			return 0;
		}
		
		qn.enqueue(root);
		
		while(!qn.isEmpty()) {
			temp = qn.dequeue();
			
			if((temp.left==null && temp.right!=null) || (temp.left!=null && temp.right==null)) {
				count++;
			}
			
			if(temp.left != null){
				qn.enqueue(temp.left);
			}
			
			if(temp.right != null) {
				qn.enqueue(temp.right);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(5);
		root.right = new Node(6);
		
		root.left.left = new Node(8);
		//root.left.right = new Node(9);
		 
        root.right.left = new Node(12);
        root.right.right = new Node(13);
        //root.right.right.left = new Node(15);
        root.right.right.right = new Node(18);
        
        try {
			System.out.println("Number of half nodes in Tree: "+numberOfHalfNodes(root));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} 
