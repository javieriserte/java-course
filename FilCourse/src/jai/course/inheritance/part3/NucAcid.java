package jai.course.inheritance.ex03;

/**
 * This class represents any nucleic Acid in an abstract way.
 * 
 * @author Javier Iserte
 *
 */
public abstract class NucAcid {
	
	////////////////////////////////////////////////////////////////////////////
	// Instance variables - Internal state
	String sequence;
	////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////
	// Constructor
	public NucAcid() {
		super();
	}
	////////////////////////////////////////////////////////////////////////////

	
	////////////////////////////////////////////////////////////////////////////
	// Methods
	abstract char getCompCharForAdenine();
	
	int length() {
		return this.getSequence().length();
	}

	void setSequence(String sequence) {
		this.sequence=sequence;
	}
	
	String getSequence() {
		return this.sequence;
	}
	
	String getComplementarySequence() {
		
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