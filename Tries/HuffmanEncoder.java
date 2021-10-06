package placement.DataStructure.Tries;


import java.util.*;

import placement.DataStructure.Heap.GenericHeap;

public class HuffmanEncoder {
	private class Node implements Comparable<Node>{
		int data;
		char ch;
		Node left,right;
		Node(char ch,int data){
			this.data=data;
			this.ch=ch;
			this.left=null;
			this.right=null;
		}
		@Override
		public int compareTo(Node o) {
			return this.data-o.data;
		}
	}
	HashMap<Character,String> encoder=new HashMap<>();
	HashMap<String,Character> decoder=new HashMap<>();
	//condtructor
	public HuffmanEncoder(String str) {
		
		//1.freqmap
		HashMap<Character,Integer> freqMap=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(freqMap.containsKey(ch)) {
				freqMap.put(ch, freqMap.get(ch)+1);
			}else {
				freqMap.put(ch,1);
			}
		}
		
		//2.create node and insert that in heap
		GenericHeap<Node> heap=new GenericHeap<>();
		Set<Map.Entry<Character, Integer>> entries=freqMap.entrySet();
		for(Map.Entry<Character, Integer> entry:entries) {
			Node node=new Node(entry.getKey(),entry.getValue());
			heap.Add(node);
		}
		
		//3.remove two items from heap ,combine them and insert again until heap.size==1
		while(heap.size()!=1) {
			Node first =heap.remove();
			Node second=heap.remove();
			Node combine=new Node('\0',first.data+second.data);
			combine.left=first;
			combine.right=second;
			heap.Add(combine);
		}
		
		//4.Retrieve last Node
		Node node=heap.remove();
		this.decoder=new HashMap<>();
		this.encoder=new HashMap<>();
		intializeDeNdEnCoder(node,"");
		
	}
    private void intializeDeNdEnCoder(Node node, String ans) {
    	if(node==null)
    		return;
    	if(node.left==null && node.right==null) {
    		this.encoder.put(node.ch, ans);
    		this.decoder.put(ans, node.ch);
    	}
    	this.intializeDeNdEnCoder(node.left,ans+"0");
    	this.intializeDeNdEnCoder(node.right, ans+"1");
		
	}
    
    
    public String Encode(String source) {
    	String ans="";
    	for(int i=0;i<source.length();i++) {
    		char ch=source.charAt(i);
    		String codeForChar=this.encoder.get(ch);
    		ans+=codeForChar+"--";
    	}
    	return ans;
    }

	
}
