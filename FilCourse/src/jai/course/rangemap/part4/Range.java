package jai.course.rangemap.part4;

/**
 * This class represents a Range of values.
 * 
 * @author Javier
 *
 */
public class Range<K extends Comparable<K>> {
	
	////////////////////////////////////////////////////////////////////////////
	// Instance Variables
	private K upperBound;
	private K lowerBound;
	private boolean upperIsClosed;
	private boolean lowerIsClosed;
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	/**
	 * Create a new Range object. This implementation do not manages well
	 * range with zero length. I.e. (1,1), [1,1) or (1,1].
	 * The equals methods is used to test if two ranges overlaps. This 
	 * Range is intended to be used only as part of RangeMap. Do not use it for
	 * other work. 
	 *  
	 * @param upperBound
	 * @param lowerBound
	 * @param upperIsClosed
	 * @param lowerIsClosed
	 */
	public Range(K lowerBound, K upperBound, boolean lowerIsClosed, boolean upperIsClosed) {
		this.setLowerBound(lowerBound);
		this.setUpperBound(upperBound);
		this.setUpperIsClosed(upperIsClosed);
		this.setLowerIsClosed(lowerIsClosed);

	}
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Public Interface
	/**
	 * Checks if a given value is in the range.
	 * @param key
	 * @return true if the key is between the upper and lower bounds of the Range.
	 */
	public boolean inRange(K key) {

		int checkUpper = key.compareTo(this.getUpperBound());
		int checkLower = key.compareTo(this.getLowerBound());
			
		boolean res = (((checkUpper < 0) || (checkUpper == 0 && upperIsClosed)) && 
				       ((checkLower > 0) || (checkLower == 0 && lowerIsClosed)));
		return res;
	}
	
	/**
	 * 
	 * Checks if the current range intersects with another range.
	 * @param otherRange
	 * @return
	 */
	public boolean intersects(Range<K> otherRange) {
		
		K lower_r1 = this.getLowerBound();
		K upper_r1 = this.getUpperBound();
		
		K lower_r2 = otherRange.getLowerBound();
		K upper_r2 = otherRange.getUpperBound();
		
		int u_r2_vs_l_r1 = upper_r2.compareTo(lower_r1);
		int u_r1_vs_l_r2 = upper_r1.compareTo(lower_r2);
		
		return ( u_r2_vs_l_r1>0 || (u_r2_vs_l_r1 == 0 && otherRange.isUpperClosed() && this.isLowerClosed())) && 
			   ( u_r1_vs_l_r2>0 || (u_r1_vs_l_r2 == 0 && otherRange.isLowerClosed() && this.isUpperClosed()));
		
	}
	
	/**
	 * 
	 * String representation of a range.
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.isLowerClosed()?"[":"(");
		sb.append(this.getLowerBound().toString());
		sb.append(",");
		sb.append(this.getUpperBound().toString());
		sb.append(this.isUpperClosed()?"]":")");
		return sb.toString();
	}

	// Getters and setters
	
	public K getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(K upperBound) {
		this.upperBound = upperBound;
	}

	public K getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(K lowerBound) {
		this.lowerBound = lowerBound;
	}

	public boolean isUpperClosed() {
		return upperIsClosed;
	}

	public void setUpperIsClosed(boolean upperIsClosed) {
		this.upperIsClosed = upperIsClosed;
	}

	public boolean isLowerClosed() {
		return lowerIsClosed;
	}

	public void setLowerIsClosed(boolean lowerIsClosed) {
		this.lowerIsClosed = lowerIsClosed;
	}
	// End of public interface
	////////////////////////////////////////////////////////////////////////////
	

	
	

}
