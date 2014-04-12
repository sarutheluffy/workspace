/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MagicTTT;

import java.util.Scanner;

/**
 *
 * @author saru
 */
public class TicTacToeService {
       int position;
       int initialize_Computer,initialize_Player;
       int[] human_Array_Difference=new int[8];
       int[] computer_Array_Difference=new int[8];
       int[] play_Position=new int[10];
       String[] array_Display=new String[10];
       int[] magic_Number_Array=new int[10];
       int[] computer_Play=new int[5];
       int[] player_Play=new int[5];
       Scanner s1=new Scanner(System.in);
       
       
    public void start(){
        position=909;
        initialize_Computer=initialize_Player=0;
        magic_Number_Array[1]=8;
        magic_Number_Array[2]=3;
        magic_Number_Array[3]=4;
        magic_Number_Array[4]=1;
        magic_Number_Array[5]=5;
        magic_Number_Array[6]=9;
        magic_Number_Array[7]=6;
        magic_Number_Array[8]=7;
        magic_Number_Array[9]=2;
        play_Position[0]=0;
        for(int i=1;i<10;i++){
            play_Position[i]=2;
        }
        for(int i=0;i<5;i++){
            computer_Play[i]=-40;
            player_Play[i]=-40;
        }
        
        
        for(int i=0;i<10;i++){
            array_Display[i]=" ";
        }//end of for loop
    }//end of TTTservice constructor
       
    public void tictactoeAlgo(String player){
        int turn;
        while(true){
        System.out.println("Enter \"1\" if you wanna play first or Enter \"2\" for second:\n\n");
        turn=s1.nextInt();
        if(turn==2 || turn==1){
            break;
        }
        }
         int win=0;
        for(int i=turn;i<=10;i=i+2){
            if(win==1){
                break;
            }
        switch(i){
            case 1:
                playHuman(player);
                if(play_Position[5]==2){
			go(5);
                }
		else{
                    go(1);
                }
             printBoard();
             break;
            case 2:
                go(5);
                printBoard();
                playHuman(player);
                break;
            case 3:
                playHuman(player);
                if(blockHuman()){
                break;
                }
                if(play_Position[5]==3){
			go(3);
                        printBoard();
                }
                else if((play_Position[4]==3&&play_Position[9]==3)||(play_Position[1]==3&&play_Position[8]==3)||(play_Position[6]==3&&play_Position[8]==3)){
                            go(7);
                        printBoard();
                        break;
                        }
                        else if(play_Position[6]==3&&play_Position[7]==3 || play_Position[3]==3&&play_Position[8]==3){
                            go(9);
                            printBoard();
                            break;
                        }
                        else if(play_Position[3]==3&&play_Position[7]==3){
                            go(2);
                            printBoard();
                                    
                        }
			else {
                                fillBoard();
                                
                            printBoard();}
               
            break;               
                
            case 4:
                if(play_Position[1]==3){
                go(3);
                printBoard();
                playHuman(player);
                break;
                }
                else if(play_Position[2]==3){
                    System.out.println("sooner of later u r gonna lose buddy");
                     go(7);
                      printBoard();
                      playHuman(player);
                break;
                }
                else{
                fillBoard();
                printBoard();
                playHuman(player);
                }
                break;
            case 5:
                playHuman(player);
                if(computerWin()){
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                    break;
                }
                else if(blockHuman()){
                    break;
                }
                else{
                    fillBoard();
                    printBoard();
                }
            break;
            case 6:
                if(computerWin()){
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                    break;
                }
                else if(blockHuman()){
                    break;
                }
                else{
                    fillBoard();
                    printBoard();
                }
                break;
              
            case 7:
                playHuman(player);
                if(computerWin()){
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                    break;
                }
                else if(blockHuman()){
                    break;
                }
                else{
                    fillBoard();
                    printBoard();
                }
            break;
            case 8:
                //playHuman(player);
                if(computerWin()){
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                    break;
                }
                else if(blockHuman()){
                    break;
                }
                else{
                    fillBoard();
                    printBoard();
                }
            break;
            case 9:
                playHuman(player);
                printBoard();
                System.out.println("Its a tie better try next time ");
                break;
            case 10:
                playHuman(player);
                if(computerWin()){
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                }
                else if(blockHuman()){
                    System.out.println("it's a tie:");
                }
                else{
                    fillBoard();
                    printBoard();
                    System.out.println("it's a tie:");
                }
            break;
            }
        }        
    }

