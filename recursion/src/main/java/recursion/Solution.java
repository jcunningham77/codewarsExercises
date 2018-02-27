package recursion;

import java.util.Scanner;

public class Solution {

    static int factorial(int n) {
    		if (n>1) {
    			return n * factorial(n-1);
    		} else {
    			return 1;
    		}
        
    }

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int result = factorial(n);
    System.out.println(result);
    }

}
