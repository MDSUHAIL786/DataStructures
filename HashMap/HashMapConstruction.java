package placement.DataStructure.HashMap;

public class HashMapConstruction<K,V> {
	private class HTpair{
		K key;
		V value;
		
		//constructor
		HTpair(K key,V value){
			this.key=key;
			this.value=value;
		}
		
		//override equals method
		@Override
		public boolean equals(Object obj) {
			HTpair otherObj=(HTpair)obj;
			return this.key.equals(otherObj.key);
		}
		
		//override toString method
		@Override
		public String toString() {
			return "{"+this.key+"--->"+this.value+"}";
		}
		
	}
	public static final int DEFAULT_CAPACITY=10;
	private GenericLinkedList<HTpair>[] bucketArray;
	private int size;
	
	// constructor 
	public HashMapConstruction() {
		this(DEFAULT_CAPACITY);
	}

	public HashMapConstruction(int Capacity) {
		this.bucketArray =(GenericLinkedList<HTpair>[])new GenericLinkedList[Capacity];
		this.size=0;
	}
	
	//put or add method   o(n) time complexity
	public void put(K key,V value) throws Exception {
		int idx=hashFunction(key);
		
		GenericLinkedList<HTpair> bucket=this.bucketArray[idx];
		HTpair pairToBeAdd=new HTpair(key,value);
		if(bucket==null) {
			bucket = new GenericLinkedList<>();
			bucket.addLast(pairToBeAdd);
			this.bucketArray[idx]=bucket;
			this.size++;
		}else {
			int findat=bucket.find(pairToBeAdd);
			if(findat==-1) {
				bucket.addLast(pairToBeAdd);
				this.size++;
			}else {
				HTpair pair=bucket.getAt(findat);
				pair.value=value;
			}
			
		}
		double lambda=(this.size*1.0)/bucketArray.length;
		if(lambda>2) {
			this.rehash();
		}
		
	}

	private int hashFunction(K key) {   
		int hash_code=key.hashCode();   //many time calling of this functn with same key provide same hashcode
		int idx=Math.abs(hash_code)%this.bucketArray.length;
		return idx;
	}
	
	//get o(n)
	public V get(K key) throws Exception {
		int idx=hashFunction(key);
		System.out.println(idx);
		GenericLinkedList<HTpair> bucket=this.bucketArray[idx];
		HTpair pairToBeFind=new HTpair(key,null);
		if(bucket==null) {
			return null;
		}
		else {
			int findat=bucket.find(pairToBeFind);
			
			if(findat==-1) {
				return null;
			}else {
				HTpair pair=bucket.getAt(findat);
				return pair.value;
			}
		}
		
		
	}
	
	//reomove o(N)
	public V remove(K key) throws Exception {
		int idx=hashFunction(key);
		GenericLinkedList<HTpair> bucket=this.bucketArray[idx];
		HTpair pairToBeDelete=new HTpair(key,null);
		if(bucket==null) {
			return null;
		}else {
			int findat =bucket.find(pairToBeDelete);
			if(findat==-1) {
				return null;
			}else {
				HTpair deleted=bucket.removeAt(findat);
				this.size--;
				return deleted.value; 
			}
		}
	}
	//rehash
	private void rehash() throws Exception {
		GenericLinkedList<HTpair>[] old=this.bucketArray;
		GenericLinkedList<HTpair>[] NewB=(GenericLinkedList<HTpair>[])new GenericLinkedList[2*bucketArray.length];
		this.size=0;
		for(GenericLinkedList<HTpair> oldBucket:old) {
			while(oldBucket != null && oldBucket.size()==0) {
				HTpair pair = oldBucket.removeFirst();
				this.put(pair.key,pair.value);
			}
		}
		
	}
	//display
	public void display() throws Exception{
		for(GenericLinkedList<HTpair> bucket:this.bucketArray) {
			if(bucket==null) {
				System.out.println("NULL");
			}
			else {
				bucket.display();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
