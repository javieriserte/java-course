package jai.course.datastructures.ex01;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {

	public static void main (String ... args) {
		
		int[] numbers = new int[100000];
		
		for(int i = 0; i<numbers.length ; i++) {
			
			numbers[i] = (int) (Math.random() * 1000000) + 1; 
			
		}
		
		
		Map<Integer,Integer> s1 = new HashMap<>();
		Map<Integer,Integer> s2 = new TreeMap<>();
		

		
		////////////////////////////////////////////////////////////////////////
		// Test add
		
		long t0 = System.currentTimeMillis();
		
		for (int integer : numbers) {
			
			s1.put(integer,integer);
			
		}
		
		long t1 = System.currentTimeMillis();
		
		for (int integer : numbers) {
			
			s2.put(integer,integer);
			
		}

		long t2 = System.currentTimeMillis();
		
		System.out.println("HashSet  : "+(t1-t0)+" ms.");
		System.out.println("TreeSet : "+(t2-t1)+" ms.");

		
		long t3 = System.currentTimeMillis();
		int counts1 = 0;
		for (int i = 0; i < 1000000; i++) {
			
			counts1 += s1.containsKey(i)?1:0;
			
		}
		long t4 = System.currentTimeMillis();
		int counts2 = 0;
		for (int i = 0; i < 1000000; i++) {
			
			counts2 += s2.containsKey(i)?1:0;
			
		}
		long t5 = System.currentTimeMillis();
		
		System.out.println("HashSet  : counted "+ counts1 + " elements in " +(t4-t3)+" ms.");
		System.out.println("TreeSet  : counted "+ counts2 + " elements in " +(t5-t4)+" ms.");

		
	}
	
}
