package com.jeffcunningham.org.Queue;

public class Queue {
	
	private static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
		
	}
	
	private Node head;
	private Node tail;
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int peek() {
		return head.data;
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if (tail!=null) {
			tail.next = node;	
		}
		
		tail = node;
		
		if(head==null) {
			head = node;
		}
		
	}
	
	public int remove() {
		if (head==null) {
			throw new NullPointerException();
		}
		Node temp = head;
		head = head.next;
		if (head==null) {
			tail=null;
		}
		
		return temp.data;
	}
}
