package com.jeffcunningham.org.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ResizableArray resizableArray = new ResizableArray();
        for (int i=0;i<25;i++) {
        		resizableArray.append(i);
        }
        
        for (int i=0;i<resizableArray.size();i++) {
        		System.out.println(resizableArray.get(i));	
        }
        
    }
}
