package com.jeffcunningham.org.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        
        Node head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(3);
//        head.next.next = head;
        
        System.out.println("Does this node have a cycle? " + hasCycleFastSlow(head));
        
        
    }
    
    private static boolean hasCycle(Node head) {
    		boolean hasCycle = false;
    		Set<Node> set = new HashSet<Node>();
    		if (head==null) {
    			return hasCycle;
    		}
    		while(head.next!=null) {
    			if(!set.add(head)) {
    				hasCycle=true;
    				break;
    			};
    		}
    		
    		return hasCycle;
    }
    
    private static boolean hasCycleFastSlow(Node head) {
        if (head == null) return false;
        
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
    
    
}
