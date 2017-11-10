/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Unit Test Classes
 */
package com.andrewasquith.comp2231.assignment3.tests;

/**
 * JUnit setup/teardown
 */
import org.junit.After;
import org.junit.Before;

/**
 * The class under test
 */
import com.andrewasquith.comp2231.assignment3.common.UnorderedLinkedList;

/**
 * Test fixture providing an UnorderedLinkedList to the UnorderedListADT test cases
 * 
 */
public class UnorderedLinkedListTests extends UnorderedListTests {
	/**
	 * Create a new list of the UnorderedLinkedList<T> type
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new UnorderedLinkedList<Integer>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
}
