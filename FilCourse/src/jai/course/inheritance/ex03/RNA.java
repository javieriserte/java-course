package jai.course.inheritance.ex03;

/**
 * Class to represent a sequence of RNA.
 * 
 * @author Javier Iserte
 *
 */
public class RNA extends NucAcid{
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	RNA (String sequence) {
		this.setSequence(sequence);
	}

	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Methods
	NucAcid seqComp() {
		String newSeq = this.getComplementarySequence();
		DNA result = new DNA(String.valueOf(newSeq));
		return result;
	}

	@Override
	boolean isDNA() {
		return false;
	}
	
	@Override
	char getCompCharForAdenine() {
		return 'U';
	}

}
