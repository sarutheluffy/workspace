/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bfs_Dfs_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author saru
 */
public class Main {
    static Queue bfs_children = null;
    static Stack dfs_children = null;
    static Queue traversed = null;
    static BufferedReader brk=null;
    static ArrayList[] list=null;
    static int no_of_nodes;
    //static Services obj=new Services();
    public static void main(String arg[]){
        
    try {
        brk=new BufferedReader(new InputStreamReader(System.in));
       getGraph();
       printList();
       do{
        System.out.println("Enter \n1 to traverse by bfs\n2 to traverse using dfs\n3 to exist");
        int choice = Integer.parseInt(brk.readLine());
        switch(choice){
            case 1:
                traversed = new Queue();
                bfs_children=new Queue();
                System.out.println("Enter the starting node where you want to start the search:");
                bfs(brk.readLine(),0);
               // System.out.println(traversed.getQueue());
                print_traversal(traversed.getQueue());
                break;
            case 2:
                traversed = new Queue();
                dfs_children=new Stack();
                System.out.println("Enter the starting node where you want to start the search:");
                dfs(brk.readLine(),0);
                print_traversal(traversed.getQueue());
                break;
            case 3:
                System.exit(0);
            default :
                System.out.println("sorry Wrong choice ");
                break;
                
        }//end of switch
       }while(true);//and of do
        
        
    }
    catch(Exception e){
            System.out.println("the exception occur is :"+e.getMessage());
    }
}//end of psvm
    
    
    protected static void bfs(String start_node, int n) {
        if (n == (no_of_nodes + 1)) {
            return;
        }
        traversed.enqueue(start_node);
        n++;

        int start_index = getIndex(start_node);

        //from 1 bcoz at 0  index exists the parent already which has been added to queue traversed
        for (int i = 1; i < list[start_index].size(); i++) {
			//adds to queue all the child nodes of start_node

            String child = (String) list[start_index].get(i);
            //checks by matching if child has already been once traversed
            if(!ifNodeExists(child, bfs_children.getQueue())) {
                if (!ifNodeExists(child, traversed.getQueue())) {
                    bfs_children.enqueue(child);
                } 
            }

        }//end of loop i

		//value of n increaes each time an enqueue operation is carried out on traverse queue
        String str = bfs_children.dequeue();
        if (str == null) {
            return;
        }
        bfs(str, n);
    }//end of bfs()

    protected static void dfs(String start_node, int n) {

        if (n == (no_of_nodes + 1)) {
            return;
        }
        traversed.enqueue(start_node);
        n++;

        int start_index = getIndex(start_node);
        for (int i = (list[start_index].size() - 1); i > 0; i--) {
            String child = (String) list[start_index].get(i);
            //if child is not in stack
            if (!ifNodeExists(child, dfs_children.getStack())) {
                if (!ifNodeExists(child, traversed.getQueue())) {
                    dfs_children.push(child);
                }
            } else {
                dfs_children.pop(child);
                dfs_children.push(child);

            }
        }//end of for i loop

        String str = dfs_children.pop();
        if (str == null) {//when stack is empty
            return;
        }
        dfs(str, n);
    }//ed of dfs
    
    
    
  static void getGraph() throws IOException{
    System.out.println("Enter the no. of node of the graph");
    no_of_nodes=Integer.parseInt(brk.readLine());
    list=new ArrayList[no_of_nodes];
    System.out.println("Enter the name of following :");
    System.out.println("1 node:");
    list[0]=new ArrayList();
    list[0].add(brk.readLine());
    for(int i=1;i<no_of_nodes;i++){
            System.out.println((i+1)+" node :");
		list[i]=new ArrayList();
		String node=brk.readLine();
                boolean same=false;
		for(int j=0;j<i;j++){
			if(ifNodeExists(node,list[j])){//check if node already exists if yes return true
				i=i-1;
				System.out.println("Enter name already exists:");
                                same=true;
                                break;
			}//if statement
			if(!same){
				list[i].add(node);
                                break;
			}//end of else statement
		}//end of for j loop
    }//end of for loop i
    printList();
    
    getEdges();//get the edges of the graph
  }//end of getGraph
  
  
 public static boolean ifNodeExists(String node,ArrayList al){
	for(int i=0;i<al.size();i++){
		if(node.equalsIgnoreCase((String) al.get(i))){
			return true;
		}//end of if statement
	
	}//end of loop i
		return false;
}//end of ifNodeExists fun


static void getEdges() throws IOException{
	System.out.println("Enter the no. of Edges present in your graph:");
	int no_of_edges=Integer.parseInt(brk.readLine());
        String first,second;
	for(int j=0;j<no_of_edges;j++){
		while(true){
			boolean result=false;
			System.out.println("Enter the first node of the edge:");
                        first=brk.readLine();
				for(int i=0;i<no_of_nodes;i++){
					if(ifNodeExists(first , list[i])){
						result =true;
					}//end of if statement
				}//end of for i loop
				if(result==true){
					break;
				}
                                else {
						System.out.println("Enter node doesn't exists try again");
					}
			}//end of while statement for fist node of edge
	
		while(true){
			boolean result=false;
			System.out.println("Enter the second node of the edge:");
			second=brk.readLine();
			for(int i=0;i<no_of_nodes;i++){
				if(ifNodeExists(second, list[i])){
					result =true;
				}//end of if statement
				
			}//end of for i loop
			if(result==true){
				break;
			}
                        else {
					System.out.println("Enter node doesn't exists try again");
				}
		}//end of while statement for second edge
		
		int index;
                index = getIndex(first);
		if(!ifNodeExists(second,list[index])){
			list[index].add(second);
		}//end of if statement
		else{
			System.out.println("Entered Edge already exists\nEnter again:");
                        j--;//this will enter the edge again 
		}
	}//end of forr j loop
		
}//end of getEdges

     
    protected static int getIndex(String node) {
        for (int i = 0; i < no_of_nodes; i++) {
            if (node.equalsIgnoreCase((String) list[i].get(0))) {
                return (i);
            }
        }
        return (-1);
    }//end of getIndex()
    
    
    
    
    
    protected static void printList(){
            System.out.println(list[2].size()+"size of 2");
        for(int i=0;i<no_of_nodes;i++){
            for(int j=0;j<list[i].size();j++){
                System.out.print(" "+(String)list[i].get(j));
            }
            System.out.println();
        }
    }
    
    
    protected static void print_traversal(ArrayList al) {
        System.out.println("\t\t\tTraversed path: ");
        int i = 0;
        System.out.print("\t\t\t");
        for (; i < (al.size() - 1); i++) {
            System.out.print((String) al.get(i) + "->");
        }
        System.out.print((String) al.get(i));
        System.out.println();
    }
}
