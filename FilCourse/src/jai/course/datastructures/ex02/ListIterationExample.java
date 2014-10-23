package jai.course.datastructures.ex02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterationExample {

	public static void main(String[] args) {
		
		ListIterationExample example = new ListIterationExample();
		List<Integer> l = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9,10,1});
		System.out.println(l);
		example.alternateByPairs(l);
		System.out.println(l);
		String s = example.toStringList(l);
		System.out.println(s);
		int i = example.countElementsEqualsTo(l, 1);
		System.out.println(i);

		
	}
	
	/**
	 * Reorder the elements of the given list in this way:
	 * any element at position i such that i is an odd number is interchanged
	 * with the element at i-1 position. 
	 * @param list
	 */
	public <K> void alternateByPairs(List<K> list) {
		
		for (int i = 0 ; i < Math.floor(list.size()/2)*2; i+=2) {
			
			int j=i+1;
			
			K elementAtI = list.get(i);
			K elementAtJ = list.get(j);
			 
			list.set(i, elementAtJ);
			list.set(j, elementAtI);
			
		}
		
	}
	
	/**
	 * Returns a String where each line is the String representation of each
	 * element in a given list.
	 * @param list
	 * @return
	 */
	public <K> String toStringList(List<K> list) {

		StringBuilder sb = new StringBuilder();
		
		Iterator<K> it = list.iterator();
		
		while(it.hasNext()) {
			
			K element =it.next();
			
			sb.append(element.toString());
			
			sb.append(System.getProperty("line.separator"));
			
		}
		
		return sb.toString();
		
	}
	
	/**
	 * Iterate over a list and count the number of times that a given element 
	 * appears in the list. The elements are tested by equality.
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public <K> int countElementsEqualsTo(List<K> haystack, K needle) {

		int counter =0;
		
		for (K k : haystack) {
			
			counter += (k.equals(needle)) ? 1 : 0;
			
		}
		
		return counter;
		
	}

}
