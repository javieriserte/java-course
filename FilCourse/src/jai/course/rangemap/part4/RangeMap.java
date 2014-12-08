package jai.course.rangemap.part4;

/**
 * Interface for range maps.
 * Ranges in the maps are assumed that do not overlap.
 * Checking that a new range added to the map overlaps with an existing range
 * is implementation dependant and is not assured.
 * 
 * @author Javier Iserte
 *
 * @param <K> Range key
 * @param <V> Value.
 */
public interface RangeMap <K extends Comparable<K>,V> {
	
	/**
	 * Insert a new range with the corresponding return value in the map.
	 * Ranges in the maps are assumed that do not overlap.
     * Checking that a new range added to the map overlaps with an existing range
     * is implementation dependant and is not assured.
	 * @param key
	 * @param value
	 * @return The returning value is the insertion was succesful.
	 */
	public V put(Range<K> key, V value) ;
	
	/**
	 * Retrieves the associated value with the range cooresponding to the given 
	 * key. 
	 * @param key
	 * @return The corresponding value to the given key.
	 */
	public V get(K key) ;
	
}
