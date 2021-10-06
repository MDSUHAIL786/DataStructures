package placement.DataStructure.Trees;



public class BST {
	private class Node{
		int data;
		Node left;
		Node right;
	}
	private Node root;
	//constructor
	public BST(int arr[]) {
		this.root=constructBST(arr,0,arr.length-1);
	}
	private Node constructBST(int[] arr, int low, int high) {
		if(low>high)
			return null;
		int mid=(low+high)/2;
	
		Node node=new Node();
		node.data=arr[mid];
	    node.left=constructBST(arr,low,mid-1);
		node.right=constructBST(arr,mid+1,high);
		return node;
	}
	//add a node
	public void add(int data) {
		this.Add(this.root,data);
	}
	private void Add(Node node, int data) {
		
		if(data>node.data) {
			if(node.right!=null)
				Add(node.right,data);
			else {
				Node toBeAdd=new Node();
				toBeAdd.data=data;
				node.right=toBeAdd;
			}
		}else{
			if(node.left!=null)
				Add(node.left,data);
			else {
				Node toBeAdd=new Node();
				toBeAdd.data=data;
				node.left=toBeAdd;
			}
		}
//		else {
//			System.out.println("element is already exist!!!!");
//		}
		
	}
	
	//remove
	public void remove(int item) {
		if(!this.find(item))
			System.out.println("there is no such element please enter valid element for remove.");
		else {
			this.Remove(this.root,null,false,item);
		}
	}
	private void Remove(Node node,Node parent, boolean isLeft, int data) {
		if(data>node.data) {
			Remove(node.right,node,false,data);
		}
		else if(data<node.data){
			Remove(node.left,node,true,data);
		}else {
			if(node.right==null && node.left==null) {
				if(isLeft) {
					parent.left=null;
				}else{
					parent.right=null;
				}
			}else if(node.left==null && node.right!=null) {
				if(isLeft) {
					parent.left=node.right;
				}else {
					parent.right=node.right;
				}
			}else if(node.left!=null && node.right==null) {
				if(isLeft) {
					parent.left=node.left;
				}else {
					parent.right=node.left;
				}
			}else {
				int max=this.Max(node.left);
				node.data=max;
				Remove(node.left,node,true,max);
			}
		}
	}
	//display
	public void display() {
		this.Display(this.root);
	}
	private void Display(Node node) {
		String str="";
		if(node.left!=null)
			str=str+node.left.data+"===>";
		else
			str=str+"End===>";
		str+=node.data;
		if(node.right!=null)
			str=str+"===>"+node.right.data;
		else
			str=str+"===>End";
		System.out.println(str);
		if(node.left!=null) Display(node.left);
		if(node.right!=null) Display(node.right);
		
	}
	
	//find an element
	public boolean find(int item) {
		return this.Find(this.root,item);
	}
	private boolean Find(Node node,int item){
		if(node == null) return false;
		if(item<node.data) {
			return Find(node.left,item);
		}else if(item>node.data) {
			return Find(node.right,item);
		}else {
			return true;
		}
	}
	//maximum element
	public int max(){
		return this.Max(this.root);
	}
	private int Max(Node node) {
		if(node.right==null)
			return node.data;
		return Max(node.right);
	}
	
	//min element
	public int min(){
		return this.Min(this.root);
	}
	private int Min(Node node) {
		if(node.left==null)
			return node.data;
		return Max(node.left);
	}
}
