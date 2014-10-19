package jai.course.inheritance.ex05;


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
	// Methods
	RNA transcript(){
		String newSeq = this.getSequence().replace('T', 'U').replace('t', 'u');
		return new RNA(newSeq);
	}

	char getCompCharForAdenine() {
		return 'T';
	}
	// End of methods
	////////////////////////////////////////////////////////////////////////////
	
}
