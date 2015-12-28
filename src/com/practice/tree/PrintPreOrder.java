
package com.practice.tree;

/**
 * Find PREORDER traversal from PostOrder and InOrder.
 * 
 * step 1 - last element of postOrder will be the root of tree
 * step 2 - after that look into inOrder array to determine the location of that root, left side of the array is left subtree and right side is 
 * right subtree of the tree 
 * step 3 - by using that index we need to find out element in the left which is root
 * step 4 - similarly we do for left subtree, main idea is to determine indexes of left subtree first then right subtree by looking into inOrder array
 * 
 * 
 */
public class PrintPreOrder{

	public static void getPreOrder(int[] inorder,int iStart,int iEnd, int[] postorder, int pStart, int pEnd)
	{
		if(iStart > iEnd || pStart > pEnd)
			return ; 
		
		int root = postorder[pEnd];
		System.out.print(root);
		int k=0;
	      for(int i=0; i< inorder.length; i++){
	          if(inorder[i]==root){
	            k = i;
	            break;
	          }
	      }
	    
	    // Left Subtree  
	    getPreOrder(inorder, iStart, k-1, postorder, pStart, pStart+k-(iStart+1));
	    
	    //Right subtree
	    getPreOrder(inorder, k+1, iEnd, postorder, pStart+k-iStart, pEnd-1);   
	}


	public static void main(String args[]) {
		int[] postOrder = {4,5,2,6,8,7,3,1};
	    int[] inOrder = {4,2,5,1,6,3,8,7};
	    getPreOrder(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length-1);
	}

}