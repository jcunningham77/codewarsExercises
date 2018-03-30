package com.jeffcunningham.net.ContactWithTries;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Node {
	
	private char currentLetter;
	private HashMap<Character,Node> children;
	private boolean isCompleteWord;
	private Logger logger = LogManager.getLogger();
	public int size;
	
	public Node(char currentLetter,boolean isCompleteWord) {
		this();
		logger.trace("setting currentLetter = " + currentLetter + ", is this end of the word?" + isCompleteWord);
		this.currentLetter = currentLetter;
		this.isCompleteWord = isCompleteWord;
		this.size=1;
	}

	public Node() {
		super();
		children = new HashMap<Character,Node>();
	}

	public Character getCurrentLetter() {
		return currentLetter;
	}

	public void setCurrentLetter(Character currentLetter) {
		this.currentLetter = currentLetter;
	}

	public HashMap<Character, Node> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, Node> children) {
		this.children = children;
	}

	public boolean isCompleteWord() {
		return isCompleteWord;
	}

	public void setCompleteWord(boolean isCompleteWord) {
		logger.trace("setting this node, character of " + currentLetter + " to isCompleteWord = " + isCompleteWord);
		this.isCompleteWord = isCompleteWord;
	}


	

}
