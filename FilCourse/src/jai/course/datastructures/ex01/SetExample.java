package jai.course.datastructures.ex01;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	
	public static void main (String ... args) {
		
		int[] numbers = new int[100000];
		
		for(int i = 0; i<numbers.length ; i++) {
			
			numbers[i] = (int) (Math.random() * 1000000) + 1; 
			
		}
		
		
		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new TreeSet<>();
		
		////////////////////////////////////////////////////////////////////////
		// Test add
		
		long t0 = System.currentTimeMillis();
		
		for (int integer : numbers) {
			
			s1.add(integer);
			
		}
		
		long t1 = System.currentTimeMillis();
		
		for (int integer : numbers) {
			
			s2.add(integer);
			
		}

		long t2 = System.currentTimeMillis();
		
		System.out.println("HashSet  : "+(t1-t0)+" ms.");
		System.out.println("TreeSet : "+(t2-t1)+" ms.");

		
		long t3 = System.currentTimeMillis();
		int counts1 = 0;
		for (int i = 0; i < 1000000; i++) {
			
			counts1 += s1.contains(i)?1:0;
			
		}
		long t4 = System.currentTimeMillis();
		int counts2 = 0;
		for (int i = 0; i < 1000000; i++) {
			
			counts2 += s2.contains(i)?1:0;
			
		}
		long t5 = System.currentTimeMillis();
		
		System.out.println("HashSet  : counted "+ counts1 + " elements in " +(t4-t3)+" ms.");
		System.out.println("TreeSet  : counted "+ counts2 + " elements in " +(t5-t4)+" ms.");

		
	}

}
