package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
	
	public Name n1;
	public Name n2;
	
	@Test
	public void isSimilar_otherNotNull() throws IllegalValueException {
		n1 = null;
		n2 = new Name("bobby");
		assertFalse(n2.isSimilar(n1));
	}
	
	@Test
	public void isSimilar_differentCaseButSameName() throws IllegalValueException {
		n1 = new Name("chee yeo");
		n2 = new Name("Chee Yeo");
		assertTrue(n1.isSimilar(n2));
	}
}
