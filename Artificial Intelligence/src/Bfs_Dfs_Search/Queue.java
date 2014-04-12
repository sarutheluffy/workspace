/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bfs_Dfs_Search;

import java.util.ArrayList;

/**
 *
 * @author saru
 */
public class Queue {
    ArrayList al;
	 
	public Queue(){
	//	front = 0;
	//	rear = 0;
		al = new ArrayList();
	}	
	
	public void enqueue(String element){
		al.add(element);
	//	rear++;			
	}
	
	public String dequeue(){
		if(al.isEmpty()){
			return(null);
		}
		String str = ""+al.remove(0);
		return(str);//""+al.remove(0)); this gives wrong answer
	}
	public ArrayList getQueue(){
		return(al);
	}
}
