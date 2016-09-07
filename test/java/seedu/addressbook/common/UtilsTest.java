/**
 * 
 */
package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test for seedu.addressbook.common.Utils using Junit
 * @author CheeYeo
 *
 */
public class UtilsTest {

	/**
	 * Test method for {@link seedu.addressbook.common.Utils#isAnyNull(java.lang.Object[])}.
	 */
	@Test
	public void isAnyNull_oneNullItem() {
		Object nullObject = null;
		boolean testResult = Utils.isAnyNull(nullObject);
		assertTrue(testResult);
	}
	
	@Test
	public void isAnyNull_manyNullItems() {
		Object nullObject1 = null;
		Object nullObject2 = null;
		Object nullObject3 = null;
		boolean testResult = Utils.isAnyNull(nullObject1, nullObject2, nullObject3);
		assertTrue(testResult);
	}
	
	@Test
	public void isAnyNull_oneNonNullItem() {
		String nonNullObj = "non null string test";
		boolean testResult = Utils.isAnyNull(nonNullObj);
		assertFalse(testResult);
	}
	
	@Test
	public void isAnyNull_manyNonNullItem() {
		int nonNullObj1 = 123;
		String nonNullObj2 = "hello";
		Object nonNullObj3 = new Object();
		boolean testResult = Utils.isAnyNull(nonNullObj1, nonNullObj2, nonNullObj3);
		assertFalse(testResult);
	}

	@Test
	public void isAnyNull_noArgs() {
		boolean testResult = Utils.isAnyNull();
		assertFalse(testResult);
	}
	
	/**
	 * Test method for {@link seedu.addressbook.common.Utils#elementsAreUnique(java.util.Collection)}.
	 */
	@Test
	public void elementsAreUnique_someDuplicates() {
		ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
		listOfIntegers.add(1);
		listOfIntegers.add(2);
		listOfIntegers.add(1);
		assertFalse(Utils.elementsAreUnique(listOfIntegers));
	}
	
	@Test
	public void elementsAreUnique_uniqueElements() {
		ArrayList<Object> listOfObjs = new ArrayList<Object>();
		listOfObjs.add('A');
		listOfObjs.add("A");
		listOfObjs.add('a');
		assertTrue(Utils.elementsAreUnique(listOfObjs));
	}
	
	@Test
	public void elementsAreUnique_noElements() {
		assertTrue(Utils.elementsAreUnique(new ArrayList<Object>()));
	}
	
}
