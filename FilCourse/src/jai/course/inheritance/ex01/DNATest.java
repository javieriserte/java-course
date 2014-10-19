package jai.course.inheritance.ex01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DNATest extends DNA {
	
	DNA mol; 

	public DNATest() {
		super("");
	}

	@Before
	public void setUp() throws Exception {
		
		this.mol = new DNA("AAACCTG");
		
	}

	@Test
	public void testSeqComp() {
		assertEquals("CAGGTTT", this.mol.seqComp().getSequence());
	}

	@Test
	public void testLongitud() {
		assertEquals(7, this.mol.length());
	}

}
