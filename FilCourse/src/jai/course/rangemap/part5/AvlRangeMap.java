package jai.course.rangemap.part5;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of RangeMap interface using AVL trees.
 * Code was based in generic AVL tree implementation found at:
 * http://code.antonio081014.com/2013/07/generic-avl-tree-implementation-in-java.html
 * 
 * @author Javier
 *
 * @param <K>
 * @param <V>
 */
public class AvlRangeMap<K extends Comparable<K>,V> implements RangeMap<K,V>{
	
	////////////////////////////////////////////////////////////////////////////
	// Instance variables
	private Set<V> values;
	// A set of values, for quick retrieval of values if required.
	private AvlRangeMapNode<K, V> root;
	// The root a the AVL tree.
	private LowerBoundRangeComparator<K> lowerBoundComparator;
	// A Comparator to order Ranges in the AVL tree
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public AvlRangeMap() {
		super();
		this.values  = new HashSet<V>();
		this.root=null;
		this.setLowerBoundComparator(new LowerBoundRangeComparator<K>());
	}
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Public interface
	/**
	 * Adds a new range to the map with its corresponding return value.
	 */
	public V put(Range<K> key, V value) {
		root = put(root, key, value);
		switch (balanceNumber(root)) {
		case 1:
			root = rotateLeft(root);
			break;
		case -1:
			root = rotateRight(root);
			break;
		default:
			break;
		}
		return value;
	}
	
	/**
	 * Retrieves the value associated with a given key.
	 */
	public V get(K key) {
		AvlRangeMapNode<K,V> local = root;
		while (local != null) {
			if (local.getKey().inRange(key))
				return local.getValue();
			else if (local.getKey().getLowerBound().compareTo(key) >= 0)
				local = local.getLeft();
			else
				local = local.getRight();
		}
		return null;
	}

	/**
	 * Gets the depth of the AVLtree
	 * @return
	 */
	public int getDepth() {

		return this.depth(root);

	}

	/**
	 * Gets the number of nodes of the tree.
	 * @return
	 */
	public int size() {
		if (this.root!=null){
			return this.root.size();
		} else {
			return 0;
		}
	}

	/**
	 * Check if the map is empty.
	 * @return
	 */
	public boolean isEmpty() {
		return this.root==null;
	}

	/**
	 * Check if a given value is returned by any range in the map.
	 * @param value
	 * @return
	 */
	public boolean containsValue(V value) {
		return this.values.contains(value);
	}

	/**
	 * Removes all data in the map.
	 */
	public void clear() {
		this.values.clear();
		this.root=null;
	}

	/**
	 * Retrieves a set of all ranges in the map.
	 * @return
	 */
	public Set<Range<K>> keyRangeSet() {
		Set<Range<K>> rangeSet = new HashSet<Range<K>>();
		this.root.collectRanges(rangeSet);
		return rangeSet;
	}

	/**
	 * Retrieves all values in the map.
	 * @return
	 */
	public Set<V> values() {
		return this.values;
	}
	
	/**
	 * String representation of the map.
	 */
	@Override
	public String toString () {

		return this.root.toString();
		
	}
	
	/**
	 * String representation of the map as a tree.
	 * @return
	 */
	public String treeString () {
		System.out.println(this.depth(root));
		return this.root.treeString();
	}
	// End of public interface
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Private methods
	private int depth(AvlRangeMapNode<K,V> node) {
		if (node == null) {
			return 0;
		} else {
			return node.getDepth();
		}
	}
	
	private int balanceNumber(AvlRangeMapNode<K,V> node) {
		int L = depth(node.getLeft());
		int R = depth(node.getRight());
		if (L - R >= 2)
			return -1;
		else if (L - R <= -2)
			return 1;
		return 0;
	}

	private AvlRangeMapNode<K,V> rotateLeft(AvlRangeMapNode<K,V> node) {
		/*
		 *       q             p
		 *      / \           / \
		 *     c   p   ==>   q   b 
		 *        / \       / \
		 *       a   b     c   a
		 */
		AvlRangeMapNode<K,V> q = node;
		AvlRangeMapNode<K,V> p = q.getRight();
		AvlRangeMapNode<K,V> c = q.getLeft();
		AvlRangeMapNode<K,V> a = p.getLeft();
		AvlRangeMapNode<K,V> b = p.getRight();
		q = new AvlRangeMapNode<K,V>(q.getKey(), q.getValue(), c, a);
		p = new AvlRangeMapNode<K,V>(p.getKey(), p.getValue(), q, b);
		return p;
	}

	private AvlRangeMapNode<K,V> rotateRight(AvlRangeMapNode<K,V> node) {
		/*
		 *       q             p
		 *      / \           / \
		 *     p   c   ==>   a   q 
		 *    / \               / \
		 *   a   b             b   c 
		 */
		AvlRangeMapNode<K,V> q = node;
		AvlRangeMapNode<K,V> p = q.getLeft();
		AvlRangeMapNode<K,V> c = q.getRight();
		AvlRangeMapNode<K,V> a = p.getLeft();
		AvlRangeMapNode<K,V> b = p.getRight();
		q = new AvlRangeMapNode<K,V>(q.getKey(), q.getValue(), b, c);
		p = new AvlRangeMapNode<K,V>(p.getKey(), p.getValue(), a, q);
		return p;
	}
	
	private LowerBoundRangeComparator<K> getLowerBoundComparator() {
		return lowerBoundComparator;
	}

	private void setLowerBoundComparator(
			LowerBoundRangeComparator<K> lowerBoundComparator) {
		this.lowerBoundComparator = lowerBoundComparator;
	}
	
	private AvlRangeMapNode<K,V> put(AvlRangeMapNode<K,V> node, Range<K> key, V value) {
		
		if (node == null) {
			this.values.add(value);
			return new AvlRangeMapNode<K,V>(key,value);
		}

		int lowerBoundComparisonResult = this.getLowerBoundComparator().compare(node.getKey(), key);
		
		if (lowerBoundComparisonResult > 0) {
			// Insert the new node on the left branch. 
			node = new AvlRangeMapNode<K,V>(node.getKey(), node.getValue(), put(node.getLeft(), key, value), node.getRight());
		} else if (lowerBoundComparisonResult < 0) {
			// Insert the new node on the right branch. 
			node = new AvlRangeMapNode<K,V>(node.getKey(), node.getValue(), node.getLeft(), put( node.getRight(), key, value));
		} 
		// After insert the new node, check and rebalance the current node if
		// necessary.
		switch (this.balanceNumber(node)) {
		case 1:
			// Rebalance 
			node = this.rotateLeft(node);
			break;
		case -1:
			// Rebalance
			node = this.rotateRight(node);
			break;
		default:
			// No rebalance required
			return node;
		}
		return node;
	}
	////////////////////////////////////////////////////////////////////////////

}
