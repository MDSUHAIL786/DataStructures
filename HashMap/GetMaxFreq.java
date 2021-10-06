package placement.DataStructure.HashMap;

import java.util.*;

public class GetMaxFreq {

	public static void main(String[] args) {
		String str="aaaabbbbbaaccccccccccccccccccc";
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(!map.containsKey(ch)) 
				map.put(ch, 1);
			else 
				map.put(ch, map.get(ch)+1);
		}
		System.out.println(map);
		System.out.println(getCharOfMaxFreq(map));
		

	}

	public static char getCharOfMaxFreq(HashMap<Character, Integer> map) {
		Set<Map.Entry<Character, Integer>> entries=map.entrySet();
		int max=0;
		char ch='\0';
		for(Map.Entry<Character, Integer> i:entries) {
			int value=i.getValue();
			if(value>max) {
				max=value;
				ch=i.getKey();
			}
			
		}
		return ch;
		
		
	}

}
