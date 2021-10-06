package placement.DataStructure.Trees;

import java.util.*;

public class GenericTree {
	private class Node{
		int data;
		ArrayList<Node> children;
		Node(int data){
			this.data=data;
			this.children=new ArrayList<>();
		}
	}
	private Node root;
	private int size;
	GenericTree(){
		Scanner s=new Scanner(System.in);
		this.root=takeInput(s,null,0);
	}
	private Node takeInput(Scanner s,Node parent, int ithchild) {
		if(parent==null)
			System.out.println("Enter the data for root: ");
		else
			System.out.println("Enter the data for "+ithchild+"th child of"+parent.data);
		int nodedata=s.nextInt();
		Node node=new Node(nodedata);
		this.size++;
		System.out.println("Enter the no of children for "+node.data);
		int NoOfChildren=s.nextInt();
		for(int i=0;i<NoOfChildren;i++) {
			Node child=this.takeInput(s,node,i);
			node.children.add(child);
		}
		
		return node;
	}
	//size
	public int size() {
		return this.size;
	}
	
	//find
	public boolean find(int data) {
		return this.Find(this.root,data);
	}
	private boolean Find(Node node, int data) {
		if(node.data==data) {
			return true;
		}
		
		for(Node n:node.children) {
			boolean temp=Find(n, data);
			if(temp)
				return true;
		}
		return false;
	}
	
	//max
	public int max() {
		return this.Max(this.root,Integer.MIN_VALUE);
	}
	//45 2 10000 0 25 1 120 0
	private int Max(Node node,int t) {
		if(node.data>t)
			t=node.data;
		for(Node child:node.children) {
			int max=Max(child,t);
			if(t<max)
				t=max;
		}
		
		return t;
	}
	
	//height
	public int height() {
		return this.Height(this.root);
	}
	private int Height(Node node) {
		int temp=-1;
		for(Node child:node.children) {
			int h=Height(child);
			if(temp<h)
				temp=h;
		}
		
		return temp+1;
	}
	//display
	public void display() {
		this.Display(this.root);
	}
	private void Display(Node node) {
		String str=node.data+"===> ";
		for(int i=0;i<node.children.size();i++) {
			str=str+node.children.get(i).data+", ";
		}
		str+="END";
		System.out.println(str);
		for(int i=0;i<node.children.size();i++) {
			this.Display(node.children.get(i));
		}
		
	}
	
	
}
