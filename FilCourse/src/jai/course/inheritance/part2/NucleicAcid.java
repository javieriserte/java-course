package jai.course.inheritance.part2;

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
	abstract NucleicAcid seqComp();

	int length() {
		return this.getSequence().length();
	}

	void setSequence(String sequence) {
		this.sequence=sequence;
		
	}

	String getSequence() {
		return this.sequence;
	}
	// End of Methods
	////////////////////////////////////////////////////////////////////////////

}