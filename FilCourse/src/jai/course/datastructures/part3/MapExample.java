package jai.course.datastructures.part3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main (String ... args) {
		Map<Integer,Integer> map;
		Map<Integer,Integer> secondMap = new HashMap<Integer, Integer>();
		for (int i = 0; i<100; i++) {
		  map = new HashMap<>();
		  fillMapWithRandomNumbers(map, 1000000, 1000000);
		  Integer maxKey = getMostFrequentKey(map);
		  System.out.println("Maximum Key: "+maxKey+" | Frecuency: "+map.get(maxKey));
		  secondMap = updateKeyCount(secondMap,map.get(maxKey));
		}
		for (Integer frequency : secondMap.keySet()) {
			System.out.println("Frequency :" + frequency + " | Conteo " + secondMap.get(frequency));
		}
	}
	
	public static Map<Integer,Integer> fillMapWithRandomNumbers(Map<Integer,Integer> map, int numbers, int maximumValue) {
		
		for (int i = 0; i<numbers; i++) {
			
			Integer currentValue = (int) (Math.random()*maximumValue+1);
			
			updateKeyCount(map, currentValue);
		}
		
		return map;
		
	}

	private static Map<Integer,Integer> updateKeyCount(Map<Integer, Integer> map, Integer key) {
		if (map.containsKey(key)) {
			map.put(key, map.get(key)+1);
		} else {
			map.put(key, 1);
		}
		return map;
	}
	
	public static Integer getMostFrequentKey(Map<Integer,Integer> map) {
		Set<Integer> keySet = map.keySet();
		Integer maxValue=0;
		Integer maxKey = null;
		for (Integer currentKey : keySet) {
			Integer currentValue = map.get(currentKey);
			if (currentValue > maxValue) {
				maxValue = currentValue;
				maxKey = currentKey;
			}
		}
		return maxKey;
	}
	
}
