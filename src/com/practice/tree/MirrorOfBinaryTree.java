package com.practice.tree;

import sun.misc.Queue;

/**
 * Printing the mirror of binary tree
 * 
 * @author Sohil
 *
 */
public class MirrorOfBinaryTree {
	
	public static Node mirrorOfBinaryTree(Node root) {
		Node temp;
		
		if(root == null){
			return null;
		}
		
		mirrorOfBinaryTree(root.left);
		mirrorOfBinaryTree(root.right);
		
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		return root;
	}
	
	public static void printLevelOrder(Node root) throws InterruptedException {
		Node temp;
		Queue<Node> qn = new Queue<Node>();
		
		if(root == null){
			return;
		}
		
		qn.enqueue(root);
		
		while(!qn.isEmpty()) {
			temp = qn.dequeue();
			System.out.print(temp.data);
			
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
        
        Node root2 = mirrorOfBinaryTree(root);
                
        System.out.println("Level Order of mirror tree:");
        try {
			printLevelOrder(root2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
	}
}
