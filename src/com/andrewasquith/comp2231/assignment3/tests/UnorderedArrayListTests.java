/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 3
 * Unit Test Classes
 */
package com.andrewasquith.comp2231.assignment3.tests;

import static org.junit.Assert.assertEquals;

/**
 * Import JUnit setup/teardown
 */
import org.junit.After;
import org.junit.Before;

/**
 * JUnit Test Attribute
 */
import org.junit.Test;

/**
 * Class under test
 */
import com.andrewasquith.comp2231.assignment3.common.UnorderedArrayList;

/**
 * Test fixture providing an UnorderedArrayList to the UnorderedListADT test cases
 * with additional test cases to ensure array capacity limits are handled
 *
 */
public class UnorderedArrayListTests extends UnorderedListTests {
	/**
	 * Create a new list with a capacity of 10
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new UnorderedArrayList<Integer>(10);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test that the list will expand after 10 elements added to front
	 */
	@Test
	public final void testListWillHoldMoreThanInitialCapacityWhenAddingToFront() {
		list.addToFront(1);
		list.addToFront(2);
		list.addToFront(3);
		list.addToFront(4);
		list.addToFront(5);
		list.addToFront(6);
		list.addToFront(7);
		list.addToFront(8);
		list.addToFront(9);
		list.addToFront(10);
		list.addToFront(11);
		list.addToFront(12);
		assertEquals(12, list.size());
	}
	
	/**
	 * Test that the list will expand after 10 elements added to rear
	 */
	@Test
	public final void testListWillHoldMoreThanInitialCapacityWhenAddingToRear() {
		list.addToRear(1);
		list.addToRear(2);
		list.addToRear(3);
		list.addToRear(4);
		list.addToRear(5);
		list.addToRear(6);
		list.addToRear(7);
		list.addToRear(8);
		list.addToRear(9);
		list.addToRear(10);
		list.addToRear(11);
		list.addToRear(12);
		assertEquals(12, list.size());
	}
	
	/**
	 * Test that the list will expand after 10 elements added to front and rear
	 */
	public final void testListWillHoldMoreThanInitialCapacityWhenAddingToFrontAndRear() {
		list.addToRear(1);
		list.addToFront(2);
		list.addToRear(3);
		list.addToFront(4);
		list.addToRear(5);
		list.addToFront(6);
		list.addToRear(7);
		list.addToFront(8);
		list.addToRear(9);
		list.addToFront(10);
		list.addToRear(11);
		list.addToFront(12);
		assertEquals(12, list.size());
	}
}
