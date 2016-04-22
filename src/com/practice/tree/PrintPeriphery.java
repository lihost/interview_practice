package com.practice.tree;

/**
 * Amazon Face To Face Interview - 16-April'16
 * 
 * Printing boundary or periphery of a binary tree
 * 	- General Approach
 * 		1. Print left boundary from top to bottom
 * 		2. Print all leaf nodes
 * 			2.a Print all leaf nodes from left to right for left subtree
 * 			2.b Print all leaf nodes from left to right for right subtree
 * 		3. Print right boundary from bottom to top
 * 
 * 
 * 	- My Approach - After some analysis I figured out that boundary or periphery of a 
 * 			binary tree is nothing but PRE-ORDER traversal of left subtree(without 
 * 			printing internal nodes) and POST-ORDER traversal of right subtree(without 
 * 			printing internal nodes)
 * 
 * 		1. Print PRE-ORDER of left subtree excluding internal nodes
 * 		2. Print POST-ORDER of right subtree excluding internal nodes
 * 	
 * 
 * 
 *  Test case1 - courtesy - http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 *  
 * @author sohil
 *
 */
class TreeNode {
	public int data;
	public TreeNode left = null;
	public TreeNode right = null;
	
	TreeNode(int data) {
		this.data = data;
	}	
}

public class PrintPeriphery {

	public static void main(String[] args) {
		
		/**
		 * Example courtesy - http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
		 * Testcase Type1 - Expected output: 20, 8, 4, 10, 14, 25, 22
		 
		TreeNode tNode = new TreeNode(20);		
		//left subtree
		tNode.left = new TreeNode(8);
		tNode.left.left = new TreeNode(4);
		tNode.left.right = new TreeNode(12);
		tNode.left.right.left = new TreeNode(10);
		tNode.left.right.right = new TreeNode(14);
		
		//right subtree
		tNode.right = new TreeNode(22);
		tNode.right.right = new TreeNode(25);
		
		*/
		
		
		/**
		 * Testcase Type2 - Exepcted Output : 30, 20, 10, 5, 15, 28, 32, 37, 41, 50, 40
		 */
		TreeNode tNode = new TreeNode(30);
		
		//left subtree
		tNode.left = new TreeNode(20);
		tNode.left.left = new TreeNode(10);
		tNode.left.left.left = new TreeNode(5);
		tNode.left.left.right = new TreeNode(15);
		tNode.left.right = new TreeNode(25);
		tNode.left.right.right = new TreeNode(28);
		
		//right subtree
		tNode.right = new TreeNode(40);
		tNode.right.left = new TreeNode(35);
		tNode.right.left.left = new TreeNode(32);
		tNode.right.left.right = new TreeNode(37);
		tNode.right.right = new TreeNode(50);
		tNode.right.right.left = new TreeNode(41);
		
		
		// print periphery
		printBinaryTreePeriphery(tNode);
		
	}
	
	public static void printBinaryTreePeriphery(TreeNode root) {
		if(root == null) {
			System.out.println("NULL");
		}
		
		System.out.println("Node: "+root.data);
		
		//print left subtree
		if(root.left != null){
			printPRE(root.left, false);
		}
		
		//print right subtree
		if(root.right != null){
			printPOST(root.right, false);
		}
	}
	
	/**
	 * Generates PRE-ORDER traversal for left subtree of main Binary tree
	 * @param root
	 * @param right - marker to check if 'right' sub tree exist
	 */
	public static void printPRE(TreeNode root, boolean right) {
		if(root == null) {
			System.out.println("NULL");
		}
		
		/**
		 * check if its not right subtree OR it has neither left or right child
		 */
		if(right == false || (root.left == null && root.right == null))
			System.out.println("Node: "+root.data);
		
		if(root.left != null) {
			printPRE(root.left, false);
		}
		
		if(root.right != null) {
			printPRE(root.right, true);
		}
	}
	
	/**
	 * Generates POST-ORDER traversal for right subtree of main binary tree
	 * @param root
	 * @param left - marker to check if 'left' subtree exist
	 */
	public static void printPOST(TreeNode root, boolean left) {
		if(root == null) {
			System.out.println("NULL");
		}
		
		if(root.left != null) {
			printPOST(root.left, true);
		}
		
		if(root.right != null) {
			printPOST(root.right, false);
		}
		
		/**
		 * check if its not left subtree OR it has neither left or right child
		 */
		if(left == false || (root.left == null && root.right == null)) { 
			System.out.println("Node: "+root.data);
		}
		
	}
}
