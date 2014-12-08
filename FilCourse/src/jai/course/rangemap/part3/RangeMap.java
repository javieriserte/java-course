package jai.course.rangemap.part3;

import java.util.ArrayList;
import java.util.List;

public class RangeMap <K extends Comparable<K>,V>{

	private List<Range<K>> ranges;
	private List<V> values;
	
	public RangeMap() {
		
		this.setRanges(new ArrayList<Range<K>>());
		this.setValues(new ArrayList<V>());
		
	}
	
	public void put(Range<K> key, V value) {
		
		this.getRanges().add(key);
		this.getValues().add(value);
		
		return ;
		
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
