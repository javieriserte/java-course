package jai.course.rangemap.ex05;

public interface RangeMap <K extends Comparable<K>,V> {
	
	public V put(Range<K> key, V value) ;
	
	public V get(K key) ;
	
}
