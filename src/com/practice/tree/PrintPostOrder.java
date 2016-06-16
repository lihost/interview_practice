package com.practice.tree;

import java.util.Arrays;

/**
 * Printing POSTORDER from PreOrder and InOrder traversals
 * @author tsohil
 * 
 * step 1 - first element of preOrder will be the root of tree
 * step 2 - after that look into inOrder array to determine the location of that root, 
 * 			left side of the array is left subtree and right side is right subtree of the tree 
 * step 3 - by using that index we need to find out element in the right which is root
 * step 4 - similarly we do for left subtree, main idea is to determine indexes of right subtree 
 * 			first then left subtree by looking into inOrder array
 * step 5 - in this final step we will reverse the resultant array to get postOrder traversal
 * 
 */
public class PrintPostOrder {
	
	public static int[] postOrder;
	public static int counter = 0;
	
	public static void getPostOrder(int[] inOrder, int iStart, int iEnd, int[] preOrder, int pStart, int pEnd){
		if(iStart > iEnd || pStart > pEnd){
			return;
		}
		
		int root = preOrder[pStart];
		PrintPostOrder.postOrder[counter++] = root;
		
		int k=0;
		for(int i=0; i< inOrder.length; i++){
			if(inOrder[i] == root){
				k=i;
				break;
			}
		}
		
		//right subtree
		getPostOrder(inOrder, k+1, iEnd, preOrder, pStart+k+1-iStart, pEnd);
		//left subtree
		getPostOrder(inOrder, iStart, k-1, preOrder, pStart+1, pStart+k-iStart);
	}
	
	public static void main(String[] args){
		int[] preOrder = {1,2,4,5,3,6,7,8};
		int[] inOrder = {4,2,5,1,6,3,8,7};
		PrintPostOrder.postOrder = new int[inOrder.length];

		getPostOrder(inOrder, 0, inOrder.length-1, preOrder, 0, preOrder.length-1);
				
		// reversing the array
		for(int i=0; i<inOrder.length/2; i++){
			int temp = PrintPostOrder.postOrder[i];
			PrintPostOrder.postOrder[i] = PrintPostOrder.postOrder[inOrder.length - i - 1];
			PrintPostOrder.postOrder[inOrder.length - i - 1] = temp;
		}
		System.out.println("Post Order: "+Arrays.toString(PrintPostOrder.postOrder));
 	}
}
