package placement.DataStructure.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import placement.DataStructure.HashMap.GenericLinkedList;

public class BinaryTree {
	private class Node{
		int data;
		Node leftNode;
		Node rightNode;
		Node(int data,Node left,Node right){
			this.data=data;
			this.leftNode=left;
			this.rightNode=right;
		}
	}
	private Node root;
	private int size;
	
	//constructor
	BinaryTree(){
		Scanner s=new Scanner(System.in);
		this.root=takeInput(s,null,false);
	}

	private Node takeInput(Scanner s,Node parent, boolean isLeftOrRight) {   //true=left;false= right
		if(parent==null)
			System.out.println("Enter the data for root node : ");
		else {
			if(isLeftOrRight) System.out.println("Enter the data for left Node of "+parent.data);
			else System.out.println("Enter the data for right Node of "+parent.data);
		}
		int nodeData=s.nextInt();
		Node node=new Node(nodeData,null,null);
		this.size++;
		boolean choice=false;
		System.out.println("Do you have left node for "+node.data);
		choice=s.nextBoolean();
	    if(choice) {
	    	node.leftNode=takeInput(s,node,true);
	    }
	    
	    choice=false;
		System.out.println("Do you have right node for "+node.data);
		choice=s.nextBoolean();
	    if(choice) {
	    	node.rightNode=takeInput(s,node,false);
	    }
		return node;
	}
	
	//display
	public void display() {
		this.Display(this.root);
	}

	private void Display(Node node) {
		String str="";
		if(node.leftNode!=null)
			str=str+node.leftNode.data+"===>";
		else
			str=str+"End===>";
		str+=node.data;
		if(node.rightNode!=null)
			str=str+"===>"+node.rightNode.data;
		else
			str=str+"===>End";
		System.out.println(str);
		if(node.leftNode!=null) Display(node.leftNode);
		if(node.rightNode!=null) Display(node.rightNode);
	}
	
	//height
	public int height() {
		return this.height(this.root);
	}
	private int height(Node node) {
		if(node==null)
			return -1;
		int leftheight=height(node.leftNode);
		int rightHeight=height(node.rightNode);
		
		int height=Math.max(leftheight, rightHeight)+1;
		return height;
			
	}
	
	//traversal
	//1.preOrder
	public void preOrder() {
		this.PreOrder(this.root);
		System.out.println();
		this.preOrder2(this.root);
	}

	private void PreOrder(Node node) {
		if(node==null) return;
		System.out.print(node.data+", ");
		PreOrder(node.leftNode);
		
		PreOrder(node.rightNode);
	}
	
	//preorder iteratively
	private class preNode{
		Node node;
		boolean left,right,self;
	}
	private void preOrder2(Node n) {
		Stack<preNode> s=new Stack<>();
		preNode p=new preNode();
		p.node=n;
		s.push(p);
		while(!s.isEmpty()) {
			preNode np=s.peek();
			if(np.node==null) {
				s.pop();
				continue;
			}
				
			if(!np.self) {
				System.out.print(np.node.data+" ");
				np.self=true;
			}
			
			if(!np.left) {
				preNode x=new preNode();
				x.node=np.node.leftNode;
				s.push(x);
				np.left=true;
			}else if(!np.right) {
				preNode x=new preNode();
				x.node=np.node.rightNode;
				s.push(x);
				np.right=true;
			}else {
				s.pop();
			}
			
		}
	}
	//2.postOrder
	public void postOrder() {
		this.PostOrder(this.root);
	}

	private void PostOrder(Node node) {
		if(node==null) return;
		PostOrder(node.leftNode);
		PostOrder(node.rightNode);
		System.out.print(node.data+", ");
	}
	
	//3.inOrder
	public void inOrder() throws Exception {
//		this.InOrder(this.root);
		this.Inorder2(this.root);
	}

