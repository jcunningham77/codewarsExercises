package com.jeffcunningham.org.IsThisABinarySearchTree;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App {

	static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {

		logger.info("Hello World!");

		Node binarySearchNode = buildbadNodeTestCase2();
		binarySearchNode.printInOrder();

		logger.info("Is this node a binary search tree? " + checkBST(binarySearchNode));;

	}
	
	private static Node buildbadNodeTestCase2() {
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		
		node2.left = node1;
		node2.right = node4;
		
		node6.left = node5;
		node6.right = node7;
		
		node3.left = node2;
		node3.right = node6;
		
		return node3;
		
	}
	

	
	

	static boolean checkBST(Node root) {

		

		return isNodeLegit(root, new ArrayList<Node>(), new ArrayList<Node>());

	}
	
	private static boolean isNodeLegit(Node node, List<Node> ancestorsFromTheLeft , List<Node> ancestorsFromTheRight) {
		
		if (!ancestorsFromTheLeft.isEmpty()) {
			for (Node ancestorFromTheLeft: ancestorsFromTheLeft) {
//				logger.info("checking ancestors from the left =  " + ancestorFromTheLeft.data + " current node=" + node.data );
				if (node.data<=ancestorFromTheLeft.data) {
//					logger.info("returning false");
					return false;
				}
			}
		} 
		
		if (!ancestorsFromTheRight.isEmpty()) {
			for (Node ancestorFromTheRight: ancestorsFromTheRight) {
//				logger.info("checking ancestors from the right =  " + ancestorFromTheRight.data + " current node=" + node.data );
				if (node.data>=ancestorFromTheRight.data) {
//					logger.info("returning false");
					return false;
				}
			}
		} 		
		
		
		
		
		if (node.left==null&&node.right==null) {
//			logger.info("Node data = " + node.data + ", left and right are both null.");
			return true;
		} else if (node.left==null&&node.right.data>node.data) {
//			logger.info("Node data = " + node.data + ", left is null, right=" + node.right.data);
			ancestorsFromTheLeft.add(node);
			return true&&isNodeLegit(node.right, ancestorsFromTheLeft, ancestorsFromTheRight);
		} else if (node.right==null&&node.left.data<node.data) {
//			logger.info("Node data = " + node.data + ", right is null, left=" + node.left.data);
			ancestorsFromTheRight.add(node);
			return true&&isNodeLegit(node.left,ancestorsFromTheLeft,ancestorsFromTheRight);
		} else if (node.right.data>node.data&&node.left.data<node.data){
//			logger.info("Node data = " + node.data + ", right is = " + node.right.data + " left=" + node.left.data);
			
			//establish right check ancestor params
			List<Node> ancestorsFromTheLeftForRightCheck = new ArrayList<Node>();
			ancestorsFromTheLeftForRightCheck.addAll(ancestorsFromTheLeft);
			ancestorsFromTheLeftForRightCheck.add(node);
			List<Node> ancestorsFromTheRightForRightCheck = new ArrayList<Node>();
			ancestorsFromTheRightForRightCheck.addAll(ancestorsFromTheRight);
			
			//establish left check ancestor params
			List<Node> ancestorsFromTheLeftForLeftCheck = new ArrayList<Node>();
			ancestorsFromTheLeftForLeftCheck.addAll(ancestorsFromTheLeft);
			List<Node> ancestorsFromTheRightForLeftCheck = new ArrayList<Node>();		
			ancestorsFromTheRightForLeftCheck.addAll(ancestorsFromTheRight);		
			ancestorsFromTheRightForLeftCheck.add(node);
			

			return true&&isNodeLegit(node.right,ancestorsFromTheLeftForRightCheck,ancestorsFromTheRightForRightCheck)&&isNodeLegit(node.left,ancestorsFromTheLeftForLeftCheck,ancestorsFromTheRightForLeftCheck);
		} else if (node.right.data<=node.data||node.left.data>=node.data) {
//			logger.info("we have a problem");
			return false;
		} 
		
		return true;
		
		
	}

	private static boolean isLeftLegit(Node node) {

		if (node.left == null) {
			logger.info("left == null");
			return true;
		} else if (node.left.data < node.data) {
			logger.info("left is legit, it equals =" + node.left.data);
			return true && isLeftLegit(node.left);
		} else {
			logger.info("left is not legit, it equals =" + node.left.data);
			return false;
		}

	}

	private static boolean isRightLegit(Node node) {

		if (node.right == null) {
			logger.info("right == null");
			return true;
		} else if (node.right.data > node.data) {
			logger.info("right is legit, it equals =" + node.right.data);
			return true && isRightLegit(node.right);
		} else {
			logger.info("right is legit, it equals =" + node.right.data);
			return false;
		}

	}
	
	private static Node buildLegitNode() {
		Node binarySearchNode = new Node(10);
		binarySearchNode.insert(5);
		binarySearchNode.insert(40);
		binarySearchNode.insert(67);
		binarySearchNode.insert(21);
		binarySearchNode.insert(2);
		binarySearchNode.insert(18);
		binarySearchNode.insert(90);

		binarySearchNode.printInOrder();
		
		return binarySearchNode;
	}

}
