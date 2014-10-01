package jai.course.terrainmap;

public abstract class Region {
	
	public abstract Terreno getTerreno();
	
	public abstract Region simplificar();
	
	public abstract int countElements();
	
	public abstract boolean isBlock();
	
}
