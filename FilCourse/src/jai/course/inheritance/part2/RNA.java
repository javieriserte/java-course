package jai.course.inheritance.part2;

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
		int length = this.length();
		char[] newSeq = new char[length];
		for (int i=length; i>0;i--) {
			char currentChar = this.getSequence().charAt(i-1);
			switch (currentChar) {
			case 'a': case 'A':
				newSeq[length-i] = 'U';
				break;

			case 'c': case 'C':
				newSeq[length-i] = 'G';
				break;

			case 'u': case 'U':
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
		NucAcid result = new RNA(String.valueOf(newSeq));
		return result;
	}

}
