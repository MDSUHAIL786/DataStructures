package placement.DataStructure.HashMap;

import java.util.*;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		int arr1[]=new int[]{5,1,4,7,3,9};
		int arr2[]=new int[]{1,5,8,9,3,7,4,10,11,12};
		ArrayList<Integer> reqList=new ArrayList<>();
		//find arr1 intersection arr2
		HashMap<Integer,Boolean> map=new HashMap<>();
		for(int i:arr1) {
			map.put(i, false);
		}
		for(int i:arr2) {
			if(map.containsKey(i))
				map.put(i, true);
			
		}
		Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
		for(Map.Entry<Integer, Boolean> item:entries) {
			if(item.getValue()) {
				reqList.add(item.getKey());
			}
		}
		System.out.println(reqList);

	}

}
