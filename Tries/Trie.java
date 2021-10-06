package placement.DataStructure.Tries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	private class Node{
		char data;
		HashMap<Character,Node> children;
		boolean isTerminal;
		Node(char ch,boolean isLast){
			this.data=ch;
			this.isTerminal=isLast;
			this.children=new HashMap<>();
		}
	}
	private int noOfWords;
	private Node root;
	
	//constructor
	Trie(){
		this.noOfWords=0;
		this.root=new Node('\0',false);
	}
	//add
	public void add(String word) {
		this.Add(this.root,word);
		this.noOfWords++;
	}
	private void Add(Node parent, String word) {
		if(word.length()==0) {
			if(parent.isTerminal) {
				//word already exist
			}else {
				parent.isTerminal=true;
			}
			return;
		}
		char ch=word.charAt(0);
		String rest=word.substring(1);
		Node child=parent.children.get(ch);
		if(child==null) {
			child=new Node(ch,false);
			parent.children.put(ch,child);
		}
		this.Add(child,rest);
		
	}
	
	public int totalWords() {
		return this.noOfWords;
	}
	
	//search
	public boolean search(String word) {
		return this.Search(this.root,word);
	}
	private boolean Search(Node parent,String w) {
		if(w.length()==0) {
			if(parent.isTerminal) {
				return true;
			}else {
				return false;
			}
		}
		char ch=w.charAt(0);
		String rest=w.substring(1);
		Node child=parent.children.get(ch);
		if(child==null) {
			return false;
		}else {
			return Search(child,rest);
		}
		
	}
	
	//romove
	public void remove(String word) {
		this.Remove(this.root,word);
	}
	private void Remove(Node parent, String w) {
		if(w.length()==0) {
			if(parent.isTerminal) {
				parent.isTerminal=false;
				this.noOfWords--;
				return;
			}else {
				//this word w is not present in trie
			}
		}
		char ch=w.charAt(0);
		String rest=w.substring(1);
		Node child=parent.children.get(ch);
		if(child==null) {
			return;
		}
		this.Remove(child,rest);
		
		//if last child is terminal and we get our word then we remove all letters of word from our map because it just only occupy memory
		if(!child.isTerminal && child.children.size()==0) {
			child.children.remove(ch);
		}
		
	}
	//display
	public void display() {
		this.Display(this.root,"");
	}
	private void Display(Node node,String ans) {
		if(node.isTerminal) {
			System.out.println(ans.substring(1)+node.data);
		}else {
			
		}
		Set<Map.Entry<Character,Node>> entries=node.children.entrySet();
		for(Map.Entry<Character,Node> entry:entries) {
			this.Display(entry.getValue(), ans+node.data);
		}
		
	}
}
