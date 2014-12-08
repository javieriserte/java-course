package jai.course.inheritance.part4;

/**
 * Class to represent a sequence of RNA.
 * 
 * @author Javier Iserte
 *
 */
public class RNA extends NucleicAcid{
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public RNA (String sequence) {
		this.setSequence(sequence);
	}
	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Methods
	public RNA seqComp() {
		String newSeq = this.getComplementarySequence();
		RNA result = new RNA(String.valueOf(newSeq));
		return result;
	}

	@Override
	protected char getCompCharForAdenine() {
		return 'U';
	}
	////////////////////////////////////////////////////////////////////////////

}
