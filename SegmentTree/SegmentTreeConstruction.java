package placement.DataStructure.SegmentTree;


public class SegmentTreeConstruction {
	private class Node{
		int data;
		int sIdx,lIdx;          //starting and last index
		Node leftNode;
		Node rightNode;
		
	}
	
	private Node root;
	private int size;
    public SegmentTreeConstruction(int arr[]){
    	this.size=2*arr.length-1;
    	this.root=construct(arr,0,arr.length-1);
    }
	private Node construct(int[] arr, int start, int end) {
		if(end==start) {
			Node temp=new Node();
			temp.leftNode=null;
			temp.rightNode=null;
			temp.data=arr[start];
			temp.lIdx=end;
			temp.sIdx=start;
			return temp;
		}
		Node node=new Node();
		node.sIdx=start;
		node.lIdx=end;
		int mid=(start+end)/2;
		node.leftNode=construct(arr,start,mid);
		node.rightNode=this.construct(arr, mid+1, end);
		
		node.data=node.leftNode.data+node.rightNode.data;
		return node;
	}
	
	//size
	public int size() {
		return this.size;
	}
	
	//find qeuery for given interval
	public int qeueryForInterval(int start,int end) {
		return this.find(this.root,start,end);
	}
	private int find(Node n,int si,int li) {
		
		//case-1 interval inside in given interval
		if(n.sIdx>=si && n.lIdx<=li) {
			return n.data;
		}
		
		//case-2 outside
		else if(n.sIdx>li || n.lIdx<si) {
			return 0;
		}
		//case-3 overlap
		else {
			int left=this.find(n.leftNode, si, li);
			int right=this.find(n.rightNode, si, li);
			return left+right;
		}
	}
	
	//updation
	public void doUpdate(int at,int add) {
		this.update(this.root,at,add);
	}
	private int update(Node n, int idx, int data) {
		if(idx>=n.sIdx && idx<=n.lIdx) {
			if(n.sIdx==idx && n.lIdx==idx) {
				n.data=data;
				
			}else {
				int left=this.update(n.leftNode,idx,data);
				int right=this.update(n.rightNode, idx, data);
				n.data=left+right;
			
			}
		}
		return n.data;
		
	}
	//display
	public void display() {
		this.Display(this.root);
	}
	private void Display(Node n) {
		if(n==null) {
			
		}
		String str="";
		if(n.leftNode!=null) {
			str=str+"Interval["+n.leftNode.sIdx+","+n.leftNode.lIdx+"],data("+n.leftNode.data+")=>";
		}else {
			str="No left child=>"+str;
		}
		str=str+"Interval["+n.sIdx+","+n.lIdx+"],data("+n.data+")";
		if(n.rightNode!=null) {
			str=str+"<=Interval["+n.rightNode.sIdx+","+n.rightNode.lIdx+"],data("+n.rightNode.data+")";
		}else {
			str=str+"<=No right child";
		}
		System.out.println(str);
		if(n.leftNode!=null) this.Display(n.leftNode);
		if(n.rightNode!=null) this.Display(n.rightNode);
		
	}
}
