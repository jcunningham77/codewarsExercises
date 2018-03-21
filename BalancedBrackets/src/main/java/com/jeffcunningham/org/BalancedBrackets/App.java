package com.jeffcunningham.org.BalancedBrackets;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}
	}

	private static boolean isBalanced(String input) {
		boolean isBalanced = true;
		Stack stack = new Stack();
		char[] chars = input.toCharArray();
		for (char character : chars) {
			if (character == '[' || character == '{' || character == '(') {
				stack.push(character);
			}
			if (character == ']' || character == '}' || character == ')') {
				if (stack.isEmpty()) {
					isBalanced = false;
				} else if (doesCharacterCloseBracket(character, stack.peek())) {
					stack.pop();
				} else {
					isBalanced = false;
				}
			}
		}
		if (!stack.isEmpty()) {
			isBalanced=false;
		}
		return isBalanced;
	}

	private static boolean doesCharacterCloseBracket(char input, char top) {
		boolean doesCharacterCloseBracket = false;

		switch (input) {
		case '}':
			if (top == '{') {
				doesCharacterCloseBracket = true;
			} else {
				doesCharacterCloseBracket = false;
			}
			break;
		case ')':	
			if (top == '(') {
				doesCharacterCloseBracket = true;
			} else {
				doesCharacterCloseBracket = false;
			}
			break;		
		case ']':	
			if (top == '[') {
				doesCharacterCloseBracket = true;
			} else {
				doesCharacterCloseBracket = false;
			}
			break;				
		}

		return doesCharacterCloseBracket;

	}

}
