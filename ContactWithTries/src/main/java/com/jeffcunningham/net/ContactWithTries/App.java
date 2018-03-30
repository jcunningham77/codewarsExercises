package com.jeffcunningham.net.ContactWithTries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {

	// private static Trie trie;
	private static Node topNode;
	private static Logger logger;

	public static void main(String[] args) throws FileNotFoundException {
		logger = LogManager.getLogger();
//		Scanner in = new Scanner(System.in);
		
		
		Scanner in = new Scanner(new File("/Users/jeffcunningham/eclipse-workspace/codewarsExercises/ContactWithTries/input01.txt"));
		int n = in.nextInt();
		topNode = new Node();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();

//			logger.info("op = " + op + ", contact = " + contact);
			if (op.equalsIgnoreCase("add")) {
				
				loadContact(contact);
			}
			
			if (op.equalsIgnoreCase("find")) {
				logger.info(findPartial(contact));	
			}
		}

		logger.trace("finished");
	}

	private static void loadContact(String contact) {
		// check if trie is empty, if so, initialize first Node with the first letter of
		Node currentNode = topNode;
		char[] contactChars = contact.toCharArray();

		for (int i = 0; i < contactChars.length; i++) {

			// check the children to see if this contact's current letter exists
			if (currentNode.getChildren().containsKey(contactChars[i])) {
				// is the the last letter in the current word? if so, let's set that boolean on
				// the found node
				currentNode.size++;
				if (i == contactChars.length - 1) {
					currentNode.getChildren().get(contactChars[i]).setCompleteWord(true);
					
				} else {
					// if not, let's update the currentNode to the found child
					
					currentNode = currentNode.getChildren().get(contactChars[i]);
				}

			} else {
				// letter is not found, add a new entry into current children
				Node newChildNode = new Node(contactChars[i], i == contactChars.length - 1);

				currentNode.getChildren().put(contactChars[i], newChildNode);
				
				// set currentNode to this new node
				currentNode = newChildNode;
			}

		}
	}

	private static int findPartial(String partial) {

		int numberOfOccurences = 0;
		Node currentNode = topNode;

		char[] partialChars = partial.toCharArray();

		for (int i = 0; i < partialChars.length; i++) {
			if (currentNode.getChildren().containsKey(partialChars[i])) {
				if (i == partialChars.length - 1) {
					numberOfOccurences = currentNode.size;
				} else {
					currentNode = currentNode.getChildren().get(partialChars[i]);
				}

			} else {
				
				break;
			}
		}

		return numberOfOccurences;
	}

//	private static int findNumberOfContainingWords(Node node) {
//		int counter = 0;
//		for(Node childNode:node.getChildren().values()) {
//			if(childNode.isCompleteWord()) {
//				counter++;
//			}
//			counter=counter+findNumberOfContainingWords(childNode);
//		}
//		
//		return counter;
//
//	}

}
