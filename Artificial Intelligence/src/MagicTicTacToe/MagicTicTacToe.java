package MagicTicTacToe;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author saru
 */
public class MagicTicTacToe {
    public static void main(String arg[]){
         TicTacToeService obj=null;
        
         Scanner in =null;
         Player player=null;
        try{
            in=new Scanner(System.in);
            obj=new TicTacToeService();
            player=new Player();
            System.out.println("Enter the name of player");
            String playerName = in.nextLine();
            player.setName(playerName);
            obj.showBoard();
        while(true){
        obj.start();
        obj.tictactoeAlgo(player.getName());
            System.out.println("\n\n\nDo u wanna Lose:\n\"press 1 to continue\n\"press any other key to exit\n");
            int choice=new Scanner(System.in).nextInt();
            if(choice!=1){
                break;
            }
        }
        }
        catch(Exception e){
            System.out.println("the error is "+e.getMessage());
        }
        
       
    }    
}
