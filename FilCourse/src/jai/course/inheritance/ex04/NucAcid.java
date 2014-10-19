package jai.course.inheritance.ex04;

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
	abstract char getCompCharForAdenine() ;
	
	DNA getCompDNA(){

		DNA result = new DNA("");

		String newSeq = this.getComplementarySequence(result);
		
		result.setSequence(newSeq);

		return result;
		
	}
	
	RNA getCompRNA() {
		
		RNA result = new RNA("");
		
		String newSeq = this.getComplementarySequence(result);
		
		result.setSequence(newSeq);

		return result;
	}
	
	
	int length() {
		return this.getSequence().length();
	}

	void setSequence(String sequence) {
		this.sequence=sequence;
		
	}

	String getSequence() {
		return this.sequence;
	}
	
	String getComplementarySequence(NucAcid target) {
		
		int length = this.length();
		char[] newSeq = new char[length];
		for (int i=length; i>0;i--) {
			char currentChar = this.getSequence().charAt(i-1);
			switch (currentChar) {
			case 'a': case 'A':
				newSeq[length-i] = target.getCompCharForAdenine();
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