    private void playHuman(String player) {
        while(true){
        System.out.println(player+" move:");
        position=s1.nextInt();
        if(position>=1 || position<=9 ){
            break;
        }
        else{
            System.out.println("You Entered Wrong Board postion Please try again:\n");
            showBoard();
        }
        }//end of while
        if(play_Position[position]==2){
            play_Position[position]=3;
            player_Play[initialize_Player]=magic_Number_Array[position];
            initialize_Player++;
        }
        else{
            System.out.println("wrong move buddy Enter again:");
            playHuman(player);
        }       
   }//end of playHuman

    public void showBoard() {
        System.out.println(" 1 | 2 | 3");
        System.out.println("--- --- ---");
	System.out.println(" 4 | 5 | 6");
        System.out.println("--- --- ---");
	System.out.println(" 7 | 8 | 9");
    }

    private void printBoard() {
        System.out.println("player='x'\tcomputer='O'");
        for(int i=1;i<10;i++){
			if(play_Position[i]==3){
				array_Display[i]="X";
			}
                        if(play_Position[i]==5){
				array_Display[i]="O";
			}
		}
		System.out.println(" "+array_Display[1]+" | "+array_Display[2]+" | "+array_Display[3]);
		System.out.println("--- --- ---");
		System.out.println(" "+array_Display[4]+" | "+array_Display[5]+" | "+array_Display[6]);
		System.out.println("--- --- ---");
		System.out.println(" "+array_Display[7]+" | "+array_Display[8]+" | "+array_Display[9]);
        
    }

    private void go(int i) {
        play_Position[i]=5;
        computer_Play[initialize_Computer]=magic_Number_Array[i];
        initialize_Computer++;
    }

    private void check() {
                human_Array_Difference[0]=15-(player_Play[0]+player_Play[1]);
                human_Array_Difference[1]=15-(player_Play[0]+player_Play[2]);
                human_Array_Difference[2]=15-(player_Play[0]+player_Play[3]);
                human_Array_Difference[3]=15-(player_Play[1]+player_Play[2]);
                human_Array_Difference[4]=15-(player_Play[1]+player_Play[3]);
                human_Array_Difference[5]=15-(player_Play[2]+player_Play[3]);
    
                computer_Array_Difference[0]=15-(computer_Play[0]+computer_Play[1]);
                computer_Array_Difference[1]=15-(computer_Play[0]+computer_Play[2]);
                computer_Array_Difference[2]=15-(computer_Play[0]+computer_Play[3]);
                computer_Array_Difference[3]=15-(computer_Play[1]+computer_Play[2]);
                computer_Array_Difference[4]=15-(computer_Play[1]+computer_Play[3]);
                computer_Array_Difference[5]=15-(computer_Play[2]+computer_Play[3]);
    } 
    
    
    private boolean computerWin(){
         boolean result=false;
        check();
      
    for(int i=0;i<=5;i++){
        if(computer_Array_Difference[i]>0 && computer_Array_Difference[i]<10){
            for(int j=1;j<=9;j++){
               if(computer_Array_Difference[i]==magic_Number_Array[j]){
                   position=j;

            if(play_Position[position]==2){
                //result=true;
                go(position);
                printBoard();
                return true;
                    }
               }
            }
        }
    }
    return false;
    }

    private boolean blockHuman(){
        check();
         for(int i=0;i<=5;i++){
            if(human_Array_Difference[i]>0&&human_Array_Difference[i]<10){
                for(int j=1;j<=9;j++){
                    if(human_Array_Difference[i]==magic_Number_Array[j]){
                        position=j;

                    if(play_Position[position]==2){
                        go(position);
                        printBoard();
                        return true;
                        }
                    }
                }
            }
        }
    return false;
   }
    
    void fillBoard(){
		for(int i=1;i<=9;i++){
			if(play_Position[i]==2){
				go(i);
				break;
			}
		}		
	}
}
