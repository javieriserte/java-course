package jai.course.inheritance.part4;


/**
 * Class to represent a sequence of DNA.
 * 
 * @author Javier Iserte
 *
 */
class DNA extends NucAcid {
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public DNA (String sequence) {
		this.setSequence(sequence);
	}

	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Methods
	public DNA seqComp() {
		String newSeq = this.getComplementarySequence();
		DNA result = new DNA(String.valueOf(newSeq));
		return result;
	}
	
	public RNA transcribe(){
		String newSeq = this.getSequence().replace('T', 'U').replace('t', 'u');
		return new RNA(newSeq);
	}
    
	
	
	@Override
	protected char getCompCharForAdenine() {
		return 'T';
	}
	// End of methods
	////////////////////////////////////////////////////////////////////////////
	
}
