package jai.course.terrainmap;

public abstract class Region {
	
	public abstract Terrain getTerrain();
	
	public abstract Region simplify();
	
	public abstract int countElements();
	
	public abstract boolean isBlock();
	
}
