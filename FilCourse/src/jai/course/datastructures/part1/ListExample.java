package jai.course.datastructures.part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExample {
	
	public static void main(String ... args) {
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new LinkedList<>();
		List<Integer> l3 = new Vector<>();
		
		l1 = createRandomArray(l1, 5000, 1000000);
		l2 = createRandomArray(l2, 5000, 1000000);
		l3 = createRandomArray(l3, 5000, 1000000);
		
		List<List<Integer>> lists = new ArrayList<>();
		
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);

		compareAllLists(lists);
		
		
	}

	private static List<Integer> createRandomArray(List<Integer> emptyList, int length, int maxValue) {
		
		for(int i = 0; i<length ; i++) {
			
		   emptyList.add((int) (Math.random() * maxValue) + 1); 
			
		}
		return emptyList;
	}
	
	private static int compareTwoLists(List<Integer> first, List<Integer> second) {
		int count = 0;
		for (int i : first) {
			
			count += second.contains(i)?1:0;
			
		}
		return count;
	}
	
	private static void compareAllLists(List<List<Integer>> lists) {
	
		for(int i=0; i<lists.size()-1; i++) {
			
			for(int j=i+1; j<lists.size(); j++) {
				
				int count = compareTwoLists(lists.get(i), lists.get(j));
				
				System.out.println("List "+i+" vs "+" list " + j + " : " + count );
				
			}
			
		}
		
	}
	

}
