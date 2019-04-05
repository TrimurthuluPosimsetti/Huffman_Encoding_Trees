/*
Given An array of Alphabets and their frequency. Your task is to print all the given alphabets Huffman Encoding.
Note: If two elements have same frequency, then the element which if at first will be taken on left of Binary Tree and other one to right.

Input:
First line consists of test cases T. First line of every test case consists of string of alphabets and second line consists of its frequencies.

Output:
Print the HuffmanCodes in single line, with n spaces of each alphabet's HuffmanCodes respectively. In PreOrder form of Binary Tree.

Constraints:
1<=T<=100
1<=|String length|<=26

Example:
Input:
1
abcdef
5 9 12 13 16 45
Output:
0 100 101 1100 1101 111 
*/


import java.util.*;
import java.lang.*;
import java.io.*;

/*Structure for a node*/
class Node{
    Node left=null,right=null;
    int data;
    public Node(int a){
        data=a;
    }
}
/*Comparator function return -1 if n1 < n2 else return 1 when n1>n2|n1==n2*/
class Comp implements Comparator<Node>{
    public int compare(Node n1,Node n2){
        if(n1.data<n2.data){
          return -1;  
        }
        return 1;
    }
}

class Trees {
    //this function will traverse whole tree
    public static void print(Node root,String s){
        if(root.left==null){//when it reaches to null we should print that encrypted string which contains 1's and 0's 
            System.out.print(s+" ");
        }
        if(root.left!=null){
            print(root.left,s+"0");//calling print function for iterating left subtree for current node
        }
        if(root.right!=null)
        {
            print(root.right,s+"1");//calling print function for iterating right subtree for current node
        }
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//reading testcases
		for(int i=0;i<t;i++){
		String s=sc.next();//reading input string
		int a[]=new int[s.length()];//creating array for integer values
		for(int j=0;j<s.length();j++){
		    a[j]=sc.nextInt();//reading data for nodes
		}
		PriorityQueue<Node> pq=new PriorityQueue<Node>(new Comp());
		for(int j=0;j<s.length();j++){
		    pq.add(new Node(a[j]));
		}
		while(pq.size()!=1){//repeat until priority queue contains only one element
        Node m = pq.remove();
        Node n = pq.remove();
        Node mn=new Node(m.data+n.data);//creating a new node
        mn.left=m;
        mn.right=n;
        pq.add(mn);//adding into priority queue
		}
		Node root=pq.remove();//removing last element from priorityqueue
		String str="";
		print(root,str);//calling print function with root of the tree
		System.out.println();
		}
	}
}
