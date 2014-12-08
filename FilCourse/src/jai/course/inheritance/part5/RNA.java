package jai.course.inheritance.part5;

/**
 * Class to represent a sequence of RNA.
 * 
 * @author Javier Iserte
 *
 */
public class RNA extends NucleicAcid{
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	/**
	 * Creates a new RNA molecule.
	 * @param sequence is a String representing the molecule's sequence.
	 */
	RNA (String sequence) {
		this.setSequence(sequence);
	}
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Protected and private methods
	protected char getCompCharForAdenine() {
		return 'U';
	}
	// End of methods
	//////////////////////////////////////////////////////////////////////////// 


}
