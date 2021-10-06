package placement.DataStructure.Heap;
import java.util.*;
public class HeapConstruction {
	//min heap construction
	ArrayList<Integer> heap=new ArrayList<>();;
//	public HeapConstruction(){
//		ArrayList<Integer> heap=new ArrayList<>();
//		this.heap=heap;
//	}
	public void Add(int data) {
		heap.add(data);
		int ci=heap.size()-1;             //child index i.e newly add element index
		makeMinHeap(ci);
	}
	private void makeMinHeap(int ci) {
		
		int pi=(ci-1)/2;             //parentIdxofNewlyAdd
		int childVal=this.heap.get(ci);
		int parentVal=this.heap.get(pi);
		if(childVal<parentVal) {
			Collections.swap(heap, ci, pi);
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
	public int remove() {    //we cannot remove by our choice it remove most priority element
		Collections.swap(heap, 0, this.size()-1);
		int deleted=heap.remove(this.size()-1);
		downHeapify(0);
		return deleted;
	}
	private void downHeapify(int pi) {
		
		int li=2*pi+1,ri=2*pi+2;     //ri=right index of child of parent pi li is left index 
		int minidx=pi;
		if(li<this.size() && heap.get(li)<heap.get(minidx))
			minidx=li;
		if(ri<this.size() && heap.get(ri)<heap.get(minidx))
			minidx=ri;
		if(minidx!=pi) {
			Collections.swap(heap, pi, minidx);
			downHeapify(minidx);
		}else {
			return;
		}
		
	}
	
	//get method return most priority element
	public int get() {
		return this.heap.get(0);
	}
	public void display() {
		
		System.out.println(this.heap);
	}
}
