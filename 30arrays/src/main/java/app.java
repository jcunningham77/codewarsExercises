import java.io.*;
import java.util.*;


public class app {

    public static void main(String[] args) {
     	System.out.println("hello");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        in.close();
        for (int i=(n-1);i>=0;i--){
            System.out.print(arr[i] + " ");
        }
    }
}