	private void InOrder(Node node) {
		if(node==null) return;
		InOrder(node.leftNode);
		System.out.print(node.data+", ");
		InOrder(node.rightNode);
	}
	//3.b inorder traversal itratively
	private void Inorder2(Node node) throws Exception {
		if(node==null)
			return;
		Stack<Node> s=new Stack<>();
		ArrayList<Integer> lst=new ArrayList<>();
		while(true) {
			if(node!=null) {
				s.push(node);
				node=node.leftNode;
			}else {
				if(s.isEmpty())
					break;
				node=s.pop();
				lst.add(node.data);
				node=node.rightNode;
				
			}
		}
//		for(int i:lst) {
//			System.out.print(i+", ");
//		}
		System.out.println(lst);
	}

	
	//4.levelOrder
	public void levelOrder() throws Exception {
		GenericLinkedList<Node> queue=new GenericLinkedList<>();
		queue.addLast(this.root);
		while(queue.size()!=0) {
			Node remove=queue.removeFirst();
			System.out.print(remove.data+", ");
			if(remove.leftNode!=null)
				queue.addLast(remove.leftNode);
			if(remove.rightNode!=null)
				queue.addLast(remove.rightNode);
		}
	}
	//isBT a BST
	public boolean isBST() {
//		return this.check(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		ArrayList<Integer> lst=new ArrayList<>();
		this.check2(this.root,lst);
		Integer[] rslt=lst.toArray(new Integer[lst.size()]);
		for(int i=0;i<rslt.length-1;i++) {
			if(rslt[i]>rslt[i+1]) {
				return false;
			}
		}
		return true;
		
		
		
	}

	private boolean check(Node node,int min,int max) {
		if(node==null)
			return true;
		if(node.data>max || node.data<min) {
			return false;
		}else if(!this.check(node.leftNode, min, node.data)) {
			return false;
		}else if(!this.check(node.rightNode,node.data,max)) {
			return false;
		}
		return true;
	}
	//2nd method to check
	private void check2(Node node,ArrayList<Integer> l) {
		if(node==null) return;
		check2(node.leftNode,l);
		l.add(node.data);
		check2(node.rightNode,l);
		return;
	}
	
	//sumof leafNodes
	public int Leafsum() {
//		return this.lst(this.root);
		return this.sumrecursively(this.root);
	}
    //iterative method
	private int lst(Node node) {
		Stack<Node> s=new Stack<>();
		ArrayList<Integer> lst=new ArrayList<>();
		while(true) {
			if(node!=null) {
				s.push(node);
				node=node.leftNode;
			}else {
				
				node=s.pop();
				if(node.rightNode==null) {
					lst.add(node.data);
					if(s.isEmpty()) {
						break;
					}else {
						
						node=s.pop().rightNode;
					}
					
				}else {
					node=node.rightNode;
				}
				
				
			}
		}
		int sum=0;
		for(int i:lst)
			sum+=i;
		return sum;
	}
	//recursive method
	private int sumrecursively(Node node) {
		if(node==null) return 0;
		if(node.leftNode==null && node.rightNode==null) return node.data;
		int sumOfAllLeftLeaf=sumrecursively(node.leftNode);
		int sumOfAllRightLeaf=sumrecursively(node.rightNode);
		return sumOfAllLeftLeaf+sumOfAllRightLeaf;
	}
	
	//diameter of bT
	public int diameter() {
		return this.Diameter(this.root);
	}
	private int Diameter(Node node){
		if(node==null)
			return 0;
		
		int case1=this.height(node.leftNode)+this.height(node.rightNode)+2;
		int case2=this.Diameter(node.leftNode);
		int case3=this.Diameter(node.rightNode);
		int ans=Math.max(case1, Math.max(case2, case3));
		return ans;
	}
	//method 2 for find diameter in o(n)
	private class DiaPair{
		int h=-1;  //hieght of node 
		int d=0;  //diameter of node
	}
	public DiaPair FindDiameter(Node n) {
		if(n==null) {
			return new DiaPair();
		}
		DiaPair left=FindDiameter(n.leftNode);
		DiaPair right=FindDiameter(n.rightNode);
		DiaPair ans=new DiaPair();
		int d=left.h+right.h+2;
		int leftD=left.d;
		int rightD=right.d;
		ans.d=Math.max(d,Math.max(leftD, rightD));
		ans.h=Math.max(left.h, right.h)+1;
		return ans;
	}
	//max
	public int max() {
		return Max(this.root);
	}

	private int Max(Node node){
		if(node==null) {
			return Integer.MIN_VALUE;
		}
		int rightMax=Max(node.rightNode);
		int leftMax=Max(node.leftNode);
		
		return Math.max(node.data,Math.max(rightMax, leftMax));
	}
	
	//find
	public boolean find(int data) {
		return this.Find(this.root,data);
	}
	private boolean Find(Node node, int data) {
		if(node.data==data) {
			return true;
		}
		boolean rightC=Find(node.rightNode,data);
		
		boolean leftC=Find(node.leftNode,data);
		
		return leftC||rightC;
		
	}

	
}

