package jai.course.terrainmap;



public class Bloque extends Region {
	
	
	///////////////////////////////
	// Instance Variables
	private Region arribaDerecha;
	private Region arribaIzquierda;
	private Region abajoDerecha;
	private Region abajoIzquierda;
	
	///////////////////////////////
	// Constructor
	public Bloque(Region arribaDerecha, Region arribaIzquierda,
			Region abajoDerecha, Region abajoIzquierda) {
		super();
		this.setArribaDerecha(arribaDerecha);
		this.setArribaIzquierda(arribaIzquierda);
		this.setAbajoDerecha(abajoDerecha);
		this.setAbajoIzquierda(abajoIzquierda);
		
	}
	
	////////////////////////////////////
	// Public interface
	@Override
	public Terreno getTerreno() {
		if (this.getAbajoDerecha().getTerreno() == 
			this.getAbajoIzquierda().getTerreno() && 
			this.getAbajoIzquierda().getTerreno() ==
			this.getArribaDerecha().getTerreno() &&
			this.getArribaDerecha().getTerreno() ==
			this.getArribaIzquierda().getTerreno() ) {
			return this.getAbajoDerecha().getTerreno();
		} else {
			return Terreno.Mezclado;
		}
	}

	@Override
	public Region simplificar() {
		Terreno actual = this.getTerreno();
		switch (actual) {
		case Mezclado:
			return this;
		default:
			return new Unidad(actual);
		}

	}
	
	///////////////////////////////
	// Getters and Setters
	public void setAbajoIzquierda(Region abajoIzquierda) {
		this.abajoIzquierda = abajoIzquierda;
	}
	public Region getAbajoIzquierda() {
		return this.abajoIzquierda;
	}
	public void setAbajoDerecha(Region abajoDerecha) {
		this.abajoDerecha = abajoDerecha;
	}
	public Region getAbajoDerecha() {
		return this.abajoDerecha;
	}
	public void setArribaIzquierda(Region arribaIzquierda) {
		this.arribaIzquierda = arribaIzquierda;
	}
	public Region getArribaIzquierda() {
		return arribaIzquierda;
	}
	public void setArribaDerecha(Region arribaDerecha) {
		this.arribaDerecha = arribaDerecha;
	}
	public Region getArribaDerecha() {
		return arribaDerecha;
	}


	
}
