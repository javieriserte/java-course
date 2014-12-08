package jai.course.rangemap.part5;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a RangeMap as a list of ranges.
 * 
 * @author Javier
 *
 * @param <K>
 * @param <V>
 */
public class ListRangeMap<K extends Comparable<K>,V> implements RangeMap<K , V> {

	////////////////////////////////////////////////////////////////////////////
	// Intance variables
	private List<Range<K>> ranges;
	// List to store ranges
	private List<V> values;
	// List to store returning values
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public ListRangeMap() {
		
		this.setRanges(new ArrayList<Range<K>>());
		// Creates an new empty list for ranges.
		this.setValues(new ArrayList<V>());
		// Creates an new empty list for values.
		
	}
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Public Interface
	/**
	 * Adds a new range to the map, with its corresponding return value.
	 */
	public V put(Range<K> key, V value) {
		
		this.getRanges().add(key);
		
		this.getValues().add(value);
		
		return value;
		
	}

	/**
	 * Retrieves the value corresponding to the given key.
	 */
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
	// End of public interface
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Private methods
	// Getters and setters
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
	// End of private and protected methods
	////////////////////////////////////////////////////////////////////////////
	
}
