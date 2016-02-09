package OX;

import java.io.IOException;
import java.util.Scanner;

public class OXImperative {
    public static void main(String[] args) {
        int[] table = new int[9];
        boolean winner;
        int movesCounter, field, playerWhoWinsTheGame;
        String typed;
        Scanner in = new Scanner(System.in);


        games:
        while (true){
            //set up the game
            try {
                Runtime.getRuntime().exec("clear");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Welcome in Tic-tac-toe game!");
            System.out.println();
            System.out.println();
            System.out.println("NEW GAME");
            System.out.println();
            for (int x = 0; x < table.length; x++) {
                table[x] = 0;
            }
            winner=false;
            movesCounter=0;
            playerWhoWinsTheGame=0;

            while (!winner || movesCounter<9){
                for (int x = 0; x < table.length; x++) {
                    if (table[x]==1) System.out.print("X");
                    else if (table[x]==-1) System.out.print("O");
                    else System.out.print((x+1));
                    if ((x+1)%3!=0) System.out.print("|");
                    else System.out.println("");
                }
                System.out.println("Player " + (movesCounter%2+1)+".");
                System.out.println("Choose field:");
                typed = in.next();
                if (typed.equals("exit")) break games;
                if (typed.replaceAll("[^0-9]","").length()<typed.length()){
                    System.out.println("You should type only one digit.");
                    continue;
                }
                else if (typed.length()>1 || typed.equals("0")){
                    System.out.println("You can type a digit in range from 1 to 9.");
                    continue;
                }
                field = Integer.parseInt(typed);
                if (table[field-1]!=0) continue;
                if (movesCounter%2==0) table[field-1]=1;
                else table[field-1]=-1;
                if ((table[0]== table[1] && table[1]== table[2] && table[0]!=0) ||
                        (table[3]== table[4] && table[4]== table[5] && table[3]!=0) ||
                        (table[6]== table[7] && table[7]== table[8] && table[6]!=0) ||
                        (table[0]== table[3] && table[3]== table[6] && table[0]!=0) ||
                        (table[1]== table[4] && table[4]== table[7] && table[1]!=0) ||
                        (table[2]== table[5] && table[5]== table[8] && table[2]!=0) ||
                        (table[0]== table[4] && table[4]== table[8] && table[0]!=0) ||
                        (table[2]== table[4] && table[4]== table[6] && table[2]!=0)
                        ) winner =true;
                movesCounter++;
                if (winner) {
                    playerWhoWinsTheGame = movesCounter%2+1;
                    break;
                }
                else if (movesCounter==9){
                    break;
                }
            }
            System.out.println("koniec");
            if (playerWhoWinsTheGame!=0) System.out.println("Player " + playerWhoWinsTheGame + " has won.");
        }
    }

}
