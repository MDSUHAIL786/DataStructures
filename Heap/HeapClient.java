package placement.DataStructure.Heap;

public class HeapClient {

	public static void main(String[] args) {
		HeapConstruction heap=new HeapConstruction();
		heap.Add(10);
		heap.Add(20);
		heap.Add(30);
		
//		heap.display();
		heap.display();
		heap.Add(5);
		heap.display();
		heap.Add(1);
		heap.display();
		heap.Add(85);
		heap.display();
		System.out.println(heap.remove());
		heap.display();
		System.out.println(heap.remove());
		heap.display();
		System.out.println(heap.remove());
		heap.display();
		System.out.println(heap.get());
		

	}

}
