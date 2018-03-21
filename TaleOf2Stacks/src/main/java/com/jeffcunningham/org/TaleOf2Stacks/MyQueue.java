package com.jeffcunningham.org.TaleOf2Stacks;

import java.util.Stack;

public class MyQueue<T> {
	Stack<T> stackNewestOnTop = new Stack<T>();
	Stack<T> stackOldestOnTop = new Stack<T>();

	public void enqueue(T value) { // Push onto newest stack

		stackNewestOnTop.push(value);

	}

	public T peek() {
		if (stackOldestOnTop.isEmpty()) {
			while (!stackNewestOnTop.isEmpty()) {
				stackOldestOnTop.push(stackNewestOnTop.pop());
			}
		}
		return stackOldestOnTop.peek();

	}

	public T dequeue() {
		if (stackOldestOnTop.isEmpty()) {
			while (!stackNewestOnTop.isEmpty()) {
				stackOldestOnTop.push(stackNewestOnTop.pop());
			}
		}

		return stackOldestOnTop.pop();
	}
}
