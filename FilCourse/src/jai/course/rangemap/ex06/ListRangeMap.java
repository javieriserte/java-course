package jai.course.rangemap.ex06;


import java.util.ArrayList;
import java.util.List;

public class ListRangeMap <K extends Comparable<K>,V> implements RangeMap<K , V> {

	private List<Range<K>> ranges;
	private List<V> values;
	
	public ListRangeMap() {
		
		this.setRanges(new ArrayList<Range<K>>());
		this.setValues(new ArrayList<V>());
		
	}
	
	public V put(Range<K> key, V value) {
		
		this.getRanges().add(key);
		this.getValues().add(value);
		
		return value;
		
	}
	
	public V get(K key) {
		
		int counter=0;
		for (Range<K> range : this.getRanges()) {
			
			if (range.inRange(key)) {
				return this.getValues().get(counter);
			}
			
			counter++;
		}
		
		return null;
		
	}
	
	
	
	private List<V> getValues() {
		
		return this.values;
	}

	private List<Range<K>> getRanges() {
	
		return this.ranges;
	}

	private void setValues(List<V> values) {
		
		this.values = values;
		
	}

	private void setRanges(List<Range<K>> ranges) {
		
		this.ranges = ranges;
		
	}

}
