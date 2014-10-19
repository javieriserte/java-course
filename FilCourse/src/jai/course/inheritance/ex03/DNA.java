package jai.course.inheritance.ex03;


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
	@Override
	NucAcid seqComp() {
		
		String newSeq = this.getComplementarySequence();

		DNA result = new DNA(String.valueOf(newSeq));
		return result;
	}
	
	
	RNA transcript(){
		String newSeq = this.getSequence().replace('T', 'U').replace('t', 'u');
		return new RNA(newSeq);
	}

	@Override
	boolean isDNA() {
		return true;
	}

	@Override
	char getCompCharForAdenine() {
		return 'T';
	}
	// End of methods
	////////////////////////////////////////////////////////////////////////////
	
}
