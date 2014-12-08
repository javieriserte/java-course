package jai.course.inheritance.part5;


/**
 * Class to represent a sequence of DNA.
 * 
 * @author Javier Iserte
 *
 */
class DNA extends NucAcid {
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	DNA (String sequence) {
		this.setSequence(sequence);
	}

	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Public interface
	/**
	 * Creates a new RNA molecule resulting of the transcription of this DNA
	 * molecule.
	 * @return a RNA molecule.
	 */
	RNA transcript(){
		
		String newSeq = this.getSequence().replace('T', 'U').replace('t', 'u');
		
		return new RNA(newSeq);
		
	}

	
	////////////////////////////////////////////////////////////////////////////
	// Protected and private methods
	protected char getCompCharForAdenine() {
		return 'T';
	}
	// End of methods
	////////////////////////////////////////////////////////////////////////////
	
}
