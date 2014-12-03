package jai.course.datastructures.ex01;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	
	public static void main (String ... args) {
		
		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new TreeSet<>();
		Set<Integer> s3 = new HashSet<>();
		Set<Integer> s4 = new TreeSet<>();
		
		s1 = fillSetWithRandomNumbers(s1,1000000,1000000);
		s2 = fillSetWithRandomNumbers(s2,1000000,1000000);
		s3 = fillSetWithRandomNumbers(s3,1000000,1000000);
		s4 = fillSetWithRandomNumbers(s4,1000000,1000000);
		
		compareTwoSets(s1,s3);
		compareTwoSets(s1,s4);
		compareTwoSets(s2,s3);
		compareTwoSets(s2,s4);
	}
	
	public static Set<Integer> fillSetWithRandomNumbers(Set<Integer> set, int numbers, int maximumValue) {
		long t0 = System.nanoTime();
		for (int i=0; i< numbers; i++) {
		  set.add((int) (Math.random() * maximumValue) + 1);
		}
		long t1 = System.nanoTime();
		System.out.println("Set Adding: "+ set.getClass().getCanonicalName()+ " - "+(t1-t0)/1000000+" ms.");
		return set;
		
	}
	
	public static int compareTwoSets(Set<Integer> first, Set<Integer> second) {
		long t0 = System.nanoTime();
		int counter=0;
		for (Integer i: first) {
			counter+=second.contains(i)?1:0;
		}
		long t1 = System.nanoTime();
		System.out.println("Set contains: "+ first.getClass().getCanonicalName() + "/"+ second.getClass().getCanonicalName() + " - "+ (t1-t0)/1000000+" ms.");
		return counter;
	}

}
