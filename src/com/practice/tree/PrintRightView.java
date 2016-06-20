package com.practice.tree;
import java.util.Arrays;

/**
 * Print Right View of a Binary Tree  - http://www.geeksforgeeks.org/print-right-view-binary-tree-2/
 * 
 * @author sohil
 *
 */
public class PrintRightView {
	public static int[] rightView;
	public static int count = 0;
	
	public static void printRightView(Node root) {
		if(root == null) {
			System.out.println("NULL");
		}
		
		if(root.right != null) {
			printRightView(root.right);
		}
		
		rightView[count++] = root.data;
	}
	
	public static int depth(Node root) {
		if(root == null) {
			return 0;
		} else {
			return 1+depth(root.right);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		
		
		rightView = new int[depth(root)];
		printRightView(root);
		
		//reverse array
		for(int i=0; i<rightView.length/2; i++) {
			int temp = rightView[i];
			rightView[i] = rightView[rightView.length - i - 1];
			rightView[rightView.length - i - 1] = temp;
		}
		
		System.out.println(Arrays.toString(rightView));
	}
}
