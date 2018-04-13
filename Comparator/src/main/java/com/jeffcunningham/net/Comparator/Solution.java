package com.jeffcunningham.net.Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator{

	public int compare(Object o1, Object o2) {
		Player player1 = (Player) o1;
		Player player2 = (Player) o2;
		if(player1.score>player2.score) {
			return -1;
		} else if (player2.score>player1.score) {
			return 1;
		} else if (player1.score==player2.score) {
			return player1.name.compareTo(player2.name);
		}
		
		
		return 0;
	}


}

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}