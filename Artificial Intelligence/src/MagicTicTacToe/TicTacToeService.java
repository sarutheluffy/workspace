/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MagicTicTacToe;

import java.util.Scanner;

/**
 *
 * @author saru
 */
public class TicTacToeService {
       int[] humanD=new int[8];
       int[] computerD=new int[8];
       String[] arrayShow=new String[10];
       int[] humanPos=new int[10];
       int[] computerPos=new int[10];
       int[] magicNumber=new int[10];
       Scanner s1=new Scanner(System.in);
       
        
    public void start(){
        magicNumber[1]=8;
        magicNumber[2]=3;
        magicNumber[3]=4;
        magicNumber[4]=1;
        magicNumber[5]=5;
        magicNumber[6]=9;
        magicNumber[7]=6;
        magicNumber[8]=7;
        magicNumber[9]=2;
        for(int i=0;i<=9;i++){
            humanPos[i]=0;
            computerPos[i]=0;
            arrayShow[i]=" ";
           }
    }
    
    
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
                if(humanPos[5]!=0){
			go(1);
                }
		else{
                    go(5);
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
                printBoard();
                break;
                }
                else if(humanPos[1]>0 && humanPos[8]>0){
                    go(7);
                    printBoard();
                }
                else if(humanPos[5]>0 && humanPos[9]>0){
                    go(3);
                    printBoard();
                }
                else if(humanPos[2]>0 && humanPos[9]>0){
                    go(3);
                    printBoard();
                }
                else if(humanPos[3]>0 && humanPos[8]>0){
                    go(9);
                    printBoard();
                }
                else{
                    fillBoard();
                    printBoard();
                }
            break;               
                
            case 4:
                fillBoard();
                printBoard();
                playHuman(player);
                break;
            case 5:
                playHuman(player);
                if(computerWin()){
                    printBoard();
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                    break;
                }
                else if(blockHuman()){
                    printBoard();
                    break;
                }
                else{
                    fillBoard();
                    printBoard();
                }
            break;
            case 6:
                if(computerWin()){
                    printBoard();
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                    break;
                }
                else if(blockHuman()){
                    printBoard();
                    break;
                }
                 else if(humanPos[1]>0 && humanPos[8]>0){
                    //System.out.println("hi u the herfhsf");
                    go(7);
                    printBoard();
                }
                else if(humanPos[5]>0 && humanPos[9]>0){
                    go(3);
                    printBoard();
                }
                else if(humanPos[2]>0 && humanPos[9]>0){
                    go(3);
                    printBoard();
                }
                else if(humanPos[2]>0 && humanPos[7]>0){
                    go(7);
                    printBoard();
                }
                else if(humanPos[3]>0 && humanPos[8]>0){
                    go(9);
                    printBoard();
                }
                else{
                    fillBoard();
                    printBoard();
                }
                
            break;
              
