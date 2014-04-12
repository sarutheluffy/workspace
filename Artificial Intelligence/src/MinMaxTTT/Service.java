/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MinMaxTTT;

/**
 *
 * @author saru
 */
public class Service {

    int[] board=new int[10];
    int[] sum=new  int[8];
    int player;//=new String();
    
    
    public Service(){
        for(int i=0;i<=10;i++){
            board[i]=2;                    
        }
    }
    
    
    public void multiCheck(){
        sum [0]=board[1]+board[2]+board[3];
	sum [1]=board[4]+board[5]+board[6];
	sum [2]=board[7]+board[8]+board[9];
	sum [3]=board[1]+board[4]+board[7];
	sum [4]=board[2]+board[5]+board[8];
	sum [5]=board[3]+board[6]+board[9];
	sum [6]=board[1]+board[5]+board[9];
	sum [7]=board[3]+board[5]+board[7];
    }
    
     boolean lose(){// return true if player lose
        multiCheck();
        for(int i=0;i<8;i++){
            if(sum[i]==15){
                return true;
            }
        }
        return false;
    }//end of lose fun
    
        boolean win(){//check the player state and return true if he win 
            multiCheck();
            for(int i=0;i<8;i++){
                if(sum[i]==9){
                    return true;
                }
            }
            return false;
    }///end of win 
       
        
        
    int stateScore(int depth){
        /*
         *  this function will return the value of prespective postion i.e
         *  like heristic value, so more the positive value greater is the 
         *  chance of winnig and vice-versa
         */
        if(win()){
            return 100-depth;
        }
        else if(lose()){
            return depth-100;
        }
        return 0;
    }//end of stateScore
    
    int moveGenerator(){//generate all the move that the player can make in board 
        for(int i=1;i<10;i++){
            if(board[i]==2){
                return i;
            }
        }
        return 0;
    }//end of movegenerator
    
    int min_Max(int player ,int[] board, int depth  ){
        int res;
        if (win())
            return 100;
        else if (lose())
            return -10;
        else if(draw())
            return 0;
            for(int i=1;i<=9;i++){
                if(board[i]==2){
                    if(player==2){
                        board[i]=3;
                        res=min_Max(1, board,depth+1);
                        board[i]=2;
                    }//end of player if
                }//end of board if          
            }//end of for loop
            return 0;

        
    }//end of min_Max

    private boolean draw() {
        if(win() || lose()){
            return false;
        }
        return true;
        
    }
}