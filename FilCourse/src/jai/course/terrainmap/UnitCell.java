package jai.course.terrainmap;

public class UnitCell extends Region {
	///////////////////////////////
	// Instance Variables
	private Terrain terrain;

	
	
	///////////////////////////////
	// Constructor
	public UnitCell(Terrain terrain) {
		super();
		this.setTerreno(terrain);
	}

	///////////////////////////////
	// Getters and Setters
	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerreno(Terrain terreno) {
		if (terreno==Terrain.MIXED) {
			System.err.println("No se puede asignar terreno mezclado a una unidad");
			System.exit(1);
			
		}
		this.terrain = terreno;
	}

	@Override
	public Region simplify() {

		return this;
		
	}
	
	@Override
	public int countElements() {
		return 1;
	}

	@Override
	public boolean isBlock() {

		return false;
	}


}
