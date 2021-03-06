package jai.course.hanoi;

public class Ring {
	
	////////////////////////////////////////////////////////////////////////////
	// Private Methods
	private int radio;
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public int getRadio() {
		return radio;
	}
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Public Interface
	public void setRadio(int radio) {
		this.radio = radio;
	}

	public Ring(int radio) {
		super();
		this.setRadio(radio);
	}
	////////////////////////////////////////////////////////////////////////////

}
