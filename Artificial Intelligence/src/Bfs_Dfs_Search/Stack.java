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
public class Stack {
    int top;//index of lest element in stack
	ArrayList al;
	
	Stack(){
		top = -1;
		al = new ArrayList();
	}
	
	public void push(String element){
		al.add(element);
		top = al.size()-1;
	}
	
	public String pop(){
		if(top == -1)
		{
			return(null);
		}
		String element = ""+al.remove(top);
		top = al.size()-1;
		return(element);		
	}//end of pop()
	public void pop(String element){
		al.remove(element);
		top = al.size()-1;
	}
	
	public ArrayList getStack(){
		return(al);
	}
}
