package com.jeffcunningham.org.Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




/**
 * Hello world!
 *
 */
public class App 
{
	private static int counter = 0; 
	
//	private static final Logger logger = LogManager.getLogger(App.class);
	
	
    private static int numberNeeded(String first, String second) {
    		

	    	
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
//        	logger.info("# of occurences of " + c + " In first string: " + characterCountMatrix[characterCountMatrixLetterIndex][0] + " In second string: " + characterCountMatrix[characterCountMatrixLetterIndex][1]);
        		characterCountMatrixLetterIndex++;
        }
        characterCountMatrixLetterIndex=0; 
        
        
        for(c = 'a'; c <= 'z'; ++c) {
	      
        	
			if (characterCountMatrix[characterCountMatrixLetterIndex][0]>characterCountMatrix[characterCountMatrixLetterIndex][1]) {
//				logger.info("The first string has " + characterCountMatrix[characterCountMatrixLetterIndex][0] + " occurences of " + c + " and the second string has only " + characterCountMatrix[characterCountMatrixLetterIndex][1] + " occurences of  " + c );
				
//				logger.info("So removing " + (characterCountMatrix[characterCountMatrixLetterIndex][0] - characterCountMatrix[characterCountMatrixLetterIndex][1]) + " occurences of " + c + " from first string");
				first = removeOccurrencesOfCharacter(c,first,(characterCountMatrix[characterCountMatrixLetterIndex][0] - characterCountMatrix[characterCountMatrixLetterIndex][1]));	
			}
			if (characterCountMatrix[characterCountMatrixLetterIndex][1]>characterCountMatrix[characterCountMatrixLetterIndex][0]) {
//				logger.info("The second string has " + characterCountMatrix[characterCountMatrixLetterIndex][1] + " occurences of " + c + " and the first string has only " + characterCountMatrix[characterCountMatrixLetterIndex][0] + " occurences of  " + c );
				
//				logger.info("So removing " + (characterCountMatrix[characterCountMatrixLetterIndex][1] - characterCountMatrix[characterCountMatrixLetterIndex][0]) + " occurences of " + c + " from second string");
				first = removeOccurrencesOfCharacter(c,second,(characterCountMatrix[characterCountMatrixLetterIndex][1] - characterCountMatrix[characterCountMatrixLetterIndex][0]));	
			}			
			characterCountMatrixLetterIndex++; 
        }
        
        
        char[] firstCharArray = first.toCharArray();
        Arrays.sort(firstCharArray);
        String sortedFirst = new String(firstCharArray);
//        logger.info("Sorted and trimmed first string = " + sortedFirst);  
        
        char[] secondCharArray = second.toCharArray();
        Arrays.sort(secondCharArray);
        String sortedSecond = new String(secondCharArray);
//        logger.info("Sorted and trimmed second string = " + sortedSecond);          
	        
	        
    	
        return counter;
    }
    
    private static String removeOccurrencesOfCharacter(char c, String inputString, int numberOfOccurences) {
    		
    		
    		for (int i = 0; i < numberOfOccurences; i++){
    			inputString =  inputString.replaceFirst(String.valueOf(c), "");
//    			logger.info("removeOccurrencesOfCharacter: Just removed an occurence of " + c + ", resulting in " + inputString);
    			counter++;
    		}
//    		logger.info("returning resulting string:  " + inputString);
    		return inputString;
    		
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        
//        logger.info(numberNeeded(a, b) + " total characters were removed");
        System.out.println(numberNeeded(a, b) + " total characters were removed");
    }
}
