package com.jeffcunningham.net.IceCreamParlor;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            solve(arr, money);
        }
        in.close();
    }
    
    static void solve(int[] arr, int money) {
    	
    		Hashtable originalOrderHash = new Hashtable<Integer, Integer>(arr.length);
    		for (int i=1;i<arr.length+1;i++) {
    			originalOrderHash.put(i, arr[i-1]);
    		}
    	
    	 	Arrays.sort(arr);
    	 	
    	 	int cone1Amount = 1;
    	 	int cone2Amount = money-cone1Amount;
    	 	
    	 	int indexForFirstCone = Arrays.binarySearch(arr, cone1Amount);
    	 	int indexForSecondCone = Arrays.binarySearch(arr, cone2Amount);
    	 	
    	 	int originalIndexForFirstCone= 0, originalIndexForSecondCone = 0;
    	 	boolean foundFirst = false;
    	 	boolean foundSecond = false;
    	 	
    	 	if (indexForFirstCone!=indexForSecondCone) {
    	 		
    	 		
    	 			Set<Entry> entries = originalOrderHash.entrySet();
    	 			for(Entry entry : entries) {
    	 				
        	 				if (cone1Amount ==((Integer)entry.getValue()).intValue()) {
        	 					originalIndexForFirstCone = (Integer)entry.getKey();
        	 					foundFirst=true;	
        	 				}
        	 				if (cone2Amount ==((Integer)entry.getValue()).intValue()) {
        	 					originalIndexForSecondCone = (Integer)entry.getKey();
        	 					foundSecond=true;	
        	 				}	
    	 				if(foundFirst&&foundSecond) {
    	 					break;
    	 				}
    	 		    }
    	 			
    	 			System.out.println(originalIndexForFirstCone + " " + originalIndexForSecondCone);
    	 		  



    	 		
    	 	} else {
    	 		
    	 	}
    	 	
        // 
    }
}
