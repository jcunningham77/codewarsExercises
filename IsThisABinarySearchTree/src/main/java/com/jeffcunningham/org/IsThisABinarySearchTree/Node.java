package com.jeffcunningham.org.IsThisABinarySearchTree;

public class Node {
	Node left, right;
	int data;

	public Node(int data) {
		this.data = data;
	}

	public void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if (value==data) {
			return true;
		} else if (value <= data &&( left !=null)) {
			return left.contains(value);
		} else if (value > data &&( right !=null)) {
			return right.contains(value);
		} else {
			return false;
		}
	}
	
	public void printInOrder() {
		if (left!=null) {
			left.printInOrder();
		}
		System.out.println(data);
		if (right!=null) {
			right.printInOrder();
		}
		
		
		
		
	}

}
