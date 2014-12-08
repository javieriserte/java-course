package jai.course.rangemap.part1;


/**
 * This class represents a Range of values.
 * 
 * @author Javier
 */
public class Range {
	
	////////////////////////////////////////////////////////////////////////////
	// Instance Variables
	private Double upperBound;
	private Double lowerBound;
	private boolean upperIsClosed;
	private boolean lowerIsClosed;
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	/**
	 * Create a new Range object. It is required to define the lower and upper 
	 * bounds values and the open/closed limits.
	 *  
	 * @param upperBound
	 * @param lowerBound
	 * @param upperIsClosed
	 * @param lowerIsClosed
	 */
	public Range(Double lowerBound, Double upperBound, boolean lowerIsClosed, boolean upperIsClosed) {
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
	public boolean contains(Double key) {
			
		Double upper = this.getUpperBound();
		Double lower = this.getLowerBound();
		
		boolean res = (((key < upper) || (key == upper && this.isUpperClosed())) && 
				       ((key > lower) || (key == upper && this.isLowerClosed())));
		return res;
	}

	/**
	 * 
	 * Checks if the current range intersects with another range.
	 * @param otherRange
	 * @return
	 */
	public boolean intersects(Range otherRange) {
		
		Double lowerR1 = this.getLowerBound();
		Double upperR1 = this.getUpperBound();
		
		Double lowerR2 = otherRange.getLowerBound();
		Double upperR2 = otherRange.getUpperBound();
		
		boolean res = ( upperR2 > lowerR1 || (upperR2 == lowerR1 &&  otherRange.isUpperClosed() && this.isLowerClosed())) &&
				      ( upperR1 > lowerR2 || (upperR1 == lowerR2 &&  otherRange.isUpperClosed() && this.isLowerClosed()));
				
		return res;

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
	
	// Getters and Setters
	
	public Double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Double upperBound) {
		this.upperBound = upperBound;
	}

	public Double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Double lowerBound) {
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
