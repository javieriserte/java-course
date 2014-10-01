package jai.course.rangemap.ex06;

import java.util.Comparator;

/**
 * Compares two ranges by its lower bound.
 * The total order is used first to compare the values,
 * then, if the two ranges has the same lower bound value, the open-closed
 * state of the range is used. A closed bound is considered lower than an open bound.
 * @author Javier Iserte
 *
 * @param <K> Any object the implements Comparable<K> interface.
 */
public class LowerBoundRangeComparator <K extends Comparable<K>> implements Comparator<Range<K>> {

	/**
	 * Compares two ranges by its lower bound value and open/closed state.
	 */
	@Override
	public int compare(Range<K> range1, Range<K> range2) {
		int diff = range1.getLowerBound().compareTo(range2.getLowerBound());
		
		if (diff!=0) {
			return diff;
		} else {
			
			int tl = range1.isLowerClosed()?0:1;
			int ol = range2.isLowerClosed()?0:1;
			return tl-ol;
		}
	}

}
