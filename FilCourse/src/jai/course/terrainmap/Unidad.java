package jai.course.terrainmap;

public class Unidad extends Region {
	///////////////////////////////
	// Instance Variables
	private Terreno terreno;

	
	
	///////////////////////////////
	// Constructor
	public Unidad(Terreno terreno) {
		super();
		this.setTerreno(terreno);
	}

	///////////////////////////////
	// Getters and Setters
	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		if (terreno==Terreno.Mezclado) {
			System.err.println("No se puede asignar terreno mezclado a una unidad");
			System.exit(1);
			
		}
		this.terreno = terreno;
	}

	@Override
	public Region simplificar() {

		return this;
		
	}
	
	@Override
	public int countElements() {
		return 1;
	}


}
