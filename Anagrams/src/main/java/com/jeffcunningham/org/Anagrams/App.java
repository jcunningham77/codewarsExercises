package com.jeffcunningham.org.Anagrams;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	private static int counter = 0; 
	
    public static int numberNeeded(String first, String second) {
    		
//	    	char[] firstChars = first.toCharArray();
//	    	char[] secondChars = first.toCharArray();
//	    	
//	    	Arrays.sort(firstChars);
//	    	Arrays.sort(secondChars);
	    	
	    	int characterCountMatrix[][] = new int[26][2];
	    
	    	char c;

	    	//loop through each letter of the alphabet
	    	int characterCountMatrixLetterIndex=0;
        for(c = 'a'; c <= 'z'; ++c) {
        		
        	
	        	int firstCounter = 0;
	        	int secondCounter = 0;
	        	
	        	//loop through each string count how many times that character appears
	        	for( int i=0; i<first.length(); i++ ) {
	        	    if( first.charAt(i) == c ) {
	        	        firstCounter++;
	        	    } 
	        	}
	        	
	        	for( int i=0; i<second.length(); i++ ) {
	        	    if( second.charAt(i) == c ) {
	        	        secondCounter++;
	        	    } 
	        	}
	        	
	        	//insert # of occurrences of this letter in each string
	        	characterCountMatrix[characterCountMatrixLetterIndex][0]=firstCounter;
	        	characterCountMatrix[characterCountMatrixLetterIndex][1]=secondCounter;
	        	
	        	characterCountMatrixLetterIndex++;
	    }
	    
        characterCountMatrixLetterIndex=0; 
        for(c = 'a'; c <= 'z'; ++c) {
        		       	
        		System.out.println("# of occurences of " + c + " In first string: " + characterCountMatrix[characterCountMatrixLetterIndex][0] + " In second string: " + characterCountMatrix[characterCountMatrixLetterIndex][1]);
        		characterCountMatrixLetterIndex++;
        }
	        
	        
    	
        return counter;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
