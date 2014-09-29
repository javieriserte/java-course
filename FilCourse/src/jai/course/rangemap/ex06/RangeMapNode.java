package jai.course.rangemap.ex06;

import java.util.Set;


public class RangeMapNode <K extends Comparable<K>,V>{

	/////////////////////////////////////////////////////////
	// Instance variables
	private Range<K> key;
	private RangeMapNode<K, V> left;
	private RangeMapNode<K, V> right;
	private int depth;
	private V value;
	/////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Constructors
	public RangeMapNode(Range<K> key, V value) {
		this.key=key;
		this.value=value;
	}
	public RangeMapNode(Range<K> key, V value, RangeMapNode<K,V> left, RangeMapNode<K,V> right) {
		this.key=key;
		this.value=value;
		this.left = left;
		this.right = right;
		if (left == null && right == null)
			setDepth(1);
		else if (left == null)
			setDepth(right.getDepth() + 1);
		else if (right == null)
			setDepth(left.getDepth() + 1);
		else
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
	}
	////////////////////////////////////////////////////////////////////////////
	
	
	public Range<K> getKey() {
		return key;
	}

	public void setKey(Range<K> key) {
		this.key = key;
	}

	public RangeMapNode<K,V> getLeft() {
		return left;
	}

	public void setLeft(RangeMapNode<K,V> left) {
		this.left = left;
	}

	public RangeMapNode<K,V> getRight() {
		return right;
	}

	public void setRight(RangeMapNode<K,V> right) {
		this.right = right;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		String l = this.left==null?"":this.left.toString();
		String r = this.right==null?"":this.right.toString();
		return l + this.key.toString()+":"+this.getValue().toString() + System.lineSeparator() + r;
	}
	
	public String treeString() {
		String l = this.left==null?"E":this.left.treeString();
		String r = this.right==null?"E":this.right.treeString();
		return "<" + l + " "+ this.key.toString()+":"+this.getValue().toString() + " "+ r + ">";
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public int size() {
		int sizeLeft = this.left!=null?(this.left.size()):0;
		int sizeRight = this.right!=null?(this.right.size()):0;
		return 1 + sizeLeft + sizeRight;
	}
	
	public void collectRanges (Set<Range<K>> rangeSet) {
		
		rangeSet.add(this.key);
		
		if (this.left!=null) {
			this.left.collectRanges(rangeSet);
		}
		
		if (this.right!=null) {
			this.right.collectRanges(rangeSet);
		}

	}
}