            case 7:
                playHuman(player);
                if(computerWin()){
                    printBoard();
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                    break;
                }
                else if(blockHuman()){
                    printBoard();
                    break;
                }
                else{
                    fillBoard();
                    printBoard();
                }
            break;
            case 8:
                playHuman(player);
                if(computerWin()){
                    printBoard();
                    System.out.println("LOL u lose this GAME try next time");
                    win=1;
                    break;
                }
                else if(blockHuman()){
                    printBoard();
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
                fillBoard();
                printBoard();
                System.out.println("Its a tie");
                break;
            }
        }        
    }

    private void playHuman(String player) {
        int position =5445;
        while(true){
        System.out.println(player+" move:");
        position=s1.nextInt();
        if(position>1 || position<9 ){
            break;
        }
        else{
            System.out.println("You Entered Wrong Board postion Please try again:\n");
            showBoard();
        }
        }
        if(computerPos[position]>0){
            System.out.println("Entered Position already occupies Try again\n");
            playHuman(player);
        }
        else{
           humanPos[position]=magicNumber[position]; 
            //System.out.println(humanPos[position]);
        }       
   }

    public void showBoard() {
        System.out.println(" 1 | 2 | 3");
        System.out.println("--- --- ---");
	System.out.println(" 4 | 5 | 6");
        System.out.println("--- --- ---");
	System.out.println(" 7 | 8 | 9");
    }

    private void printBoard() {
        for(int i=1;i<10;i++){
			if(humanPos[i]==magicNumber[i]){
				arrayShow[i]="X";
			}
                        if(computerPos[i]==magicNumber[i]){
				arrayShow[i]="O";
			}
		}
		System.out.println(" "+arrayShow[1]+" | "+arrayShow[2]+" | "+arrayShow[3]);
		System.out.println("--- --- ---");
		System.out.println(" "+arrayShow[4]+" | "+arrayShow[5]+" | "+arrayShow[6]);
		System.out.println("--- --- ---");
		System.out.println(" "+arrayShow[7]+" | "+arrayShow[8]+" | "+arrayShow[9]);
        
    }

    private void go(int i) {
        computerPos[i]=magicNumber[i];
    }

    private void check() {
            humanD[0]=15-(humanPos[1]+humanPos[2]+humanPos[3]);
            humanD[1]=15-(humanPos[4]+humanPos[5]+humanPos[6]);
            humanD[2]=15-(humanPos[7]+humanPos[8]+humanPos[9]);
            humanD[3]=15-(humanPos[1]+humanPos[5]+humanPos[9]);
            humanD[4]=15-(humanPos[1]+humanPos[4]+humanPos[7]);
            humanD[5]=15-(humanPos[2]+humanPos[5]+humanPos[8]);
            humanD[6]=15-(humanPos[3]+humanPos[5]+humanPos[7]);
            humanD[7]=15-(humanPos[3]+humanPos[6]+humanPos[9]);
    
            computerD[0]=15-(computerPos[1]+computerPos[2]+computerPos[3]);
            computerD[1]=15-(computerPos[4]+computerPos[5]+computerPos[6]);
            computerD[2]=15-(computerPos[7]+computerPos[8]+computerPos[9]);
            computerD[3]=15-(computerPos[1]+computerPos[5]+computerPos[9]);
            computerD[4]=15-(computerPos[1]+computerPos[4]+computerPos[7]);
            computerD[5]=15-(computerPos[2]+computerPos[5]+computerPos[8]);
            computerD[6]=15-(computerPos[3]+computerPos[5]+computerPos[7]);
            computerD[7]=15-(computerPos[3]+computerPos[6]+computerPos[9]);
    } 
    
    
    private boolean computerWin(){
          check();
        boolean result = false;
            for(int i=0;i<8;i++ ){
                if(computerD[i]>9 || computerD[i]<1){
                    continue;
                }
                if(i==0){
                    if(magicNumber[1]==computerD[i] && humanPos[1]==0){
                        go(1);
                        result = true;
                        break;
                    }
                    else if(magicNumber[2]==computerD[i] && humanPos[2]==0){
                        go(2);
                        result = true;
                        break;
                    }
                    else if(magicNumber[3]==computerD[i] && humanPos[3]==0){
                        go(3);
                        result = true;
                        break;
                    }
                }
                
                else if(i==1){
                    if(magicNumber[4]==computerD[i] && humanPos[4]==0){
                        go(4);
                        result = true;
                        break;
                    }
                    else if(magicNumber[5]==computerD[i] && humanPos[5]==0){
                        go(5);
                        result = true;
                        break;
                    }
                    else if(magicNumber[6]==computerD[i] && humanPos[6]==0){
                        go(6);
                        result = true;
                        break;
                    }
                }
                 
                   else if(i==2){
                    if(magicNumber[7]==computerD[i] && humanPos[7]==0){
                        go(7);
                        result = true;
                        break;
                    }
                    else if(magicNumber[8]==computerD[i] && humanPos[8]==0){
                        go(8);
                        result = true;
                        break;
                    }
                    else if(magicNumber[9]==computerD[i]  && humanPos[9]==0){
                        go(9);
                        result = true;
                        break;
                    }
                }
                else if(i==3){
                    if(magicNumber[1]==computerD[i] && humanPos[1]==0){
                        go(1);
                        result = true;
                        break;
                    }
                    else if(magicNumber[5]==computerD[i]  && humanPos[5]==0){
                        go(5);
                        result = true;
                        break;
                    }
                    else if(magicNumber[9]==computerD[i] && humanPos[9]==0){
                        go(9);
                        result = true;
                        break;
                    }
                }
                else if(i==4){
                    if(magicNumber[1]==computerD[i] && humanPos[1]==0){
                        go(1);
                        result = true;
                        break;
                    }
                    else if(magicNumber[4]==computerD[i] && humanPos[4]==0){
                        go(4);
                        result = true;
                        break;
                    }
                    else if(magicNumber[7]==computerD[i] && humanPos[7]==0){
                        go(7);
                        result = true;
                        break;
                    }
                }
                else if(i==5){
                    if(magicNumber[2]==computerD[i] && humanPos[2]==0){
                        go(2);
                        result = true;
                        break;
                    }
                    else if(magicNumber[5]==computerD[i] && humanPos[5]==0){
                        go(5);
                        result = true;
                        break;
                    }
                    else if(magicNumber[8]==computerD[i] && humanPos[8]==0){
                        go(8);
                        result = true;
                        break;
                    }
                }
                else if(i==6){
                    if(magicNumber[3]==computerD[i] && humanPos[3]==0){
                        go(3);
                        result = true;
                        break;
                    }
                    else if(magicNumber[5]==computerD[i] && humanPos[5]==0){
                        go(5);
                        result = true;
                        break;
                    }
                    else if(magicNumber[7]==computerD[i] && humanPos[7]==0){
                        go(7);
                        result = true;
                        break;
                    }
                }
                else if(i==7){
                    if(magicNumber[3]==computerD[i] && humanPos[3]==0){
                        go(3);
                        result = true;
                        break;
                    }
                    else if(magicNumber[6]==computerD[i] && humanPos[6]==0){
                        go(6);
                        result = true;
                        break;
                    }
                    else if(magicNumber[9]==computerD[i] && humanPos[9]==0){
                        go(9);
                        result = true;
                        break;
                    }
                }
                
            }
        
        return result;
    
    }
    private boolean blockHuman(){
        check();
        boolean result = false;
            for(int i=0;i<8;i++ ){
                if(humanD[i]>9 || humanD[i]<1){
                    continue;
                }
                if(i==0){
                    if(magicNumber[1]==humanD[i] && computerPos[1]==0){
                        go(1);
                        result = true;
                        break;
                    }
                    else if(magicNumber[2]==humanD[i] && computerPos[2]==0){
                        go(2);
                        result = true;
                        break;
                    }
                    else if(magicNumber[3]==humanD[i] && computerPos[3]==0){
                        go(3);
                        result = true;
                        break;
                    }
                }
                
                else if(i==1){
                    if(magicNumber[4]==humanD[i] && computerPos[4]==0){
                        go(4);
                        result = true;
                        break;
                    }
                    else if(magicNumber[5]==humanD[i] && computerPos[5]==0){
                        go(5);
                        result = true;
                        break;
                    }
                    else if(magicNumber[6]==humanD[i] && computerPos[6]==0){
                        go(6);
                        result = true;
                        break;
                    }
                }
                 
                   else if(i==2){
                    if(magicNumber[7]==humanD[i] && computerPos[7]==0){
                        go(7);
                        result = true;
                        break;
                    }
                    else if(magicNumber[8]==humanD[i] && computerPos[8]==0){
                        go(8);
                        result = true;
                        break;
                    }
                    else if(magicNumber[9]==humanD[i]  && computerPos[9]==0){
                        go(9);
                        result = true;
                        break;
                    }
                }
                else if(i==3){
                    if(magicNumber[1]==humanD[i] && computerPos[1]==0){
                        go(1);
                        result = true;
                        break;
                    }
                    else if(magicNumber[5]==humanD[i]  && computerPos[5]==0){
                        go(5);
                        result = true;
                        break;
                    }
                    else if(magicNumber[9]==humanD[i] && computerPos[9]==0){
                        go(9);
                        result = true;
                        break;
                    }
                }
                else if(i==4){
                    if(magicNumber[1]==humanD[i] && computerPos[1]==0){
                        go(1);
                        result = true;
                        break;
                    }
                    else if(magicNumber[4]==humanD[i] && computerPos[4]==0){
                        go(4);
                        result = true;
                        break;
                    }
                    else if(magicNumber[7]==humanD[i] && computerPos[7]==0){
                        go(7);
                        result = true;
                        break;
                    }
                }
                else if(i==5){
                    if(magicNumber[2]==humanD[i] && computerPos[2]==0){
                        go(2);
                        result = true;
                        break;
                    }
                    else if(magicNumber[5]==humanD[i] && computerPos[5]==0){
                        go(5);
                        result = true;
                        break;
                    }
                    else if(magicNumber[8]==humanD[i] && computerPos[8]==0){
                        go(8);
                        result = true;
                        break;
                    }
                }
                else if(i==6){
                    if(magicNumber[3]==humanD[i] && computerPos[3]==0){
                        go(3);
                        result = true;
                        break;
                    }
                    else if(magicNumber[5]==humanD[i] && computerPos[5]==0){
                        go(5);
                        result = true;
                        break;
                    }
                    else if(magicNumber[7]==humanD[i] && computerPos[7]==0){
                        go(7);
                        result = true;
                        break;
                    }
                }
                else if(i==7){
                    if(magicNumber[3]==humanD[i] && computerPos[3]==0){
                        go(3);
                        result = true;
                        break;
                    }
                    else if(magicNumber[6]==humanD[i] && computerPos[6]==0){
                        go(6);
                        result = true;
                        break;
                    }
                    else if(magicNumber[9]==humanD[i] && computerPos[9]==0){
                        go(9);
                        result = true;
                        break;
                    }
                }
                
            }
        
        return result;
    }
    
    void fillBoard(){
		for(int i=1;i<=9;i++){
			if(humanPos[i]==0 && computerPos[i]==0){
				computerPos[i]=magicNumber[i];
				break;
			}
		}		
	}
}
