package TicTacToe;

import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
*/
class Demo{
	Scanner s1=new Scanner(System.in);
	int[] arrayPos=new int[12];
	String[] arrayShow=new String[12];
	int[] check=new int[10];
	Demo(){
		for(int i=0;i<10;i++){
			arrayShow[i]=" ";
			arrayPos[i]=2;
		}
	}
	
	
	void check(){
		check[0]=arrayPos[1]*arrayPos[2]*arrayPos[3];
		check[1]=arrayPos[4]*arrayPos[5]*arrayPos[6];
		check[2]=arrayPos[7]*arrayPos[8]*arrayPos[9];
		check[3]=arrayPos[1]*arrayPos[4]*arrayPos[7];
		check[4]=arrayPos[2]*arrayPos[5]*arrayPos[8];
		check[5]=arrayPos[3]*arrayPos[6]*arrayPos[9];
		check[6]=arrayPos[1]*arrayPos[5]*arrayPos[9];
		check[7]=arrayPos[3]*arrayPos[5]*arrayPos[7];
	}
	
	public void move(int pos){
		if(arrayPos[pos]==2){
			arrayPos[pos]=3;
		}
		else
			System.out.println(": Wrong move :");
			playHuman();
	}
	void go(int pos){
		arrayPos[pos]=5;
	}
	
	
	void occupie(){
		for(int i=1;i<=9;i++){
			if(arrayPos[i]==2){
				arrayPos[i]=5;
				break;
			}
		}		
	}
	
	
	public void playHuman(){
		int position=213;
		while(position>9 || position<1){
		System.out.println("enter the position: ");
		position=s1.nextInt();
		if(position>9 || position<1){
		  System.out.println("::::::::Wrong move:::::::");
		  }/*
		  else{
		    break;
		  }*/
		}
		if(arrayPos[position]==2){
			arrayPos[position]=3;
		}
		else{
			System.out.println(": ******** Wrong move ****** :");
			playHuman();
			}
	}
	
	
	public void printBoard(){
		for(int i=1;i<10;i++){
			if(arrayPos[i]==3){
				arrayShow[i]="X";
			}
			if(arrayPos[i]==5){
				arrayShow[i]="O";
			}
		}
		System.out.println(" "+arrayShow[1]+" | "+arrayShow[2]+" | "+arrayShow[3]);
		System.out.println("--- --- ---");
		System.out.println(" "+arrayShow[4]+" | "+arrayShow[5]+" | "+arrayShow[6]);
		System.out.println("--- --- ---");
		System.out.println(" "+arrayShow[7]+" | "+arrayShow[8]+" | "+arrayShow[9]);		
	}
	public void printBoard1(){
		System.out.println(" 1 | 2 | 3");
		System.out.println("--- --- ---");
		System.out.println(" 4 | 5 | 6");
		System.out.println("--- --- ---");
		System.out.println(" 7 | 8 | 9");	
	}
	boolean block(){
		check();
		boolean value=false;
		if(check[0]==18){
			if(arrayPos[1]==2){
				arrayPos[1]=5;
			}
			else if(arrayPos[2]==2){
				arrayPos[2]=5;
			}
			else {
				arrayPos[3]=5;
				}
			value=true;
			
		}
		else if(check[1]==18){
			if(arrayPos[4]==2){
				arrayPos[4]=5;
			}
			else if(arrayPos[5]==2){
				arrayPos[5]=5;
			}
			else {
				arrayPos[6]=5;
				}
			value=true;
		}
		else if(check[2]==18){
			if(arrayPos[7]==2){
				arrayPos[7]=5;
			}
			else if(arrayPos[8]==2){
				arrayPos[8]=5;
			}
			else {
				arrayPos[9]=5;
				}
			value=true;
		}
		else if(check[3]==18){
			
			if(arrayPos[1]==2){
				arrayPos[1]=5;
			}
			else if(arrayPos[4]==2){
				arrayPos[4]=5;
			}
			else {
				arrayPos[7]=5;
				}
			value=true;
		}
		else if(check[4]==18){
			if(arrayPos[2]==2){
				arrayPos[2]=5;
			}
			else if(arrayPos[5]==2){
				arrayPos[5]=5;
			}
			else {
				arrayPos[8]=5;
				}
			value=true;
		}
		else if(check[5]==18){
			if(arrayPos[3]==2){
				arrayPos[3]=5;
			}
			else if(arrayPos[6]==2){
				arrayPos[6]=5;
			}
			else {
				arrayPos[9]=5;
				}
			value=true;
		}
		else if(check[6]==18){
			if(arrayPos[1]==2){
				arrayPos[1]=5;
			}
			else if(arrayPos[5]==2){
				arrayPos[5]=5;
			}
			else {
				arrayPos[9]=5;
				}
			value=true;
		}
		else if(check[7]==18){
			if(arrayPos[3]==2){
				arrayPos[3]=5;
			}
			else if(arrayPos[5]==2){
				arrayPos[5]=5;
			}
			else {
				arrayPos[7]=5;
				}
			value=true;
		}
		return value;
	}
	
