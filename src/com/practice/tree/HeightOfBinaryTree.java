package com.practice.tree;

public class HeightOfBinaryTree {
	
	public static int heightOfBinaryTree(Node root) {
		int leftHeight, rightHeight;
		
		if(root == null){
			return 0;
		} else {
			leftHeight = heightOfBinaryTree(root.left);
			rightHeight = heightOfBinaryTree(root.right);
			
			if(leftHeight > rightHeight)
				return(leftHeight+1);
			else
				return(rightHeight+1);
			
		}
		
	}
	
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(5);
		root.right = new Node(6);
		
		root.left.left = new Node(8);
		root.left.right = new Node(9);
		 
        root.right.left = new Node(12);
        root.right.right = new Node(13);
        root.right.right.left = new Node(15);
        root.right.right.right = new Node(18);
		
		System.out.println("Height of binary tree: "+heightOfBinaryTree(root));
		
	}

}
