package jai.course.terrainmap;

public class Block extends Region {
	
	
	////////////////////////////////////////////////////////////////////////////
	// Instance Variables
	private Region topRight;
	private Region topLeft;
	private Region bottomRight;
	private Region bottomLeft;
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public Block(Region topRight, Region topLeft,
			Region bottomRight, Region bottomLeft) {
		super();
		this.setTopRight(topRight);
		this.setTopLeft(topLeft);
		this.setBottomRight(bottomRight);
		this.setBottomLeft(bottomLeft);
		
	}
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Public interface
	@Override
	public Terrain getTerrain() {
		if (this.getBottomRight().getTerrain() == 
			this.getBottomLeft().getTerrain() && 
			this.getBottomLeft().getTerrain() ==
			this.getTopRight().getTerrain() &&
			this.getTopRight().getTerrain() ==
			this.getTopLeft().getTerrain() ) {
			return this.getBottomRight().getTerrain();
		} else {
			return Terrain.MIXED;
		}
	}

	@Override
	public Region simplify() {
		Terrain actual = this.getTerrain();
		switch (actual) {
		case MIXED:
			Region topRight = this.getTopRight().simplify();
			Region topLeft= this.getTopLeft().simplify();
			Region bottomRight = this.getBottomRight().simplify();
			Region bottomLeft= this.getBottomLeft().simplify();
			return new Block(topRight, topLeft, bottomRight, bottomLeft);
		default:
			return new UnitCell(actual);
		}

	}
	
	@Override
	public int countElements() {
		
		return this.getTopLeft().countElements() +
			   this.getTopRight().countElements()   +
			   this.getBottomLeft().countElements()  +
			   this.getBottomRight().countElements() + 1;
		
		
	}
	
	@Override
	public boolean isBlock() {
		return true;
	}
	
	public void setBottomLeft(Region abajoIzquierda) {
		this.bottomLeft = abajoIzquierda;
	}
	public Region getBottomLeft() {
		return this.bottomLeft;
	}
	public void setBottomRight(Region abajoDerecha) {
		this.bottomRight = abajoDerecha;
	}
	public Region getBottomRight() {
		return this.bottomRight;
	}
	public void setTopLeft(Region arribaIzquierda) {
		this.topLeft = arribaIzquierda;
	}
	public Region getTopLeft() {
		return topLeft;
	}
	public void setTopRight(Region arribaDerecha) {
		this.topRight = arribaDerecha;
	}
	public Region getTopRight() {
		return topRight;
	}
	// End of public interface
	////////////////////////////////////////////////////////////////////////////
	
}
