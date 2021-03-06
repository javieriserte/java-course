package jai.course.inheritance.part3;

/**
 * Class to represent a sequence of RNA.
 * 
 * @author Javier Iserte
 *
 */
public class RNA extends NucleicAcid{
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	RNA (String sequence) {
		this.setSequence(sequence);
	}
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Methods
	RNA seqComp() {
		String newSeq = this.getComplementarySequence();
		RNA result = new RNA(String.valueOf(newSeq));
		return result;
	}

	@Override
	char getCompCharForAdenine() {
		return 'U';
	}
	////////////////////////////////////////////////////////////////////////////

}
