package com.practice.tree;

public class SizeOfBinaryTree {
	
	public static int sizeOfBinaryTree(Node root) {
		if(root == null){
			return 0;
		} else {
			return (sizeOfBinaryTree(root.left) + 1 + sizeOfBinaryTree(root.right));
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(5);
		root.right = new Node(6);
		
		root.left.left = new Node(8);
		root.left.right = new Node(9);
		 
        root.right.left = new Node(12);
        root.right.right = new Node(13);
        root.right.right.left = new Node(15);
        root.right.right.right = new Node(18);
		
		System.out.println("Binary tree sise: "+sizeOfBinaryTree(root));
	}
}
