package com.jeffcunningham.org.BalancedBrackets;

public class Stack {
	private static class Node {
		char data;
		Node next;

		public Node(char data) {
			this.data = data;
		}
	}

	private Node top;

	public boolean isEmpty() {
		return top == null;

	}

	public char peek() {
		if (top == null) {
			throw new NullPointerException();
		}
		return top.data;

	}

	public void push(char data) {
		Node node = new Node(data);
		node.next = top;
		top = node;

	}

	public char pop() {

		char data = top.data;

		top = top.next;

		return data;
	}

}
