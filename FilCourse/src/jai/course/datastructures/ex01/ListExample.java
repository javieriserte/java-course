package jai.course.datastructures.ex01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExample {
	
	public static void main(String ... args) {
		
		int[] numbers = new int[100000];
		
		for(int i = 0; i<numbers.length ; i++) {
			
			numbers[i] = (int) (Math.random() * 1000000) + 1; 
			
		}
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new LinkedList<>();
		List<Integer> l3 = new Vector<>();
		
		////////////////////////////////////////////////////////////////////////
		// Test add
		
		long t0 = System.currentTimeMillis();
		
		for (int integer : numbers) {
			
			l1.add(integer);
			
		}
		
		long t1 = System.currentTimeMillis();
		
		for (int integer : numbers) {
			
			l2.add(integer);
			
		}
		
		long t2 = System.currentTimeMillis();
		
		for (int integer : numbers) {
			
			l3.add(integer);
			
		}
		
		long t3 = System.currentTimeMillis();
		
		System.out.println("ArrayList  : "+(t1-t0)+" ms.");
		System.out.println("LinkedList : "+(t2-t1)+" ms.");
		System.out.println("Vector     : "+(t3-t2)+" ms.");
		
		long t4 = System.currentTimeMillis();
		int counts1 = 0;
		for (int i = 0; i < 10000; i++) {
			
			counts1 += l1.contains(i)?1:0;
			
		}
		
		long t5 = System.currentTimeMillis();
		int counts2 = 0;
		for (int i = 0; i < 10000; i++) {
			
			counts2 += l2.contains(i)?1:0;
			
		}
		long t6 = System.currentTimeMillis();
		int counts3 = 0;
		for (int i = 0; i < 10000; i++) {
			
			counts3 += l3.contains(i)?1:0;
			
		}
		long t7 = System.currentTimeMillis();
		
		System.out.println("ArrayList  : counted "+ counts1 + " elements in " +(t5-t4)+" ms.");
		System.out.println("LinkedList : counted "+ counts2 + " elements in " +(t6-t5)+" ms.");
		System.out.println("Vector     : counted "+ counts3 + " elements in " +(t7-t6)+" ms.");
		
		////////////////////////////////////////////////////////////////////////
		
		
	}

}
