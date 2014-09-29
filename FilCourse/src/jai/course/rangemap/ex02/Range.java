package jai.course.rangemap.ex02;


/**
 * This class represents a Range of values.
 * 
 * @author Javier
 *
 * @param <K>
 */
public class Range {
	
	////////////////////////////////////////////////////////////////////////////
	// Instance Variables
	private Number upperBound;
	private Number lowerBound;
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
	public Range(Number lowerBound, Number upperBound, boolean lowerIsClosed, boolean upperIsClosed) {
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
	public boolean inRange(Number key) {

		int checkUpper = ((Double)key.doubleValue()).compareTo(this.getUpperBound().doubleValue());
		int checkLower = ((Double)key.doubleValue()).compareTo(this.getLowerBound().doubleValue());
			
		boolean res = (((checkUpper < 0) || (checkUpper == 0 && upperIsClosed)) && 
				       ((checkLower > 0) || (checkLower == 0 && lowerIsClosed)));
		return res;
	}
	
	public Number getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Number upperBound) {
		this.upperBound = upperBound;
	}

	public Number getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(Number lowerBound) {
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


	public boolean intersects(Range otherRange) {
		
		Number lower_r1 = this.getLowerBound();
		Number upper_r1 = this.getUpperBound();
		
		Number lower_r2 = otherRange.getLowerBound();
		Number upper_r2 = otherRange.getUpperBound();
		
		int u_r2_vs_l_r1 = ((Double)upper_r2.doubleValue()).compareTo((Double) lower_r1);
		int u_r1_vs_l_r2 = ((Double)upper_r1.doubleValue()).compareTo((Double) lower_r2);
		
		return ( u_r2_vs_l_r1>0 || (u_r2_vs_l_r1 == 0 && otherRange.isUpperClosed() && this.isLowerClosed())) && 
			   ( u_r1_vs_l_r2>0 || (u_r1_vs_l_r2 == 0 && otherRange.isLowerClosed() && this.isUpperClosed()));
		
	}
	
	public int compareLowerBounds(Range otherRange) {
		
		int diff = ((Double)this.getLowerBound().doubleValue()).compareTo(otherRange.getLowerBound().doubleValue());
		
		if (diff!=0) {
			return diff;
		} else {
			
			int tl = this.isLowerClosed()?0:1;
			int ol = otherRange.isLowerClosed()?0:1;
			return tl-ol;
		}
		
		
	}

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
	
	////////////////////////////////////////////////////////////////////////////
	

	
	

}