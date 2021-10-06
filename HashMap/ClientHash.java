package placement.DataStructure.HashMap;

public class ClientHash {

	public static void main(String[] args) throws Exception {
		HashMapConstruction<String,Integer> map=new HashMapConstruction<>(4);
		map.put("india", 450);
		map.put("usa", 851);
		map.put("pakistan", 878);
		map.put("turkey", 100);
		map.put("arab", 89);
		
		map.display();
		System.out.println(map.remove("turkey"));
		map.display();
		
		

	}

}
