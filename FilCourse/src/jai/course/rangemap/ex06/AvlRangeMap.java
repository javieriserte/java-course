package jai.course.rangemap.ex06;

import java.util.HashSet;
import java.util.Set;


// Check code:
// http://code.antonio081014.com/2013/07/generic-avl-tree-implementation-in-java.html
public class AvlRangeMap<K extends Comparable<K>,V> implements RangeMap<K,V>{
	private Set<V> values;
	private RangeMapNode<K, V> root;
	
	public AvlRangeMap() {
		super();
		this.values  = new HashSet<V>();
		this.root=null;
	}
	

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

		 public RangeMapNode<K,V> put(RangeMapNode<K,V> node, Range<K> key, V value) {
			 if (node == null) {
				 this.values.add(value);
				 return new RangeMapNode<K,V>(key,value);
			 }

			 if (node.getKey().compareLowerBounds(key) > 0) {
				 node = new RangeMapNode<K,V>(node.getKey(), node.getValue(), put(node.getLeft(), key, value),
						 node.getRight());
			 } else if (node.getKey().compareLowerBounds(key) < 0) {
				 node = new RangeMapNode<K,V>(node.getKey(), node.getValue(), node.getLeft(), put(
						 node.getRight(), key, value));
			 } 
		  // After insert the new node, check and rebalance the current node if
		  // necessary.
		  switch (balanceNumber(node)) {
		  case 1:
		   node = rotateLeft(node);
		   break;
		  case -1:
		   node = rotateRight(node);
		   break;
		  default:
		   return node;
		  }
		  return node;
		 }

		 public V get(K key) {
			 RangeMapNode<K,V> local = root;
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

		 private int depth(RangeMapNode<K,V> node) {
			 if (node == null)
				 return 0;
			 return node.getDepth();
		 }
		 
		 public int getDepth() {
			 
			 return this.depth(root);
			 
		 }
		 
		 private int balanceNumber(RangeMapNode<K,V> node) {
			 int L = depth(node.getLeft());
			 int R = depth(node.getRight());
			 if (L - R >= 2)
				 return -1;
			 else if (L - R <= -2)
				 return 1;
			 return 0;
		 }

		 private RangeMapNode<K,V> rotateLeft(RangeMapNode<K,V> node) {
			 RangeMapNode<K,V> q = node;
			 RangeMapNode<K,V> p = q.getRight();
			 RangeMapNode<K,V> c = q.getLeft();
			 RangeMapNode<K,V> a = p.getLeft();
			 RangeMapNode<K,V> b = p.getRight();
			 q = new RangeMapNode<K,V>(q.getKey(), q.getValue(), c, a);
			 p = new RangeMapNode<K,V>(p.getKey(), p.getValue(), q, b);
			 return p;
		 }

		 private RangeMapNode<K,V> rotateRight(RangeMapNode<K,V> node) {
			 RangeMapNode<K,V> q = node;
			 RangeMapNode<K,V> p = q.getLeft();
			 RangeMapNode<K,V> c = q.getRight();
			 RangeMapNode<K,V> a = p.getLeft();
			 RangeMapNode<K,V> b = p.getRight();
		  q = new RangeMapNode<K,V>(q.getKey(), q.getValue(), b, c);
		  p = new RangeMapNode<K,V>(p.getKey(), p.getValue(), a, q);
		  return p;
		 }
	

	public int size() {
		if (this.root!=null){
		 return this.root.size();
		} else {
			return 0;
		}
	}

	public boolean isEmpty() {
		return this.root==null;
	}

	public boolean containsValue(V value) {
		return this.values.contains(value);
	}

	public void clear() {
		this.values.clear();
		this.root=null;
	}

	public Set<Range<K>> keyRangeSet() {
		Set<Range<K>> rangeSet = new HashSet<Range<K>>();
		this.root.collectRanges(rangeSet);
		return rangeSet;
	}

	public Set<V> values() {
		return this.values;
	}
	@Override
	public String toString () {

		return this.root.toString();
		
	}
	
	public String treeString () {
		System.out.println(this.depth(root));
		return this.root.treeString();
	}
	
}
