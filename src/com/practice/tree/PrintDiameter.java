package com.practice.tree;

/**
 * Printing Binary tree diameter
 * 
 * Problem Statement - http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * 
 * @author sohil
 *
 */
public class PrintDiameter {
	
	public static void main(String[] args) {
		// Test case
		TreeNode root = new TreeNode(30);
		root.left = new TreeNode(20);
		root.left.left = new TreeNode(10);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(15);
		root.left.right = new TreeNode(25);
		root.left.right.right = new TreeNode(28);
		
		root.right = new TreeNode(40);
		root.right.left = new TreeNode(35);
		root.right.right = new TreeNode(50);
		root.right.right.left = new TreeNode(41);
		
		int diameter = depthOfTree(root.left)+depthOfTree(root.right);
		
		System.out.println("Diameter: "+ diameter);
	}
	
	public static int depthOfTree(TreeNode root) {
		if(root == null) {
			return 0;
		} else {
			return 1+ Math.max(depthOfTree(root.left), depthOfTree(root.right));
		}
	}
}
