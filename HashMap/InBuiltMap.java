package placement.DataStructure.HashMap;
import java.util.*;
public class InBuiltMap {

	public static void main(String[] args) {
		HashMap<String,Integer> map=new HashMap<>();
		map.put("india",200);
		map.put("Turkey", 10);
		map.put("saudi arab", null);
		System.out.println(map);
		map.put("saudi arab", 500);
		map.remove("india");
		System.out.println(map.get("Turkey"));
		System.out.println(map.containsKey("usa"));
		System.out.println(map);
		Set<String> keys=map.keySet();
		for(String str:keys) {
			System.out.print(str+"  ");
		}
		Collection<Integer> values=map.values();
		for(int i:values) {
			System.out.println(i);
		}
		Set<Map.Entry<String, Integer>> entries=map.entrySet();
		for(Map.Entry<String, Integer> i:entries) {
			System.out.print(i.getKey()+"----->"+i.getValue());
			System.out.println();
		}

	}

}
