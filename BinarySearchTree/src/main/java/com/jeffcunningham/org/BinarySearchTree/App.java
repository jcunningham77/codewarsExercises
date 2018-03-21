package com.jeffcunningham.org.BinarySearchTree;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Node node = new Node(8);
        node.insert(5);
        node.insert(10);
        node.insert(2);
        node.insert(4);
        node.insert(9);
        node.insert(70);
        
        node.printInOrder();
    }
}
