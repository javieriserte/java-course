package jai.course.inheritance.part2;


/**
 * Class to represent a sequence of DNA.
 * 
 * @author Javier Iserte
 *
 */
class DNA extends NucleicAcid {
	
	////////////////////////////////////////////////////////////////////////////
	// Constructor
	DNA (String sequence) {
		this.setSequence(sequence);
	}

	////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////
	// Methods
	@Override
	NucleicAcid seqComp() {
		int length = this.length();
		char[] newSeq = new char[length];
		for (int i=length; i>0;i--) {
			char currentChar = this.getSequence().charAt(i-1);
			switch (currentChar) {
			case 'a': case 'A':
				newSeq[length-i] = 'T';
				break;

			case 'c': case 'C':
				newSeq[length-i] = 'G';
				break;

			case 't': case 'T':
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
		DNA result = new DNA(String.valueOf(newSeq));
		return result;
	}
	
	
	RNA transcribe(){
		String newSeq = this.getSequence().replace('T', 'U').replace('t', 'u');
		return new RNA(newSeq);
	}


	
}
