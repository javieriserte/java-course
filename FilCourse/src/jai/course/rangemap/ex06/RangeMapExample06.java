package jai.course.rangemap.ex06;

import java.util.ArrayList;
import java.util.List;

public class RangeMapExample06 {

	public static void main(String[] args) {

		RangeMap<Integer, String> map1 = new AvlRangeMap<>();
		RangeMap<Integer, String> map2 = new ListRangeMap<>();

		
		int nRanges =300000;
		
		List<Integer> l = new ArrayList<>();
			
		for (int i=0; i<10000; i++) {
		
			int rnd = (int) Math.floor(Math.random()*1000);
			
			l.add(rnd);
			
		}
		
		
		long t0 = System.currentTimeMillis();
		
		for (int i=0; i<=nRanges ;i++) {
			
			Range<Integer> r = new Range<>(i, i, true, true);
			map1.put(r, String.valueOf(i));
			
		}
		long t1 = System.currentTimeMillis();
		for (int i=0; i<=nRanges ;i++) {
			
			Range<Integer> r = new Range<>(i, i, true, true);
			map2.put(r, String.valueOf(i));
			
		}
		long t2 = System.currentTimeMillis();
		
		for (Integer integer : l) {
			
			map1.get(integer);
			
		}
		
		long t3 = System.currentTimeMillis();
		
		for (Integer integer : l) {
			
			map2.get(integer);
			
		}
		
		long t4 = System.currentTimeMillis();
		System.out.println("insert avl:" + (t1-t0) + " / list: " + (t2-t1));
		System.out.println("get    avl:" + (t3-t2) + " / list: " + (t4-t3));
	}

}
