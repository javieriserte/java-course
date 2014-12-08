package jai.course.inheritance.part3;


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
	DNA seqComp() {
		String newSeq = this.getComplementarySequence();
		DNA result = new DNA(String.valueOf(newSeq));
		return result;
	}
	
	RNA transcribe(){
		String newSeq = this.getSequence().replace('T', 'U').replace('t', 'u');
		return new RNA(newSeq);
	}
    
	
	
	@Override
	char getCompCharForAdenine() {
		return 'T';
	}
	// End of methods
	////////////////////////////////////////////////////////////////////////////
	
}
