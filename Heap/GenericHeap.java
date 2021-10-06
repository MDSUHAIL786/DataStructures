package placement.DataStructure.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class GenericHeap<T extends Comparable<T>> {
	//min heap construction
	ArrayList<T> heap=new ArrayList<>();
	HashMap<T,Integer> indexMap=new HashMap<>();
//	public HeapConstruction(){
//		ArrayList<Integer> heap=new ArrayList<>();
//		this.heap=heap;
//	}
	public void Add(T data) {
		heap.add(data);
		indexMap.put(data, this.heap.size()-1);
		int ci=heap.size()-1;             //child index i.e newly add element index
		makeMinHeap(ci);
	}
	private void makeMinHeap(int ci) {  //upheapify
		
		int pi=(ci-1)/2;             //parentIdxofNewlyAdd
		T childVal=this.heap.get(ci);
		T parentVal=this.heap.get(pi);
		if(this.isLarger(childVal,parentVal)>0){
			Collections.swap(heap, ci, pi);
			indexMap.put(heap.get(ci), pi);
			indexMap.put(heap.get(pi), ci);
			makeMinHeap(pi);
		}
	}
	//can be use for swap
//	private void swap(int i,int j) {
//		int ith=this.heap.get(i);
//		int jth=this.heap.get(j);
//		this.heap.set(j, ith);
//		this.heap.set(i, jth);
//	}
	
	//size
	public int size() {
		return heap.size();
	}
	
	//isEmpty
	public boolean isEmpty() {
		return heap.size()==0;
	}
	
	//remove 
	public T remove() {    //we cannot remove by our choice it remove most priority element
		Collections.swap(heap, 0, this.size()-1);
		T deleted=heap.remove(this.size()-1);
		downHeapify(0);
		indexMap.remove(deleted);
		return deleted;
	}
	private void downHeapify(int pi) {
		
		int li=2*pi+1,ri=2*pi+2;     //ri=right index of child of parent pi li is left index 
		int minidx=pi;
		if(li<this.size() && this.isLarger(heap.get(li),heap.get(minidx))>0)
			minidx=li;
		if(ri<this.size() && this.isLarger(heap.get(ri),heap.get(minidx))>0)
			minidx=ri;
		if(minidx!=pi) {
			Collections.swap(heap, pi, minidx);
			downHeapify(minidx);
		}else {
			return;
		}
		
	}
	
	//get method return most priority element
	public T get() {
		return this.heap.get(0);
	}
	public void display() {
		
		System.out.println(this.heap);
	}
	
	//islarger method return +ve value as element have more priority  
	public int isLarger(T t,T o) {
		return t.compareTo(o);
	}
	public void update(T pair) {
		
		int index=indexMap.get(pair);
		this.makeMinHeap(index);    
		
	}
}
