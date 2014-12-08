package jai.course.rangemap.part5;

import java.util.Set;

/**
 * This class represents a Node for the AVL implementation of 
 * RangeMap in the class AvlRangeMap. 
 * Is not intended that this class is instantiated outside AvlRangeMap code.
 * @author Javier
 *
 * @param <K>
 * @param <V>
 */
public class AvlRangeMapNode <K extends Comparable<K>,V>{

	/////////////////////////////////////////////////////////
	// Instance variables
	private Range<K> key;
	private AvlRangeMapNode<K, V> left;
	private AvlRangeMapNode<K, V> right;
	private int depth;
	private V value;
	/////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Constructors
	public AvlRangeMapNode(Range<K> key, V value) {
		this.key=key;
		this.value=value;
	}
	public AvlRangeMapNode(Range<K> key, V value, AvlRangeMapNode<K,V> left, AvlRangeMapNode<K,V> right) {
		this.key=key;
		this.value=value;
		this.left = left;
		this.right = right;
		if (left == null && right == null) {
			setDepth(1);
		} else if (left == null) { 
			setDepth(right.getDepth() + 1);
		} else if (right == null) {
			setDepth(left.getDepth() + 1);
		} else {
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
		}
	}
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Public interface
	/**
	 * String representation of a node.
	 */
	@Override
	public String toString() {
		String l = this.left==null?"":this.left.toString();
		String r = this.right==null?"":this.right.toString();
		return l + this.key.toString()+":"+this.getValue().toString() + System.lineSeparator() + r;
	}

	/**
	 * Alternative string representation of the node.
	 */
	public String treeString() {
		String l = this.left==null?"E":this.left.treeString();
		String r = this.right==null?"E":this.right.treeString();
		return "<" + l + " "+ this.key.toString()+":"+this.getValue().toString() + " "+ r + ">";
	}
	
	/**
	 * Retrieves the size of the subtree beyond this node. 
	 * @return
	 */
	public int size() {
		int sizeLeft = this.left!=null?(this.left.size()):0;
		int sizeRight = this.right!=null?(this.right.size()):0;
		return 1 + sizeLeft + sizeRight;
	}
	
	/**
	 * Add the range of this node and all subnodes beyond this point to the 
	 * given set of ranges.
	 * @param rangeSet
	 */
	public void collectRanges (Set<Range<K>> rangeSet) {
		
		rangeSet.add(this.key);
		
		if (this.left!=null) {
			this.left.collectRanges(rangeSet);
		}
		
		if (this.right!=null) {
			this.right.collectRanges(rangeSet);
		}

	}

	// Getters and setters
	
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Range<K> getKey() {
		return key;
	}
	public void setKey(Range<K> key) {
		this.key = key;
	}
	public AvlRangeMapNode<K,V> getLeft() {
		return left;
	}
	public void setLeft(AvlRangeMapNode<K,V> left) {
		this.left = left;
	}
	public AvlRangeMapNode<K,V> getRight() {
		return right;
	}
	public void setRight(AvlRangeMapNode<K,V> right) {
		this.right = right;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	// End of public interface
	////////////////////////////////////////////////////////////////////////////

}
