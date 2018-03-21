package com.jeffcunningham.org.RansomNote;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class App {

    public static void main(String[] args) {
    	
    		String result = "Yes";
    	
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        //load all magazine strings into a hashTable. Use the strings as the value, and insert a Integer as the Key
        Hashtable magazineHashTable = new Hashtable();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
        		magazineHashTable.put(new Integer(magazine_i), magazine[magazine_i]);
        }        
        
        
        //iterate through the array of ransom string; if the current value exists in the hashtable, remove it
        //it can be removed by the following manner:
        //loop through all the values 
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            if(magazineHashTable.containsValue(ransom[ransom_i])) {
            		Integer key;
            		Set<Map.Entry> entries = magazineHashTable.entrySet();
                for(Map.Entry entry: entries ){
                    if(ransom[ransom_i].equals(entry.getValue())){
                        key = (Integer)entry.getKey();
                        magazineHashTable.remove(key);
                        
                        break; //breaking because its one to one map
                    }
                }


        
            		
            }else {
            		result="No";
            		break;
            }
        }        
        
        
        System.out.println(result);
        
        
        
    }
}
