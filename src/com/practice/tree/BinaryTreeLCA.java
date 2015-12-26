package com.practice.tree;

/**
 * Finding least common ancestor in a binary tree
 *
 */
class Node {
    public int data;
    public Node right;
    public Node left;
	
    public Node(int data) {
        this.data = data;
    }
}

public class BinaryTreeLCA {
	
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
        
        System.out.println("Lowest common ancestor of 18 and 12 is: "+findLCA(root, root.right.right.right, root.right.left).data);
        System.out.println("Lowest common ancestor of 18 and null is: "+findLCA(root, root.right.right.right, null).data);
		
        
	}
	
	
	public static Node findLCA(Node root, Node p, Node q){
		if(root==null){
			return null;
		}
		
		if(root==p || root==q){
			return root;
		}
		
		Node l = findLCA(root.left, p, q);
		Node r = findLCA(root.right, p, q);
		
		if(l != null && r != null){
			return root;
		}
		
		return (l!=null) ? l : r;
		
	}

}
