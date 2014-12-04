package jai.course.inheritance.ex05;

/**
 * This class represents any nucleic Acid in an abstract way.
 * 
 * @author Javier Iserte
 *
 */
public abstract class NucAcid {
	
	////////////////////////////////////////////////////////////////////////////
	// Instance variables - Internal state
	private String sequence;
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Public Interface
	/**
	 * Returns a new DNA molecule whose sequence is complementary to the 
	 * sequence of this molecule. 
	 * 
	 * @return a DNA molecule.
	 */
	public DNA getCompDNA(){

		DNA result = new DNA("");

		String newSeq = this.getComplementarySequence(result);
		
		result.setSequence(newSeq);

		return result;
		
	}

	/**
	 * Returns a new RNA molecule whose sequence is complementary to the 
	 * sequence of this molecule. 
	 * 
	 * @return a RNA molecule.
	 */
	public RNA getCompRNA() {
		
		RNA result = new RNA("");
		
		String newSeq = this.getComplementarySequence(result);
		
		result.setSequence(newSeq);

		return result;
	}
	
	/**
	 * Retrieves the number of characters of the molecule's sequence.
	 * @return
	 */
	public int length() {
		return this.getSequence().length();
	}

	/**
	 * Set a new sequence to the molecule.
	 * @param sequence is a String representing the new sequence.
	 */
	public void setSequence(String sequence) {
		this.sequence=sequence;
		
	}

	/**
	 * Retrieves a String representing the molecule's sequence.
	 * @return the molecule's sequence.
	 */
	public String getSequence() {
		return this.sequence;
	}
	// End of Public interface
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Private and protected methods
	protected abstract char getCompCharForAdenine() ;
	
	private String getComplementarySequence(NucAcid target) {
		
		int longitud = this.length();
		char[] newSeq = new char[longitud];
		for (int i=longitud; i>0;i--) {
			char currentChar = this.getSequence().charAt(i-1);
			switch (currentChar) {
			case 'a': case 'A':
				newSeq[longitud-i] = target.getCompCharForAdenine();
				break;

			case 'c': case 'C':
				newSeq[longitud-i] = 'G';
				break;

			case 't': case 'T': case 'u': case 'U':
				newSeq[longitud-i] = 'A';
				break;

			case 'g': case 'G':
				newSeq[longitud-i] = 'C';
				break;

			case '-': 
				newSeq[longitud-i] = '-';
				break;

			default:
				newSeq[longitud-i] = 'N';
				break;
			}
			
		}
		return sequence;
		
	}
	////////////////////////////////////////////////////////////////////////////

}