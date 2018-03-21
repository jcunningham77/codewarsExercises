package com.jeffcunningham.org.Queue;

public class Stack {
	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node top;

	public boolean isEmpty() {
		return top == null;

	}

	public int peek() {
		if (top == null) {
			throw new NullPointerException();
		}
		return top.data;

	}

	public void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;

	}

	public int pop() {

		int data = top.data;

		top = top.next;

		return data;
	}

}