	boolean posWin(){
		boolean value=false;
		check();
		if(check[0]==50){
			if(arrayPos[1]==2){
				arrayPos[1]=5;
			}
			else if(arrayPos[2]==2){
				arrayPos[2]=5;
			}
			else {
				arrayPos[3]=5;
				}
			value=true;
		}
		else if(check[1]==50){
			if(arrayPos[4]==2){
				arrayPos[4]=5;
			}
			else if(arrayPos[5]==2){
				arrayPos[5]=5;
			}
			else {
				arrayPos[6]=5;
				}
			value=true;
			}
		else if(check[2]==50){
			if(arrayPos[7]==2){
				arrayPos[7]=5;
			}
			else if(arrayPos[8]==2){
				arrayPos[8]=5;
			}
			else {
				arrayPos[9]=5;
				}
			value=true;
		}
		else if(check[3]==50){
			if(arrayPos[1]==2){
				arrayPos[1]=5;
			}
			else if(arrayPos[4]==2){
				arrayPos[4]=5;
			}
			else {
				arrayPos[7]=5;
				}
			value=true;
		}
		
		else if(check[4]==50){
			if(arrayPos[2]==2){
				arrayPos[2]=5;
			}
			else if(arrayPos[5]==2){
				arrayPos[5]=5;
			}
			else {
				arrayPos[8]=5;
				}
			value=true;
		}
		else if(check[5]==50){
			if(arrayPos[3]==2){
				arrayPos[3]=5;
			}
			else if(arrayPos[6]==2){
				arrayPos[6]=5;
			}
			else {
				arrayPos[9]=5;
				}
			value=true;
		}
		else if(check[6]==50){
			if(arrayPos[1]==2){
				arrayPos[1]=5;
			}
			else if(arrayPos[5]==2){
				arrayPos[5]=5;
			}
			else {
				arrayPos[9]=5;
				}
			value=true;
		}
		else if(check[7]==50){
			if(arrayPos[3]==2){
				arrayPos[3]=5;
			}
			else if(arrayPos[5]==2){
				arrayPos[5]=5;
			}
			else {
				arrayPos[9]=5;
				}
			value=true;
		}
		return value;
		}
		
	
	public void algo(){
		int a;
		while(true){
		System.out.println("would you like to play first(\"Enter 1\") or second(\"Enter 2\")");
		a=s1.nextInt();
		if(a==1 || a==2){
		break;
		}
		else{
		 System.out.println("wrong choice Enter again");
		}
		}
		int checkWin=0;
		for(int i=a;i<=10;i=i+2){
		      
			switch(i){
			case 1:
				playHuman();
				if(arrayPos[5]==3){
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
				playHuman();
				break;
			case 3:
				playHuman();
				if(block()){
					
					printBoard();
					break;
				}
				if(arrayPos[2]==3 || arrayPos[4]==3 && arrayPos[1]==2){
					go(1);
					
				}
				else if(arrayPos[8]==3 || arrayPos[6]==3 && arrayPos[9]==2){
					go(9);
				}
				else if(arrayPos[1]==3 || arrayPos[9]==3 ){
					go(4);
				}
				else if(arrayPos[3]==3 || arrayPos[7]==3 && arrayPos[6]==2){
					go(6);
				}
				else{
					occupie();
				}
				printBoard();
				break;
			case 4:
				if(arrayPos[2]==3 || arrayPos[4]==3 && arrayPos[1]==2){
					go(1);
					}
				else if(arrayPos[6]==3 || arrayPos[8]==3 && arrayPos[9]==2){
					go(9);
					}
				else if(arrayPos[9]==3 || arrayPos[1]==3) {
					go(3);
				}
				else{
					occupie();
				}
				printBoard();
				playHuman();
				break;
				
			case 5:
				playHuman();
				if(posWin()){
					
					printBoard();
					System.out.println("********YOU LOSE*********");
					checkWin=1;
					break;
				}
				if(block()){
					printBoard();
					break;
				}
				occupie();
				printBoard();
				break;
			case 6:
				if(posWin()) {
					printBoard();
					System.out.println("********YOU LOSE*********");
					checkWin=1;
					break;
				}
				if(block()){
					printBoard();
					break;
				}
				if(arrayPos[7]==2){
					go(7);
					printBoard();
				}
				else{
					go(3);
					
					printBoard();
				}		
				break;
			case 7:
				if(checkWin==1){
				break;
				}
				playHuman();
				if(posWin()) {
					printBoard();
					System.out.println("********YOU LOSE*********");
					checkWin=1;
					break;
				}
				if(block()){
					printBoard();
					break;
				}
				occupie();
				printBoard();
				break;
				
			case 8:	
				if(checkWin==1){
				break;
				}
				playHuman();	
				if(posWin()) {
					printBoard();
					System.out.println("********YOU LOSE*********");
					checkWin=1;
					break;
				}
				if(block()){
					printBoard();
					break;
				}
				occupie();
				printBoard();
				break;
			case 9:
				if(checkWin==1){
				  break;
				}
				playHuman();
				printBoard();
				System.out.println("It's a tie: try again");
				break;
			case 10:
			    if(checkWin==1){
			    break;
			    }
			    playHuman();
			    if(posWin()) {
					printBoard();
					System.out.println("********YOU LOSE*********");
					checkWin=1;
					break;
				}
				if(block()){
					printBoard();
					System.out.println("It's a tie: try again");
					break;
				}
				occupie();
				printBoard();
				System.out.println("It's a tie: try again");
				break;
			    
				
				}
			
			    
			}
		}
	}

public class TicTacToe{
	public static void main(String[] arg){
		Demo objDemo=new Demo();
		objDemo.printBoard1();
		objDemo.algo();
	}
}