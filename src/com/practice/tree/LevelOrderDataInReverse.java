package com.practice.tree;

import java.util.Stack;

import sun.misc.Queue;

public class LevelOrderDataInReverse {
	
	public static void printLevelOrderDataInReverse(Node root) throws InterruptedException {
		Queue<Node> qn = new Queue<Node>();
		Stack<Node> sn = new Stack<Node>();
		Node temp;
		
		if(root == null) {
			return;
		}
		
		qn.enqueue(root);
		
		while(!qn.isEmpty()) {
			temp = qn.dequeue();
						
			if(temp.right != null){
				qn.enqueue(temp.right);
			}
			
			if(temp.left != null){
				qn.enqueue(temp.left);
			}
			
			sn.push(temp);
		}

		while(!sn.isEmpty()) {
			System.out.print(sn.pop().data);
		}
	}
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		try {
			printLevelOrderDataInReverse(root);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
