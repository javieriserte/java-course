package jai.course.inheritance.part4;

/**
 * This class represents any nucleic Acid in an abstract way.
 * 
 * @author Javier Iserte
 *
 */
public abstract class NucleicAcid {
	
	////////////////////////////////////////////////////////////////////////////
	// Instance variables - Internal state
	String sequence;
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public NucleicAcid() {
		super();
	}
	////////////////////////////////////////////////////////////////////////////

	
	////////////////////////////////////////////////////////////////////////////
	// Methods
	protected abstract char getCompCharForAdenine();
	
	public int length() {
		return this.getSequence().length();
	}

	protected void setSequence(String sequence) {
		this.sequence=sequence;
		
	}
	
	public String getSequence() {
		return this.sequence;
	}
	
	protected String getComplementarySequence() {
		
		int length = this.length();
		char[] newSeq = new char[length];
		for (int i=length; i>0;i--) {
			char currentChar = this.getSequence().charAt(i-1);
			switch (currentChar) {
			case 'a': case 'A':
				newSeq[length-i] = this.getCompCharForAdenine();
				break;

			case 'c': case 'C':
				newSeq[length-i] = 'G';
				break;

			case 't': case 'T': case 'u': case 'U':
				newSeq[length-i] = 'A';
				break;

			case 'g': case 'G':
				newSeq[length-i] = 'C';
				break;

			case '-': 
				newSeq[length-i] = '-';
				break;

			default:
				newSeq[length-i] = 'N';
				break;
			}
			
		}
		return sequence;
		
	}
	// End of Methods
	////////////////////////////////////////////////////////////////////////////

}